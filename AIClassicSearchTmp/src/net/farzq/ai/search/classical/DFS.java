package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class DFS extends Search
{
	public DFS(Problem problem)
	{
		super(problem);
	}
	
	@Override
	public IState beginSearch()
	{
		// TODO Auto-generated method stub
		IState currentState = problem.getInitialState();
		Node<IState> currentNode = new Node<IState>(currentState, null);
		
		Stack<Node<IState>> stack = new Stack<>();
		stack.push(currentNode);
		
		while(stack.size() > 0)
		{
			currentNode = stack.pop();
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
				stack.push(new Node<IState>(resultingState, currentNode));
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
