import java.util.*;
import java.lang.*;
import java.io.*;

/*
N light bulbs are connected by a wire. Each bulb has a switch associated with it, 
however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
Given an initial state of all bulbs, find the minimum number of switches you have 
to press to turn on all the bulbs. You can press the same switch multiple times.

Note : 0 represents the bulb is off and 1 represents the bulb is on.

Input Format
First line is N.
Second line has N values of the array

Output Format
Print an integer representing the minimum number of switches required.

Example 1
Input
1
1

Output
0

Explanation
There is no need to turn any switches as all the bulbs are already on.

Example 2
Input
4
0 1 0 1

Output
4

Explanation
press switch 0 : [1 0 1 0]
press switch 1 : [1 1 0 1]
press switch 2 : [1 1 1 0]
press switch 3 : [1 1 1 1]

Constraints
1 <= N <= 5e5
0 <= A[i] <= 1
*/

class Solution {
    public static int bulbs(int[] A) {
        int result = 0;

		for(int ind=0; ind<A.length; ind++){
			if(result%2 == 0 && A[ind]==0){
				result++;
			}else if(result % 2 != 0 && A[ind]==1){
				result++;
			}
		}
		return result;
    }
}

public class faultyWiringsAndBulbs {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0;i<n;i++)
			{
				A[i]= sc.nextInt();
			}
            Solution solution = new Solution();
	    	System.out.println(solution.bulbs(A));
		
	}
}
