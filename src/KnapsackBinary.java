import java.util.*;

public class KnapsackBinary {
	
	/*
	 * funciton to find the maximum of 2 integers
	 * @param 2 integers
	 * @return largest of 2 integers
	 */
	int max(int a, int b) {
		return a > b ? a : b;
	}
	
	/*
	 * knapsack using dynamic programming approach
	 * @param weight array, profit array and size of the knapsack
	 */
	void knapsack(int n, int[] w, int[] p, int size) {
		// 2d array to solve the problem using dynamic programing
		int[][] v = new int[n + 1][size + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= size; j++) {
				if(w[i - 1] <= j) {
					v[i][j] = max(v[i - 1][j], (p[i - 1] + v[i - 1][j - w[i - 1]]));
				} else {
					v[i][j] = v[i - 1][j];
				}
			}
		}
		System.out.println("Maximum profit: " + v[n][size]);
		printMatrix(v, n, size);
	}
	
	/*
	 * funciton to print a matrix
	 * @param 2D matrix, row size, coloumn size
	 */
	void printMatrix(int[][] matrix, int m, int n) {
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of objects: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the profits: ");
		int p[] = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = sc.nextInt();
		
		System.out.println("Enter the weights: ");
		int w[] = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
		}
		
		System.out.println("Enter the knapsack size: ");
		int size = sc.nextInt();
		
		KnapsackBinary obj = new KnapsackBinary();
		obj.knapsack(n, w, p, size);
		
		sc.close();
	}
}

/*
input:

4
12 10 20 15
2 1 3 2
5

 */