import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value, B, to search. If found in the array, print its index; otherwise, print -1.
You may assume no duplicate exists in the array.

Note
Array A was sorted in non-decreasing order before rotation.
You need to think of an O(log n) solution.

Input Format
The first line given is an integer N, denoting the size of array A.
The second line given is N integers, the elements of array A.
The third line given is the integer B.

Output Format
Print index of B in array A; otherwise, print -1.

Example 1
Input
8
4 5 6 7 0 1 2 3
4

Output
0

Explanation
Target 4 is found at index 0 in A.

Example 2
Input
4
5 17 100 3
6

Output
-1

Explanation
6 is not present in the array.

Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are distinct.
*/

class rotatedSortedArraySearch {
  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int N = sc.nextInt();
	  int[] A = new int[N];
	  for(int i=0;i<N;i++){
          A[i] = sc.nextInt();
      }
	  int B = sc.nextInt();
	  Solution ob = new Solution();
    System.out.println(ob.search(A,B));
		
	}
}

class Solution{
	//function for recursive binarysearch
	public int binarySearch(final int[] a, int target, int start, int end){
		//base condition
		if(start > end){
			return -1; //target not found
		}
		int mid = start + (end-start)/2;

		if(a[mid] == target){
			return mid; //target found
		}
		
		//check if the region is sorted
		if(a[start] <= a[mid]){
			if(a[start] <= target && a[mid] >= target){ //search left region
				return binarySearch(a,target,start,mid-1);
			}
			return binarySearch(a,target,mid+1, end); //search right region
		}

		//if the current region is un-sorted
		if(target >= a[mid] && target <= a[end]){
			return binarySearch(a,target,mid+1, end); //search right region
		}
		return binarySearch(a,target,start,mid-1); //search left region
	}
    public int search(final int[] a, int target) {
        //recursuve binary search
		return binarySearch(a,target,0,a.length-1);
    }
}
