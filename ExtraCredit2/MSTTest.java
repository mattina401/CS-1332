//import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class MSTTest {

	@Test
	public void disjoint1(){
		int num = 1000;
		Set<Integer> s = makeSet(num);
		DisjointSets<Integer> ds = new DisjointSets<Integer>(s);
		//Merge everything
		for(int i = 0; i<num; i++){
			for(int j = i+1; j<num; j++){
				ds.merge(i, j);
			}
		}
		//Test if everything is in the same set
		for(int i = 0; i<num; i++){
			for(int j = i+1; j<num; j++){
				assertTrue(ds.sameSet(i, j));
				assertTrue(ds.sameSet(j, i));
			}
		}
	}
	
	@Test
	public void disjoint2(){
		Set<Integer> s = makeSet(10);
		DisjointSets<Integer> ds = new DisjointSets<Integer>(s);
		//Merge
		ds.merge(0, 1);
		//Merge again to check for loop
		ds.merge(1, 0);
		assertTrue(ds.sameSet(0, 1));
		assertTrue(ds.sameSet(1, 0));
	}
	@Test
	public void noMSTKruskal() {
		Collection<Edge> mst = MST.kruskals(makeDisconnectedGraph());
		assertTrue(mst == null);
	}
	
	@Test
	public void noMSTPrims() {
		Collection<Edge> mst = MST.prims(makeDisconnectedGraph(), 1);
		assertTrue(mst == null);
	}
	
	@Test
	public void testTriangleKruskals(){
		Graph g = makeTriangleGraph();
		Collection<Edge> mst = MST.kruskals(g);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(3, sum);
		
	}
	
	@Test
	public void testTrianglePrims(){
		Graph g = makeTriangleGraph();
		Collection<Edge> mst = MST.prims(g, 1);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(3, sum);
		
	}

	@Test
	public void testKruskals4(){
		Graph g = makeGraph4();
		Collection<Edge> mst = MST.kruskals(g);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(7, sum);
		
	}
	@Test
	public void testKruskals3(){
		Graph g = makeGraph3();
		Collection<Edge> mst = MST.kruskals(g);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(53, sum);
	}
	
	@Test
	public void testPrims3(){
		Graph g = makeGraph3();
		Collection<Edge> mst = MST.prims(g, 3);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(53, sum);
	}
	
	@Test
	public void testPrims4(){
		Graph g = makeGraph4();
		Collection<Edge> mst = MST.prims(g, 3);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(7, sum);
		
	}
	
	@Test
	public void testKruskals5(){
		Graph g = makeGraph5();
		Collection<Edge> mst = MST.kruskals(g);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(23, sum);
		
	}
	
	@Test
	public void testPrims5(){
		Graph g = makeGraph5();
		Collection<Edge> mst = MST.prims(g, 3);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(23, sum);
		
	}
	
	@Test
	public void testKruskals6(){
		Graph g = makeGraph6();
		Collection<Edge> mst = MST.kruskals(g);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(31, sum);
	}
	
	@Test
	public void testPrims6(){
		Graph g = makeGraph6();
		Collection<Edge> mst = MST.prims(g, 10);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(31, sum);
	}
	
	@Test
	public void testKruskals7(){
		Graph g = makeGraph7();
		Collection<Edge> mst = MST.kruskals(g);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(9, sum);
	}
	
	@Test
	public void testPrims7(){
		Graph g = makeGraph7();
		Collection<Edge> mst = MST.prims(g, 0);
		HashSet<Vertex> set = new HashSet<Vertex>();
		int sum = 0;
		for(Edge e : mst){
			sum += e.getWeight();
			set.add(e.getU());
			set.add(e.getV());
		}
		//MST contains every vertex
		for(Vertex v : g.getVertices()){
			assertTrue(set.contains(v));
		}
		//MST contain the appropriate number of edges
		assertTrue(mst.size() == g.getVertices().size() - 1);
		//MST is appropriate weight
		assertEquals(9, sum);
	}
	
	public Set<Integer> makeSet(int num){
		HashSet<Integer> ret = new HashSet<Integer>();
		for(int i = 0; i<num; i++){
			ret.add(i);
		}
		return ret;
	}
	public Graph makeDisconnectedGraph(){
		String in = "2 1 2 3 3 4 2";
		return new Graph(in);
	}
	
	public Graph makeTriangleGraph(){
		String in = "3 1 2 1 1 3 2 2 3 3";
		return new Graph(in);
	}
	
	public Graph makeGraph3(){
		String in = "15 1 2 5 1 4 7 2 4 8 2 3 6 2 5 7 3 5 9 4 5 10 4 6 8 5 7 9 5 9 15 6 7 5 6 8 7 7 8 9 7 9 8 8 9 11";
		return new Graph(in);
	}
	
	public Graph makeGraph4(){
		String in = "6 1 2 4 1 3 1 2 4 3 3 5 3 3 4 1 4 5 2";
		return new Graph(in);
	}
	
	public Graph makeGraph5(){
		String in = "14 1 2 4 1 3 5 1 9 3 2 3 2 2 6 3 2 7 5 3 4 6 4 5 1 5 8 4 6 7 1 6 9 7 6 10 2 7 8 3 9 10 5";
		return new Graph(in);
	}
	
	public Graph makeGraph6(){
		String in = "10 1 2 1 1 3 1 1 4 1 2 5 2 2 6 2 3 10 3 4 7 4 4 8 4 6 9 6 7 11 7";
		return new Graph(in);
	}
	
	public Graph makeGraph7(){
		String in = "45";
		for(int i = 1; i < 10; i++){
			for(int j = 0; j<i ;j++){
				in += " "+i+" "+j+" "+1;
			}
		}
		return new Graph(in);
	}
	

}
