package net.farzq.ai.search.classical;

public abstract class Search implements ISearch
{
	protected final IProblem problem;
	
	public Search(IProblem problem)
	{
		this.problem = problem;
	}
}
