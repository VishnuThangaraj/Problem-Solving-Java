import java.io.*;
import java.util.*;

/*
Given an array of length N, find an element before which all elements are smaller than it, and after which all are greater than it. 
Return the index of the element if there is such an element, otherwise, return -1.

NOTE:
If the right most element is the largest element in the array, it is the hinged element.
First element can never be hinged element.
Complete the given function.

Input Format:
The first line contains integer N.
The second line contains N space-separated integers of arr[i].

Output Format:
Print the required index (0-based).

Example 1
Input:
9
5 1 4 3 6 8 10 7 9

Output:
4

Explanation:
All elements on the left of arr[4] are smaller than it and all elements on right are greater.

Example 2
Input:
4
5 1 4 4

Output:
-1

Explanation:
No such index exists.

Constraints:
0 <= nums.length <= 100000
0 <= nums[i] <= 10000
*/

class Solution {
    public int findElement(int[] arr, int n) {
        // find the left-max first
		int[]leftMax = new int[n];

		leftMax[0] = Integer.MIN_VALUE;

		for(int i=1;i<n;i++)
			leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);

		int rightMin = Integer.MAX_VALUE;

		//traverse backwards in Array
		for(int i=n-1;i>=0;i--){
			// greater than leftMax and smaller than right min
			if(arr[i] > leftMax[i] && arr[i] < rightMin){
				return i; //hinged index found
			}
			rightMin = Math.min(rightMin, arr[i]);
		}

		return -1; //no-hinged element found
    }
}

public class findHingedElement {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

        Solution Obj = new Solution(); 
		System.out.println(Obj.findElement(nums, n));
	}
}
