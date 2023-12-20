/*
Parv is a Financial Analyst working for a company specialized in algorithmic trading.
For his stock analysis Parv needs to formulate an algorithm that given the value of stock as an array
arr the program needs to return the kth highest value that the stock had in O(n*log(k)) time complexity
You being Parv's friend need to help Parv by writing a program for the same.

Input Format
First line of input denotes the size n of array and value of k
followed by n space separated integers denoting arr

Output Format
You have to return the kth highest value of the stock

Example 1
Input
10 5
1 2 3 4 5 10 6 7 8 9

Output
6

Explanation
6 is the 5th largest element in the given array

Example 2
Input
5 1
1 2 3 4 5

Output
5

Explanation
5 is the largest element in the given array

Constraints
1 <= n,k <= 10^5
1 <= arr[i] <= 10^6
*/

import java.io.*;
import java.util.*;

class Solution {
    public int StockAnalysis(int[] arr, int k) {
		PriorityQueue<Integer> storage = new PriorityQueue<>((a,b) -> a-b);

        for(int num : arr){
            storage.offer(num);
            if(storage.size() > k) storage.poll();
        }

        return storage.peek();
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
        System.out.print(Obj.StockAnalysis(arr,k));
    }
}
