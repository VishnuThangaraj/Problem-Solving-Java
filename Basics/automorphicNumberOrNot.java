import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a Java program check whether a number is an Automorphic number or not.
In mathematics, an automorphic number is a number whose square "ends" in the same digits as the number itself. 
For example, 5^2 = 25, 6^2 = 36, 76^2 = 5776, and 890625^2 = 793212890625, so 5, 6, 76 and 890625 are all automorphic numbers.

Input Format
Any integer value.

Output Format
Return whether number is an "Automorphic Number" or "Not an Automorphic Number".

Example 1
Input
10

Output
Not an Automorphic Number

Example 2
Input
76

Output
Automorphic Number

Explanation
65 * 80 = 5200

Constraints
1 < = N < = 10^9
*/

public class automorphicNumberOrNot
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner read = new Scanner(System.in);
		int N = read.nextInt();

		int sq = N * N;

		while (N > 0) {
            // Return false, if any digit of N doesn't
            // match with its square's digits from last
            if (N % 10 != sq % 10){
				System.out.print("Not an Automorphic Number");
				return ;
			}
                
  
            // Reduce N and square
            N /= 10;
            sq /= 10;
        }
  
        System.out.print("Automorphic Number");
	}
}
