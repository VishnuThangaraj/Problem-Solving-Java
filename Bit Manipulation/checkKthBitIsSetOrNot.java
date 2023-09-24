import java.io.*;
import java.util.*;

/*
Given a number N and a bit number K, check if Kth bit of N is set or not. 
A bit is called set if it is 1.
Position of set bit 1 should be indexed starting with 0 from LSB side in binary representation of the number.

Input Format
First line of input contains 2 space seperated integers N and K.

Output Format
Return whether the kth bit is set or not.

Example 1
Input:
4 0

Output
NO

Explanation
Binary representation of 4 is 100, in which 0th bit from LSB is not set. So, return false.

Example 2
Input
4 2

Output:
YES

Explanation
Binary representation of 4 is 100, in which 2nd bit from LSB is set. So, return true.

Constraints
1 ≤ N ≤ 109
0 ≤ K ≤ floor(log2(N) + 1)
*/

public class checkKthBitIsSetOrNot
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K=sc.nextInt();
        

        Solution obj=new Solution();
        Boolean ans=obj.solve(N,K);

        if(ans==true)
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
}

class Solution{
    
    public static Boolean solve(int n,int k)
    {
        int bitMask = 1 << k;

		if((n & bitMask) != 0) return true;

		return false;
    }
}
