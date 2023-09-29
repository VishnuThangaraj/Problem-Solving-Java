import java.util.Scanner;

/*
Given an array of string words and a prefix string pre. 
The task is to count the number of words in words with a given prefix using trie.

Input Format
First line of input contains size N of array of strings.
Second line of input contains N space separated words.
Third line of input contains prefix pre.

Output Format
Print total number of words with prefix as pre.

Example 1
Input
5
words = ["app","apple","apply","earth","apk"]
pre = "app"

Output
3

Example 2
Input
5
words = ["a","accio","according","accessible","accuse"]
pre = "acc"

Output
4

Constraints
1 <= words.length <= 100
1 <= words[i].length, pre.length <= 100
words[i] and pre consist of lowercase English letters.
*/

public class countNumberOfWordsWithGivenPrefix {

    public static int countPrefixMatchingWords(String[] words, String prefix) {
        int count = 0;

		for(String word : words){
			//starts with prefix
			if(word.startsWith(prefix)) count++;
		}

		return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            words[i] = word;
        }
        String prefix = scanner.next();
        int result = countPrefixMatchingWords(words, prefix);
        System.out.println(result);
    }
}
