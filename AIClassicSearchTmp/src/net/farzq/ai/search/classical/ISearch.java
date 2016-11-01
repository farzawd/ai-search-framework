package net.farzq.ai.search.classical;

import java.util.Queue;



public interface ISearch
{
	/**
	 * Begins the search on the given Problem's state space.
	 * 
	 * @return true if it finds a goal state, false otherwise.
	 */
	public boolean beginSearch();


	/**
	 * 
	 * @return The number of Nodes visited during search.
	 */
	public int getVisitedNodeCount();


	/**
	 * 
	 * @return The number of Nodes expanded during search.
	 */
	public int getExpandedNodeCount();


	/**
	 * 
	 * @return A list containing Nodes on the best path to a goal Node, null if
	 *         there is no path.
	 */
	public Queue<?> getBestPathToGoal();


	/**
	 * 
	 * @return The cost of best path found to a goal node.
	 */
	public float getBestCostToGoal();

}
