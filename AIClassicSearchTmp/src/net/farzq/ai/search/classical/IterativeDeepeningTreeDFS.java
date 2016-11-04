package net.farzq.ai.search.classical;

public class IterativeDeepeningTreeDFS extends DepthLimitedTreeDFS
{
	private int minDepth;
	private int maxDepth;
	private int depthStep;

	public IterativeDeepeningTreeDFS(Problem problem, int minDepth, int maxDepth, int depthStep)
	{
		super(problem, minDepth);
		
		this.maxDepth = maxDepth;
		this.minDepth = minDepth;
		this.depthStep = depthStep;
//		
//		if(minDepth >= maxDepth)
//			throw new InvalidAlgorithmParameterException("Minimum depth should be less than maximum depth.");
	}
	
	@Override
	public IState beginSearch()
	{
		for(int depth = minDepth; depth < maxDepth; depth += depthStep)
		{
			super.maxDepth = depth;
			IState result = super.beginSearch();
			if(result != null)
			{
				return result;
			}
		}
		
		return null;
	}

}
