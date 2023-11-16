/*
Sereja and Dima play a game. The rules of the game are very simple. The players have n cards in a row. 
Each card contains a number, all numbers on the cards are distinct. The players take turns, Sereja moves first. 
During his turn a player can take one card: either the leftmost card in a row, or the rightmost one. 
The game ends when there is no more cards. The player who has the maximum sum of numbers on his cards by the end of the game, wins.

Sereja and Dima are being greedy. Each of them chooses the card with the larger number during his move.

Inna is a friend of Sereja and Dima. She knows which strategy the guys are using, so she wants to determine the final score, 
given the initial state of the game. Help her.

Input Format
The first line contains integer n (1 ≤ n ≤ 1000) — the number of cards on the table. 
The second line contains space-separated numbers on the cards from left to right. The numbers on the cards are distinct integers from 1 to 1000.

Output Format
On a single line, print two integers. The first number is the number of Sereja's points at the end of the game, 
the second number is the number of Dima's points at the end of the game.

Example 1
Input
4
4 1 2 10

Output
12 5

Explanation
In the first sample Sereja will take cards with numbers 10 and 2, so Sereja's sum is 12. 
Dima will take cards with numbers 4 and 1, so Dima's sum is 5.

Example 2
Input
7
1 2 3 4 5 6 7

Output
16 12

Constraints
1 <= arr.size() <= 1000
*/

import java.util.*;

class Solution{
    public static void solve(int n, int[] arr) {
        // Two-Pointers
        int start = 0, end = n-1;
        
        int sereja = 0, dima = 0;
        boolean sere = true;

        while(start <= end){
            if(sere){
                if(arr[start] > arr[end]){
                    sereja += arr[start++];
                }else{
                    sereja += arr[end--];
                }
            }else{
               if(arr[start] > arr[end]){
                    dima += arr[start++];
                }else{
                    dima += arr[end--];
                } 
            }

            sere = !sere;
        }

        System.out.println(sereja+" "+dima);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution.solve(n, arr);

    }
}
