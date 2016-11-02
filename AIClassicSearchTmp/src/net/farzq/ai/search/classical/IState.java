package net.farzq.ai.search.classical;

public interface IState
{
	// TODO Change this interface to include a hash function instead, used for both graph search hash maps and equality check
	public boolean equals(IState other);
}
