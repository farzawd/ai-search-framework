package net.farzq.courses.ai;

import java.util.ArrayList;

import net.farzq.ai.search.classical.IAction;
import net.farzq.ai.search.classical.IState;
import net.farzq.ai.search.classical.Problem;
import net.farzq.ai.search.classical.exceptions.InvalidActionException;
import net.farzq.util.Direction;

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
		PathfinderState pfState = (PathfinderState)currentState;
		
		ArrayList<Direction> dirs = pfState.getAvailableDirections();
		ArrayList<IAction> actions = new ArrayList<>();
		for(Direction dir: dirs)
		{
			if(dir.deltaX > 0 || dir.deltaY > 0) // FIXME remove this if
				actions.add(new PathfinderAction(dir));
		}
		
		return actions;
	}

	@Override
	public IState getResultingState(IState currentState, IAction action)
	{
		PathfinderState pfState = (PathfinderState)currentState;
		PathfinderAction pfAction = (PathfinderAction)action;
		
		PathfinderState newState = new PathfinderState(pfState);
		newState.move(pfAction.getDirection());
		
		return newState;
	}

	@Override
	public int getActionCost(IState currentState, IAction action)
	{
		PathfinderState pfState = (PathfinderState)currentState;
		PathfinderAction pfAction = (PathfinderAction)action;
		
		if(pfState.canMove(pfAction.getDirection()))
			return 1;
		
		throw new InvalidActionException(pfState, pfAction);
	}

	@Override
	public double getHeuristicFunctionValue(IState currentState)
	{	
		PathfinderState pfState = (PathfinderState)currentState;
		
		return pfState.getPosition().distance(pfState.getGoal()); 
	}

	@Override
	public boolean isGoal(IState state)
	{
		PathfinderState pfState = (PathfinderState)state;
		
		if(pfState.getPosition().x == pfState.getGoal().x && pfState.getPosition().y == pfState.getGoal().y)
			return true;
		
		return false;
	}

}
