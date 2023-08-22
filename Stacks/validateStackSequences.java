import java.util.*;

/*
You are given two integer arrays both having distinct values in each array.
One of the arrays is pushed which tells the order of the elements being pushed and another array is popped which tells the order of the elements being popped.
Find out if this could be the result of a sequence of push and pop operations on an initially empty stack.

Input Format
The first line of input contains a single integer n.
The second line of input contains n space-separated integers representing the sequence pushed.
The third line of input contains n space-separated integers representing the sequence popped.

Output Format
The only line of output contains true or false depending upon if the above mentioned condition is satsified.

Example 1:
Input
5 
1 2 3 4 5
4 5 3 2 1

Output
true

Explanation: First push 1, 2, 3, 4, then pop 4, then push 5, then pop 5, 3, 2, 1.

Example 2:
Input
5
1 2 3 4 5
4 3 5 1 2

Output
false

Explanation: 1 cannot be popped before 2.

Constraints:
1 <= n <= 1000
0 <= pushed[i] <= 1000
popped is a permutation of pushed
*/

class Solution {
    public boolean validateStack(int[] pushed, int[] popped) {
        // create stack to sotore the elements
		Stack<Integer> storage = new Stack<>();

		int popPointer = 0;
		//traverse throught the push array
		for(int index =0; index <pushed.length; index ++){
			//add to the stack
			storage.push(pushed[index]);
			//pop the element if its same as in popped array
			while(!storage.isEmpty() && popped[popPointer] == storage.peek()){
				storage.pop(); //pop the element
				popPointer++;
			}
		}
		if(storage.isEmpty()){ //few elements present in stack
			return true;
		}
		return false;
    }
}

public class validateStackSequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] pushed = new int[n];
        int[] popped = new int[n];
        for (int i = 0; i < n; i++) {
            pushed[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            popped[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        System.out.print(Obj.validateStack(pushed, popped));
    }
}
