import java.util.*;

/*
You are given an integer N. You have to print all the even numbers from N to 0.

Input Format
The first line contains the number of test cases.
For each test case: The first line contains a single integer N.

Output Format
For each test case print the answer in a new line.

Example 1
Input
1
8

Output
8 6 4 2 0

Explanation
We print the even numbers in descending order.

Example 2
Input
1
7

Output
6 4 2 0

Explanation
We print the even numbers in descending order.

Constraints
1 <= T <= 10
1 <= N <= 100000
*/

class Solution {
    static void evenNumber(int n)
    {
        if(n%2 != 0) n--;
        
        while(n >= 0){
            System.out.print(n+" ");
            n-=2; 
        }
    }
}

public class evenNumbers {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			 //take input
			int n= sc.nextInt();
			Solution Obj = new Solution();
			Obj.evenNumber(n);
                        System.out.println();
    	}
		
	}
}

