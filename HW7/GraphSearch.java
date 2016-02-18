import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


//name : Jongyeon Kim(jkim989)
//GTID# : 903018469


public class GraphSearch {

	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a
	 * path exists from the start node to the goal node using General Graph
	 * Search.
	 * 
	 * Assume the AdjacencyList contains adjacent nodes of each node in the
	 * order they should be visited.
	 * 
	 * The structure(struct) passed in is an empty structure may behave as a
	 * Stack or Queue and the correspondingly search function should execute
	 * DFS(Stack) or BFS(Queue) on the graph.
	 * 
	 * @param start
	 * @param struct
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean search(T start, Structure<T> struct, Map<T, List<T>> adjList, T goal) {
		
		Set<T> v = new HashSet<T>();
		struct.add(start);
		while (struct.isEmpty() == false) {
			T element = struct.remove();
			
			// if element and goal is same, return true
			if (goal.equals(element)) {
				return true;
			}
			
			// if element and goal is not same
			else {
				
				// add element to visited
				v.add(element);
				
				if (apply(element, adjList) != null) {
					int i = 0;
					while (i < apply(element, adjList).size()) {
						if (v.contains(apply(element, adjList).get(i)) == false) {
							struct.add(apply(element, adjList).get(i));
						}
						i++;
					}
				}
			}
		}
		return false;
	}
	
	private static <T> List<T> apply(T e, Map<T, List<T>> adjList) {
		
		List<T> list = adjList.get(e);
			return list;
	}

	/**
	 * Find the shortest distance between the start node and the goal node in
	 * the given a weighted graph in the form of an adjacency list where the
	 * edges only have positive weights Return the aforementioned shortest
	 * distance if there exists a path between the start and goal,-1 otherwise.
	 * 
	 * Assume the AdjacencyList contains adjacent nodes of each node in the
	 * order they should be visited. There are no negative edge weights in the
	 * graph.
	 * 
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return the shortest distance between the start and the goal node
	 */
	public static <T> int dsp(T start, Map<T, List<Pair<T, Integer>>> adjList, T goal) {
		
		Comparator<Pair<T, Integer>> comparator = new Comparator<Pair<T, Integer>>() {
			
			public int compare(Pair<T, Integer> c1, Pair<T, Integer> c2) {
				
				// if c1.b and c2.b are null or same, then return 0
				if ((c1.b == null && c2.b == null) || (c1.b == c2.b)) {
					return 0;
				}
				
				// if c1.b is null as positive infinity
				if (c1.b == null) {
					return 1;
				}
				
				// if c2.b is null as positive infinity
				if (c2.b == null) {
					return -1;
				}
				
				// else use normal compareTo
				else
					return (c1.b).compareTo((c2.b));
			}
		};

		int path = 0;
		
		PriorityQueue<Pair<T, Integer>> priorityQueue = new PriorityQueue<Pair<T, Integer>>(adjList.size(), comparator);
		
		// list for visited
		ArrayList<T> v = new ArrayList<T>();
		Pair<T, Integer> initial = new Pair<T, Integer>(start, 0);
		
		// HashMap for weight and valid keys
		HashMap<T, Integer> map = new HashMap<T, Integer>();

		// if start is goal
		if (start.equals(goal)) {
			return initial.b;
		}
		
		else {
		
			// add stars to priorityQueue
			priorityQueue.add(initial);
		
			map.put(start, 0);
		
			// since priorityQueue is not empty
			while (priorityQueue.isEmpty() == false) {
			
				// peek minimum value from priorityQueue
				Pair<T, Integer> minPeek = priorityQueue.peek();
				
				// poll minimum value from priorityQueue
				Pair<T, Integer> minPoll = priorityQueue.poll();
				
				if (!v.contains(minPeek.a)) {
					
					// add minimum value to visited
					v.add(minPeek.a);
				}
			
				// if find a goal, finish search
				if (minPoll.a.equals(goal)) {
					return path = minPoll.b;
				} 
			
				// if do not find goal yet
				else  {

					// if list is not null
					if (adjList.get(minPoll.a) != null) {
						int i = 0;
						while (i < adjList.get(minPoll.a).size()) {
							
							if (!v.contains(adjList.get(minPoll.a).get(i).a)) {
								Pair<T, Integer> compare1 = new Pair<T, Integer>(adjList.get(minPoll.a).get(i).a, map.get(minPoll.a) + adjList.get(minPoll.a).get(i).b);
								Pair<T, Integer> compare2 = new Pair<T, Integer>(adjList.get(minPoll.a).get(i).a, map.get(adjList.get(minPoll.a).get(i).a));
								
								// if compare1 is smaller than compare2
								if (comparator.compare(compare1, compare2) < 0) {
									map.put(adjList.get(minPoll.a).get(i).a, compare1.b);
									priorityQueue.add(compare1);
								}
							}
							i++;
						}
					}
				}
				if (priorityQueue.peek() != null) {
					path = priorityQueue.peek().b;
				}
				else {
					
					// does not have goal
					path = -1;
				}
			}
			return path;
		}
	}
}
