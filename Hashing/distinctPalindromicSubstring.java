import java.util.*;

/*
Given a string s, print all the substrings of s that are palindromic. Print all the required substrings in lexicographical order.
A substring is a subset or part of another string, or it is a contiguous sequence of characters within a string.
A lexicographic order is an arrangement of characters, words, or numbers in alphabetical order, that is, the letters are sorted from A-Z.

Input Format
First line contains a string s.

Output Format
Print various strings according to the question, each string should be in a new line

Example 1
Input
abc

Output
a
b
c

Example 2
Input
abccbc

Output
a
b
bccb
c
cbc
cc

Constraints
1 <= s.size() <= 1000
*/

public class distinctPalindromicSubstring {
    static void palindromeSubStrs(String s) {
        //use HashSet to to store distinct substrings
		HashSet<String> duplicates = new HashSet<>();

		List<String> answer = new ArrayList<>(); //for storing answers

		//get the substring
		for(int start=0; start<s.length(); start++){
			for(int end=start; end<s.length(); end++){
				String newString = s.substring(start,end+1);
				//check its palindrome and not a repeated one
				if(isPalindrome(newString) && !duplicates.contains(newString)){
					duplicates.add(newString); //add to hashset
					answer. add(newString);
				}
			}
		}

		//sort the answers
		Collections.sort(answer);

		//print the answer
		for(String value:answer){
			System.out.println(value);
		}
    }

	static boolean isPalindrome(String s){
		if(s.length() == 1){
			return true; //single element
		}

		//use two pointers and check both are same 
		int start = 0;
		int end = s.length()-1;

		while(start<end){
			if(s.charAt(start) != s.charAt(end)){
				return false; //// not a palindrome
			}
			start++;end--;
		}

		return true;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        palindromeSubStrs(s);
    }
}
