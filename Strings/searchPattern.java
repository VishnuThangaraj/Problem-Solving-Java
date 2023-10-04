import java.util.*;

/*
You are given two string a and b. Your task is find all the indices(1-based) where string b is present in string a as a substring.
If b is not present in a, return an array {-1}.

Input Format
First line contains the string a
Second line contains the string b

Output Format
Complete the function FindIndices() and return the array required array/vector.

Example 1
Input
acciojobacciojob
job

Output
6 14

Explanation
The string job occurs twice at indices {6, 14}

Example 2
Input
marvelsuperheros
batman

Output
-1

Constraints
1 <= a.size() <= 105
1 <= b.size() <= a.size()
*/

class Solution {
    public ArrayList<Integer> FindIndices(String a, String b) {
        ArrayList<Integer> result = new ArrayList<>();
		int aLength = a.length();
		int bLength = b.length();

		for(int start=0; start<aLength; start++){
			if(a.charAt(start) == b.charAt(0) && a.substring(start, aLength).startsWith(b)){ // substring found
				result.add(start+1);
				start += bLength;
			}	
		}

		if(result.size() == 0) result.add(-1);

		return result;
    }
}

public class searchPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}
