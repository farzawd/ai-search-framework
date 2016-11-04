package net.farzq.ai.search.classical;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UniformCostSearch extends Search
{
	private PriorityQueue<Node<IState>> frontier;
	private HashSet<IState> explored;
	
	private HashMap<IState, Node<IState>> statesNodes;
	
	public UniformCostSearch(Problem problem)
	{
		super(problem);
		
		explored = new HashSet<>();
		statesNodes = new HashMap<>();
		frontier = new PriorityQueue<>(new Comparator<Node<IState>>()
		{
			@Override
			public int compare(Node<IState> n1, Node<IState> n2)
			{
				if(n1.getCost() > n2.getCost())
					return 1;
				else if(n1.getCost() == n2.getCost())
					return 0;
				else
					return -1;
			}
			
		});
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
		IState currentState = problem.getInitialState();
		Node<IState> currentNode = new Node<IState>(currentState, null);
		
		addNode(currentNode);
		
		while(!isDone())
		{			
			currentNode = getNode();
			currentState = currentNode.getState();
			
			if(problem.isGoal(currentState))
			{
				costToGoal = currentNode.getCost();
				pathToGoal = new LinkedList<>();
				
				while(currentNode != null)
				{
					pathToGoal.addFirst(currentNode.getState());
					currentNode = currentNode.getParent();
				}
				
				return currentState;
			}
			 
			ArrayList<IAction> actions = problem.getAvailableActions(currentNode.getState());
			
			for(IAction action : actions)
			{
				IState resultingState = problem.getResultingState(currentNode.getState(), action);
				
				Node<IState> newNode = new Node<IState>(resultingState, currentNode);
				double cost = problem.getActionCost(currentNode.getState(), action);
				newNode.addCost(cost);
				addNode(newNode);
			}
		}
		
		return null;
	}

	@Override
	protected boolean _addNode(Node<IState> node)
	{
		if(!explored.contains(node.getState()))
		{
			Node<IState> tmp = statesNodes.get(node.getState()); // does frontier already contain a node with the same state?
			if(tmp == null)
			{
				statesNodes.put(node.getState(), node);
				frontier.add(node);
				
				return true;
			}
			else
			{
				if(node.getCost() < tmp.getCost())
				{
					frontier.remove(tmp);
					statesNodes.remove(tmp.getState());
					
					frontier.add(node);
					statesNodes.put(node.getState(), node);
				}
			}
		}
		
		return false;
	}

	@Override
	protected Node<IState> _getNode()
	{
		Node<IState> node = frontier.poll(); 
		
		explored.add(node.getState());
		
		return node;
	}

	@Override
	protected boolean isDone()
	{
		return frontier.size() == 0;
	}
}
