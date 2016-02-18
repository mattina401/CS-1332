import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import struct.Worth;

//import struct.Worth;

/**
*This test class is divided into 4 parts, each of which test a critical part of the homework
*Part 1: Tests if the StackStrucutre has complete functionality
*Part 2: Tests if the QueueStructure has complete functionality
*Part 3: Tests if the Search method in the GraphSearch class works as required
*Part 4: Tests if the Djikstra's Shortest Path function in the GraphSearch class works as required
*/


public class GraphTest {

	
	//Part 1:Testing if Stack Structure works as required

	public StructureStack<Integer> stack= new StructureStack<Integer>();

	@Test (timeout = 300)
	@Worth (points = 5)
	public void StackTest1() {
		//Empty and Clear Check
		assertTrue(stack.isEmpty());
		stack.add(1);
		stack.add(2);
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	@Test (timeout = 300)
	@Worth (points = 5)
	public void StackTest2() {
		//Add and remove check
		stack = new StructureStack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(1);
		stack.add(1);
		
		assertEquals((Integer)1,stack.remove());
		assertEquals((Integer)1,stack.remove());
		assertEquals((Integer)4,stack.remove());
		assertEquals((Integer)3,stack.remove());
		assertEquals((Integer)2,stack.remove());
		assertEquals((Integer)1,stack.remove());	
	}
	
	//Part 2: Testing if Queue Structure works as Required

	public StructureQueue<Integer> queue= new StructureQueue<Integer>();
	@Test (timeout = 300)
	@Worth (points = 5)
	public void QueueTest1() {

		//Empty and Clear Check
		assertTrue(queue.isEmpty());
		queue.add(1);
		queue.add(2);
		queue.clear();
		assertTrue(queue.isEmpty());
	}

	@Test (timeout = 300)
	@Worth (points = 5)
	public void QueueTest2() {

		//Add and remove check
		queue = new StructureQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(1);
		queue.add(1);
		
		assertEquals((Integer)1,queue.remove());
		assertEquals((Integer)2,queue.remove());
		assertEquals((Integer)3,queue.remove());
		assertEquals((Integer)4,queue.remove());
		assertEquals((Integer)1,queue.remove());
		assertEquals((Integer)1,queue.remove());
	}
	

	//Part 3:General Graph Search Test

	//Instantiation of Data Structures being used
	public TAStructureStack<Character> s = new TAStructureStack<Character>();
	public TAStructureQueue<Character> q = new TAStructureQueue<Character>();
	public HashMap<Character,List<Character>> GraphUnweighted=new HashMap<Character,List<Character>>();
	
	@Before
	public void buildGraphUnweighted(){
		
		GraphUnweighted.put('A',Arrays.asList('B','D'));
		GraphUnweighted.put('B',Arrays.asList('A','C','F'));
		GraphUnweighted.put('C',Arrays.asList('B','D','E','F'));
		GraphUnweighted.put('D',Arrays.asList('A','C'));
		GraphUnweighted.put('E',Arrays.asList('C','F','Y'));
		GraphUnweighted.put('F',Arrays.asList('B','C','E'));
		GraphUnweighted.put('X',Arrays.asList('Y','Z'));
		GraphUnweighted.put('Y',Arrays.asList('E','X'));
		GraphUnweighted.put('Z',Arrays.asList('X'));
		GraphUnweighted.put('M',Arrays.asList('N','P'));
		GraphUnweighted.put('N',Arrays.asList('M','P'));
		GraphUnweighted.put('P',Arrays.asList('M','N'));
	}

	//---------------------------//
	
	//Finding Self
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DFSSearchTest1() {
		s.clear();
		assertTrue(GraphSearch.search('A', s, GraphUnweighted, 'A'));
		assertTrue(GraphSearch.search('B', s, GraphUnweighted, 'B'));
		assertTrue(GraphSearch.search('M', s, GraphUnweighted, 'M'));
	}

	//Basic Path Exists
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DFSSearchTest2() {
		s.clear();
		assertTrue(GraphSearch.search('A', s, GraphUnweighted, 'F'));
		assertTrue(GraphSearch.search('A', s, GraphUnweighted, 'X'));
		assertTrue(GraphSearch.search('D', s, GraphUnweighted, 'Z'));
	}

	//Basic Path Doesn't Exists
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DFSSearchTest3() {
		s.clear();
		assertFalse(GraphSearch.search('A', s, GraphUnweighted, 'M'));
		assertFalse(GraphSearch.search('M', s, GraphUnweighted, 'F'));
		assertFalse(GraphSearch.search('X', s, GraphUnweighted, 'M'));
	}
	
	//Cycle test
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DFSSearchTest4() {
		s.clear();
		assertTrue(GraphSearch.search('A', s, GraphUnweighted, 'C'));
		assertTrue(GraphSearch.search('A', s, GraphUnweighted, 'D'));
		assertTrue(GraphSearch.search('M', s, GraphUnweighted, 'N'));
		assertTrue(GraphSearch.search('M', s, GraphUnweighted, 'P'));
	}


	//Stack Order(Actually doing DFS and not BFS)
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DFSSearchTest5() {
		s.clear();
		GraphSearch.search('A', s, GraphUnweighted, 'F');
		List<Character> popped=s.getPopped();
		assertEquals((Character)'A',(Character)popped.get(0));
		assertEquals((Character)'D',(Character)popped.get(1));
		assertEquals((Character)'C',(Character)popped.get(2));
		
	}

	//------------------------------//

	//Finding Self
	@Test (timeout = 300)
	@Worth (points = 5)
	public void BFSSearchTest1() {
		q.clear();
		assertTrue(GraphSearch.search('A', q, GraphUnweighted, 'A'));
		assertTrue(GraphSearch.search('B', q, GraphUnweighted, 'B'));
		assertTrue(GraphSearch.search('M', q, GraphUnweighted, 'M'));
	}

	//Basic Path Exists
	@Test (timeout = 300)
	@Worth (points = 5)
	public void BFSSearchTest2() {
		q.clear();
		assertTrue(GraphSearch.search('A', q, GraphUnweighted, 'F'));
		assertTrue(GraphSearch.search('A', q, GraphUnweighted, 'X'));
		assertTrue(GraphSearch.search('D', q, GraphUnweighted, 'Z'));
	}

	//Basic Path Doesn't Exists
	@Test (timeout = 300)
	@Worth (points = 5)
	public void BFSSearchTest3() {
		q.clear();
		assertFalse(GraphSearch.search('A', q, GraphUnweighted, 'M'));
		assertFalse(GraphSearch.search('M', q, GraphUnweighted, 'F'));
		assertFalse(GraphSearch.search('X', q, GraphUnweighted, 'M'));
	}
	
	//Cycle test
	@Test (timeout = 300)
	@Worth (points = 5)
	public void BFSSearchTest4() {
		q.clear();
		assertTrue(GraphSearch.search('A', q, GraphUnweighted, 'C'));
		assertTrue(GraphSearch.search('A', q, GraphUnweighted, 'D'));
		assertTrue(GraphSearch.search('M', q, GraphUnweighted, 'N'));
		assertTrue(GraphSearch.search('M', q, GraphUnweighted, 'P'));
	}


	//Queue Order(Actually doing BFS and not DFS)
	@Test (timeout = 300)
	@Worth (points = 5)
	public void BFSSearchTest5() {
		q.clear();
		GraphSearch.search('A', q, GraphUnweighted, 'F');
		List<Character> popped=q.getPopped();
		assertEquals((Character)'A',(Character)popped.get(0));
		assertEquals((Character)'B',(Character)popped.get(1));
		assertEquals((Character)'D',(Character)popped.get(2));
		
	}
	
	//-----------------------------//

	//Part 4: Djikstra's Shortest Path Test
	public HashMap<Character,List<Pair<Character, Integer>>> GraphWeighted=new HashMap<Character, List<Pair<Character, Integer>>>();
	
	@Before
	public void buildGraphWeighted(){
		
		GraphWeighted.put('A',Arrays.asList(new Pair<Character,Integer>('B',2),new Pair<Character,Integer>('C',4)));
		GraphWeighted.put('B',Arrays.asList(new Pair<Character,Integer>('A',2),new Pair<Character,Integer>('C',4),new Pair<Character,Integer>('G',2)));
		GraphWeighted.put('C',Arrays.asList(new Pair<Character,Integer>('A',4),new Pair<Character,Integer>('B',4)));
		GraphWeighted.put('D',Arrays.asList(new Pair<Character,Integer>('C',2),new Pair<Character,Integer>('E',4),new Pair<Character,Integer>('F',1),new Pair<Character,Integer>('H',2)));
		GraphWeighted.put('E',Arrays.asList(new Pair<Character,Integer>('D',4),new Pair<Character,Integer>('F',1),new Pair<Character,Integer>('G',1)));
		GraphWeighted.put('F',Arrays.asList(new Pair<Character,Integer>('E',1),new Pair<Character,Integer>('D',1)));
		GraphWeighted.put('G',Arrays.asList(new Pair<Character,Integer>('B',2),new Pair<Character,Integer>('E',1),new Pair<Character,Integer>('H',4)));
		GraphWeighted.put('H',Arrays.asList(new Pair<Character,Integer>('D',2),new Pair<Character,Integer>('G',4)));
		GraphWeighted.put('W',Arrays.asList(new Pair<Character,Integer>('Y',2),new Pair<Character,Integer>('X',4)));
		GraphWeighted.put('X',Arrays.asList(new Pair<Character,Integer>('Z',2),new Pair<Character,Integer>('W',4),new Pair<Character,Integer>('Y',1)));
		GraphWeighted.put('Y',Arrays.asList(new Pair<Character,Integer>('W',2),new Pair<Character,Integer>('Z',4),new Pair<Character,Integer>('X',1)));
		GraphWeighted.put('Z',Arrays.asList(new Pair<Character,Integer>('X',2),new Pair<Character,Integer>('Y',4)));
	}

	//Finite Shortest Path Exists
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DjikstraTest1() {
		assertEquals(2,GraphSearch.dsp('A',GraphWeighted,'B'));
		assertEquals(4,GraphSearch.dsp('A',GraphWeighted,'G'));
		assertEquals(6,GraphSearch.dsp('B',GraphWeighted,'H'));
	}

	//Finite Shortest Path Exists via a cycle
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DjikstraTest2() {
		assertEquals(8,GraphSearch.dsp('A',GraphWeighted,'H'));
		assertEquals(3,GraphSearch.dsp('G',GraphWeighted,'D'));
		assertEquals(2,GraphSearch.dsp('E',GraphWeighted,'D'));
	}

	//Finite Shortest Path Exists via a cycle
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DjikstraTest3() {
		assertEquals(5,GraphSearch.dsp('W',GraphWeighted,'Z'));
		assertEquals(3,GraphSearch.dsp('X',GraphWeighted,'W'));
		assertEquals(5,GraphSearch.dsp('D',GraphWeighted,'B'));
	}

	//Shortest Path Does not exist no cycle
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DjikstraTest4() {
		assertEquals(-1,GraphSearch.dsp('A',GraphWeighted,'Z'));
		assertEquals(-1,GraphSearch.dsp('B',GraphWeighted,'X'));
		assertEquals(-1,GraphSearch.dsp('D',GraphWeighted,'Z'));
	}

	//Shortest Path Does not exist cycle
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DjikstraTest5() {
		assertEquals(-1,GraphSearch.dsp('Z',GraphWeighted,'G'));
		assertEquals(-1,GraphSearch.dsp('X',GraphWeighted,'B'));
		assertEquals(-1,GraphSearch.dsp('D',GraphWeighted,'Z'));
	}

	//Self==0
	@Test (timeout = 300)
	@Worth (points = 5)
	public void DjikstraTest6() {
		assertEquals(0,GraphSearch.dsp('Z',GraphWeighted,'Z'));
		assertEquals(0,GraphSearch.dsp('A',GraphWeighted,'A'));
		assertEquals(0,GraphSearch.dsp('D',GraphWeighted,'D'));
	}

}
