package net.farzq.ai.search.classical;

import java.util.Stack;

public class TreeDFS extends QueueBasedSearch
{
	protected Stack<Node<IState>> openList;
	
	public TreeDFS(Problem problem)
	{
		super(problem);
	}

	@Override
	protected boolean _addNode(Node<IState> node)
	{
		openList.add(node);
		
		return true;
	}

	@Override
	protected Node<IState> _getNode()
	{
		return openList.pop();
	}

	@Override
	protected boolean isDone()
	{
		return openList.size() == 0;
	}

	@Override
	protected void initialize()
	{
		openList = new Stack<>();
	}
	
}
