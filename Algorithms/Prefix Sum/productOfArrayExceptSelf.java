import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an array of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Expected Time Complexity:O(n)

Input Format
line 1: contains an integer n denoting number of elements in array.
line 2: contains n separated integers denoting elements of array. All integers are greater than 0.

Output Format
Print an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example 1
Input
4
4 3 2 10

Output
60 80 120 24

Explanation
Product of array except 4 is 3*2*10=60
Product of array except 3 is 4*2*10=80
Product of array except 2 is 4*3*10=120
Product of array except 10 is 4*3*2=24

Example 2
Input
5
1 2 3 4 5

Output
120 60 40 30 24

Explanation
Product of array except 1 is 2*3*4*5=120
Product of array except 2 is 1*3*4*5=60
Product of array except 3 is 1*2*4*5=40
Product of array except 4 is 1*2*3*5=30
Product of array except 5 is 1*2*3*4=24

Constraints
2 <= n <= 10^5
-30 <= nums[i] <= 30
It is guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32-bit integer.
*/

public class productOfArrayExceptSelf {
	  public static void main(String[] args) throws Throwable {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();

	        int nums[]=new int[n];
	        for(int i = 0; i < n; i++)
	        {
	            nums[i] = sc.nextInt();
	        }
	        Solution obj = new Solution();
	        long ans[] = obj.ProductOfArrayExceptSelf(n,nums);
	        for(int i=0; i<n ; i++){
	            System.out.print(ans[i] + " ");
	        }
	    }
}
class Solution{
	public long[] ProductOfArrayExceptSelf(int n, int[] a){
		long[] result = new long[n]; // to store the result
		// sum from left and sum from right
        long[] left = new long[n], right = new long[n];

		// left sum
		left[0] = a[0];
        for (int ind = 1; ind < n; ind++)
            left[ind] = left[ind - 1] * a[ind];

		// right sum
        right[n - 1] = a[n - 1];
        for (int ind = n - 2; ind >= 0; ind--)
            right[ind] = right[ind + 1] * a[ind];

		//calcualting result
        result[0] = right[1];
        result[n - 1] = left[n - 2];
        for (int ind = 1; ind < n - 1; ind++)
            result[ind] = left[ind - 1] * right[ind + 1];
		
        return result;
	}
}
