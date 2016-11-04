package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class QueueBasedSearch extends Search
{
	private LinkedList<IState> pathToGoal;
	private double costToGoal;
	
	public QueueBasedSearch(Problem problem)
	{
		super(problem);
		
		pathToGoal = null;
		costToGoal = Double.MAX_VALUE;
	}
	
	/**
	 * 
	 * @param node Will be stored in the for later processing
	 * @return true if the node was successfully stored, or false if the node got rejected.
	 */
	protected abstract boolean _addNode(Node<IState> node);
	
	/**
	 * 
	 * @return the next node that must be expanded
	 */
	protected abstract Node<IState> _getNode();
	
	/**
	 * 
	 * @return true when the search should terminate.
	 */
	protected abstract boolean isDone();
	
	private boolean addNode(Node<IState> node)
	{
		boolean added = _addNode(node);
		
		if(added)
			incVisitedNodes();
		
		return added;
	}
	
	private Node<IState> getNode()
	{
		incExpandedNodes();
		return _getNode();
	}
	
	@Override
	public IState beginSearch()
	{
		IState currentState = problem.getInitialState();
		Node<IState> currentNode = new Node<IState>(currentState, null);
		
		addNode(currentNode);
		
		while(!isDone())
		{			
			currentNode = getNode();	
			
			ArrayList<IAction> actions = problem.getAvailableActions(currentNode.getState());
			
			for(IAction action : actions)
			{
				IState resultingState = problem.getResultingState(currentNode.getState(), action);
				
				Node<IState> newNode = new Node<IState>(resultingState, currentNode);
				double cost = problem.getActionCost(currentNode.getState(), action);
				newNode.addCost(cost);
				addNode(newNode);
				
				if(problem.isGoal(resultingState))
				{
					costToGoal = newNode.getCost();
					pathToGoal = new LinkedList<>();
					
					pathToGoal.add(resultingState);
					while(currentNode != null)
					{
						pathToGoal.addFirst(currentNode.getState());
						currentNode = currentNode.getParent();
					}
					
					return resultingState;
				}
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
	public double getCostToGoal()
	{
		return costToGoal;
	}
}
