import java.util.*;

public class HamiltonianCycle {
	boolean graph[][];
	int x[];
	int n;
	
	// graph is boolean cuz only 2 values
	HamiltonianCycle(int n) {
		graph = new boolean[n][n];
		x = new int[n];
		this.n = n;
	}
	
	Scanner sc = new Scanner(System.in);
	
	void getGraph() {
		System.out.println("Enter the adjacency matrix: ");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				if(tmp != 0)
					graph[i][j] = true;
			}
		}
	}
	
	// function to find the next value to be added in x[k]
	void nextValue(int k) {
		int i = 0;
		while(true) {
			x[k] = x[k] + 1;	// assign x[k] to next higest possible vertex
			
			if(x[k] == n) {		// x[k] has radched limit, cannot assign anymore vertex
				x[k] = 0;		// this is important else the inifinite while loop wont stop
				return;			// return to hamiltonian wit x[k] = 0
			}
			// USELESS!
			// if(x[k] == 0)
			// 	return;
				
			// if edge exists between 2 vertices in any stage
			if(graph[x[k - 1]][x[k]])
				for(i = 1; i <= k - 1; i++)
					if(x[i] == x[k])
						break;
			
			if(i == k)
				if(k < n || (k == n && graph[x[n]][1]))	// checks for the validity of the cycle
					return;		// return without modifying x[k]
		}
	}
	
	void hamiltonian(int k) {
		while(true) {
			nextValue(k);	// get the next element of next stage
			
			if(x[k] == 0)	// cant assign vertex, then backtrack cuz dead-end
				return;
			
			// if the recursion has gone throught all the vertices, n - 1 because: 0, 1, 2... n - 1
			if(k == n - 1) {
				System.out.println("\n Path");
				for (int i = 0; i < n; i++)
					System.out.print((x[i] + 1) + "-->");
				System.out.println("1");
			}
			else 			// not yet reached the end, then go the the k + 1 iteration
				hamiltonian(k + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n = sc.nextInt();
		HamiltonianCycle obj = new HamiltonianCycle(n);
		obj.getGraph();
		
		// starting from index 1 because the first index is alwasys 0
		obj.hamiltonian(1);
		
		sc.close();
	}
}
/*
input

0 1 1 1 
1 0 1 0
1 1 0 1
1 0 1 0
 */