import java.io.*;
import java.util.*;

/*
You are given an array of strings ARR. You have to find out the second most repeated word in the array ARR. 
It is guaranteed every string occurs a unique number of times in the array.

Example:- N = 5 S = [‘aaa’, ‘bbb’, ‘ccc’, ‘aaa’, ‘bbb’, ‘aaa’]

ANSWER:- 
The answer should be bbb as it is repeated 2 times and is the second most 
repeated word in the array [after the word aaa which is repeated 3 times].

Input Format :
The first line contains a single integer ‘N’ denoting the length of the array.
The next line of contains ‘N’ strings denoting the string in the array.

Output Format :
Return the second most repeated string in the array.

Example 1:
Input:
3
aa bb aa

Output:
bb 

Explanation:
The string bb has frequency 1 and is the 2nd most repeated character in the array.

Example 2:
Input:
6
a b b c a a

Output:
b

Explanation:
The string b has frequency 2 and is the 2nd most repeated character in the array.

Constraints:
3 <= N <= 1000
1 <= |ARR[i]| <= 1000
It is gauranteed that there exists at least two type of strings.
All string contains lower case latin letters only.
*/

public class secondMostRepeatedWord {
	public static String findWord(String[] words, int n){
		HashMap<String,Integer> storage = new HashMap<>();
		int max = -1;
		//add words and its count to hashMap
		for(String word : words){
			storage.put(word, storage.getOrDefault(word, 0)+1);
			max = Math.max(max, storage.get(word));
		}

		// find the second max
		int Smax = -1;
		String result = "";
		
		for(String key : storage.keySet()){
			int current = storage.get(key);
			if(current > Smax && current < max){
				//potential answer found
				result = key;
				Smax = current;
			}	
		}

		return result;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for(int i=0; i<n ;i++){
			words[i] = sc.next();
		}

		String result = findWord(words, n);

		System.out.println(result);
	}
}
