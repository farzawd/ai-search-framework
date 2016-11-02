package net.farzq.courses.ai;

import net.farzq.ai.search.classical.IAction;
import net.farzq.util.Direction;

public class PathfinderAction implements IAction
{
	private Direction direction;

	public PathfinderAction(Direction direction)
	{
		this.direction = direction;
	}

	public Direction getDirection()
	{
		return direction;
	}
	
	public String toString()
	{
		return "GO " + direction;
	}
}
