import java.util.*;
import static java.lang.Math.ceil;

/*
You are given a string s consisting of opening parentheses ( and closing parentheses ). 
In one operation, you can swap character at any index i with character at any index j, 0 <= i, j < s.size(). 
You are allowed to perform this operation any number of times.
Your task is to find out if this string s can be converted to Balanced Parentheses String or not. Return true if it can be, else return false.
A Balanced Parentheses string has a corresponding closing parentheses for each opening parentheses, and the pairs of parentheses are properly nested.

Input Format
First line contains a string s

Output Format
Complete the function CanBalance() which returns true or false

Example 1
Input
))((

Output
true

Example 2
Input
(())()())

Output
false

Constraints
1 <= s.size() <= 104
*/

class Solution {
    public boolean CanBalance(String s) {
        //count the number of opening and closing brackets
		int opening = 0;
		int closing = 0;

		//iterate over the string
		for(int index=0; index<s.length(); index++){
			char letter = s.charAt(index);
			if(letter == '('){
				opening++;
			}else{
				closing++;
			}
		}

		if(opening == closing){
			return true; //balanced expression
		}
        return false;
    }
}

public class balancedParantheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
	    Solution Obj = new Solution();
        if(Obj.CanBalance(s))
            System.out.println("1");
        else
            System.out.println("0");
    }
}
