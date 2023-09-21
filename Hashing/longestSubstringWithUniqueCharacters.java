import java.util.*;

/*
You are given a string s. Your task is to find the length of the longest substring that contains each character at most once.
A substring is a contiguous sequence of characters within a string.

Input Format
First line contains the string s.

Output Format
Complete the function longestSubstring() where you return the required integer.

Example 1
Input
xyzxyzyy

Output
3

Explanation
The answer is "xyz ", with the length of 3

Example 2
Input
xxxxxx

Output
1

Constraints
0 <= s.size() <= 104
s contains only english alphabets, digits, spaces and symbols.
*/

class Solution {
    public int longestSubstring(String s) {
		//to store only unique characters
        HashSet<Character> unique = new HashSet<>();

		int first = 0;
		int second = 0;
		int max = 0;

		while(first < s.length()){
			if(second < s.length() && !unique.contains(s.charAt(second))){
				unique.add(s.charAt(second));
				//update max size
				max = Math.max(max, (second - first) +1);
				second++;
			}else{
				unique.remove(s.charAt(first));
				first++;
			}
		}

		return max;
    }
}

public class longestSubstringWithUniqueCharacters {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        Solution ob = new Solution();
        int ans=ob.longestSubstring(s);
        System.out.println(ans);
    }
}
