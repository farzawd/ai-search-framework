package net.farzq.ai.search.classical;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Search implements ISearch
{
	protected final Problem problem;
	
	private int visitedNodesCount;
	private int expandedNodesCount;
	
	private LinkedList<IState> pathToGoal;
	private double costToGoal;

	
	public Search(Problem problem)
	{
		this.problem = problem;
		
		this.visitedNodesCount = 0;
		this.expandedNodesCount = 0;
		
		pathToGoal = null;
		costToGoal = Double.MAX_VALUE;
	}
	
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
