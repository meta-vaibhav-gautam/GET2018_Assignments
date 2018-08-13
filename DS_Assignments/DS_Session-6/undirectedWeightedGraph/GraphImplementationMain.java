package undirectedWeightedGraph;

/**
 * class containing main method
 * created on August 11, 2018
 */
public class GraphImplementationMain {
	public static void main(String args[]) {
		GraphStructure graph = new GraphStructure(7);
		
		graph.addEdgeToGraph(0,1,1);
		graph.addEdgeToGraph(0,2,1);
		graph.addEdgeToGraph(0,3,5);
		graph.addEdgeToGraph(0,4,2);
		graph.addEdgeToGraph(1,3,1);
		graph.addEdgeToGraph(1,4,3);
		graph.addEdgeToGraph(3,4,2);
		graph.addEdgeToGraph(2,5,5);
		graph.addEdgeToGraph(2,6,7);
		graph.addEdgeToGraph(5,6,8);
		
		GraphImplementation obj = new GraphImplementation();
		System.out.println("Connected : "+obj.isConnected(graph));
		System.out.println("Reachable vertex from 0: ");
		for(int value : obj.getReachableVertices(graph, 0)) {
			System.out.print(value+" ");
		}
		
		System.out.println("\nShortest path from 0 to 3:");
		obj.getShortestPath(0, 3, graph);
		obj.getMinimumSpanningTree(graph);
		
	}
	
}
