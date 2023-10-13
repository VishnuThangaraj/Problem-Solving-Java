import java.util.*;
import java.io.*;

/*
Given a string S consisting of opening and closing parenthesis ( and ).
Find length of the longest valid parenthesis substring.

Input
Each test case have one line string S of character ( and ) of length N.

Output
Print the length (A non-negative integer) of the longest valid parenthesis substring.

Example 1:
Input
)()())

Output
4

Example 2
Input
)()

Output
2

Constraints:
1 <= N <= 10^5
*/

class Solution{
	static int longestParanthesis(String s){
		int result = 0;
		// stack to store the index
		Stack<Integer> storage = new Stack<>();
		storage.push(-1);
		
		for(int index=0; index<s.length(); index++){
			char letter = s.charAt(index);

			// push to stack if opening
			if(letter == '(')
				storage.push(index);
			else{
				// pop the opening bracket
				if(!storage.isEmpty()){
					storage.pop();
				}

				// update the result
				if(!storage.isEmpty())
					result = Math.max(result, index - storage.peek());
				else
					storage.push(index); // empty stack
			}
		}
		return result;
	}
}
public class longestValidParanthesis {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(Solution.longestParanthesis(s));
    }
}
