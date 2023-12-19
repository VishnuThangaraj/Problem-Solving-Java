/*
Spiderman is wearing a new suit and to test its capabilities he went to Zhangjiajie National Forest Park in China.
The mountains are of different heights and spiderman wants to go to the furthest mountain using the web fluid he has.
He has two new features in his suit which he can use for specific amount of times only:

Dash: you can dash up one unit of height using one Dash
Sling: you can go up any amount of height using one Sling
You are given the heights of the mountain in array heights
You start your journey from mountain 0 and move to the next mountain by possibly using Dash or Sling.
While moving from mountain i to mountain i+1 (0-indexed),
If the current mountain's height is greater than or equal to the next mountain's height, you do not need to use Dash or Sling.
If the current mountain's height is less than the next mountain's height, you can either use one Sling or (h[i+1] - h[i]) Dashs. 
Return the furthest mountain index (0-indexed) you can reach if you use the given Slings and Dashs optimally.

Input Format
First line of input denotes the size n of array and number of dashes dash and number of slings sling
followed by n space seperated integers denoting heights

Output Format
You need to return the index of the furthest mountain spiderman can reach using available slings and dashes optimally.

Example 1
Input
7 5 1
4 2 7 6 9 14 12

Output
4

Explanation
Starting at mountain 0, you can follow these steps:
Go to mountain 1 without using slings nor dashes since 4 >= 2.
Go to mountain 2 using 5 dashes. You must use either dashes or slings because 2 < 7.
Go to mountain 3 without using slings nor dashes since 7 >= 6.
Go to mountain 4 using your only ladder. You must use either dashes or slings because 6 < 9. 
It is impossible to go beyond mountain 4 because you do not have any more dashes or slings.

Example 2
Input
9 10 2
4 12 2 7 3 18 20 3 19

Output
7

Constraints
1 <= heights.length <= 10^5
1 <= heights[i] <= 10^6
0 <= dashes <= 10^9
0 <= slings <= heights.length

Topics
Heaps
*/

import java.io.*;
import java.util.*;

class Solution {
    public int SpidermanInChina(int[] heights, int n, int dashes, int slings) {
		
        Queue<Integer> heap = new PriorityQueue<>();

        for(int index=1; index<n; ++index){
            int diff = heights[index] - heights[index-1];
            if(diff <= 0) continue;

            heap.offer(diff);

            if(heap.size() > slings)
                dashes -= heap.poll();
            if(dashes < 0) 
                return index-1;
        }
        return n-1;
    }
}

public class spidermanInChina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int dash = sc.nextInt();
        int sling = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        Solution Obj = new Solution();
        System.out.print(Obj.SpidermanInChina(arr,n,dash,sling));
    }
}
