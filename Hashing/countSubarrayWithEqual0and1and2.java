import java.util.*;

/*
Given an array arr of size n containing 0,1 and 2 only. 
Find the count of subarrays having equal number of 0's,1's and 2's.

Input Format
The First line of input contain an integer N denoting size of array.
Second line contain N space separted random sequence of 0's,1's and 2's.

Output Format
Print the count of subarrays having equal number of 0's,1's and 2's.

Example 1
Input
4
2 0 1 2

Output
2

Explanation
the subarrays from index 0 to 2 and 1 to 3 have equal number of 0's,1's and 2's.

Example 2
Input
3
1 1 2

Output
0

Explanation
No such subarray is possible with equal number of 0's,1's and 2's.

Constraints
1 <= N <=10^6
0 <= |arr[i]| <= 2
*/

class Solution {
    static int countEqualSubarray012(int arr[], int n){
		HashMap<String,Integer> storage = new HashMap<>();
        int zero = 0,one = 0,two = 0;
		int count = 0;

		String key = (one - zero)+"#"+(two-one);
		storage.put(key,1);
		for(int num : arr){
			// update the counter
			if(num == 0) zero++;
			if(num == 1) one++;
			if(num == 2) two++;

			key = (one - zero)+"#"+(two-one);

			if(storage.containsKey(key))
				count += storage.get(key);

			// add to hashmap
			storage.put(key,storage.getOrDefault(key,0)+1);
		}
		return count;
    }   

}

public class countSubarrayWithEqual0and1and2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray012(arr,N));

    }
}
