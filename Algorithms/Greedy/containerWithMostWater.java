/*
You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Note
You may not slant the container.

Input Format
Input consists of two lines.
First line contains an integer n.
Next line contains n spaced integers.

Output Format
Return the maximum amount of water a container can store.

Example 1
Input
9
1 8 6 2 5 4 8 3 7

Output
49

Explanation
The vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water the container can contain is 49 b/w the heights 8(index 1) and 7(index 8)

Example 2
Input
2
1 1

Output
1

Explanation
The vertical lines are represented by array [1,1].
In this case, the max area of water the container can contain is 1 b/w the heights 1(index 0) and 1(index 1)

Constraints
2 <= n <= 10^5
1 <= heights[i] <= 10^3

Topics:
2-Pointers
Greedy
Arrays

Companies:
Bloomberg
Flipkart
Amazon
Google
*/

import java.util.*;

class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int maxArea = 0;

        while(left < right){
            int currentArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea); // update maxArea

            //Update Pointers
            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}

public class containerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.maxArea(arr);
        System.out.println(result);
        sc.close();
    }
}
