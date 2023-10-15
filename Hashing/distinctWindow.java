import java.util.*;

/*
You are given a string s.
Your task is to find the smallest window of string with all distinct characters of the given string.

Input Format
First and only line of input contains a string s

Output Format
Return the smallest substring with all distinct characters of given string.

Example 1
Input
aabcbcdbca

Output
dbca

Explanation
Possible substrings= {aabcbcd, abcbcd, bcdbca, dbca....}Of the set of possible substrings 
dbca' is the shortest substring having all the distinct characters of given string. 

Example 2
Input
aaab

Output
ab

Explanation
Possible substrings={aaab, aab, ab} Of the set of possible substrings 'ab' is the shortest substring having all 
the distinct characters of given string. 

Constraints
1<=|s|<=10^4
*/

public class distinctWindow {

    public static String DistinctWindow(String s){
        // to store the character and its occurance
    		HashMap<Character, Integer> unique = new HashMap<>();
    		String result = s;
    		int start =0, end = 0, size = s.length(); // Two pointers
    
    		// find all the unique characters
    		for(int index=0; index< size; index++)
    			unique.put(s.charAt(index),1);
    
    		int uniqueCount = unique.size();
    		unique.clear(); // reset the Hashmap
    
    		while(start < size){
    			if(end < size && unique.size()<uniqueCount){
    				char letter = s.charAt(end++);
    				// add to HashMap
    				unique.put(letter, unique.getOrDefault(letter, 0)+1);
    			}else{
    				char letter = s.charAt(start++);
    				if(unique.get(letter) == 1)
    					unique.remove(letter); // remove from HashMap
    				else
    					// update Hashmap
    					unique.put(letter, unique.get(letter)-1);
    			}
    
    			// update result
    			if(unique.size() == uniqueCount){
    				if(result.length() > (end - start))
    					result = s.substring(start, end);
    			}
    		}
    
    		return result;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}
