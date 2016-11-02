package net.farzq.courses.ai;

import java.util.ArrayList;

import net.farzq.ai.search.classical.IAction;
import net.farzq.ai.search.classical.IState;
import net.farzq.ai.search.classical.Problem;

public class PathfinderProblem extends Problem
{

	@Override
	public IState getInitialState()
	{
		return new PathfinderState();
	}

	@Override
	public ArrayList<IAction> getAvailableActions(IState currentState)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IState getResultingState(IState currentState, IAction action)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getActionCost(IState currentState, IAction action)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeuristicFunctionValue(IState currentState)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isGoal(IState state)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
