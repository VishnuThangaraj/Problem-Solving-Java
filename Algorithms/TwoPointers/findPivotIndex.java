import java.util.*;

/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly 
to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Input Format
Input consists of two lines.
First line contains an integer n which is the number of elements in nums that are given.
Next line contains n spaced integers which represents the elements in the array.

Output Format
Return the leftmost pivot index. If no such index exists, return -1.

Example 1
Input
6
1 7 3 6 5 6

Output
3

Explanation
The pivot index is 3. Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2
Input
3
1 2 3

Output
-1  

Explanation
There is no index that satisfies the conditions in the problem statement.

Example 3
Input
3
2 1 -1

Output
0

Explanation
The pivot index is 0. Left sum = 0 (no elements to the left of index 0) Right sum = nums[1] + nums[2] = 1 + -1 = 0

Constraints
1 <= n <= 10^4
-1000 <= nums[i] <= 1000
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;

		// add elements in array to rightsum
		for(int element : nums) rightSum+=element;

		// find the pivot
		int leftSum = 0;
		for(int index=0; index<nums.length; index++){
			rightSum-= nums[index];
			//left and right sum is equal
			if(leftSum == rightSum){
				return index;
			}
			leftSum+=nums[index];
		}

		return -1; //no pivot found
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.pivotIndex(arr);
        System.out.println(result);
        sc.close();
    }
}
