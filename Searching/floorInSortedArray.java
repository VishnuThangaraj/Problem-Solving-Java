import java.util.*;
import java.io.*;

/*
Given a sorted array arr[] of size N without duplicates, and given a value x. 
Find the index of floor of x in given array. 
Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Try to use binary search to solve this problem.

Input Format
First line of input contains number of integers in array, N and element whose floor is to be searched.
Last line of input contains array elements.

Output Format
Output the index of floor of x if exists, else print -1. Use 0-indexing.

Example
Input
7 0 
1 2 8 10 11 12 19

Output
-1

Explanation
No element less than or equal to 0 is found. So output is "-1".

Example 2
Input
7 5 
1 2 8 10 11 12 19

Output
1

Explanation
Number less than or equal to 5 is 2, whose index is 1(0-based indexing).

Example 3
Input
7 10 
1 2 8 10 11 12 19

Output
3

Explanation
Number less than or equal to 10 is 10 and its index is 3.

Constraints
1 ≤ N ≤ 10^5
1 ≤ arr[i] < 10^9
0 ≤ X ≤ arr[n-1]
*/

public class floorInSortedArray {
	//binary search
	public static int binarySearch(int[]arr,int number, int start, int end, int answer){
		if(start > end){
			return answer;
		}
		//get mid index
		int mid = (start+end) /2;

		if(arr[mid] <= number){ //a possible answer found
			//search right region
			return binarySearch(arr,number,mid+1,end,mid);
		}

		//search left region
		return binarySearch(arr,number,start, mid-1, answer);
	}
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int size  = sc.nextInt();

		int number = sc.nextInt(); //number to find its floor
		int[]arr = new int[size];

		//get inputs for array
		for(int index=0;index<size; index++){
			arr[index] = sc.nextInt();
		}

		//binary search
		//array, number(floor find), start index, endINdex, possible-answer
		int answer = binarySearch(arr,number,0,arr.length-1,-1);
		//print the answer
		System.out.println(answer);
    }
}
