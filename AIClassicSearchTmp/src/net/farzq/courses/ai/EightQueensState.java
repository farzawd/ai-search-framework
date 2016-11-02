package net.farzq.courses.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.farzq.ai.search.classical.IState;

public class EightQueensState implements IState
{
	private ArrayList<Integer> queensRows;
	
	public EightQueensState()
	{
		queensRows = new ArrayList<>();
	}
	
	public EightQueensState(EightQueensState state)
	{
		queensRows = new ArrayList<>(state.queensRows);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
			return false;
		
		if(!(other instanceof EightQueensState))
			return false;
		
		EightQueensState _other = (EightQueensState) other;
		
		if(this.queensRows.size() != _other.queensRows.size())
			return false;
		
		for(int i = 0; i < this.queensRows.size(); i++)
		{
			if(this.queensRows.get(i) != _other.queensRows.get(i))
				return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode()
	{
		int sum = 0;
		
		for(Integer row: queensRows)
		{
			sum *= 10;
			sum += row;
		}
		
		return sum;
	}
	
	public void addQueen(int row)
	{
		queensRows.add(row);
	}
	
	public List<Integer> getQueensRows()
	{
		return Collections.unmodifiableList(queensRows);
	}
	
	public int getQueensCount()
	{
		return queensRows.size();
	}

	public String toString()
	{
		String s = "Queens' rows: ";
		
		for(Integer row: queensRows)
		{
			s += row;
		}
		
		return s;
	}
}
