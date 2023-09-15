import java.io.*;
import java.util.*;

/*
Given an array of integers arr of even length n (always even) and an integer k.
We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
Return true If you can find a way to do that or false otherwise.

Input Format
First line of input denotes the size n of array and value of k
followed by n space seperated integers denoting arr

Output Format
You just have to return true or false based on above condition

Example 1
Input
10 5
1 2 3 4 5 10 6 7 8 9

Output
true

Explanation
Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

Example 2
Input
5 10
1 2 3 4 5 6

Output
false

Explanation
there is no way to divide arr into 3 pairs each with sum divisible by 10.

Constraints
1 <= n,k <= 10^5
n is even
1 <= arr[i] <= 10^6
*/

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
		//array to store the mod of given elements in arr
        int[] storage = new int[k];

        //add elements to array
        for(int value : arr){
            value%=k; //get the mod 
            if(value < 0){
                value+=k;
            }
            storage[value]++;
        }

        if(storage[0] %2 != 0) return false; //zero should be an even frequency

        //check for valid pairs
        for(int i=1;i<=k/2; i++){
            if(storage[i] != storage[k-i]){
                return false; //no matching pairs found
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
		k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
    }
}
