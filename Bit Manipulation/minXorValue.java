import java.io.*;
import java.util.*;

/*
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
Return the minimum XOR value.

Input Format
First line contains n (Size of the array )
Second line contains n integers (Elements of array A)

Output Format
Print a single integer denoting minimum xor value

Example 1
Input
4
0 2 5 7

Output
2

Explanation
0 xor 2 = 2

Example 2
Input
4
0 4 7 9

Output
3

Constraints
2 <= N <= 100000  
0 <= A[i] <= 1000000000
*/

public class minXorValue {
    public static void minXor(int[]arr, int size){
        int result = Integer.MAX_VALUE;

        for(int i=0; i<size; i++)
            for(int j=i+1; j<size; j++)
                // Update result
                result = Math.min(result, arr[i]^arr[j]);

        System.out.println(result);
    }
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        
        for(int index=0; index<size; index++)
            arr[index] = sc.nextInt();

        sc.close();

        minXor(arr, size);
	}
}
