package undirectedWeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import undirectedWeightedGraph.GraphStructure.Edge;

/**
 * class containing implementation of graph
 * created on August 10, 2018
 */
public class GraphImplementation implements Graph {
	
	private List<Integer> pathList;
	LinkedList<Edge> adjacencyList[];
	private int distanceArray[];
	private boolean isVisited[];
	private List<Integer> shortestPathList;
	
	/**
	 * method to check if the given graph is connected or not
	 * @param Graph object
	 * @return true if graph is connected otherwise return false
	 */
	@Override
	public boolean isConnected(GraphStructure graph) {
		getDepthFirstSearchTraversal(graph);
		if(pathList.size()==graph.getNumberOfVertices()) {
			return true;
		}
		return false;
	}

	/**
	 * method to find list of reachable vertex from a particular vertex
	 * @param graphStructure object
	 * @param vertex for which we have to find reachable vertices */
	@Override
	public List<Integer> getReachableVertices(GraphStructure graph,int vertex) {
		adjacencyList=graph.getAdjacencyList();
		pathList=new ArrayList<Integer>();
		isVisited=new boolean [graph.getNumberOfVertices()];
		traverseRecursively(graph, vertex);
		return pathList;
	}

	/**
	 * method to find shortest path between a source and destination
	 * @param source vertex
	 * @param destination vertex
	 * @return list of vertices making shortest path
	 */
	@Override
	public List<Integer> getShortestPath(int source, int destination, GraphStructure graph) {
		shortestPathList = new ArrayList<Integer>();
		isVisited = new boolean[graph.getNumberOfVertices()];
		distanceArray = new int [graph.getNumberOfVertices()];
		Arrays.fill(distanceArray,Integer.MAX_VALUE);
		distanceArray[source]=0;
		calculateShortestDistances(graph, source, destination);
		for(Integer value : shortestPathList) {
			System.out.println(value+" ");
		}
		return shortestPathList;
	}

	/**
	 * method to obtain minimum spanning tree whose root is vertex 0
	 * @param graph structure object
	 */
	@Override
	public void getMinimumSpanningTree(GraphStructure graph) {
		distanceArray = new int [graph.getNumberOfVertices()];
		int numberOfVertices=graph.getNumberOfVertices();
		Set<Integer> spanningTreeSet = new HashSet<Integer>();
		Arrays.fill(distanceArray,Integer.MAX_VALUE);
		distanceArray[0]=0;
		adjacencyList = graph.getAdjacencyList();
		List<Edge> list;
		while(spanningTreeSet.size()!=numberOfVertices) {
			for (int vertex=0; vertex<numberOfVertices;vertex++) {
				if(! spanningTreeSet.contains(vertex)) {
					spanningTreeSet.add(vertex);
					list = adjacencyList[vertex];
					for(Edge value : list) {
						int sumOfWeightAndSourceVertexDistanceValue = distanceArray[vertex] + value.getWeight();
						int distanceValueOfDestinationVertex =  distanceArray[value.getVertex()];
						if( sumOfWeightAndSourceVertexDistanceValue < distanceValueOfDestinationVertex ) {
							distanceArray[value.getVertex()] = sumOfWeightAndSourceVertexDistanceValue;
						}
					}
				}
			}
		}
		System.out.println("\nvertex\tdistance from source");
		for (int i=0;i<numberOfVertices;i++) {
			System.out.println(i+"\t"+distanceArray[i]);
		}
	}
	
	/**
	 * helper method to find shortest path between two vertices
	 * @param graph object
	 * @param start vertex
	 * @param destination vertex
	 */
	private void calculateShortestDistances (GraphStructure graph,int startVertex,int destinationVertex) {
		//traverseRecursively(graph, startVertex);
		if(pathList.contains(destinationVertex)) {
			distanceArray = new int [graph.getNumberOfVertices()];
			int numberOfVertices=graph.getNumberOfVertices();
			Set<Integer> spanningTreeSet = new HashSet<Integer>();
			Arrays.fill(distanceArray,Integer.MAX_VALUE);
			distanceArray[startVertex]=0;
			adjacencyList = graph.getAdjacencyList();
			List<Edge> list;
			list = graph.getAdjacencyList()[startVertex];
			if(startVertex==destinationVertex) {
				return;
			} else {
				for(Edge value : list) {
					if(! isVisited[value.getVertex()]) {
						int sumOfWeightAndSourceVertexDistanceValue = distanceArray[startVertex] + value.getWeight();
						int distanceValueOfDestinationVertex =  distanceArray[value.getVertex()];
						if( sumOfWeightAndSourceVertexDistanceValue < distanceValueOfDestinationVertex ) {
							distanceArray[value.getVertex()] = sumOfWeightAndSourceVertexDistanceValue;
							shortestPathList.add(value.getVertex());
							calculateShortestDistances(graph,value.getVertex(), distanceValueOfDestinationVertex);
						} 
					} 
				}
			}
			
			/*for(Integer value : spanningTreeSet) {
				System.out.print(value+" ");
			}*/
		} else {
			System.out.println("No route is present between given vertices !");
		}
	}
	
	/**
	 * method traverse the graph in Depth First Order
	 * @param Graph object as input
	 * @return the pathList calculated
	 */
	public List<Integer> getDepthFirstSearchTraversal(GraphStructure graph) {
		pathList = new ArrayList<Integer>();
		int numberOfVertices = graph.getNumberOfVertices();
		isVisited = new boolean [graph.getNumberOfVertices()];
		adjacencyList = graph.getAdjacencyList();
		traverseRecursively(graph,0);
		return pathList;
	}
	
	/**
	 * helper method for getting Depth first traversal of the graph recursively
	 * @param graph object
	 * @param vertex to be traversed
	 */
	private void traverseRecursively(GraphStructure graph,Integer vertex) {
		List<GraphStructure.Edge> list = adjacencyList[vertex];
		pathList.add(vertex);
		isVisited[vertex]=true;
		for(GraphStructure.Edge adjacentVertex : list) {
			if(! isVisited[adjacentVertex.getVertex()]) {
				traverseRecursively(graph, adjacentVertex.getVertex());
			}
		}
	}
	
}
