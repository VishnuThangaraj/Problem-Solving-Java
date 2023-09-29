import java.util.*;
import java.io.*;

/*
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
You can perform the following operation at most maxOperations times:
Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
Print the minimum possible penalty after performing the operations.

Input Format
The first line of the input contains the number 𝑛(length of the array) and m(maximum number of operations).
The next n integers denote the elements of the array.

Output Format
Print the minimum penalty possible after performing at most m operations.

Example 1
Input
1 2
9

Output
3 

Explanation
Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.

Example 2
Input
4 4
2 4 8 2

Output
2

Explanation
Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
The bag with the most number of balls has 2 balls, so your penalty is 2 an you should return 2.

Constraints:
1 <= nums.length <= 10^5
1 <= maxOperations, nums[i] <= 10^9
*/

class Solution
{
    public static int solve(int n,int m,int[]arr){
		//sort the array and perform binary search
		Arrays.sort(arr);
        int low = 1, high = arr[n-1]; 
		while(low < high){
			int mid = low + (high - low) / 2;
			if(isPossible(arr, mid, m)){
				high = mid;
			}else{
				low = mid+1;
			}
		}
		return low; // minimum possible penality
    }

	// function to check if possible to place with the penality
	public static boolean isPossible(int[]arr, int penality, int max){
		int count = 0;
		// traverse from back
		for(int i=arr.length-1; i>=0; i--){
			int num = arr[i];
			if(num <= penality) break;

			int operation = (num / penality) - 1; // operation needed to split the bag
			if(num%penality != 0) operation++; //extra operation needed for reminder

			count += operation;
		}
		return count <= max;
	}
}
public class minimumLimitOfBallsInBag {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}
