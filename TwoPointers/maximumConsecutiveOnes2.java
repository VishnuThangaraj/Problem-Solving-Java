import java.util.*;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Input format
The first line contains two integer, n and k, where n denotes the size of binary array and k denotes the number of flips allowed.
The second line contains n space separated integers

Output format
A single integer denoting maximum number of consecutive 1's in a single line.

Example 1
Input
11 2
1 1 1 0 0 0 1 1 1 1 0

Output
6

Explanation
[1,1,1,0,0,1,1,1,1,1,1]
This is the longest consecutive 1's subarray

Example 2
Input
4 4
0 0 0 1

Output
4

Explanation
We can flip all 0s to make it [1,1,1,1].

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 1
0 <= k <= nums.length
*/

class Solution {
    static int maxOne(int arr[], int n,int k){
        int result = 0;
		int first = 0, second = 0;
		int zeroCount = 0;

		while(first < n){
			if(second<n && zeroCount<=k){
				//update result
				result = Math.max(result, (second - first));
				if(arr[second++] == 0) zeroCount++;
			}else{
				// reduce zero
				if(arr[first++] == 0) zeroCount--;
			}
		}
		return result;
    }

}

public class maximumConsecutiveOnes2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}
