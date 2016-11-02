package net.farzq.util;

public enum Direction
{
	EAST(1, 0),
	NORTH(0, -1),
	WEST(-1, 0),
	SOUTH(0, 1);
	

	public final int deltaX;
	public final int deltaY;
	
	private Direction(int deltaX, int deltaY)
	{
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public Direction opposite()
	{
		return values()[(this.ordinal() + 2) % 4];
	}
}
