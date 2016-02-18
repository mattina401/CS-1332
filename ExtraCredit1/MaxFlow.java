
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//name : Jongyeon Kim
//GTID : jkim989

/**
 * You're given a directed graph in the form of an Adjacency Matrix Your goal is
 * to find the maximum flow given a source and sink node.
 * 
 * Remember this is a directed graph, so matrix[i][j] doesn't always equal
 * matrix[j][i]. matrix[][] is a square matrix and the number of nodes in the
 * graph is equal to the dimension of the matrix.
 * 
 * We will only be grading this based on the value you return. This means you
 * may code it however you want. (There are many different ways to implement
 * these algorithms)
 * 
 * Remember, don't change any headers like in previous homeworks.
 * 
 * * * * * * * * * * *
 * 
 * You may assume that every graph has at least two nodes, and that source and
 * sink are two valid distinct nodes. capacity[i][j] having a value of 0
 * represents that there is no edge going from vertex i to vertex j. Note that
 * cost[i][j] has no meaning if capacity[i][j] is initially 0 and it should
 * be ignored
 * 
 * * * * * * * * * * *
 * 
 * These are not necessarily algorithms we've gone over. You will have to do a
 * little research to code these.
 * 
 * * * * * * * * * * *
 * 
 * Example:
 * 
 * int[][] matrix = {{0,2}, {0,0}}; 
 * int[][] cost = {{0, 4}, {0, 0}};
 * 
 * MaxFlow.maxFlow(matrix, 0, 1) should return 2 
 * MaxFlow.minCost(matrix, cost, 0, 1) should return 8
 * 
 */
public class MaxFlow {

	/**
	 * Max Flow (Ford Fulkerson / Edmonds Karp)
	 * 
	 * This method returns the maximum flow through a graph.
	 * 
	 * @param capacity
	 * @param source
	 * @param sink
	 * @return
	 */
	public static int maxFlow(int[][] capacity, int source, int sink) {
		
		int Vs = capacity.length;
		int Flow = 0;
		int[][] F = new int[Vs][Vs];
		int[] par = new int[Vs];
		
		int i = 0;
		while (i < Vs) {
			int j = 0;
			while (j < Vs) {
				F[i][j] = 0;
				j++;
			}
			i++;
		}
		
		while (true) {
			
			int k = 0;
			while (k < Vs) {
				par[k] = -1;
				k++;
			}
			
			Queue<Integer> Q = new LinkedList<Integer>();
			
			par[source] = -2;
			Q.add(source);
			
			while(!Q.isEmpty() && (par[sink] == -1)) {
				int u = Q.poll();
				
				int v = 0;
				while (v < Vs) {
					if(par[v] == -1){
						if(F[v][u] > 0 || F[u][v] < capacity[u][v]){
							par[v] = u;
							Q.add(v);
						}
					}
					v++;
				}
			}
			
			if(par[sink] == -1) {
				break;
			}
			
			int path = Integer.MAX_VALUE;
			int V = sink;
			int U = par[V];
			while(U >= 0) {
				if(F[V][U] > 0) {
					path = Math.min(F[V][U], path);
				} else{
					path = Math.min(capacity[U][V] - F[U][V], path);
				}
				V = U;
				U = par[V];
			}
			V= sink;
			U = par[V];
			
			while(U >= 0) {
				if(F[V][U] > 0) {
					F[V][U] = F[V][U] - path;
				}
				else {
					F[U][V] = F[U][V] + path;
				}
				
				V = U;
				U = par[V];
			}
			Flow = Flow + path;
		}
		
		return Flow;
	}

	/**
	 * Min-Cost Max-Flow
	 * 
	 * This method returns the minimum cost of the maximum flow through a graph.
	 * The cost of putting a single unit of flow through an edge i,j is
	 * cost[i][j]
	 * 
	 * @param capacity
	 * @param cost
	 * @param source
	 * @param sink
	 * @return
	 */
	public static int minCost(int[][] capacity, int[][] cost, int source, int sink) {
		searchMin min = new searchMin(source, sink, capacity, cost);
		int C = 0;
		int F = 0;
		while (min.search(source, sink)) {
			int M = min.INF;
			for (int i = sink; i != source; i = min.par[i]) {
				M = Math.min(M, min.flow[i][min.par[i]] != 0 ? min.flow[i][min.par[i]] : min.capacity[min.par[i]][i] - min.flow[min.par[i]][i]);
			}
			for (int i = sink; i != source; i = min.par[i]){
				if(min.flow[i][min.par[i]] != 0){
					min.flow[i][min.par[i]] = min.flow[i][min.par[i]] - M;
					C = C - M * min.C[i][min.par[i]];
				}
				else{
					min.flow[min.par[i]][i] = min.flow[min.par[i]][i] + M;
					C = C + M * min.C[min.par[i]][i];
				}
			}
			F = F + M;
		}
		return C;
	}

	private static class searchMin {
		boolean F[];
		int L;
		int D[];
		int P[];
		int capacity[][];
		int C[][];
		int flow[][];
		int par[];

		private searchMin(int source, int sink, int[][] capacity, int[][] cost) {
			this.capacity = capacity;
			this.C = cost;
			L = capacity.length;
			F = new boolean[L];
			flow = new int[L][L];
			D = new int[L + 1];
			par = new int[L];
			P = new int[L];
		}

		final int INF = (Integer.MAX_VALUE / 2) - 1;

		private boolean search(int source, int sink) {
			Arrays.fill(F, false);
			Arrays.fill(D, INF);
			D[source] = 0;

			while (source != L) {
				int path = L;
				F[source] = true;
				for (int i = 0; i < L; i++) {
					if (F[i]) {
						continue;
					}
					if (flow[i][source] != 0) {
						int value = D[source] + P[source] - P[i] - C[i][source];
						if (D[i] > value) {
							D[i] = value;
							par[i] = source;
						}
					}
					if (flow[source][i] < capacity[source][i]) {
						int value = D[source] + P[source] - P[i] + C[source][i];
						if (D[i] > value) {
							D[i] = value;
							par[i] = source;
						}
					}
					if (D[i] < D[path])
						path = i;
					
				}
				source = path;
			}
			
			int k = 0;
			while (k < L) {
				P[k] = Math.min(P[k] + D[k], INF);
				k++;
			}
			return F[sink];
		}
	}
}