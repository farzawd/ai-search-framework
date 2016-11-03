package net.farzq.ai.search.classical;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS extends QueueBasedSearch
{
	protected Queue<Node<IState>> openList;
	
	public TreeBFS(Problem problem)
	{
		super(problem);
		
		openList = new LinkedList<>();
	}

	@Override
	protected boolean addNode(Node<IState> node)
	{
		openList.add(node);
		
		return true;
	}

	@Override
	protected Node<IState> getNode()
	{
		return openList.poll();
	}

	@Override
	protected boolean isDone()
	{
		return openList.size() == 0;
	}
	
}
