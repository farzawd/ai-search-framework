package net.farzq.ai.search.classical;

public abstract class Search implements ISearch
{
	protected final Problem problem;
	
	private int visitedNodesCount;
	private int expandedNodesCount;
	
	public Search(Problem problem)
	{
		this.problem = problem;
		
		this.visitedNodesCount = 0;
		this.expandedNodesCount = 0;
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
	
	protected void incExpandedNodes()
	{
		this.expandedNodesCount++;
	}
	
	protected void incVisitedNodes()
	{
		this.visitedNodesCount++;
	}
}
