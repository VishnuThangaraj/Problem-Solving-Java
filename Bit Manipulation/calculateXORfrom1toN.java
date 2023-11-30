/*
Given a number N, find the XOR of 1 to N.

Input Format
A integer N.

Output Format
Print the XOR of 1 to N.

Example 1
Input
5

Output
1

Explanation
000^001^010^011100^101= 001=1

Example 2
Input
6

Output
7

Explanation
000^001^010^011100^101^110=7

Constraints
1 <= N <= 2000

Topics
Bit Manipulation
*/

import java.util.*;

class Solution {
    public  static int computeXOR(int n)
    {
       int sum = 0;
        
       for(int i=1;i<=n;i++)
           sum = sum^i;

        return sum;
    }
    
}

public class calculateXORfrom1toN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Solution.computeXOR(n));
    }
}

