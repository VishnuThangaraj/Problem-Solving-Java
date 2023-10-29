import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a string s consisting of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, print 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Given s = "Hello World",
print 5 as length("World") = 5.
Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.

Input Format
The first line given is a string s.

Output Format
Print a single integer denoting the length of the last word.

Example 1
Input
Hello World

Output
5

Explanation
The last word is 'World' with length 5.

Example 2
Input
God is great.

Output
6

Explanation
The last word is 'great.' with length 6.

Constraints
0<=Length of string <=10^8
*/

public class lengthOfLastWord {
    public static int lengthOfLastWord(final String a) {
      int result = 0;

        for(int index=a.length()-1; index>=0; index--){
            if(a.charAt(index) == ' ') break;
            result++;
        }
        return result;
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  String s = sc.nextLine();
	  
    System.out.println(lengthOfLastWord(s));
		
	}
}
