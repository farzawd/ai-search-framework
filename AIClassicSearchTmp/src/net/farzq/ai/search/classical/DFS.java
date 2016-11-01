package net.farzq.ai.search.classical;


public class DFS extends Search
{
	public DFS(IProblem problem)
	{
		super(problem);
	}
	
	@Override
	public boolean beginSearch()
	{
		// TODO Auto-generated method stub
		IState currentState = problem.getInitialState();  
		
		throw new UnsupportedOperationException();
	}

	@Override
	public int getVisitedNodeCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getExpandedNodeCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Queue<?> getBestPathToGoal()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getBestCostToGoal()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
