package net.farzq.ai.search.classical;

public class Node<T extends IState>
{
	private Node<T> parent;
	private T state;
	private final int depth;
	
	public Node(T state, Node<T> parent)
	{
		this.state = state;
		this.parent = parent;
		
		if(parent == null)
			this.depth = 0;
		else
			this.depth = parent.depth + 1;
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
}
