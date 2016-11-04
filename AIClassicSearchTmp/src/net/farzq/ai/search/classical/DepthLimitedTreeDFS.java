package net.farzq.ai.search.classical;

public class DepthLimitedTreeDFS extends TreeDFS
{
	private final int maxDepth;

	public DepthLimitedTreeDFS(Problem problem, int maxDepth)
	{
		super(problem);
		
		this.maxDepth = maxDepth;
	}
	
	@Override
	protected boolean _addNode(Node<IState> node)
	{
		if(node.getDepth() <= maxDepth)
			return super._addNode(node);
		else
			return false;
	}
}
