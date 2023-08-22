import java.io.*;
import java.util.*;

/*
Given an array of 'n' integers. Print the first element that occurs k number of times. 
If there is no element that occurs for at least k number of times print -1.

Input Format
Line 1: contains two integers n and k.
Line 2: contains n-spaced integers denoting elements of the array.

Output Format
Print a single integer denoting the first element in the array which occurs at least k times. If no such element exists, print -1.

Example 1
Input
7 2
1 7 4 3 4 8 7

Output
4

Explanation
As we traverse the array the first number whose frequency becomes greater than or equal to k(2) is 4. Hence, the answer is 4.

Example 2
Input
7 4
2 4 1 2 2 19 3

Output
-1

Explanation
As no element in array has a frequency greater than or equal to k(4), the output will be -1.

Constraints
1 <= n <= 10^6
1 <= arr[i] <= 10^6
*/

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
		//create hashMap to store the value and occurance
        HashMap <Integer, Integer> storage = new HashMap<>();

		if (k==1) { //only one element in array
			System.out.println(nums[0]);
			return;
		}

		//traverse through the array
		for (int index = 0; index<n; index++) {

			//if already exists get its frequence
			int existingFreq = storage.getOrDefault(nums[index], 0);
			//increase frequency
			storage.put(nums[index], existingFreq + 1);

			if(storage.get(nums[index]) == k) { 
				//first element with k occurance
				System.out.println(nums[index]);
				return;
			}
		}
		//no element with k frequency found
		System.out.println(-1);
    }
}

public class firstElementToOccurKTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}
