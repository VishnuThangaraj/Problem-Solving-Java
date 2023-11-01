import java.io.*;
import java.util.*;

/*
You are given an array A consisting of N integers. They could be negative, positive or even zero. Find the subarray which has the maximum product.

NOTE:
You need to complete the given function. The input and printing of output will be handled by the driver code.

Input Format
The first line contains the number of test cases.
For each test case: The first line has the value of N.
The next line contains N space-separated integers of array A.

Output Format
For each test case return the maximum product.

Example 1
Input:
1
5
3 -2 -3 0 2

Output
18

Explanation
The sub array [0, 2] gives maximum product.

Example 2
Input
1
4
-2 -2 0 5

Output
5

Explanation
The sub array [3, 3] gives maximum product.

Constraints
1 <= T <= 10
1 <= N <= 10000
-10<= A[i] <= 10


*/

  public class maximumProductSubarray {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

class Solution {
    long maxProduct(int[] arr, int n) {
        long sum = 1;
		long result = 0;

        // Traverse array from left to right
		for(int index=0; index<arr.length; index++){
			sum *= arr[index];
            // Update result
            result = Math.max(result, sum);
            if(arr[index] == 0) sum = 1;
		}

        sum = 1;

        // Traverse array from right to left
        for(int index=n-1; index>=0; index--){
            sum *= arr[index];
            // Update result
            result = Math.max(result, sum);
            if(arr[index] == 0) sum = 1;
        }

		return result;
    }
}
