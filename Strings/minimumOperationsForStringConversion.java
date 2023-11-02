import java.util.*;

/*
You are given two strings a and b. In a single operation, you can remove any character from string a and place it at end of a.
The end goal is to use these operations to convert the string a to the exact string b. Find the minimum number of operations requires for this.

Input Format
First line contains the string a
Second line contains the string b

Output Format
Complete the function MinOps() which returns the required integer

Example 1
Input
ABC
ACB

Output
1

Explanation
we can move ''B'' to the end of a so a becomes ''ACB'' which is equal to the b. Hence 1 operation was needed.

Example 2
Input
AbcD
bcAD

Output
2

Constraints
1 <= a.size(), b.size() <= 105
*/

class Solution {
    public int MinOps(String a, String b) {
        // Check for the size of the two strings
        if(a.length() != b.length()) return -1;

        int[] storage = new int[256];

        for(int index=0; index<a.length(); index++){
            storage[a.charAt(index)]++;
            storage[b.charAt(index)]--;
        }

        // Check if all the places has zero
        for(int index=0; index<storage.length; index++){
            // Both strings does not have same set of characters
            if(storage[index] != 0) return -1;
        }

        int first = 0, second = 0, result = 0;

        while(first < a.length()){
            if(a.charAt(first) != b.charAt(second))
                result++;
            else
                second++;

            first++;
        }
        return result;
    }
}

public class minimumOperationsForStringConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
	Solution Obj = new Solution();
        System.out.println(Obj.MinOps(a, b));
    }
}
