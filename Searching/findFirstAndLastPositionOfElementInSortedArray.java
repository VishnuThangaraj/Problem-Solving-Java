import java.util.*;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, print[-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Input Format
The first line contains two integers n (number of elements in the array) and target.
The second line contains n integers (value of elements in the array).

Output Format
Print two space separated integers denoting the first and last index of target.

Example 1
Input
 6 8
 5 7 7 8 8 10
 
Output
 3 4
 
Explanation
8 occurs for the first time at index 3 and at index 4 for the last time.

Example 2
Input
 6 6
 5 7 7 8 8 10
 
Output
 -1 -1
 
Explanation
6 doesn't occur in the given array, hence we return -1 -1

Constraints
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
*/

public class findFirstAndLastPositionOfElementInSortedArray {
	//first Index of the target
	public static int firstIndex(int[]A, int target, int start, int end){
		if(start > end){
			return -1; //element is not found in the array
		}
		int mid = start + (end-start)/2; 

		if(A[mid] == target){ // target found
			if(mid == 0 || A[mid-1] != target){
				return mid; //target found
			}
			return firstIndex(A,target,start, mid-1); //search left half
		}

		if(A[mid] > target){
			return firstIndex(A,target,start, mid-1); //search left half
		}

		return firstIndex(A,target,mid+1, end); //search right half
	}

	//last Index of the target
	public static int lastIndex(int[]A, int target, int start, int end){
		if(start > end){
			return -1; //element is not found in the array
		}
		int mid = end-start; 

		if(A[mid] == target){ // target found
			if(mid == A.length-1 || A[mid+1] != target){
				return mid; //target found
			}
			return lastIndex(A,target,start, mid-1); //search left half
		}

		if(A[mid] > target){
			return lastIndex(A,target,start, mid-1); //search left half
		}

		return lastIndex(A,target,mid+1, end); //search right half
	}
	
    public static void findPosition(int a[], int n,int k)
    {
        //use two functions for finding first and last occurance of a element
		// array , target, start index, end index
		System.out.print(firstIndex(a,k,0,a.length-1)+" ");
		System.out.println(lastIndex(a,k,0,a.length-1));
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}
