import java.io.*;
import java.util.*;

/*
Find number of ways an integer N can be represented as a sum of unique natural numbers.

Input Format
First line contains a single integer N.

Output Format
Return a single integer containing number of ways.

Example 1
Input
6

Output
4

Explaination
6 can be represented as (1, 2, 3), (1, 5), (2, 4), (6)

Example 1
Input
7

Output
5

Explaination
7 can be represented as (1, 2, 4), (1, 6), (2, 5), (3, 4), (7)

Constraints
0 <= N <= 120
*/

public class NumberOfWaysToFormNaturalNumber {
    public static long ways(int processed, int unProcessed){
	    if(unProcessed==0){
			return 1;
		}
		long total = 0;
		//for processed
		for(int i=processed+1;i<=unProcessed;i++){
			total += ways(i,unProcessed-i);
		}
		return total;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(ways(0, n));
    }
}
