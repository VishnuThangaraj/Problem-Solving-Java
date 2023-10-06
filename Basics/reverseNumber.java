/*
Ninja is feeling very bored and wants to try something new. 
So, he decides to find the reverse of a given number. But he cannot do it on his own and needs your help.

Note: If a number has trailing zeros, then its reverse will not include them. For e.g., the reverse of 10400 will be 401 instead of 00401.

Input Format
The only line of input contains one integer ‘N’ denoting the given number.

Output Format
The only line of output should be reverse of the given number.

Example 1
Input
1000

Output
1

Explanation
As the input number is ‘1000’, we get the reverse as ‘1’.

Example 2
Input
7654321

Output
1234567

Explanation
As the input number is ‘7654321’, we get the reverse as ‘1234567’.

Constraints
1 <= N <= 10 ^ 18
*/

import java.util.*;

class Accio{
    static long ReverseNumber(long N){
        long reverse = 0;

		while(N > 0){
			reverse = (reverse*10) + N%10;
			N /= 10;
		}

		return reverse;
    }
}

public class reverseNumber {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        Accio obj = new Accio();
        long ans = obj.ReverseNumber(N);
        System.out.println(ans);
    }
}
