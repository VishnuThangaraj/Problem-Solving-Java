import java.util.*;

/*
Given an array arr of size n containing 0 and 1 only. Find the count of subarrays having equal number of 0's and 1's

Input Format
The First line of input contain an integer N denoting size of array.
Second line contain N space separted random sequence of 0's and 1's.

Output Format
Print the count of subarrays having equal number of 0's and 1's.

Example 1
Input
3
1 0 1

Output
2

Explanation
the subarrays from index 0 to 1 and 1 to 2 have equal number of 1's and 0's.

Example 2
Input
2
1 1

Output
0

Explanation
No such subarray is possible with equal number of 1's and 0's.

Constraints
1 <= N <=10^6
0 <= |arr[i]| <= 1
*/

class Solution {
    static int countEqualSubarray01(int arr[], int n){
		HashMap<Integer,Integer> storage = new HashMap<>();

		int sum = 0,count = 0;

		for(int num : arr){
			// treat 0 as -1
			if(num == 0) sum+=-1;
			else sum+=num;

			if(sum == 0) count++;

			if(storage.containsKey(sum))
				count += storage.get(sum);

			// ADD/UPDATE hashMap
			storage.put(sum,storage.getOrDefault(sum,0)+1);
		}
		return count;
    }   
}

public class countSubarrayWithEqualOand1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray01(arr,N));

    }
}
