import java.io.*;
import java.util.*;

/*
Peter gives Mike an array arr of integers and a sum. 
He challenges Mike to find if the sum of elements of a subarray is equal to the sum provided by Peter.
Can you help Mike win this challenge?
Your task is to complete the function theChallenge which receives the input array, 
n and sum as its parameters and returns 1 if the sum of elements of a subarray is equal to the sum provided by Peter else returns 0.

Input Format
Input consists of three lines.
First line contains an integer n.
Next line contains n spaced integers representing the type of candies.
Next line contains the sum.

Output Format
Return 1 if there exists a subarray whose sum is equal to the sum provided else return 0.

Example 1
Input
6
1 4 20 3 10 5
33

Output
1

Explanation
Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33. Hence we return 1, which denotes a subarray has been found.

Example 2
Input
5
10 2 -2 -20 10
-10

Output
1

Explanation
Sum of elements between indices 0 and 3 is 10 + 2 - 2 - 20 = -10. Hence we return 1, which denotes a subarray has been found.

Example 3
Input
6
-10 0 2 -2 -20 10
20

Output
0

Explanation
No subarray whose sum is equal to 20. Hence we return 0, which denotes no subarray found.

Constraints
1 <= arr.size() <=10^5
-10^5 <= arr[i] <= 10^5
The sum can be upto 10^9.
*/

class Solution {
  int theChallenge(int arr[], int n, int sum)
    {
        HashSet<Integer> storage = new HashSet<>();
		int total =0;

		for(int num : arr){
			total+=num; //add the element to total
			if(storage.contains(sum - total) || storage.contains( total - sum)){
				return 1;
			}
			storage.add(total);
		}
		return 0; // no subarray found 
    }
}

public class theChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        int sum;
        sum = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.theChallenge(arr1, n, sum);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}
