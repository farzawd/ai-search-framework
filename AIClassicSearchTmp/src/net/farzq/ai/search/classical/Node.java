package net.farzq.ai.search.classical;

public class Node<T extends IState>
{
	private Node<T> parent;
	private T state;
	private final int depth;
	private double cost;
	
	public Node(T state, Node<T> parent)
	{
		this.state = state;
		this.parent = parent;
		
		if(parent == null)
		{
			this.depth = 0;
			this.cost = 0d;
		}
		else
		{
			this.depth = parent.depth + 1;
			this.cost = parent.cost;
		}
		
	}

	public Node<T> getParent()
	{
		return parent;
	}

	public T getState()
	{
		return state;
	}
	
	public int getDepth()
	{
		return this.depth;
	}

	public double getCost()
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	public void addCost(double cost)
	{
		this.cost += cost;
	}
}
