import java.io.*;
import java.util.*;

/*
N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy. 
Children with a higher rating get more candies than their neighbors. 
find the minimum number of candies you must give.

Input Format
In example input, the first line contains an integer n.
The next line contains n space-separated integer denoting the element of the array.

Output Format
Return an integer representing the minimum candies to be given.

Example 1
Input
2
1 2

Output
3

Explanation
The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. 
So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Example 2
Input
4
1 5 2 1

Output
7

Explanation
Candies given = [1, 3, 2, 1]

Constraints
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9
*/

public class distributionOfCandy {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }
        
        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));
        
	}
}


class Solution {
    public int candies(ArrayList<Integer> A,int n) {
        // compare with left neighbors 
		int[] left = new int[n];
		left[0] = 1;

		for(int index=1; index<n; index++){
			if(A.get(index) > A.get(index-1)){ // greater than left neighbor
				left[index] = left[index-1]+1;
			}else{
				// smaller the right neighbor
				left[index] = 1;
			}
		}

		// compare with right neighbor
		int[] right = new int[n];
		right[n-1] = 1;

		for(int index = n-2; index>=0; index--){
			if(A.get(index) > A.get(index+1)){ // greater than left neighbor
				right[index] = right[index+1] +1;
			}else{
				right[index] = 1;
			}
		}

		// calculate the number of candy required
		int candyCount = 0;

		for(int index=0; index<n; index++){
			// maximum of left and right will be the count
			candyCount += Math.max(left[index], right[index]);
		}

		return candyCount;
    }
}
