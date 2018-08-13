package undirectedWeightedGraph;

import java.util.List;

/**
 * Interface containing the methods for graph implementation
 * created on August 10, 2018
 */
public interface Graph {

	public boolean isConnected(GraphStructure graph);
	public List<Integer> getReachableVertices(GraphStructure graph,int vertex);
	public void getMinimumSpanningTree(GraphStructure graphs);
	public List<Integer> getShortestPath(int source, int destination,GraphStructure graph);
	
}
