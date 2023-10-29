import java.util.*;

/*
Once upon a time, there was a brilliant computer scientist named Alice. 
She was working on a project that involved finding the element in a sorted array that was closest to a certain key. 
One day, her manager gave her an array of integers that were already sorted, 
and a key value that she had to use to find the element with the minimum difference.

Given the key value and the sorted array, help Alice to achieve her objective.

Input Format
A integer K in the first line denoting key.
A integer N in the second line denoting size of array.
N space separated elements of array.

Output Format
Print the integer closest to key.

Example 1
Input
9
6
2 5 8 11 14 17

Output
8

Explanation
8 is closest to 9.

Example 2
Input
7
5
1 2 4 8 15

Output
8

Explanation
8 is closest to 7.

Constraints
1 <= N,K <= 10^5
1 <= A[i] <= 10^6
*/

class Solution {
    public static int minDifference(int[] arr, int key) {
        // Perform binary Search
        int result = -1;

        int start = 0, end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(Math.abs(result-key) > Math.abs(key-arr[mid])){
                // update result
                result = arr[mid];
            }
            if(arr[mid] > key){end = mid-1;}
            else{ start = mid+1;}
        }
        return result;
    }
}

public class longestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution obj= new Solution();
        System.out.println(obj.minDifference(a,k));
    }
}
