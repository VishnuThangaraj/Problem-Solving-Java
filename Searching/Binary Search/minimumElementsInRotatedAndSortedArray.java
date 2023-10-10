import java.util.*;

/*
Given an array arr which is sorted in ascending order and contains n elements. 
Also, this array is rotated at some unknown point. The task is to find the minimum element in it.

Input Format
line 1: contains an integer n denoting the size of array.
line 2: contains n separated integers denoting elements of array.

Output Format
Print a single integer denoting the minimum element of the array.

Example 1
Input
10
2 3 4 5 6 7 8 9 10 1

Output
1

Example 2
Input
8
7 8 9 10 3 4 5 6

Output
3

Constraints
1 <= n <= 10^5
1 <= arr[i] <= 10^6
*/

class Solution{
    static int MinElement(int n,int[] arr){
        // use binary search to find the minimum element
		int start = 0, end = arr.length-1;

		while(start <= end){
			int mid = start + (end - start)/2;

			// minimum element found
			if(arr[mid-1] > arr[mid]) return arr[mid];

			// check if the range is sorted
			if(arr[start] < arr[end]) return arr[start];

			if(arr[start] > arr[mid]){
				// search left
				end = mid-1;
			}else{
				// search right region
				start = mid+1;
			}
		}
		return -1;
    }
}

public class minimumElementsInRotatedAndSortedArray {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int ans = obj.MinElement(n,arr);
        System.out.println(ans);
    }
}
