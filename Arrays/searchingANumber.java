import java.io.*;
import java.util.*;

/*
Given an array Arr of N elements and a integer K. 
Your task is to print the position of first occurrence of K in the given array. 
If the number is not found, print -1.

Note: Position of first element is considered as 1.

Input Format
The first line contains two integers N and K.
The second line contains N spaced integers, elements of Arr.

Output Format
Print the position of first occurrence of K.
If K is not present in the array, print -1.

Example 1
Input
5 16
9 7 2 16 4

Output
4

Explanation
K = 16 is found in the given array at position 4.

Example 2
Input
 6 6
 5 7 7 8 8 10
 
Output
 -1
 
Explanation
6 doesn''t occur in the given array, hence we print -1.

Constraints
1 <= N <= 10^6
1 <= K <= 10^6
1 <= Arr[i] <= 10^6
*/

class Solution {
    static int findNumber(int arr[], int n, int k)
    {
		for(int i=0;i<n;i++){
			if(arr[i] == k){ //element found ... return the index+1
				return i+1; 
			}
		}
		return -1; // element not found in the array
    }
}

public class searchingANumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        int result = Obj.findNumber(arr, n, k);
        System.out.print(result);        
        System.out.println();
    }
}
