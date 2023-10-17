import java.util.*;

/*
In the Squid Games, there are n people left n people left for the first round. 
For the last game, they are standing in a circle, numbered from 1 to n. 
Starting with person 1, every kth person is killed by the guard. For example, if n is 5 and k is 3, 
the order of elimination would be 3, 5, 2, 4, and finally 1. The remaining person is the winner. 
The contestants are given 30 secs to arrange themselves. One of the person is you. 
You are brilliant programmer and have a small device that can do some fast computation, but since time is less, 
you are required to write recursive solution to type it quickly. Find out at which position that you should stand such that you are the last person remaining.

Write a function that takes two integers, n and k, and returns the position of the last person standing.

Input Format
The First line of input contain two integer N and k.

Output Format
Print the position that survives.

Example 1
Input
5 2

Output
3

Explanation
2 is killed first, then 4 is killed, then 1 is killed, then 5 is killed, at the end only 3 remains.

Example 2
Input
6 5

Output
1

Explanation
5 is killed first, then 4, then 6, then 2, then 3. At the end only person at position 1 remains.

Constraints
1 <= N <=10^5
2 <= K <= N
*/

class Solution {

    public static int deathGame(int n, int k) {
       return josephus(n,k)+1;
    }

	public static int josephus(int n, int k){
		return n == 1 ? 0 : ((josephus(n-1, k))+k)%n;
	}
}

public class deathGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int k= sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.deathGame(N,k));

    }
}
