import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), 
return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, print -1 for this number.

Input Format
The first line contains a single integer n. Second line contains n spaced integers.

Output Format
Print the next greater element for each array value and if it doesnt exist then print -1

Example 1
Input
3
1 2 1

Output
2 -1 2

Explanation
The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.

Example 2
Input
6
1 2 3 4 3 3

Output
2 3 4 -1 4 4

Explanation
Here , next greatest of 1st element is 2. Next greatest of second is 3 ans similarly we will check next larger even circularly.

Constraints
1 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
*/

public class nextGreaterElementII {
	
	  public static void main (String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			    int n = Integer.parseInt(br.readLine().trim());
			    String inputLine[] = br.readLine().trim().split(" ");
			    int[] nums = new int[n];
			    for(int i=0; i<n; i++)nums[i]=Integer.parseInt(inputLine[i]);
			    int[] res = new Solution().nextLarger2(nums, n);
			    for (int i = 0; i < n; i++) 
			        System.out.print(res[i] + " ");
			    System.out.println();
		}
}
class Solution{
  
	public static int[] nextLarger2(int[] nums, int n){
		int[] result = new int[n];
		Stack<Integer> storage = new Stack<>();

		for(int index = 2*(n-1); index>=0; index--){
			// remove elements in stack that are less than [i%n]
			while(!storage.isEmpty() && nums[storage.peek()] <= nums[index % n])
				storage.pop();

			if(index< n){
				if(storage.isEmpty()){
					result[index] = -1;
				}else{
					result[index] = nums[storage.peek()];
				}
			}
			storage.push(index % n);
		}

		return result;
	}
}
