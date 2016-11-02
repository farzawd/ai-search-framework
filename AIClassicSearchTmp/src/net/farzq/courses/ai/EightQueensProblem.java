package net.farzq.courses.ai;

import java.util.ArrayList;
import java.util.List;

import net.farzq.ai.search.classical.IAction;
import net.farzq.ai.search.classical.IState;
import net.farzq.ai.search.classical.Problem;
import net.farzq.ai.search.classical.exceptions.InvalidActionException;

public class EightQueensProblem extends Problem
{

	@Override
	public IState getInitialState()
	{
		return new EightQueensState();
	}

	@Override
	public ArrayList<IAction> getAvailableActions(IState currentState)
	{
		EightQueensState state = (EightQueensState)currentState;
		
		ArrayList<IAction> actions = new ArrayList<>();
		
		if(state.getQueensCount() < 8)
		{
			for(int i = 0; i < 8; i++)
				actions.add(new EightQueensAction(i));
		}
		
		return actions;
		
	}

	@Override
	public IState getResultingState(IState currentState, IAction action)
	{
		EightQueensAction eqAction = (EightQueensAction)action;
		EightQueensState eqState = (EightQueensState)currentState;
		
		EightQueensState newState = new EightQueensState(eqState);
		newState.addQueen(eqAction.getColumnNo());
		
		return newState;
	}

	@Override
	public int getActionCost(IState currentState, IAction action)
	{
		EightQueensAction eqAction = (EightQueensAction)action;
		EightQueensState eqState = (EightQueensState)currentState;
		
		if(eqState.getQueensCount() >= 8)
			throw new InvalidActionException(eqState, eqAction);
		
		return 1;
	}

	@Override
	public double getHeuristicFunctionValue(IState currentState)
	{
		EightQueensState eqState = (EightQueensState)currentState;
		
		List<Integer> queensRows = eqState.getQueensRows();
		
		int queensCount = eqState.getQueensCount();

		int attacksCount = 0;
		for(int i = 0; i < queensCount; i++)
		{
			for(int j = i + 1; j < queensCount; j++)
			{
				if(queensRows.get(i) == queensRows.get(j))
					attacksCount++;
				
				if(queensRows.get(i) - queensRows.get(j) == i - j)
					attacksCount++;
				
				if(queensRows.get(i) - queensRows.get(j) == j - i)
					attacksCount++;
			}
		}
		
		return attacksCount + (8 - queensCount);
	}

	@Override
	public boolean isGoal(IState state)
	{
		return getHeuristicFunctionValue(state) == 0;
	}

}
