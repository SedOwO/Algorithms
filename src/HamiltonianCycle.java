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
	
	// function to find the next value to be added
	void nextValue(int k) {
		int i = 0;
		while(true) {
			x[k] = x[k] + 1;
			if(x[k] == n)
				x[k] = 0;
			if(x[k] == 0)
				return;
				
			// if edge exists between 2 vertices in any stage
			if(graph[x[k - 1]][x[k]])
				for(i = 1; i <= k - 1; i++)
					if(x[i] == x[k])
						break;
			
			if(i == k)
				if(k < n || k == n && graph[x[n]][1])
					return;
		}
	}
	
	void hamiltonian(int k) {
		while(true) {
			nextValue(k);	// get the next element of next stage
			if(x[k] == 0)
				return;
			if(k == n - 1) {
				System.out.println("\n Path");
				for (int i = 0; i < n; i++)
					System.out.print((x[i] + 1) + "-->");
				System.out.println("1");
			}
			else 
				hamiltonian(k + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n = sc.nextInt();
		HamiltonianCycle obj = new HamiltonianCycle(n);
		obj.getGraph();
		
		// starting from first stage
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