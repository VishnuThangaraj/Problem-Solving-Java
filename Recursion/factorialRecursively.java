import java.util.*;

/*
Given a number n, find its factorial using recursion.

Input Format
Input consists only of integer n.

Output Format
Print the factorial of the number.

Example 1
Input
5

Output
120

Explanation
1 * 2 * 3 * 4 * 5 = 120.

Example 2
Input
10

Output
3628800

Explanation
1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 = 3628800.

Constraints
0 <= n <= 18
*/

public class factorialRecursively {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial_recursive(n));
        sc.close();
    }

    public static long factorial_recursive(int n) {
        if(n==1){
			return 1; //base condition
		}
		long ans = n*factorial_recursive(n-1);
		return ans;
    }
}
