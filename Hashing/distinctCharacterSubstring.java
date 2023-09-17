import java.util.*;

/*
You are given a string s
Your task is to find the number of possible substrings (not necessarily distinct) that consists of distinct characters only.

Input Format
First and Only line of input contains a string s.

Output Format
Print an integer representing the count.

Example 1
Input
gffg

Output
6

Explanation
All possible substrings from the given string are, 
( “g“, “gf“, “gff”, “gffg”, “f“, “ff”, “ffg”, “f“, “fg“, “g” ) 
Among them, the highlighted ones consists of distinct characters only.

Example 2
Input
acciojob

Output
18

Constraints
1<=|s|<=10^5
*/

public class Main {

    public static long DistinctCharacterSubstring(String s){
        long substringCount = 0; 

		int[]frequency = new int[26]; //alphabetical frequency 

		int start = 0; 
		int end = 0;

		while(start < s.length()){
			if(end < s.length() && frequency[s.charAt(end)-'a'] < 1){
				//add to frequency array and increase the count
				frequency[s.charAt(end)-'a']++;
				substringCount += (end - start)+1;
				end++;
			}
			else{ //already exists
				frequency[s.charAt(start)-'a']--;
				start++;
			}
		}

		return substringCount;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
