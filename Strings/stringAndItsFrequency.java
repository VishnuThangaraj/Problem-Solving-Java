/*
Given a string str with lowercase english alphabets.Your have to print a string in which, with each character its frequency is written in adjacent.
Note: In the output string, distinct characters with their respective frequencies should be in order of occurrence as in given input str

Input Format
The first and only line contains the given string str with lower case english alphabets

Output Format
Print a string in which each character frequency is written in adjacent.

Example 1
Input
abbhuabcfghh

Output
a2b3h3u1c1f1g1

Explanation
‘a’ occurs in the string a total of 2 times so we write a2 then ‘b’ occurs a total of 3 times so next we write b3 and so on

Example 2
Input
a

Output
a1

Explanation
‘a’ occurs in the string a total of 1 time only.

Constraints
1 <= |str| <= 10^5

Topics
Strings

Companies
SAP
*/

import java.util.*;

public class stringAndItsFrequency {
    public String StringFreq(String s) {
        HashMap<Character, Integer> storage = new HashMap<>();
        // Add character and it frequency to HashMap
        for(char letter : s.toCharArray()){
            storage.put(letter, storage.getOrDefault(letter,0)+1);
        }

        String result = "";
        for(char letter : s.toCharArray()){
            if(storage.containsKey(letter)){
                result += letter;
                result += storage.get(letter);
                storage.remove(letter);
            }
        }

        return result;
    }
}

public class Main {
    public static void main(    String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Accio Obj = new Accio();
        System.out.println(Obj.StringFreq(s));
    }
}
