import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

// name : Jongyeon Kim
// GTID : jkim989

public class MST {

    /**
     * Using Disjoint set(s), run Kruskal's algorithm on the given graph and return the MST, return
     * null if no MST exists for the graph
     * 
     * @param g
     *            The graph, g will never be null
     * @return the MST of the graph, null if no valid MST exists
     */
    public static Collection<Edge> kruskals(Graph g) {
        // TODO
    	
    	LinkedList<Edge> Eg = new LinkedList<>(g.getEdgeList());
    	DisjointSets<Vertex> djset = new DisjointSets<>(g.getVertices());
    	LinkedList<Edge> mst = new LinkedList<>();
    	Collections.sort(Eg);
    	
    	for (Edge small : Eg) {
    		Vertex v = small.getV();
    		Vertex u = small.getU();
    		
    		if (!djset.sameSet(u, v)) {
    			djset.merge(u, v);
    			mst.add(small);
    		}
    	}
    	
    	if (mst.size() == g.getVertices().size() - 1) {
    		return mst;
    	} else {
        return null;
    	}
    }

    /**
     * Run Prim's algorithm on the given graph and return the minimum spanning tree
     * If no MST exists, return null
     * 
     * @param g 
     * 				The graph to be processed.  Will never be null
     * @param start 
     * 				The ID of the start node.  Will always exist in the graph
     * @return the MST of the graph, null if no valid MST exists
     */
    public static Collection<Edge> prims(Graph g, int start){
    	
    	Vertex initial = new Vertex(start);
    	PriorityQueue<Edge> Q = new PriorityQueue<Edge>();
    	LinkedList<Edge> mst = new LinkedList<Edge>();
		HashSet<Vertex> visitedV = new HashSet<Vertex>(); 
		visitedV.add(initial);

		
		for (Vertex V : g.getAdjacencies(initial).keySet()) {
			Q.add(new Edge(initial, V, g.getAdjacencies(initial).get(V)));		
		}

		
		while (!Q.isEmpty()) {
			
			Edge edge = Q.poll();
			
			if (!visitedV.contains(edge.getU()) || !visitedV.contains(edge.getV())) {
				Vertex vertex;
				if (!visitedV.contains(edge.getU())) {
					vertex = edge.getU();
					visitedV.add(vertex);
				} else {
					vertex = edge.getV();
					visitedV.add(vertex);
				}
				
				for (Vertex V : g.getAdjacencies(vertex).keySet()) {
					Q.add(new Edge(vertex, V, g.getAdjacencies(vertex).get(V)));
				}

				mst.add(edge);
			}
		}
    	if (mst.size() == g.getVertices().size() - 1) {
    		return mst;
    	} else {
        return null;
    	}
	}
}