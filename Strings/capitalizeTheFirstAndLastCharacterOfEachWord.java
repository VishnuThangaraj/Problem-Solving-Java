/*
Given the string, the task is to capitalize the first and last character of each word in a string.

Input Format
The input contains a single line containing the string s.

Output Format
Print the updated string after performing the operation.

Example 1
Input
hello world 

Output
HellO WorlD

Explanation
First and last character of each word is capitalised.

Example 2
Input
welcome to geeksforgeeks

Output
WelcomE TO GeeksforgeekS

Explanation
First and last character of each word is capitalised.

Constraints
1<=|s|<=100

Topics
Strings
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class capitalizeTheFirstAndLastCharacterOfEachWord
{
    public static String formatString(String str, int size){
        StringBuilder result = new StringBuilder();
        boolean space = true;

        for(int index=0; index < size; index++){
            char letter = str.charAt(index);
            if(index == size-1 || str.charAt(index+1) == ' ' || space){
                result.append((char)(letter-32));
                space = false;
            }
            else{
                if(letter == ' ') {
                    space = true;
                }
                else{
                    space = false; 
                } 
                
                result.append(letter);
            }
        }

        return result.toString();
        
    }
	public static void main (String[] args) throws java.lang.Exception{

        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        read.close();

        String result = formatString(str, str.length());

        System.out.println(result);
	}
}
