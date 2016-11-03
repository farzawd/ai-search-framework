package net.farzq.ai.search.classical;

import java.util.HashSet;
import java.util.Set;

public class GraphBFS extends TreeBFS
{
	protected Set<IState> closedSet;
	
	public GraphBFS(Problem problem)
	{
		super(problem);
		
		closedSet = new HashSet<>();
	}

	@Override
	protected boolean addNode(Node<IState> node)
	{
		if(closedSet.contains(node.getState()))
			return false;
		
		closedSet.add(node.getState());
		
		return super.addNode(node);
	}	
}
