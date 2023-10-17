import java.io.*;
import java.util.*;

/*
Given an integer n, print all balanced bracket strings of length 2*n.
A bracket string is a string which contains only ( and ) as its characters and for each opening bracket there is a corresponding valid closing bracket.
Empty string is a balanced bracket string
If S is a balanced bracket string, so is (S).
If S and T are balanced bracket strings, so is ST
Print all the generated balanced strings in lexicographical order. ( appears before ) in lexicographical order
Your task is to complete the function generateParanthesis which receives n as its parameter and prints all the balanced paranthesis strings of length 2*n.

Input Format
Single line of input containing an integer n.

Output Format
Print all possible balanced bracket string of length 2*n in a separate lines.

Example 1
Input
3

Output
((()))
(()())
(())()
()(())
()()()

Example 2
Input
2

Output
(())
()()

Constraints
1 <= n <= 10
*/

class Solution{
	public static void parenthesis(int opening, int closing, String result){
		if(opening == 0 && closing == 0)
			System.out.println(result);

		if(opening > closing) // unbalanced
			return;

		if(opening > 0)
			parenthesis(opening-1, closing, result+"(");
		if(closing > 0)
			parenthesis(opening, closing-1, result+")");
	}
     public static void generateParanthesis(int n){
        parenthesis(n,n,"");
    }
}
public class generateAllParenthesis {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.generateParanthesis(n);
    }
}
