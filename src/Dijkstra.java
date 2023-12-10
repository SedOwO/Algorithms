import java.util.*;


public class Dijkstra {
	int graph[][];
	boolean set[];
	int dist[];
	int n;
	Dijkstra(int n) {
		graph = new int[n][n];
		dist = new int[n];
		set = new boolean[n];
		this.n = n;
	}
	
	Scanner sc = new Scanner(System.in);
	void getGraph() {
		System.out.println("Enter the cost matrix: ");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int var = sc.nextInt();
				if(var == 0) 
					graph[i][j] = 9999;
				else
					graph[i][j] = var;
			}
		}
	}
	
	/*
	 * to find the minimum vertex in the array 'dist[]' not in the list set
	 * also adds the minimum index to the list 'set[]'
	 * @return index with the minimum weight
	 */
	int getMin() {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < n; i++) {
			if(!set[i] && dist[i] < min){	//if 'set[i]' is not considered yet && 'dist[i]' is the smaller than min
				minIndex = i;
				min = dist[i];
			}
		}
		return minIndex;
	}
	
	/*
	 * finds the minimum of 2 numbers
	 * @param 2 integers
	 * @return smallest among the 2
	 */
	int min(int a, int b) {
		if(b < a)
			return b;
		else 
			return a;
	}
	
	/*
	 * function implementing Dijkstra'set algorithm
	 * finds the shortest parth from a given source vertex
	 */
	void dijkstra(){
		getGraph();
		System.out.println("Enter Source: ");
		int src = sc.nextInt();
		for(int i = 0; i < n; i++) 
			dist[i] = graph[src][i];
		set[src] = true;
		dist[src] = 0;
		
		for(int i = 0; i < n; i++) {
			int w = getMin();
			set[w] = true;
			
			for(int v = 0; v < n; v++) {
				if(!set[v]) {
					dist[v] = min(dist[v], dist[w] + graph[w][v]);
				}
			}
		}
		
		//printing the array
		System.out.println(Arrays.toString(dist));
		//System.out.println(Arrays.toString(set));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Vertices: ");
		int n = sc.nextInt();
		Dijkstra G = new Dijkstra(n);
		G.dijkstra();
		sc.close();
	}
}

/*cost matrix


0 10 0 30 100
0 0 50 0 0 
0 0 0 0 10
0 0 20 0 60
0 0 0 0 0

0 10 40 0 55 0 
20 0 20 0 0 0 
0 0 0 0 5 0 
0 35 10 0 30 0 
0 0 0 35 0 0 
0 0 0 3 0 0 

*/
