import java.util.*;

/*
Given a string s. The task is to print all permutations of a given string in lexicographically sorted order.

Input
The first and only line contains string s which consist of consists of the only uppercase alphabet and every character will be distinct.

Output
Print all the strings in lexicographically sorted order.

Example 1
Input
ABC

Output
ABC ACB BAC BCA CAB CBA

Explanation
ABC has 6 possible permutations and those are ABC ACB BAC BCA CAB CBA

Example 2
Input
BA

Output
AB BA

Explanation
BA has 2 possible permutations and those are "AB" and "BA" .

Constraints
1<=s.length()<=6
Expected Time Complexity: O(n!*n)
Expected Space Complexity: O(n)
*/

public class permutationsOfString{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			String str=sc.nextLine();
			Solution ob =new Solution();
			ob.printPermutaions(str);
		}
	}

}
class Solution {
	public void getPermutation(String source, String current, ArrayList<String> result){
		if(source.length() == 0){
			result.add(current); // possible permutation
		}

		for(int index=0; index<source.length(); index++){
			String newSource = source.substring(0,index) + source.substring(index+1);
			getPermutation(newSource, current+source.charAt(index), result);
		}
	}
    public void printPermutaions(String str) {
        ArrayList<String> result = new ArrayList<>();

		getPermutation(str,"",result);
		
		// sort the result arrayList
		Collections.sort(result);

		// print the ArrayList
		for(String permutation : result)
			System.out.println(permutation);
    }
}
