package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class QueueBasedSearch extends Search
{	
	public QueueBasedSearch(Problem problem)
	{
		super(problem);
	}
	
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
		initialize();
		
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
	
	/**
	 * prepare for search (e.g. by initializing any queue or stack)
	 */
	protected abstract void initialize();
}
