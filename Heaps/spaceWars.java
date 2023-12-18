/*
There are given an array ships of size n where ships[i] denotes the power of the ith ship
You are playing the game of Space Wars.
On each turn, we choose the two most powerful ships and make them battle.
Suppose the most powerful ships have powers x and y with x <= y.
The result of this battle is:
If x == y, both ships are destroyed
If x != y, then the ship of power x is destroyed, and as a result of the battle the other ship needs repairs and its power is reduced to y - x.
At the end of the game, there is at most one ship left
Return the power of the last remaining ship. If there are no ships left, return 0.

Input Format
First line of input denotes the size n
followed by n space seperated integers denoting ships

Output Format
You have to return the power of the last remaining ship, and if no ships left return 0

Example
Input
6
2 7 4 1 8 1

Output
1

Explanation
ships 7 and 8 battle so we get 1 so the array converts to [2,4,1,1,1] then,
ships 2 and 4 battle so we get 2 so the array converts to [2,1,1,1] then,
ships 2 and 1 battle so we get 1 so the array converts to [1,1,1] then,
ships 1 and 1 battle so we get 0 so the array converts to [1] then that's the power of the last remaining ship.

Constraints
1 <= n <= 10^5
1 <= arr[i] <= 10^6

Topics
Heaps
*/

import java.io.*;
import java.util.*;

class Solution {
    int SpaceWars(int ships[], int n)
    {
        PriorityQueue<Integer> storage = new PriorityQueue<>((a,b)->b-a);

        for(int num : ships) storage.offer(num);

        while(storage.size() > 1){
            int first = storage.poll();
            int second = storage.poll();

            if(first == second)
                continue;
            else
                storage.offer(Math.abs(first-second));
        }

        if(storage.size() == 0) return 0;

        return storage.peek();
    }
}

public class spaceWars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        System.out.print(Obj.SpaceWars(arr1, n));
    }
}
