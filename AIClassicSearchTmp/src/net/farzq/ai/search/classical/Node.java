package net.farzq.ai.search.classical;

public class Node<T extends IState>
{
	private Node<T> parent;
	private T state;
	
	public Node(T state, Node<T> parent)
	{
		this.state = state;
		this.parent = parent;
	}

	public Node<T> getParent()
	{
		return parent;
	}

	public T getState()
	{
		return state;
	}
}
