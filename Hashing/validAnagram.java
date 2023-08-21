import java.util.*;

/*
Given an string str1 and str2, check if they both are anagrams or not.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Input Format
Input consists of a 2 lines of String str1 and String str2.

Output Format
Print "Yes" if they both are valid anagrams else print "No".

Example 1
Input:
anagram
grmaana

Output:
Yes

Explanation:
Both anagram and gramaana contains same set of characters.

Example 2
Input:
rat
car

Output:
No

Explanation:
car and rat contain different characters.

Constraints:
1 <= str1.length, str2.length <= 5 * 10^4
str1 and str2 consist of lowercase English letters.
*/

class Solution {
   static boolean areAnagram(String c1, String c2) {
       //use HashMap to store character and occurance
	   HashMap<Character, Integer> first = new HashMap<>();
	   HashMap<Character, Integer> second = new HashMap<>();
	   
	   //store the first string
	   for(int index=0; index<c1.length(); index++){
		   char letter = c1.charAt(index);
		   //character already in the hashMap
		   if(first.containsKey(letter)){
			   first.put(letter, first.get(letter)+1);
		   }
		   else{
			   first.put(letter,1);
		   }
	   }

	   //store the second string
	   for(int index=0; index<c2.length(); index++){
		   char letter = c2.charAt(index);
		   //character already in the hashMap
		   if(second.containsKey(letter)){
			   second.put(letter, second.get(letter)+1);
		   }
		   else{
			   second.put(letter,1);
		   }
	   }

	   //traverse through second array and find if its matching
	   for(int index=0; index<c2.length(); index++){
			char letter = c2.charAt(index);

		   if(first.containsKey(letter)){
			   //same occurance of character
			   if(first.get(letter) == second.get(letter)){
				   continue;
			   }
		   }
		   return false; //chaaracter not found or different occurance of character
	   }

	   return true;
    }
}

public class validAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();
        
        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
