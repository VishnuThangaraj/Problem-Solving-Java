import java.util.Scanner;

/*
Given an array of positive integers a and a positive integer k. Your task is to return the minimal length of a subarray whose sum is greater than or equal to k. 
If there is no such subarray, return 0 instead.You have to complete findLengthOfSmallestSubarray function which consists of array a and integer k 
as input and you have to return the minimum integer size of subarray

Input Format
The first line of input contains two single space-separated integers 'n' and 'k' representing the size of the array and the given integer, respectively.
The second line of input contains 'N' single space -separated integers representing the array elements.

Output Format
Print the minimum integer length of subarray whose sum is greater than or equal to k.

Example 1
Input
6 7
2 1 4 3 2 5

Output
2 

Explanation
The smallest subarray with a sum greater than or equal to '7' is [4, 3]

Example 2
Input
5 8
3 4 1 1 6

Output
3

Explanation
Smallest subarrays with sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6]

Constraints
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
*/

class Solution{
    static int findLengthOfSmallestSubarray(int[] a, int K) {
        int result = Integer.MAX_VALUE, sum = 0;
        // Two- Pointers
        int first = 0, second = 0;

        while(first < a.length){
            if(second < a.length && sum < K){
                sum += a[second++];
            }else{
                sum -= a[first++];
            }
            // Update result
            if( sum >= K ){
                result = Math.min(result, second-first);
            }
        }
        return result;
    }
}
public class minimumSizeSubarraySum{ 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		int K = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
}
