import java.util.*;
import java.lang.*;
import java.io.*;

/*
You are given a string S (containing only lowercase characters). You need to print the repeated character whose first appearance is leftmost.

Input Format
The first line of input contains T denoting the number of testcases. T testcases follow.
Each testcase contains one line of input containing the string S.

Output Format
For each testcase, in a new line, print the character. If not found then print "-1".

Example 1
Input
 2
 geeksforgeeks
 abcd
 
Output
g
-1

Explanation
Testcase1: We see that both e and g repeat as we move from left to right. But the leftmost is g so we print g.
Testcase2: No character repeats so we print -1.

Constraints:
1 <= T <= 100
1 <= |S| <= 1000
*/

public class repeatingCharacterFirstAppearanceLeftmost
{
    public static void findFirstAppearance(String str){
        // HashSet to store the characters of the string
        HashSet<Character> storage = new HashSet<>();
        String result = "-1";

        for(int index=str.length()-1; index>=0; index--){
            char letter = str.charAt(index);

            if(storage.contains(letter)){
                result = letter+"";
            }
            //Add to HashSet
            storage.add(letter);
        }

        System.out.println(result);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        for(int loop=0; loop<count; loop++){
            String str = sc.next();

            findFirstAppearance(str);
        }

        sc.close();
	}
}
