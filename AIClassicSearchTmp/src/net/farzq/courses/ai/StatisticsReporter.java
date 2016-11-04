package net.farzq.courses.ai;

import net.farzq.ai.search.classical.ISearch;

public final class StatisticsReporter
{
	public static void printStatistics(ISearch searcher)
	{
		System.out.println("Statistics report for algorithm: " + searcher.getClass().getSimpleName());
		System.out.println("Number of expanded nodes: " + searcher.getExpandedNodesCount());
		System.out.println("Number of visited nodes: " + searcher.getVisitedNodesCount());
	}
}
