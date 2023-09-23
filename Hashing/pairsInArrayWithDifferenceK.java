import java.io.*;
import java.util.*;

/*
You are given an array a of n integers and an integer k.
Your task is to return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
nums[i] - nums[j] == k

Input Format
The first line contains two integers n and k.
The second line contains n space seperated integers.

Output Format
Return an integer denoting the number of unique k-diff pairs in the array.

Example 1
Input
5 2
3 1 4 1 5

Output
2

Explanation
There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2
Input
5 0
1 3 1 5 4

Output
1

Explanation
There is one 0-diff pair in the array, (1, 1).

Constraints
1 <= n <= 10000
0 <= k <= 10^7
1 <= a[i] <= 10^7
*/

public class pairsInArrayWithDifferenceK {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        // store all the integers and its occurance to Hashmap
        HashMap<Integer,Integer> storage  = new HashMap<>();
        int count =0;

        for(int value : nums) storage.put(value, storage.getOrDefault(value,0)+1);

        for(int key : storage.keySet()){
            int find = key + k;
            if(find == key){
                if(storage.getOrDefault(find,0) > 1) count++; //pair found
            }else if (storage.containsKey(find)) count++;
        }

        return count;
    }
}
