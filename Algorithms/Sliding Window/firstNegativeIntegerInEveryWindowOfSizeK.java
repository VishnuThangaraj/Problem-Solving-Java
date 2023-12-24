/*
You are given a 0-indexed array of integers arr of length n and a positive integer k, 
find the first negative integer for each and every window(contiguous subarray) of size k.
Note: Your task is to complete the function printFirstNegativeInteger() which takes the array arr, 
its size n and an integer k as inputs and returns the first negative number in every window of size k starting from the first till the end. 
If a window does not contain a negative integer , then return 0 for that window.

Input Format
The first line contains an integer n denoting the size of the array arr. 
The next line contains n space separated integers forming the array arr. 
The last line contains the window size k.

Output Format
Print the first negative integer in each window of size k seperated by a space.

Example 1
Input
9
-10 20 -30 -40 50 60 -70 80 90
3

Output
-10 -30 -30 -40 -70 -70 -70 

Explanation
The windows of size 3 with their first negative integers are as follows:-
[-10, 20, -30] => -10 
[20, -30, -40] => -30 
[-30, -40, 50] => -30
[-40, 50, 60] => -40
[50, 60, -70] => -70 
[60, -70, 80] => -70 
[-70, 80, 90] => -70 

Example 2
Input
5
-1 2 3 -4 5
2

Output
-1 0 -4 -4 

Explanation
The windows of size 2 with their first negative integers are as follows:- 
[-1, 2] => -1
[2, 3] => 0 (No negative element in window)
[3, -4] => -4
[-4, 5] => -4 

Constraints
1 <= n <= 105
10-5 <= arr[i] <= 105
1 <= k <= n

Topics
Queues
2-Pointers
Sliding Window

Companies
Amazon
*/

import java.util.*;
class Solution{
    public static int[] printFirstNegativeInteger(int arr[], int n, int k){
        Deque<Integer> storage = new ArrayDeque<>(); // stores index of negative numbers
        int[] result = new int[(n-k)+1];

        for(int index=0; index<n; index++){
            if(arr[index] < 0) storage.offerLast(index);

            if(index >= k-1){
                while(!storage.isEmpty() && storage.peekFirst() < index - (k-1))
                    storage.pollFirst();

                if(storage.isEmpty()) result[index - (k-1)] = 0;
                else result[index - (k-1)] = arr[storage.peekFirst()];
            }
        }
        return result;
    }
}
public class firstNegativeIntegerInEveryWindowOfSizeK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n] ; 
        for(int i = 0 ; i < n ; ++i){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int []ans = (Solution.printFirstNegativeInteger(arr, n , k ));
        for(int i = 0 ; i < ans.length ; ++i){
            System.out.print(ans[i] + " ");
        }
    }
}
