package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS extends Search
{
	private final boolean graphSearch;
	
	public BFS(Problem problem, boolean graphSearch)
	{
		super(problem);
		this.graphSearch = graphSearch;
	}
	
	@Override
	public IState beginSearch()
	{
		IState currentState = problem.getInitialState();
		Node<IState> currentNode = new Node<IState>(currentState, null);
		
		Queue<Node<IState>> openList = new LinkedList<>();
		Set<IState> closedSet = new HashSet<>();
		
		openList.add(currentNode);
		closedSet.add(currentState);
		
		while(openList.size() > 0)
		{			
			currentNode = openList.poll();
			
			incExpandedNodes();
			
			ArrayList<IAction> actions = problem.getAvailableActions(currentNode.getState());
			
			for(IAction action : actions)
			{
				IState resultingState = problem.getResultingState(currentNode.getState(), action);
				incVisitedNodes();
				
				if(problem.isGoal(resultingState))
				{
					// TODO generate path to goal
					return resultingState;
				}
				
				if(graphSearch)
				{
					if(closedSet.contains(resultingState))
						continue;
					else
						closedSet.add(resultingState);
				}
				
				openList.add(new Node<IState>(resultingState, currentNode));
			}
		}
		
		return null;
	}

	@Override
	public Queue<IState> getBestPathToGoal()
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
