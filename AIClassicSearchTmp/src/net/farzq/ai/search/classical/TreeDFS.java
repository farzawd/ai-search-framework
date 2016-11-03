package net.farzq.ai.search.classical;

import java.util.Stack;

public class TreeDFS extends QueueBasedSearch
{
	protected Stack<Node<IState>> openList;
	
	public TreeDFS(Problem problem)
	{
		super(problem);
		
		openList = new Stack<>();
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
		return openList.pop();
	}

	@Override
	protected boolean isDone()
	{
		return openList.size() == 0;
	}
	
}
