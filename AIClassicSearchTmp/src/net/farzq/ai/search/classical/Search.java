package net.farzq.ai.search.classical;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Search implements ISearch
{
	protected final Problem problem;
	
	private int visitedNodesCount;
	private int expandedNodesCount;
	
	protected LinkedList<IState> pathToGoal;
	protected double costToGoal;

	
	public Search(Problem problem)
	{
		this.problem = problem;
		
		this.visitedNodesCount = 0;
		this.expandedNodesCount = 0;
		
		pathToGoal = null;
		costToGoal = Double.MAX_VALUE;
	}
	
	/**
	 * 
	 * @param node Will be stored in the for later processing
	 * @return true if the node was successfully stored, or false if the node got rejected.
	 */
	protected abstract boolean _addNode(Node<IState> node);
	
	/**
	 * 
	 * @return the next node that must be expanded
	 */
	protected abstract Node<IState> _getNode();
	
	/**
	 * 
	 * @return true when the search should terminate.
	 */
	protected abstract boolean isDone();
	
	@Override
	public int getVisitedNodesCount()
	{
		return this.visitedNodesCount;
	}

	@Override
	public int getExpandedNodesCount()
	{
		return this.expandedNodesCount;
	}
	
	
	@Override
	public Queue<IState> getBestPathToGoal()
	{
		return (Queue<IState>)pathToGoal;
	}

	@Override
	public double getCostToGoal()
	{
		return costToGoal;
	}
	
	protected void incExpandedNodes()
	{
		this.expandedNodesCount++;
	}
	
	protected void incVisitedNodes()
	{
		this.visitedNodesCount++;
	}
}
