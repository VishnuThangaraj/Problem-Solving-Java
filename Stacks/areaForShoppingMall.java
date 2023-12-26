/*
Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. 
Your task is to find the largest solid rectangular area in which the mall can be constructed.
There are a number of buildings in a certain two-dimensional landscape. 
Each building has a height, given by h[i] where i belongs to [1, n]. 
If you join k adjacent buildings, they will form a solid rectangle of area k x min(h[i], h[i+1], . . ., h[i+k-1]).

Input Format
The first line contains n, the number of buildings.
The second line contains n space-separated integers, each the height of a building.

Output Format
Return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings.

Example 1
Input
3
3 2 3

Output
6

Explanation
A rectangle of height h = 2 and length k = 3 can be constructed within the boundaries. 
The area formed is h x k = 2 x 3 = 6.

Example 2
Input
5
1 2 3 4 5

Output
9

Explanation
A rectangle of height h = 3 and length k = 3 can be constructed within the boundaries. The area formed is h x k = 3 x 3 = 9.

Constraints
1 <= n <= 10^5
1 <= h[i] <= 10^6

Topics
Stacks
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(getMaxArea(arr, n));
    }

    public static int getMaxArea(int hist[], int n) {
        int prev[] = new int[n];
		int next[] = new int[n];

		Stack<Integer> storage = new Stack<>();

		for(int times=0; times<n; times++){
			while(!storage.isEmpty() && hist[storage.peek()] >= hist[times]){
				storage.pop();
			}

			if(storage.isEmpty()){
				prev[times] = -1;
			}else{
				prev[times] = storage.peek();
			}

			storage.push(times);
		}

		Stack<Integer> second = new Stack<>();

		for(int times=n-1; times>=0; times--){
			while(!second.isEmpty() && hist[second.peek()]>=hist[times]){
				second.pop();
			}

			if(second.isEmpty()){
				next[times] = n;
			}else{
				next[times] = second.peek();
			}

			second.push(times);
		}

		//calculate area
		int area = 0;
		for(int i=0;i<n;i++){
			area = Math.max(area,(next[i]-prev[i]-1)*hist[i]);
		}

		return area;
    }
}
