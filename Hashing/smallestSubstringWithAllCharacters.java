import java.util.*;

/*
You are given two strings a and b. You are required to find the smallest substring of a, which has all the characters of b.

Note:
If there are multiple such substrings of same size, then return one with the least starting index.
If there is no possible solution return the string -1.
Input Format
First line contains the string a
Second line contains the string b

Output Format
Complete the function SmallestSubstring() which returns the required string.

Example 1
Input
acciojob
coo

Output
ciojo

Explanation
"ciojo" is the smallest string that contains all the characters of "coo"

Example 2
Input
timetopractice
cot

Output
toprac

Constraints
1 <= a.size(), b.size() <= 103
*/

class Solution {
    public String SmallestSubstring(String a, String b) {
        // Write your code here
        HashMap<Character, Integer> storage = new HashMap<>();
        int count = 0;

        // add the characters and it's occurance in the HashMap
        for(char letter : b.toCharArray()){
            storage.put(letter, storage.getOrDefault(letter,0)+1);
            count++;
        }

        int start = 0, end = 0;
        int result = Integer.MAX_VALUE; // Store the minimum length of substring till now
        int left = -1, right = -1; // start and end of minimum string(result)

        while(end < a.length()){
            // Check all the characters are present in the range
            while(end < a.length() && count > 0){
                // increase the range (size of the window)
                char letter = a.charAt(end);
                
                // Decrease the count of charater in hashMap
                if(storage.containsKey(letter)){
                    if(storage.get(letter) > 0) count--;
                    
                    storage.put(letter, storage.get(letter)-1); 
                }
                end++;
            }
            if(end == a.length() && count > 0) break; // end of the length

            // count is zero(All characters present in the window)
            while(start < end && count == 0){
                char letter = a.charAt(start); 
                if(storage.containsKey(letter)){
                    storage.put(letter, storage.get(letter)+1);

                    if(storage.get(letter) >= 1){
                        // Wanted character
                        count++;
                        break;
                    }
                }
                start++;
            }

            // Update result
            int currentLength = (end == a.length()) ? end-start : end-start+1;
            if(currentLength < result){
                left = start;
                right = end;
                result = currentLength;
            }
            start++;
        }
        return (left == -1) ? "-1" : a.substring(left, right);
    }
}

public class smallestSubstringWithAllCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
	    Solution Obj = new Solution();
        System.out.println(Obj.SmallestSubstring(a, b));
    }
}
