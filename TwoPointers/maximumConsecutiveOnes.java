import java.io.*;
import java.util.*;

/*
Given a binary array, find count of maximum number of consecutive ones present in the array.

Input Format
First line contains n, the size of the array.
Second line contains n spaced integers representing array.

Output Format
Print the maximum number of consecutive ones present in the array.

Example 1
Input
4
1 0 1 1

Output
2

Explanation
arr[2] = arr[3] = 1
Therefore the number of consecutive 1s is 2

Example 2
Input
3
1 1 1

Output
3

Explanation
arr[0] = arr[1] = arr[2] = 1
Therefore the number of consecutive 1s is 3

Constraints
1 <= n <= 10^5
0 <= arr[i] <= 1
*/

class Solution{
     public static int maxConsecutiveOnes(int[] arr, int n) {
        int first = 0, second = 0;
		 int result = 0;

		 while(first < n){
			 if(second < n && arr[second]!=0){
				 // update result;
				 result = Math.max(result, (second - first)+1);
				 second++;
			 }else{
				 // move the pointers next to zero
				 first = second+1;
				 second = first;
			 }
		 }
		 return result;
	 }
}

public class maximumConsecutiveOnes {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.maxConsecutiveOnes(arr, n));
    }
}
