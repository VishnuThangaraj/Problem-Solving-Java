import java.util.*;

/*
Given an array of integers A. Every element in the array appears twice but there is one element which occurs only once. 
Find the single element which appears for only once.

Note: 
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Your task is to complete the function singleElement which receives the array A as parameter and prints the only single number present in the array.

Input Format
The first line contains an integer n, the size of the array A.
The second line contains n space separated integers which are the elements of the array A.

Output Format
Print a single integer denoting the single element.

Example 1
Input
5
1 2 2 3 1

Output
3

Explanation
Except for 3 every element in the array is occuring twice. So 3 is the single number.

Example 2
Input
3
1 2 2

Output
1

Explanation
Only 1 occurs once in the array. So 1 will be the answer.

Constraints
2 <= n <= 200000
0 <= A[i] <= 200000
*/

class Solution {
    public void singleElement(int[]A,int n) {
        int result = 0;

		// XOR OF ALL THE NUMBERS
		for(int num : A) result = result^num;

		System.out.println(result);
    }
}

public class singleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.singleElement(A,n);
        sc.close();
    }
}

