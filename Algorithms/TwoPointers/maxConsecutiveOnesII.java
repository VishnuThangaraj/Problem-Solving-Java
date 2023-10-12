import java.util.*;

/*
Given a binary array nums and an integer k, 
return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Input Format
First line contains n which is the size of the array nums.
Next line contains n space separated integers denoting nums.
Next line contains an integer k.

Output Format
Return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1
Input
11
1 1 1 0 0 0 1 1 1 1 0
2

Output
6

Explanation
[1,1,1,0,0,1,1,1,1,1,1]

Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2
Input
18
0 1 1 0 0 1 1 1 0 1 1 0 0 0 1 1 1 1
3

Output
10

Explanation
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Constraints
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
0 <= k <= nums.length
*/

class Solution{
	public static int longestOnes(int[] A, int K) {
       // two pointers 
		int start = 0, end = 0, zero = 0, result = 0;

		while(start < A.length){
			if(end < A.length && zero <= K){
				// increase the count of zero if current is zero
				if(A[end++] == 0)
					zero++;
			}else{
				if(A[start++] == 0)
					zero--;
			}
			// update result
			if(zero <= K)
				result = Math.max(result, (end-start));
		}

		return result;
    }
}

public class maxConsecutiveOnesII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        scan.close();
        System.out.print(Solution.longestOnes(arr, k));
    }
}
