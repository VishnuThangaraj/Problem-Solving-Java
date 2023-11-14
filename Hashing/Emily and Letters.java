/*
There was a young woman named Emily who worked as a librarian at a large public library. She was very organized and had a great memory, 
which helped her keep track of all the books in the library's collection.

One day, a patron came to Emily and asked her to help them find a book with a specific title. Emily searched through the library's database 
and found several books with the same title, but none of them seemed to match the description provided by the patron. She was about to give up 
when she remembered that the patron had also mentioned the author of the book.

Emily quickly searched the database again and this time, she noticed that there was only one book with the same title and author as the one described by the patron. 
She triumphantly retrieved the book and handed it to the patron, who was delighted to finally have found the book they were looking for.

As Emily was putting the rest of the books back on the shelf, 
she realized that it would have been much easier to find the book if she had a system in place to keep track of which books were unique in the library's collection. 
She decided to write a program that would take a string representing the title of a book, and return the index of the first non-repeating character in the string. 
If there were no non-repeating characters in the string, the program would return -1. Can you help Emily write this program?

Input Format
The first line of input contains a string.

Output Format
The first line of output contains the index of the first non-repeating character in the string. 
If there are no non-repeating characters in the string, the program should return -1.

Example 1
Input
leetcode

Output
0

Explanation
The first non-repeating character in the string is 'l', which has an index of 0.

Example 2
Input
loveleetcode

Output
2

Explanation
The first non-repeating character in the string is 'v', which has an index of 2.

Constraints
1 <= length of string <= 10^5
The string will only contain lowercase English letters.
*/

import java.util.*;
import java.io.*;

class Main {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> storage = new HashMap<>();
        // Add the characters and its frequency to HashMap
        for(char letter : s.toCharArray())
            storage.put(letter, storage.getOrDefault(letter,0)+1);

        for(int index=0; index<s.length(); index++)
            if(storage.get(s.charAt(index)) == 1)
                return index;

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(firstUniqChar(s));
    }
}
