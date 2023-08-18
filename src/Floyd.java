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
     * @param: 2 integers a and b
     * @return: smallest of a and b
     */
    int min(int a, int b) {
        return (a < b) ? a : b;
    }
    
    /*
     * funciton to clone a matrix
     * @param: 2D matrix
     * @return: clone of the original matrix
     */
    int[][] clone(int[][] matrix) {
        if(matrix == null)
            return null;
        
        int[][] tmpMatrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            tmpMatrix[i] = Arrays.copyOf(matrix[i], matrix.length);
        }
        return tmpMatrix;
    }
    
    
    void floydsAlgorithm() {
        getGraph();
        int[][] prevgraph = clone(graph);
        int[][] curgraph = new int[n][n];
        
        for(int k = 0; k < n; k ++) {
            curgraph = clone(prevgraph);
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == k || j == k) {
                        continue;       //do nothing if i or j is intermediate
                    } else {
                        curgraph[i][j] = min(prevgraph[i][j], prevgraph[i][k] + prevgraph[k][j]);
                    }
                }
            }
            prevgraph = clone(curgraph);
        }
        printMatrix(curgraph);
    }
    
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