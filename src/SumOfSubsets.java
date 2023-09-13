import java.util.*;
public class SumOfSubsets {
	int w[];
	boolean x[];
	int sum;
	int total;
	int n;
	
	SumOfSubsets(int n){
		this.n = n;
		w = new int[n];
		x = new boolean[n];
	}
	
	Scanner sc = new Scanner(System.in);
	
	/*
	* funciton to get the subset and the sum to match from the user
	* also checks the edge case (total < sum)
	*/
	void getSet() {
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			total += w[i];
		}
		System.out.println("Enter the sum to match: ");
		sum = sc.nextInt();
		if(total < sum) {
			System.out.println("Subset not possible");
			System.exit(1);
		}
	}
	
	/*
	 * funciton that does all the funcion call
	 */
	void computeSubset() {
		getSet();
		System.out.println("The subset(s) are: ");
		
		// initial sum = 0
		// initial remaining value = total
		// initial stage = 0 (because we start from 0)
		subset(0, total, 0);
	}
	
	/*
	 * subset funcion recursively calling itself
	 * @param
	 * 		s = sum considred till now
	 * 		r = remaining total
	 * 		k = stage (level in the binary tree)
	 */
	void subset(int s, int r, int k) {
		// base case
		if(k == n) {	// 'k' reached max length i.e., reached last stage
			if(s == sum) {	// sum matches
				printSet();
			}
			return;		// return to another branch
		}
		
		// if there is enough space
		if (s + w[k] <= sum) {
			x[k] = true;
			subset(s + w[k], r - w[k], k + 1);
		}
		
		// item not included
		x[k] = false;
		subset(s, r - w[k], k + 1);
	}
	
	/*
	 * function to print the subset in the format (s1 s2 s3 s4 ...)
	 */
	void printSet() {
		System.out.print("(");
		for (int i = 0; i < n; i++) {
			if(x[i])	// print only if element is included
				System.out.print(" " + w[i]);
		}
		System.out.println(")");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		SumOfSubsets obj = new SumOfSubsets(n);
		obj.computeSubset();
		
		sc.close();
	}
}
/*
input

6
1 2 3 4 6 7
11
 */