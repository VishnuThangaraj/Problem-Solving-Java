/*
Given an input stream arr[] of n integers. Find the Kth largest element for each element in the stream and if the Kth element does not exist, print -1.

Input
The first line contains two integers n and integer k.
The second line contains n spaced integers, the running stream.

Output
Print the Kth largest element in the stream.

Example
Sample Input
6 4
1 2 3 4 5 6

Sample Output
-1 -1 -1 1 2 3

Explanation
k = 4
For 1, the 4th largest element does not
exist so we print -1.
For 2, the 4th largest element does not
exist so we print -1.
For 3, the 4th largest element does not
exist so we print -1.
For 4, the 4th largest element is 1.
For 5, the 4th largest element is 2.
for 6, the 4th largest element is 3.

Sample Input
2 1
3 4

Sample Output
3 4

Explanation
For the 1st and 2nd element the 1st largest element is itself.

Expected Time Complexity: O(n*logk)
Expected Auxiliary Space: O(n)

Constraints
1 ≤ k ≤ n ≤ 10⁵
1 ≤ arr[i] ≤ 10⁵

Topics:
Heaps

Companies :
Microsoft
Flipkart
Cisco
Amazon
Oyo Rooms
Hike
*/

import java.util.*;
import java.io.*;

public class kthLargestElementInStream {
    // function to find the kth largest element in array
    public static int[] kthLargest(int[]arr, int n, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int index=0; index<n; index++){

            if(heap.size() < k)
                heap.offer(arr[index]);
            else if(arr[index] > heap.peek()){
                heap.poll();
                heap.offer(arr[index]);
            }
                

            if(heap.size() < k) arr[index] = -1;
            else arr[index] = heap.peek();
        }

        return arr;
    }
    
    public static void main(String args[]) {
        Scanner read = new Scanner (System.in);
        int n = read.nextInt();
        int k = read.nextInt();
        int[] arr = new int[n];
        for(int index=0; index<n; index++)
            arr[index] = read.nextInt();

        int[] result = kthLargest(arr, n, k);

        // Print the Result
        for(int num : result)
            System.out.print(num+" ");

        System.out.println();
        read.close();
    }
}
