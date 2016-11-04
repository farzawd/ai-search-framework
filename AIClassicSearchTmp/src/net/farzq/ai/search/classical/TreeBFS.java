package net.farzq.ai.search.classical;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS extends QueueBasedSearch
{
	protected Queue<Node<IState>> openList;
	
	public TreeBFS(Problem problem)
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
		return openList.poll();
	}

	@Override
	protected boolean isDone()
	{
		return openList.size() == 0;
	}

	@Override
	protected void initialize()
	{
		openList = new LinkedList<>();
	}
	
}
