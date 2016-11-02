package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DFS extends Search
{
	private final boolean graphSearch;
	
	public DFS(Problem problem, boolean graphSearch)
	{
		super(problem);
		this.graphSearch = graphSearch;
	}
	
	@Override
	public IState beginSearch()
	{
		IState currentState = problem.getInitialState();
		Node<IState> currentNode = new Node<IState>(currentState, null);
		
		Stack<Node<IState>> openList = new Stack<>();
		Set<IState> closedSet = new HashSet<>();
		
		openList.push(currentNode);
		closedSet.add(currentState);
		
		while(openList.size() > 0)
		{			
			currentNode = openList.pop();

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
				
				openList.push(new Node<IState>(resultingState, currentNode));
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
