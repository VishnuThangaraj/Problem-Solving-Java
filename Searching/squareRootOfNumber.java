import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an integer x, find the square root of x.
If x is not a perfect square, then return floor(√x).
Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Note: Try Solving the question without using sqrt Function.

Input Format
The only line contains an integer x.

Output Format
Print the square root of x.

Example 1
Input
5

Output
2

Explanation
Since, 5 is not a perfect square, floor of square root of 5 is 2.

Constraints
1 ≤ x ≤ 10^7
*/

class squareRootOfNumber {
	public static long binarySearch(long value, long low, long high, long ans){
		//base condition
		if(low > high){
			return ans;
		}

		long mid = (low+high)/2;
		
		if((mid*mid) <= value){  //possible answer found
			//search the right region
			return binarySearch(value,mid+1,high,mid);
		}

		//search left region
		return binarySearch(value,low,mid-1,ans);
	}
    public static void sqrt(int A) {
        // recursive binary search
		//argurements =number, start value, end value(sqrt of a number wont be greate than its half), answer
		System.out.println(binarySearch(A,1,A/2,1));
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}
