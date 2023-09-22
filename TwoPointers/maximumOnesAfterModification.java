import java.util.*;

/*
Given a binary array A and a integer B , find the length of longest subsegment of ‘1’s possible by changing at most B ‘0’s.

Input Format
First line contains the size of array N.
Second line contains n-spaced integers represeting array A.
Thirs line contains an integer representing B.

Output Format
Return an integer denoting the length of the longest subsegment of ‘1’s possible by changing at most B ‘0’s.

Example 1
Input
7
1 0 0 1 1 0 1
1

Output
4

Explanation
After changing 6th integer in the array to 1, the array will become [1, 0, 0, 1, 1, 1, 1]. 
Length of longest subsegment of '1's is 4.

Example 2
Input
10
1 0 0 1 0 1 0 1 0 1
2

Output
5

Explanation
After changing 5th an 7th integer in the array to 1, the array will become [1, 0, 0, 1, 1, 1, 1, 1, 0, 1 ]. 
Length of longest subsegment of '1's is 5.

Constraints
1 <= N <= 10^5
0 <= A[i] <= 1
1 <= B <= 10^5
*/

class Solution {
    public int longestOnes(int[] A, int B) {
        int zero = 0;
		int max = 0;
		int left = 0;

		for(int i=0; i<A.length; i++){
			if(A[i] == 0) zero++; // increase the count of 0

			// if there is more 0..move left pointer 
			while(zero > B){
				if(A[left] == 0)
					zero--;
				left++;
			}

			// update the max
			max = Math.max(max, i- left+1);
		}

		return max;
    }
}

public class maximumOnesAfterModification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
    	for(int i=0;i<N;i++)
	    A[i] = sc.nextInt();
        int B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.longestOnes(A, B));
    }
}
