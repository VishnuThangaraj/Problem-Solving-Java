import java.util.*;
import java.io.*;

/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, 
and given an element key. The task is to find the index of the given element key in the array A.

Expected Time Complexity O(log N).
Expected Auxiliary Space O(1).

Input Format
The first line contains two integers N and key.
The second line contains N spaced integers, elements of A.

Output Format
Print the index of the given key in the array. If the key is not present print -1.

Example 1
Input
9 10
5 6 7 8 9 10 1 2 3

Output
5

Explanation
10 is found at index 5

Example 2
Input
7 10
4 7 8 9 10 1 3

Output
4

Explanation
10 is found at index 4

Constraints
1 ≤ N ≤ 10^7
0 ≤ A[i] ≤ 10^8
1 ≤ key ≤ 10^8
*/

public class searchInRotatedArray {
	static int pivotedBinarySearch(int arr[], int n, int key){
		int start = 0, end = n-1;

		while(start <= end){
			int mid = start + (end - start) /2;

			if(arr[mid] == key) return mid; // key found

			// check if the range is sorted
			if(arr[start] <= arr[mid])
				// find the key
				if(key < arr[mid] && key >= arr[start])
					// search left
					end = mid-1;
				else
					start = mid+1;
			// if the range is unsorted
			else if(key > arr[mid] && key < arr[end])
				// search right region
				start = mid+1;
			else
				end = mid-1;
		}

		return -1; // key not found
	}
    // main function
    public static void main(String args[])
    {
        // Let us search 3 in below array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), key = sc.nextInt(), pivot ;
        int[] arr = new int[n];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(pivotedBinarySearch(arr, n, key));
    }
}
