import java.io.*;
import java.util.*;

/*
Given an array of integer nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Input Format
Input consists of 3 lines.
1st line contains the size of the array N
2nd line contains N space-separated integers
3rd line contains integer K.

Output Format
Print the total number of subarrays with the given sum K.

EXAMPLE 1
Input:
3
1 1 1
2

Output::
2

EXPLANATION:
subarray [1, 1] and [1, 1] have sum 2

EXAMPLE 2
Input:
3
1 2 3
3

Output::
2

EXPLANATION:
subarray [1, 2] and [3] have sum 3

CONSTRAINTS:
1 <= nums.length <= 208
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

 class Solution
{
    static int solve(int N, int[] Arr, int K){
       // Write your code here
        int result = 0;
		int sum =0;
		//HashMap to store the sum and its occurance
		HashMap<Integer,Integer> storage = new HashMap<>();

		for(int value : Arr){
			sum+= value; //add the element to sum

			if(sum == K){
				result ++; //subarray with sum K found
			}
			result += storage.getOrDefault(sum-K,0);

			storage.put(sum,storage.getOrDefault(sum,0)+1);
		}
 
        return result;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
         {
         	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         int K = Integer.parseInt(br.readLine().trim());
 
         int out_ =  Solution.solve(N, Arr, K);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
}
