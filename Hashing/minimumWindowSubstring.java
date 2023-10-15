import java.io.*;
import java.util.*;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s 
such that every character in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Input Format
First line of input denotes string s
Second line of input denotes string t

Output Format
You have to return minimum window substring

Example 1
Input
ADOBECODEBANC
ABC

Output
BANC

Explanation
The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2
Input
a
a

Output
a

Explanation
The entire string s is the minimum window.

Constraints
1 <= s.length, t.length <= 1e5
*/

class Solution {
    public String minWindow(String s, String t) {
		// HashMap to store the character and its frequency of String B
		HashMap<Character, Integer> first = new HashMap<>();

		// find the unique character and its count of String B
		for(int index=0; index< t.length() ; index++){
			char letter = t.charAt(index);
			first.put(letter, first.getOrDefault(letter,0)+1);
		}

		HashMap<Character, Integer> second = new HashMap<>();
		int start = 0, end = 0, size = s.length(), mapCount = 0; // two pointers
		String result = s;

		while(start < size){
			if(end < size && t.length() > mapCount){
				char letter = s.charAt(end++);
				// check if letter presend in HashMap
				if(first.containsKey(letter)){
					second.put(letter, second.getOrDefault(letter,0)+1);
					mapCount++;
				}
			}else{
				char letter = s.charAt(start++);
				if(first.containsKey(letter)){
					mapCount --;
					if(second.get(letter) == 1)
						second.remove(letter); // remove from hashMap
					else
						second.put(letter, second.get(letter)-1);
				}
			}
			// check the substring if both unique size is same
			if(t.length() == mapCount){
				boolean match = true;
				for(char Key : first.keySet()){
					if(first.get(Key) != second.get(Key)){
						match = false;break;
					}
				}
				if(match){
					if(result.length() > (end - start))
						result = s.substring(start,end);
				}
					
			}
		}

		return result;
    }
}

public class minimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}
