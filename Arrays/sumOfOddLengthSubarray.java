import java.util.*;

/*
Given an array A consisting of N integers.
Your task is to find the sum of all the elements of all possible subarrays of odd length.
Complete the function oddsubarrsum which receives A and N as parameters and returns the sum of all the elements of all possible subarrays of odd length

Input Format:
The first line contains the number of test cases.
For each test case: First line contains an integer N.
Second line contains N space separated integers.

Output Format:
For each test case return an integer in separate lines.

Example 1:
Input:
1
3
1 2 4

Output:
14

Explanation:
The odd length subarrays along with their sum are as follows:
1) 1 = sum is 1.
2) 2 = sum is 2.
3) 4 = sum is 4.
4) 1, 2, 4 = sum is 1 + 2 + 4 = 7.
Therefore, sum of all subarrays = 1 + 2 + 4 + 7 = 14.

Example 2:
Input:
1
3
1 2 1

Output:
8

Explanation:
The odd length subarrays along with their sum are as follows:
1) 1 = sum is 1.
2) 2 = sum is 2.
3) 1 = sum is 1.
4) 1, 2, 1 = sum is 1 + 2 + 1 = 4.
Therefore, sum of all subarrays = 1 + 2 + 1 + 4 = 8.

Constraints:
1 <= T <= 10
1 <= N <= 10000
1 <= L[i] <= 100
*/

public class sumOfOddLengthSubarray{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0){
			int n=sc.nextInt();
			int []A=new int[n];
			for(int i=0;i<n;i++){
				A[i]=sc.nextInt();
			}
            Solution ob = new Solution();
			System.out.println(ob.oddsubarrsum(A, n));
			t--;
		}
        sc.close();
	}
}
class Solution{
    public long oddsubarrsum(int[] A, int n) {
        long sum = 0;

        for(int index=0; index<n; index++){
            sum += ((((index+1) * (n-index) + 1)/2) * A[index]);
        }
        
        return sum;
    }
}
