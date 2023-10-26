import java.util.*;

/*
Given an array containing N integers and an integer K. 
Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

Input Format
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. Each test case consists of two lines. 
The first line of each test case contains two integers N and K and the second line contains N space-separated elements of the array.

Output Format
For each test case, print the required length of the longest Sub-Array in a new line. If no such sub-array can be formed print 0.

Example 1
Input
3
6 15
10 5 2 7 1 9
6 -5
-5 8 -14 2 4 12
3 6
-1 2 3

Output
4
5
0

Explanation
Testcase 1: The sub-array is {5,2,7,1} with sum 15.
Testcase 2: The sub-array is {-5,8,-14,2,4} with sum -5.
Testcase 3: No sub-array exists with sum equal to 6.

Example 2
Input
1
3 6
2 4 6

Output
2

Explanation
Subarray [2, 4] is the longest subarray of length 2 with sum 6.

Constraints
1<=T<=500
1<=N,K<=10^5
-10^5<=A[i]<=10^5
Sum of N over all test cases does not exceed 10^5
*/

public class longestSubarrayHavingSumK
{
    static int subarraySum(int[] arr, int k) {
	    // store the sum and its index in HashMap
		HashMap <Integer,Integer> storage = new HashMap<>();

		int sum = 0;
		int result = 0;

		for(int index=0; index<arr.length; index++){
			sum += arr[index];

			// check if the value present in HashMap
			if(storage.containsKey(k - sum))
				result = Math.max(result, index - storage.get(k - sum));
			else if(storage.containsKey(sum - k))
				result = Math.max(result, index - storage.get(sum - k));

			if (!storage.containsKey(sum))
				storage.put(sum, index);
		}

		return result;
    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i=0; i<t; i++)
		{
		    int n, k;
		    n=input.nextInt();
		    k=input.nextInt();
	        int arr[] = new int[n];
	        for(int j=0; j<n; j++)
	        {
	            arr[j] = input.nextInt();
	        }
	        System.out.println(subarraySum(arr,k));
		}
	}
}
