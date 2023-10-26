import java.util.*;

/*
Find a continuous subarray within an integer array nums of size n such that, if you only sort this continuous subarray in ascending order, 
the entire array will also be sorted in ascending order.

Give the length of the shortest such subarray.

Input Format
First line contains an integer n which is the size of nums
Next line contains n space-separated integers which are the elements of nums

Output Format
Complete the function UnsortedSubarrayLength() which returns the required integer

Example 1
Input
6
3 7 5 9 11 10 16

Output
5

Explanation
To sort the entire array in ascending order, you must first sort [7, 5, 9, 11, 10] in ascending order.

Example 2
Input
5
1 2 3 4 5

Output
0

Constraints
1 <= n <= 104
1 <= nums[i] <= 105
*/

class Solution {
    public int UnsortedSubarrayLength(int[] nums) {
        // Sort the Array
		int left= -1, right = -1, size = nums.length;

		// Starting-Point
		int mini = Integer.MAX_VALUE;
		for(int index=size-1; index>=0; index--){
			if(mini >= nums[index])
				mini = nums[index];
			else
				left = index;
		}

		// Ending-Point
		int maxi = Integer.MIN_VALUE;
		for(int index=0; index<size; index++){
			if(maxi <= nums[index])
				maxi = nums[index];
			else
				right = index;
		}

		return left == -1?0 : (right - left)+1;
    }
}

public class shortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();

	    Solution Obj = new Solution();
        System.out.println(Obj.UnsortedSubarrayLength(ar));
    }
}
