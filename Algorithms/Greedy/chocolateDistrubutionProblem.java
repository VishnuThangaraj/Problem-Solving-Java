import java.io.*;
import java.util.*;

/*
Given an array A of positive integers of size N, where each value represents the number of chocolates in a packet. 
Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
Each student gets exactly one packet.
The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Input Format
The first line of the input contains the integers N and M, the size of the array of the packets of chocolates, and the number of students.
The second line contains N space separated integers, denoting the number of chocolates in each packet.

Output Format
Return the minimum possible difference between the student getting the maximum and the student getting the minimum number of chocolates.

Example 1
Input
8 5
3 4 1 9 56 7 9 12

Output
6

Explanation
The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :
{3, 4, 9, 7, 9}

Example 2
Input
7 3
7 3 2 4 9 12 56

Output
2

Explanation 
The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing following M packets :
{3, 2, 4}

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints
1 ≤ T ≤ 100
1 ≤ N ≤ 10^5
1 ≤ Ai ≤ 10^9
1 ≤ M ≤ N
*/

class chocolateDistrubutionProblem {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s = new Solution();
        System.out.println(s.minChocolateDifference(a, n, m));
    }
}

class Solution {

    public static int minChocolateDifference(int a[], int n, int m){
		int result = Integer.MAX_VALUE;
        // sort the array
		Arrays.sort(a);

		// two pointers
		int start = 0, end = m-1;

		while(end < n){
			// update result
			result = Math.min(result, (a[end] - a[start]));
			start++;end++;
		}

		return result;
    }
}
