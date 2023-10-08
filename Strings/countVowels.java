/*
Write a program to find out how many vowels (a, e, i, o, u) are present in a string str.
Vowels are the letters - a, e, i, o, u

Input Format:
Input consists of one line.
First line contains a string str

Ouput Format:
Return an integer i.e. number of vowels present in the string.

Example 1
Input
accioschool

Output
5

Explanation
The string contains 5 vovels:
a at position str[0]
i at position str[3]
o at positions str[4],str[8] and str[9]

Example 2
Input
acciojob

Output
4

Constraints
1 <= str.length <= 3 * 10^5
It is guaranteed that string contains only smallcase letters.
*/

import java.util.*;

class Solution{
    static int ASStringsProblem1(String str){
        // add the vowels in HashSet
		HashSet<Character> storage = new HashSet<>();
		//add vowels
		storage.add('a');storage.add('e');storage.add('i');storage.add('o');storage.add('u');
		int count = 0; // count of vowels

		for(int ind=0; ind<str.length(); ind++)
			if(storage.contains(str.charAt(ind)))
				count++;

		return count;
    }
}

public class countVowels {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int ans=obj.ASStringsProblem1(str);
        System.out.println(ans);
    }
}
