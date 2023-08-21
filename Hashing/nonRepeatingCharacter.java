import java.io.*;
import java.util.*;

/*
Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.

Input Format
The first line will contain the string S.

Output Format
You need to print the first non-repeating character. If there is no non-repeating character then print -1 .

Example 1
Input
hello

Output
h 

Explanation
In the given string, the first character which is non-repeating is h, as it appears first and there is no other h in the string.

Example 2
Input
zxvczbtxyzvy

Output
c

Explanation
In the given string, c is the first character which is non-repeating.

Constraints:
1 <= S.length() <= 1000
*/

class Solution {
    public void nonRepeatingCharacter(String s) {
        // create hashmap to store the character and occurance
		HashMap<Character, Integer> storage = new HashMap<>();

		//add all the characters in the hashmap
		for(int index=0; index<s.length(); index++){
			char letter = s.charAt(index);
			//check if map contains the character
			if(storage.containsKey(letter)){
				//update the occurance in hashMap
				storage.put(letter, storage.get(letter)+1);
			}else{
				storage.put(letter, 1); //add in hashMap
			}
		}

		//iterate throught the string
		for(int index=0; index<s.length(); index++){
			int occurance = storage.get(s.charAt(index));
			
			if(occurance == 1){ //1 occurance character is found  == no repeating
				System.out.println(s.charAt(index));
				//print and exit the function
				return;
			}
		}

		//no single occurance character is found
		System.out.println(-1);
    }
}

public class nonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s=sc.next();
        Solution Obj = new Solution();
        Obj.nonRepeatingCharacter(s);  
        System.out.println();
    }
}
