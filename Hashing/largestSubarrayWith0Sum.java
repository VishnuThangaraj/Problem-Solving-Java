import java.util.HashMap;
import java.io.*;
import java.util.*;

/*
Given an array arr[] of length N, find the length of the longest sub-array with a sum equal to 0.
A subarray is a contiguous part of the array.
Complete the given function.

Input Format:
First line contains integer N
Second line contains n integers arr[i].

Output Format:
Print the longest subarray length with a sum equal to 0.

EXAMPLE 1:
Input:
8
15 -2  2 -8 1 7 10 23

Output:
5

Explanation:
The longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}

EXAMPLE 2:
Input:
3
1 2 3

Output:
0

Explanation:
There is no subarray with 0 sum

constraints:
-100000 <= nums.length <= 100000
0 <= nums[i] <= 100000

*/

class Solution {
   public int maxLen(int arr[])
	{
		int max = 0; //maxlength
		int sum = 0; //sum of array

		//HashMap to store the sum and index
		HashMap<Integer,Integer> storage = new HashMap<>();

		//iterate the array
		for(int index=0; index<arr.length; index++){
			sum+=arr[index];
			if(storage.containsKey(sum)){
				int previous = storage.get(sum);
				max = Math.max(max, index-previous);
			}else{
				//add to hashMap
				storage.put(sum,index);
			}
		}

		if(sum == 0) return arr.length; 

		return max;
	}
}

class Main {
	
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution Obj = new Solution();
		System.out.println(Obj.maxLen(nums));
	}
}
