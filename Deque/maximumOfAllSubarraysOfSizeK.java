import java.util.*;
import java.io.*;

/*
Given an array A and an integer, K. Find the maximum for each and every contiguous subarray of size K.

Input Format
The first line contains two integers N and K.
The second line contains N space-seperated integers.

Output Format
Return the maximum for every subarray of size K.

Example 1
Input
9 3 
1 2 3 1 4 5 2 3 6

Output
3 3 4 5 5 5 6

Explanation
1st contiguous subarray = {1 2 3} Max = 3 
2nd contiguous subarray = {2 3 1} Max = 3 
3rd contiguous subarray = {3 1 4} Max = 4 
4th contiguous subarray = {1 4 5} Max = 5 
5th contiguous subarray = {4 5 2} Max = 5 
6th contiguous subarray = {5 2 3} Max = 5 
7th contiguous subarray = {2 3 6} Max = 6

Example 2
Input
6 2
4 1 3 1 1 2

Output
4 3 3 1 2

Explanation
1st contiguous subarray = {4 1} Max = 4 
2nd contiguous subarray = {1 3} Max = 3 
3rd contiguous subarray = {3 1} Max = 3 
4th contiguous subarray = {1 1} Max = 1 
5th contiguous subarray = {1 2} Max = 2

Constraints
1 ≤ N ≤ 10^5
1 ≤ K ≤ N
0 ≤ A[i] <= 10^5
*/

class maximumOfAllSubarraysOfSizeK
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        
        int k = sc.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i <n; i++)
        {
            arr[i] =sc.nextInt();
        }
        
        ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
        
        for (int i = 0; i < res.size(); i++)
            System.out.print (res.get (i) + " ");
        System.out.println();
    }
}

class Solution
{
    ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList <Integer> result = new ArrayList <>();
		// Dequeue to store the index of elements in descending order
		Deque<Integer> storage = new ArrayDeque<>();

		for(int index=0; index<arr.length; index++){
			// fix the index to be in the range
			while(!storage.isEmpty() && storage.peek() <= index-k){
				storage.pollFirst();
			}
			// store in decreasing order
			while(!storage.isEmpty() && arr[storage.peek()] < arr[index]){
				storage.pollLast();
			}
			// add to Deque
			storage.offerLast(index);
			if(index >= k-1)
				result.add(arr[storage.getFirst()]);
		}
		
		return result;
    }
}
