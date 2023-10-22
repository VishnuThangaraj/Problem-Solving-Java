import java.util.*;

/*
You are given an array asteroids representing integers in a row.
The absolute value of asteroids[i] represents the weight of the ith asteroid and its sign represents the direction in which it is moving.

Find the final state of the asteroids after collision, assuming the following things:
If two asteroids of different sizes meet, the smaller one explodes
If two asteroids of same sizes meet, both of them explodes
Two asteroids moving in the same direction never meet

Input Format
First line contains an integer n, representing the size of array asteroids
Second line consists of n spaced integers

Output Format
Print the final array of the states of all the asteroids after collision (it may be of less size than the original array)

Example 1
Input
3
5 10 -5

Output
5 10

Explanation
The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2
Input
2
8 -8

Output

Explanation
The 8 and -8 collide exploding each other.

Constraints
2 <= asteroids.length <= 10^4
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> storage = new Stack<>();

		for(int rock : asteroids){
			if(rock > 0){ // Positive
				storage.push(rock);
			}
			else{ // Negative
				while(!storage.isEmpty() && storage.peek() > 0 && storage.peek() < Math.abs(rock))
					storage.pop();

				if(storage.isEmpty() || storage.peek() < 0)
					storage.push(rock); // Add to Stack
				else if (storage.peek() == Math.abs(rock))
					storage.pop(); // same weight asteroids met 
			}
		}
		int[] result = new int[storage.size()];

		for(int index = result.length-1; index>=0; index--)
			result[index] = storage.pop();

		return result;
    }
}

public class asteroidCollision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.asteroidCollision(arr);
        for (int i = 0; i < result.length; ++i)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}
