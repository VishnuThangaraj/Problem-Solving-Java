/*
For a given number N, Consider a table of N X N in which elements at the intersection of ith row and jth column are the product of i and j, i. e i x j. 
Also given a positive integer X. Your task is to count the number of elements in the table that contain the integer X.

Input Format\
integer N and the integer X in a line

Output Format
Return the count of X.

Example 1
Input
5 5 

Output
2 

Explanation
table
1 2 3 4 5
2 4 6 8 10
3 6 9 12 15
4 8 12 16 20
5 10 15 20 25

Count of occurrence of X is : 2

Example 2
Input
10 13 

Output
0

Constraints
1 <= N <= 10^5
1 <= X <= 10^9
*/

import java.io.*;
import java.util.*;
public class xOccurance {
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
		int size = read.nextInt();
		int find = read.nextInt();

		int count = 0;

		for(int row=1; row<=size; row++){
			for(int col=1; col<=size; col++){
				// check if the num occurs
				if(row * col == find)
					count++;
			}
		}

		System.out.println(count);
    }
}
