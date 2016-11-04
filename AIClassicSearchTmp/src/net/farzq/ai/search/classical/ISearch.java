package net.farzq.ai.search.classical;

import java.util.Queue;


public interface ISearch
{
	/**
	 * Begins the search on the given Problem's state space.
	 * 
	 * @return A goal State if it finds one, null otherwise.
	 */
	public IState beginSearch();


	/**
	 * 
	 * @return The number of Nodes visited during search.
	 */
	public int getVisitedNodesCount();


	/**
	 * 
	 * @return The number of Nodes expanded during search.
	 */
	public int getExpandedNodesCount();


	/**
	 * 
	 * @return A list containing States on the best path to a goal State, null if
	 *         there is no path.
	 */
	public Queue<? extends IState> getBestPathToGoal();


	/**
	 * 
	 * @return The cost of best path found to a goal node.
	 */
	public double getCostToGoal();

}
