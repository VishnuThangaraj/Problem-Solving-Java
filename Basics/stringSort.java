import java.util.*;

/*
You're given a statement in the form of a string 'str' that has no more than 9 words, 
with each word suffixed by a unique number ranging from 1 to N, where N is the total number of words in the sentence. 
Your goal is to reorder the words in 'str' according to their suffix numbers and return the string.

For Example
You are given ‘str’ = ‘yash1 vishnu3 jobs2’, in this we can see the ordering of the words like ‘yash’, ‘vishnu’ ‘jobs’ 
according to the suffix number. Hence the answer string is ‘yash jobs vishnu’.

Input Format
The only line of input contains a string ‘str’ representing the given string.

Output Format
The only line of output contains the sorted string.

Example 1
Input
yash1 vishnu3 jobs2

Output
yash jobs vishnu

Explanation
Refer problem statement for explanation.

Example 2
Input
hello2 hi1

Output
hi hello

Explanation
Since, hi has lower suffix than hello. So, hi will come before hello in output.

Constraints:
1 <= N <= 9
1 <= |str| <= 10 ^ 6
‘str’ will contain lower case characters of the English alphabet and each word will contain a number between 1 and N as suffix 
where N is number of words which are no more than 9.
*/

public class stringSort {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = Solution.sentenceSorting(str);
        System.out.println(ans);
    }
}


class Solution {
    static String sentenceSorting(String str) {
        String[] storage = new String[10];

        StringBuilder current = new StringBuilder();

        for(int index=0; index<str.length(); index++){
            char letter = str.charAt(index);
            if(letter >='a' && letter <='z')
                current.append(letter);
            else if(letter != ' '){
                storage[letter - '0'] = current.toString();
                current.setLength(0);
            }
        }

        String result = "";

        for(int index=0; index<10; index++){
            if(storage[index] != null)
                result += storage[index]+" ";
        }
        return result;
    }
}
