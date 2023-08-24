import java.util.*;

/*
Given a binary sorted non-increasing array arr of size N. You need to print the count of 1 in the binary array.
Try to solve the problem using binary search

Input Format
Each test case contains two lines. The first line contains N (size of binary array). The second line contains N elements of binary array separated by space.

Output Format
In new line, print the count of 1 in binary array.

Example 1
Input
8
1 1 1 1 1 0 0 0

Output
5

Explanation
Number of 1 in given binary array : 1 1 1 1 1 0 0 0 is 5.

Example 2
Input
4
1 1 1 1

Output
4

Explanation
Number of 1 in given binary array : 1 1 1 1 is 4.

Constraints
1 <= N <= 10^6
arr[i] = 0,1
*/

class Solution {
    static int count1(int size, int arr[]) {
	    //lets solve using recursion
		//array , start , end
		return (binarySearch(arr,0,arr.length-1)+1); //+1 to change index to position
    }
	//recursive binary search
	static int binarySearch(int arr[], int start, int end){
		//base condition
		if(start>end){
			return -1;
		}
		int max = 0;
		int mid = end-start; //mid element

		//1 found
		if(arr[mid] == 1){
			//check its last element or the next element is not 1
			if(mid == arr.length-1 || arr[mid+1] != 1){
				return mid; //answer found return mid
			}
			//search the right half 
			return max = binarySearch(arr,mid+1,end);
		}

		//0 found
		return max = binarySearch(arr,start,mid-1); //search left
	}
}

public class count1InSortedBinaryArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n,array));
    }
}
