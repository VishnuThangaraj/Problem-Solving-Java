import java.io.*;
import java.util.*;

/*
Given a string str, find length of the longest substring with all distinct characters.

Input Format
Input consists of one line
The first line is a string str.

Output Format
Length of longest substring with all distinct characters

Example 1
Input
geeksforgeeks

Output
7

Explanation
"eksforg" is the longest substring with all distinct characters.

Example 2
Input
aaa

Output
1

Explanation
"a" is the longest substring with all distinct characters.

Constraints
1 <= |S| <= 105
*/

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
		int result = 0;
        int first = 0;
		int second = 0;
		HashSet<Character> storage = new HashSet<>(); // to store the characters

		while(first < str.length()){
			if(second < str.length() && !storage.contains(str.charAt(second))){
				storage.add(str.charAt(second++));
				// update result 
				result = Math.max(result, storage.size());
			}else{
				storage.remove(str.charAt(first++));
			}
		}

		return result;
    }
}

public class longestDistinctCharacters {
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

