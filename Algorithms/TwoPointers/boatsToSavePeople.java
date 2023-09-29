import java.io.*;
import java.util.*;

/*
You are given an array people where people[i] is the weight of the ith person, 
and an infinite number of boats where each boat can carry a maximum weight of limit. 
Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Input Format:
First line contains two integer N and K, where N is the size of array and K is the limit of weight of boat.
Second line contains n integers arr[i].

Output Format:
Print the minimum number of boats.

EXAMPLE 1:
Input:
2 3
1 2

Output:
1

EXPLANATION:
1 boat (1, 2)

EXAMPLE 2:
Input:
4 5
3 5 3 4

Output:
4

EXPLANATION:
4 boats (3), (3), (4), (5)

CONSTRAINTS:
1 <= people.length <= 5 * 10^4
1 <= people[i] <= limit <= 3 * 10^4
*/

class Solution
{
	public static int numRescueBoats(int[] people, int limit) {
		// sort the array before proceeding with two pointers
		Arrays.sort(people);

		int first = 0, second = people.length-1;
		int boats = 0; // boats required

		while(first <= second){
			boats++; // increase the count of boats
			if(people[first] + people[second] <= limit){
				first++;
			}
			second--;
		}
		return boats;
	}
}
public class boatsToSavePeople {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
		System.out.println(Solution.numRescueBoats(nums, k));
	}

}
