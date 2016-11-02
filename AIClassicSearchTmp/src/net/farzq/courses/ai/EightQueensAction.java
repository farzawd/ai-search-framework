package net.farzq.courses.ai;

import net.farzq.ai.search.classical.IAction;

public class EightQueensAction implements IAction
{
	private int columnNo;

	public EightQueensAction(int columnNo)
	{
		super();
		this.columnNo = columnNo;
	}

	public int getColumnNo()
	{
		return columnNo;
	}
	
	
}
