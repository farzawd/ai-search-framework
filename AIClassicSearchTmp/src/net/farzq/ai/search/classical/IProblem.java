package net.farzq.ai.search.classical;

import java.util.ArrayList;

/**
 * An interface for classical search problems to implement. Problems
 * implementing this interface can be fed to the provided search algorithms as
 * their input.
 * 
 * @author Farzad
 *
 */
public interface IProblem
{
	/**
	 * 
	 * @return An initial state for the problem.
	 */
	public IState getInitialState();
	
	/**
	 * 
	 * @param currentState An state in the problem's state space. 
	 * @return Available actions in that state.
	 */
	public ArrayList<IAction> getAvailableActions(IState currentState);
	
	/**
	 * 
	 * @param currentState An state in the problem's state space.
	 * @param action Resulting state if this action is performed when the problem is in @param currentState.
	 * @return
	 */
	public IState getResultingState(IState currentState, IAction action);
	
	/**
	 * 
	 * @param currentState An state in the problem's state space.
	 * @param action An available action when the problem is in @param currentState.
	 * @return The cost of action. An exception is thrown if the given action is not available in @param currentState.
	 */
	public int getActionCost(IState currentState, IAction action);
	
	/**
	 * 
	 * @param currentState An state in the problem's state space.
	 * @return Value of the problems heuristic function in currentState.
	 */
	public double getHeuristicFunctionValue(IState currentState);
	
	/**
	 * 
	 * @param state An state in the problem's state space.
	 * @return true if @param state is a goal state, false otherwise.
	 */
	public boolean isGoal(IState state);
}