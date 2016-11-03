package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class QueueBasedSearch extends Search
{
	private LinkedList<IState> pathToGoal;
	
	public QueueBasedSearch(Problem problem)
	{
		super(problem);
		
		pathToGoal = null;
	}
	
	/**
	 * 
	 * @param node Will be stored in the for later processing
	 * @return true if the node was successfully stored, or false if the node got rejected.
	 */
	protected abstract boolean addNode(Node<IState> node);
	
	/**
	 * 
	 * @return the next node that must be expanded
	 */
	protected abstract Node<IState> getNode();
	
	/**
	 * 
	 * @return true when the search should terminate.
	 */
	protected abstract boolean isDone();
	
	@Override
	public IState beginSearch()
	{
		IState currentState = problem.getInitialState();
		Node<IState> currentNode = new Node<IState>(currentState, null);
		
		addNode(currentNode);
		
		while(!isDone())
		{			
			currentNode = getNode();	
			incExpandedNodes();
			
			ArrayList<IAction> actions = problem.getAvailableActions(currentNode.getState());
			
			for(IAction action : actions)
			{
				IState resultingState = problem.getResultingState(currentNode.getState(), action);
				incVisitedNodes();
				
				if(problem.isGoal(resultingState))
				{
					// TODO generate path to goal
					pathToGoal = new LinkedList<>();
					
					pathToGoal.add(resultingState);
					while(currentNode != null)
					{
						pathToGoal.addFirst(currentNode.getState());
						currentNode = currentNode.getParent();
					}
					
					return resultingState;
				}
				
				addNode(new Node<IState>(resultingState, currentNode));
			}
		}
		
		return null;
	}
	
	@Override
	public Queue<IState> getBestPathToGoal()
	{
		return (Queue<IState>)pathToGoal;
	}

	@Override
	public float getBestCostToGoal()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
