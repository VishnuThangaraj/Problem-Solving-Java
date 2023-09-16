import java.io.*;
import java.util.*;

/*
Given two sorted arrays arr1[m] and arr2[n] of distinct elements, the task is to find all pairs from both arrays whose sum is equal to x. 
The pair has an element from each array.

Input Format
First line contains two space separated integers m and n denoting the size of the two arrays.
Second line contains m space separated integers denoting the elements of the first array.
Third line contains n space separated integers denoting the elements of the second array.
Fourth line contains a single integer x denoting the sum.

Output Format
Print the count of all pairs from both arrays whose sum is equal to x.

Example 1
Input
4 4
1 2 4 5
3 5 7 8
9

Output
3

Explanation
The pairs are:
(1, 8), (2, 7) and (4, 5)

Example 2
Input
3 5
1 2 3
4 5 6 7 8
8

Output
3

Explanation
The pairs are:
(1, 7), (2, 6) and (3, 5)

Constraints
1 <= m, n <= 5*10^4
1 <= arr1[i], arr2[i] <= 10^5
1 <= x <= 2 * 10^5
*/

class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = input.nextInt();
        }
        int x = input.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.countElements(arr1, arr2, m, n, x));
    }
}

class Solution {
    public int countElements(int[] arr1, int[] arr2, int m, int n, int x) {
		//start points beginning of first array
		int start = 0;
		//end points end of second array
		int end = n-1;

		int count = 0; 

		while(start < arr1.length && end>=0){
			int total = arr1[start] + arr2[end];
			if(total == x){ //pair found
				count++;start++;end--;
			}else if(x > total){ //target is bigger
				start++;
			}else{ // target is smaller than total
				end--;
			}
		}
		return count;
    }
}
