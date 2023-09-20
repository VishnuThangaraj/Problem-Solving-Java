import java.util.*;

/*
You are given roll number of students in the form of an array nums consisting of first N positive integers. 
But in the array of N integers, one of the roll number occurs twice, and one of the roll number is missing. 
You need to determine the repeating and the missing roll number.

Input Format
The first line contains an integer N denoting the number of elements present in the array.
The second line contains N space-separated integers denoting the elements present in the array.

Output Format
Print the two space-separated integers denoting the repeating and the missing numbers, in the same order.

Example 1
Input
5
1 4 2 5 2

Output
2 3

Explanation
We have, array: [1, 4, 2, 5, 2] and N = 5. In the given array ‘2’ occurs twice and the number ‘3’ is missing. 
Hence, we output 2 and 3 for the repeating and the missing number, respectively.

Example 2
Input
2
2 2

Output
2 1

Explanation
We have, array: [2, 2] and N = 2. In the given array ‘2’ occurs twice and the number ‘1’ is missing. 
Hence, we output 2 and 1 for the repeating and the missing number, respectively.

Constraints
2 <= N <= 10^5
1 <= nums[i] <= N
*/

class Solution 
{
    static int[] findRepeatingAndMissingNumbers(int[] nums) 
    {
        boolean[]register = new boolean[nums.length];
		int[]result = new int[2]; // for storing missing and repeated number

		//find the repeated number
		for(int rollNo : nums){
			if(register[rollNo-1] == true) result[0] = rollNo;
			else register[rollNo-1] = true; //mark as rollNo as registered
		}

		//find the missing register number
		for(int index=0; index<register.length; index++){
			if(register[index] == false) result[1] = index+1; //missing number found;
		}

		return result;
    }
}

public class rollNumberProblem {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = Solution.findRepeatingAndMissingNumbers(nums);
        System.out.print(ans[0] + " " + ans[1] + "\n");
    }
}
