import java.util.*;

public class Floyd {
    int n;
    int[][] graph;
    
    Floyd(int n) {
        this.n = n;
        graph = new int[n][n];
    }
    
    Scanner sc = new Scanner(System.in);
    void getGraph() {
        System.out.println("Enter the cost matrix: ");
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if(i == j)
                    graph[i][j] = 0;
                else if(tmp == 0)
                    graph[i][j] = 9999;
                else
                    graph[i][j] = tmp;
            }
        }
    }
    
    /*
     * funciton to find the minimum of 2 numbers
     * @param 2 integers a and b
     * @return smallest of a and b
     */
    int min(int a, int b) {
        return (a < b) ? a : b;
    }
    
    /*
     * funciton to clone a matrix
     * @param 2D matrix
     * @return clone of the original matrix
     */
    int[][] clone(int[][] matrix) {
        if(matrix == null)
            return null;
        
        int[][] tmpMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmpMatrix[i][j] = matrix[i][j];
            }
        }
        return tmpMatrix;
    }
    
    /*
     * function that implements Floyd-Warshall Algorithm
     */
    void floydsAlgorithm() {
        getGraph();
        int[][] graphcpy = clone(graph);
		
        for(int k = 0; k < n; k ++) {
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == k || j == k) {
                        continue;       //do nothing if i or j is intermediate
                    } else {
                        graphcpy[i][j] = min(graphcpy[i][j], graphcpy[i][k] + graphcpy[k][j]);
                    }
                }
            }
        }
        printMatrix(graphcpy);
    }
    
    /*
     * prints the cost matrix in a matrix form
     * @param 2D matrix
     */
    void printMatrix(int[][] matrix) {
        System.out.println("All pairs shortest path: ");
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        Floyd f = new Floyd(n);
        f.floydsAlgorithm();
        sc.close();
    }
}

/* 
inputs:

0 0 3 0
2 0 0 0
0 7 0 1
6 0 0 0

 */