import java.util.*;

/*
You and your friend Sam visit a carnival, where Sam decides to play the game. 
You are given with n bags arranged in a row, each having a number on them. Along with that, the game owner also gives you a number k.
The game requires you to pick bags based on the following rules
You can pick adjacent bags only,
The sum of values on bags picked should be divisible by k
To win the game, you have to tell the owner the maximum number of bags you can pick keeping in mind the rules of the game. 
Help your friend Sam win the game by calculating the number of bags.
You have to complete BagLength function which receives bag array and integer k as input and you have to return 
the maximum number of continuous bags you can pick as output.

Input Format
First line contains an integer n which is the number of bags
Second line contains n space-separated integers which are the values of each bag
Third line contains an integer k

Output Format
Print the maximum number of continuous bags that can be picked whose sum of values is divisible by k

Example 1
Input
6
2 7 6 1 4 5
3

Output
4

Explanation
The bags from index(0-based) i = 1 to i = 4, ie {7, 6, 1, 4} have sum 18, which is divisible by k = 3.

Example 2
Input
7
-2 2 -5 12 -11 -1 7
3

Output
5

Explanation
The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.

Constraints
1 <= n, k <= 106
-105 <= bag[i] <= 105
*/

class Solution {
    public int BagLength(int[] bag, int k) {
		HashMap<Integer,Integer> storage = new HashMap<>();
        int bags = 0; //max bags can be acquired
		int sum = 0; //subarray-sum(Prefix)

		for(int index=0;index<bag.length; index++){
			sum += bag[index];
			int reminder = ((sum % k) + k) % k; 
			if(reminder == 0){
				bags = index+1;
			}
			if(storage.containsKey(reminder)){
				bags = Math.max(bags, index - storage.get(reminder));
			}else{
				storage.put(reminder,index);
			}
		}
		return bags;
    }
}

public class carnivalGameOfBags {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bag = new int[n];
        for(int i = 0; i < n; i++)
            bag[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.BagLength(bag, k));
    }
}
