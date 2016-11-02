package net.farzq.ai.search.classical.exceptions;

import net.farzq.ai.search.classical.IAction;
import net.farzq.ai.search.classical.IState;

public class InvalidActionException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6376322880498084970L;

	public InvalidActionException(IState state, IAction action)
	{
		super("Action <<" + action + ">> is not available in state <<" + state + ">>");
	}
}
