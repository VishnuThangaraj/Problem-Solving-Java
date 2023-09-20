import java.io.*;
import java.util.*;

/*
Given an integer array A and a non-negative integer k. Count all distinct unordered pairs of (A[i], A[j]) such that A[i] - A[j] = k and i != j.
Here A[i] and A[j] are array elements at indexes i and j respectively.

Input Format
First line contains two integers n(denoting size of array) and k.
Second line contains n integers denoting elements of array.

Output Format
Print number of distinct unordered pairs of (A[i], A[j]) with difference equal to k.

Example 1
Input
5 0
1 5 4 1 2

Output
1

Explanation
The only unordered pair with difference 0 is (1, 1).

Example 2
Input
4 1
1 2 2 1

Output
1

Explanation
The only unordered pair with difference 1 is (1, 2).

Constraints
1 <= n <= 10^5
-10^5 <= k <= 10^5
1 <= A[i] <= 10^5
*/

class Solution {
    public long pairDifference(int []A, int n, int k) {
		//HashMap to store the integers and its occurance from array
		HashMap<Integer,Integer> storage = new HashMap<>();
		int count = 0;

		for(int value : A)
			storage.put(value,storage.getOrDefault(value,0)+1);

		//iterate the hashMap to find the valid pairs
		for(int key : storage.keySet()){
			int find = key + k; 
			if(find == key){
				if(storage.get(key) > 1) count++; //pair found
			}else if(storage.containsKey(find)) count++;
		}
		return count; // returns 0, if no pairs found
    }
}

public class countNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}
