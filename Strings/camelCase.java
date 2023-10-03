import java.io.*;
import java.util.*;

/*
There is a sequence of words in camelCase as a string of letters, s , having the following properties:
It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
Given s , determine the number of words in s.

Input Format
A single line containing string .

Output Format
A single integer which is the total number of words in the string

Example 1
Input
saveChangesInTheEditor

Output
5

Explanation
String contains five words: save, Changes, In, The, Editor.

Example 2
Input
oneTwoThree

Output
3

Explanation
String contains five words: one, Two, Three.

Constraints
1 <= s.length <= 105
*/

public class camelCase {
	// function to get the number of words
	public static int getWords(String str){
		int wordCount = 1;

		for(int index=0; index<str.length(); index++){
			char letter = str.charAt(index);
			//check if its a Capital letter
			if(letter < 'a'){
				wordCount++;
			}
		}

		return wordCount;
	}
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
		String words = read.nextLine(); 

		System.out.println(getWords(words));
    }
}
