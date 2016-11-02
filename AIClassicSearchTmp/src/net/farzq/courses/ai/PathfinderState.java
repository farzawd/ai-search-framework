package net.farzq.courses.ai;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import net.farzq.ai.search.classical.IState;
import net.farzq.util.Direction;

public class PathfinderState implements IState
{
	private Point position;
	private Maze maze;
	
	public PathfinderState()
	{
		this.position = new Point(0, 0);
		this.maze = new Maze();
	}
	
	public PathfinderState(PathfinderState baseState)
	{
		this.position = new Point(position);
		this.maze = baseState.maze;
	}
	
	public ArrayList<Direction> getAvailableDirections()
	{
		ArrayList<Direction> dirs = new ArrayList<>();
		
		for(Direction dir: Direction.values())
		{
			if(maze.canMove(position, dir))
				dirs.add(dir);				
		}
		
		return dirs;
	}
	
	public boolean move(Direction direction)
	{
		if(maze.canMove(position, direction))
		{
			position = new Point(position.x + direction.deltaX, position.y + direction.deltaY);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(IState other)
	{
		// TODO Auto-generated method stub
		return false;
	}

	private static class Maze
	{
		private Dimension size;
		
		private HashMap<Point, ArrayList<Direction>> blockedDirections;

		public Maze()
		{
			blockedDirections = new HashMap<>();
			
			Scanner stdin = new Scanner(System.in);
			
			int w = stdin.nextInt();
			int h = stdin.nextInt();
			
			size = new Dimension(w, h);
			
			int wallsCount = stdin.nextInt();
			for(int i = 0; i < wallsCount; i++)
			{
				Point p1 = new Point(stdin.nextInt(), stdin.nextInt());
				Point p2 = new Point(stdin.nextInt(), stdin.nextInt());
				
				int dx = p2.x - p1.x;
				int dy = p2.y - p1.y;
				
				Direction blockedDir = null;
				
				for(Direction direction: Direction.values())
				{
					if(direction.deltaX == dx && direction.deltaY == dy)
					{
						blockedDir = direction;
						break;
					}
				}
				if(blockedDir == null)
					continue;
				
				ArrayList<Direction> walls;
				walls = blockedDirections.get(p1);
				if(walls == null)
				{
					walls = new ArrayList<>();
					blockedDirections.put(p1, walls);
				}
				if(!walls.contains(blockedDir))
					walls.add(blockedDir);
				
				walls = blockedDirections.get(p2);
				if(walls == null)
				{
					walls = new ArrayList<>();
					blockedDirections.put(p2, walls);
				}
				if(!walls.contains(blockedDir.opposite()))
					walls.add(blockedDir.opposite());
				
			}
			
			stdin.close();
		}
		
		public boolean canMove(Point position, Direction direction)
		{
			ArrayList<Direction> blockedDirs = blockedDirections.get(position);
			if(blockedDirs == null)
				blockedDirs = new ArrayList<>();
			
			if(blockedDirs.contains(direction))
				return false;
			
			int x = position.x + direction.deltaX;
			int y = position.y + direction.deltaY;
			
			if(x < 0 || x >= size.getWidth() || y < 0 || y >= size.getHeight())
				return false;
			
			return true;
		}
	}
}
