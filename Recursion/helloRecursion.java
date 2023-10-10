import java.io.*;
import java.util.*;

/*
You will be given an array of N integers. Write a recursive function to calculate its summation.

Input Format
The first line  contains one integer T denoting number of test cases.
Each of the next T lines will start with an integer N (1 <= N <= 100), number of integers followed by N space separated.

Output Format
For each test case, output one line in the format “Case x: a” (quotes for clarity), where x is the case number and a is the summation of the integers.

Example 1
Input
2
5 10 5 -2 3 0
3 100 -10 34

Output
Case 1: 16
Case 2: 124

Explanation
There are two test cases. For Case 1: the size of array is 5, adding 10 + 5 + (-2)+ 3+0= 16. 
Therefore, we print, Case1: 16. For case 2: the size of array is 3, adding 100 + (-10)+ 34= 124. Therefore, we print, Case2: 124.

Example 2
Input
1
2 1 1

Output
Case 1: 2

Explanation
There is one test case. For Case 1: the size of array is 2, adding 1+1= 2. Therefore, we print, Case1: 2.

Constraints
0 <= N <= 100
-1000 <= nums[i] <= 1000
*/

public class helloRecursion {
    public static int sum(int a[], int i){
		if(i == 0) return a[0];
		
        return a[i] + sum(a, i-1);
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int testcases = input.nextInt();
        for(int testcase = 1; testcase <= testcases; testcase++){
            int n = input.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = input.nextInt();
            }
            System.out.println("Case " + testcase + ": " + sum(a, n - 1));
        }
    }
}
