import java.util.*;

/*
Given an array arr consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Print the array in the form [x1,y1,x2,y2,...,xn,yn].

Input Format
First line contains an integer n
Second line contains 2n space separated integer

Output Format
Print the 2n integer in space-separated manner, in order as mentioned in question

Example 1
Input
4
1 2 3 4 4 3 2 1 

Output
1 4 2 3 3 2 4 1

Example 2
Input
3
2 5 1 3 4 7

Output
2 3 5 4 1 7 

Constraints
1 <= n <= 5000
-105 <= arr[i] <= 105
*/

class Solution {
    public void ShuffleArray(int[] arr, int n) {
        // two pointers
		int first = 0, second = n;

		while(first < n && n < arr.length){
			System.out.print(arr[first++]+" "+arr[second++]+" ");
		}
    }
}

public class shuffleTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2*n];
        for(int i = 0; i < 2*n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        Obj.ShuffleArray(arr, n);
    }
}
