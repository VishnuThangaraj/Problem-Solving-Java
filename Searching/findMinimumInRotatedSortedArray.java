// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of unique elements, print the minimum element of this array.

Note: Write an algorithm that runs in O(logn) time.

Input Format
The first line contains a single integer n, number of elements in the array.
The second line contains n space-separated integers representing array nums.

Output Format
Print a single number — the minimum element of this array.

Example 1
Input
5
3 4 5 1 2

Output
1

Explanation
The original array was [1,2,3,4,5] rotated 4 times.

Example 2
Input
7
4 5 6 7 0 1 2

Output
0

Explanation
The original array was [0, 1, 2, 4, 5, 6, 7] rotated 3 times.

Constraints
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
*/

class Solution
{
	//recursive binary search
    static int findMin(int arr[], int low, int high){
        if(low > high){
			return -1; //this wont occur just for base case 
		}

		int mid = low + (high - low)/2;

		if(mid!=0 && arr[mid]<arr[mid-1]){
			return arr[mid]; //miminum number found
		}

		if(arr[high] < arr[mid]){ //search right region
			return findMin(arr,mid+1,high);
		}

		return findMin(arr,low,mid-1); //search left region
    }
}

class findMinimumInRotatedSortedArray {
    // Driver Program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
