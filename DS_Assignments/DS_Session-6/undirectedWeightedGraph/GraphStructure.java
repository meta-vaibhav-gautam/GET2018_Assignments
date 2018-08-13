package undirectedWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * class for defining structure of a graph
 * created on August 10, 2018
 */
public class GraphStructure {

	private int numberOfVertices;
	private LinkedList<Edge> adjacencyList[];
	
	public GraphStructure (int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		adjacencyList = new LinkedList [numberOfVertices];
		
		for(int i=0;i<numberOfVertices;i++) {
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}
	
	/**
	 * Edge class containing attributes of edge
	 */
	static class Edge {
		
		private int vertex;
		private int weight;
		
		public Edge (int vertex,int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int getVertex() {
			return vertex;
		}

		public int getWeight() {
			return weight;
		}
		
		
	}
	
	public void addEdgeToGraph(int source, int destination,int weight) {
		Edge edge1 = new Edge(source, weight);
		Edge edge2 = new Edge(destination, weight);
		adjacencyList[source].add(edge2);
		adjacencyList[destination].add(edge1);
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	} 

	public LinkedList<Edge>[] getAdjacencyList() {
		return adjacencyList;
	}
	
	
	
}
