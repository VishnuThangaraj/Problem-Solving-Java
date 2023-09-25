import java.util.*;

/*
Given an integer array nums, handle multiple queries of the following type:
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Input Format
Input consists of 4 lines.
First line contains an integer n.
Next line contains n spaced integers that denote the array
Next line contains integer m which is the number of queries for to calculate range sum.
Next m lines contains 2 integers each which denotes left and right.

Example 1
Input
6
-2 0 3 -5 2 -1
3
0 2 
2 5
0 5

Output
1 -1 -3

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

Constraints
1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.
*/

class Solution {
        public int[] sumQuery(int[] arr, int[][] ranges) {
            //create a array of range-sum
			int rangeSum[] = new int[arr.length];

			//store the values in array
			for(int index=0; index<arr.length; index++){
				if(index==0){
					rangeSum[index] = arr[index];
				}else{
					//previous range + current 
					rangeSum[index] = rangeSum[index-1] + arr[index];
				}
			}

			//Array to store the result of range queries
			int result [] = new int[ranges.length];

			//iterate throught the range queries and calculate the rangeSum
			for(int index=0; index< ranges.length; index++){
				int firstNum = (ranges[index][0] == 0) ? 0 : rangeSum[(ranges[index][0])-1];
				int secondNum = rangeSum[ranges[index][1]];
				
				result[index] = secondNum - firstNum;
			}

			return result;
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
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
