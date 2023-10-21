import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a string str. Find out the distinct alphabets and the number of times they occur.
Note:- String will contain only lowercase , uppercase characters and spaces.
You have to complete print function which contains single string input str and prints the frequency of each alphabet (whether present or not )in the given string.

Input Format
The input contains a single string str.

Output Format
Print 26 space separated numbers that denote the number of occurrences of each character from 'a' to 'z'.

Example 1
Input
accio job

Output
1 1 2 0 0 0 0 0 1 1 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 

Explanation
The distinct alphabets are 'a', 'b', 'c', 'i', 'j', 'o' and they occur 1, 1, 2, 1, 1,2 times respectively.

Example 2
Input
A quick brown fox jumps over the lazy dog

Output
2 1 1 1 2 1 1 1 1 1 1 1 1 1 4 1 1 2 1 1 2 1 1 1 1 1 

Explanation
The distinct alphabets are 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' 
and they occur 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1 times respectively.

Constraints
1 <= |S| <= 100000
*/

class Solution{
        static void print(String str){
            int[] alphabet = new int[26];
			// convert the string to lowerCase
			str = str.toLowerCase();

			for(int index=0; index<str.length(); index++){
				if(str.charAt(index) == ' ')
					continue; // ignore the spae
				int position = str.charAt(index) - 'a';
				alphabet[position]++;
			}

			for(int num : alphabet)
				System.out.print(num+ " ");
        }
}
public class distinctAlphabets
{
	public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Solution.print(str);
    }
}
