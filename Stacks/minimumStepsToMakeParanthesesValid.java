import java.util.*;

/*
You are given a string s consisting of only opening parentheses ( or closing parentheses ). You can perform the following operations on this string.
insert opening parentheses ( at any position in s
insert closing parentheses ) at any position in s
Return the minimum operations to make this string Valid.

A Parenthesis string is Valid if and only if:
It is an empty string
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Input Format
First line contains the string s

Output Format
Complete the function MinOps() which returns the required integer.

Example 1
Input
(()

Output
1

Example 2
Input
)))

Output
3

Constraints
1 <= s.size() <= 1000
*/

class Solution {
    public int MinOps(String s) {
        // create stack to store opening parantheses
		Stack<Character> storage = new Stack<>();

		int stepsNeeded = 0;		
		
		//iterate through the string
		for(int index=0; index<s.length(); index++){
			char letter = s.charAt(index);

			if(letter == '('){
				storage.push(letter);//add to stack
			}else{
				if(storage.isEmpty()){
					stepsNeeded++; //stack is empty and no valid bracket pair
				}else{
					storage.pop(); //valid bracket pair in stack is popped
				}
			}
		}

		//unclosed opening brackets in stack will also taken in count
		stepsNeeded+=storage.size();

		return stepsNeeded;
    }
}

public class minimumStepsToMakeParanthesesValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
	    Solution Obj = new Solution();
        System.out.println(Obj.MinOps(s));
    }
}
