import java.util.*;

/*
Given an array of size n, find the equilibrium index in the array, or return -1 if it does not exist.
The equilibrium index is that index such that the sum of elements at lower indices is equal to sum of elements at higher indices.
complete the function that returns the equilibrium index given an array.

Input Format
The first line of the input contains one integer n, denoting the size of the array arr.
The second line of the input contains the elements of the array arr.

Output Format
Your code should output the equilibrium index if it exists, else output -1.

Example 1
Input
4
2 3 1 1

Output
1

Explanation
The value at index 1 is 3, we can see that sum of elements left of 3 is 2 and sum of elements right of 3 is 1+1=2 therefore 3 is the equilibrium index.

Example 2
Input
3
3 3 4

Output
-1

Explanation
there is no index for which leftsum is equal to rightsum therefore value is -1

Example 3
Input
1
2

Output
0

Explanation
As sum left of index 0 is 0 and right of index 0 is 0 as there is only one element. the equilibrium index is 0.

Constraints
1 <= n <= 2*10^5
0 <= arr[i] <= 1000
*/

public class equilibriumIndex {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a) {
        //add all the elemnts in array
		int rightSum = 0;
		for(int value:a) rightSum+=value;

		int leftSum = 0;

		for(int index=0; index<a.length; index++){
			rightSum-=a[index];

			if(rightSum == leftSum) return index; //index found

			leftSum+=a[index];
		}

		return -1;
    }
}
