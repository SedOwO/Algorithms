import java.util.*;

// fractional Knapsack problem
public class KnapsackFractional {
	
	// funciton to return index having maximum profit
	static int getMaxIndex(float[] p) {
		float maxProfit = 0.0f;
		int maxIndex = 0;
		for (int i = 0; i < p.length; i++) {
			if(p[i] > maxProfit){
				maxProfit = p[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	static void knapsack(float m, int n, float[] w, float[] p) {
		float x[] = new float[n];		//holds the final profit after the knapsack is full
		float profit = 0.0f;
		float rc = m;
		
		int i = getMaxIndex(p);
		while(w[i] <= rc) {
			x[i] = 1;
			rc -= w[i];
			profit += p[i];
			p[i] = 0;					//ugly part of the code
			i = getMaxIndex(p);
		}
		// fractional knapsack
		if(rc != 0) {
			x[i] = rc / w[i];
			profit += x[i] * p[i];
		}
		
		//print profit and x[i]
		System.out.println("Profit: " + profit);
		System.out.println(Arrays.toString(x));
	}


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of the Knapsack: ");
		float m = sc.nextFloat();
		System.out.println("Enter the number of total objects: ");
		int n = sc.nextInt();
		
		float[] w = new float[n];
		float[] p = new float[n];
		
		System.out.println("Enter the weights of the objects: ");
		for(int i = 0; i < n; i++) {
			System.out.print("Object " + i + " weight: ");
			w[i] = sc.nextInt();
		}
		System.out.println("Enter the profit of the objects: ");
		for(int i = 0; i < n; i++) {
			System.out.print("Object " + i + " profit: ");
			p[i] = sc.nextInt();
		}
		knapsack(m, n, w, p);
		sc.close();
	}
}
/*
 
40
3
20 25 10
30 40 35

 */
	