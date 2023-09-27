import java.util.*;

/*
A special number of an array is defined as the product of its length and its sum.
For example, the special number of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75
Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose special number is strictly less than k.
A subarray is a contiguous sequence of elements within an array.

Input Format
The first line contains two integers n representing number of elements in the array.
The second line contains n space seperated integers.
Third line contain k

Output Format
Return the number of non-empty subarrays of nums whose special number is strictly less than k.

Example 1
Input
5
2 1 4 3 5
10

Output
6

Explanation
The 6 subarrays having scores less than 10 are:
- [2] with score 2 * 1 = 2.
- [1] with score 1 * 1 = 1.
- [4] with score 4 * 1 = 4.
- [3] with score 3 * 1 = 3. 
- [5] with score 5 * 1 = 5.
- [2,1] with score (2 + 1) * 2 = 6.
Note that subarrays such as [1,4] and [4,3,5] are not considered because their scores are 10 and 36 respectively, 
while we need scores strictly less than 10.

Example 2
Input
3
1 1 1
5

Output
5

Explanation
Every subarray except [1,1,1] has a score less than 5.
[1,1,1] has a score (1 + 1 + 1) * 3 = 9, which is greater than 5.
Thus, there are 5 subarrays having scores less than 5.

Constraints
1 <= n <= 10000
*/

class Solution
{
	public static long countSubarrays(int[] nums, long k) {
		long sum =0, result =0;
		int second =0;

		for(int i=0; i<nums.length; i++){
			sum += nums[i]; //increase the sum
			while(sum * ( i - second + 1) >= k){ // not in range
				sum -= nums[second];
				second++;
			}
			// update result
			result += i - second + 1;
		}
		
		return result;
	}
}
 
public class countSpecialSubarray{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        k = sc.nextInt();
        System.out.println(Solution.countSubarrays(arr1,k));
    }
}
