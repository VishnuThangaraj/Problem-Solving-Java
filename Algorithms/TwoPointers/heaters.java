import java.util.*;

/*
Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
Every house can be warmed, as long as the house is within the heater's warm radius range.
Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.

Note:
All the heaters follow your radius standard, and the warm radius will the same.

Input Format
On the first line you are given n, the size of the array houses.
On the next line there are n spaced integers that represent the elements of the array houses.
On the third line you are given m, the size of the array heaters.
On the last line there are m spaced integers that represent the elements of the array heaters.

Output Format
Return the minimum radius standard of heaters so that those heaters could cover all houses.

Example 1
Input
3
1 2 3
1
2

Output
1

Explanation
The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

Example 2
Input
4
1 2 3 4
2
1 4

Output
1

Explanation
The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

Constraints
1 <= n,m <= 3*10^4
1 <= houses[i], heaters[i] <= 10^9
*/

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0; // min radius required to cover houses
		int housePointer = 0;
		int heaterPointer = 0;

		// keep the pointers in range
		while(housePointer < houses.length && heaterPointer < heaters.length){
			// current heater to house 
			int distance1 = Math.abs(houses[housePointer] - heaters[heaterPointer]);
			//next heater to curren house
			int distance2 = Integer.MAX_VALUE;
			// check if next heater exists
			if(heaterPointer+1 < heaters.length){
				distance2 = Math.abs(houses[housePointer] - heaters[heaterPointer+1]);
			}
			// update the radius
			if(distance1 < distance2){
				radius = Math.max(radius, distance1);
				housePointer++;
			}else{
				radius = Math.max(radius, distance2);
				heaterPointer++;
			}
		}
		return radius;
    }
}

public class heaters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.findRadius(arr, arr2);
        System.out.println(res);
        sc.close();
    }
}
