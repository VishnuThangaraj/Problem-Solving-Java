import java.util.*;

/*
Given an array arr of integers and a number K.
Find the count of distinct elements in every window of size K in the array.

Input Format
Input consists of two lines.
First line contains an integer n which is the size of the array and an integer K which is the size of the window.
Next line contains n spaced integers of the array.

Output Format
Print the distinct elements in each window of size K in the array separated by space.

Example 1
Input
7 4
1 2 1 3 4 2 3

Output
3 4 4 3

Explanation
Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

Example 2
Input
3 2
4 1 1

Output
2 1

Explanation
Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window are 1.

Constraints
1 <= k <= n <= 10^5
1 <= arr[i] <= 10^3
*/

class Solution {
    public int[] countDistinct(int[] arr, int k) {
        // store the elements and its occurance
        HashMap<Integer,Integer> storage = new HashMap<>();
        int[] result = new int[(arr.length-k)+1];
        int ind = 0; // index for the result array

        int start = 0;
        for(int index=0; index<arr.length; index++){
            storage.put(arr[index], storage.getOrDefault(arr[index],0)+1);

            if(index >= k-1){
                if(index >= k){
                    if(storage.get(arr[start]) == 1){
                        storage.remove(arr[start]);
                    }else{
                        storage.put(arr[start], storage.get(arr[start])-1);
                    }
                    start++;
                }
                result[ind++] = storage.size();
            }
        }
        return result;
    }
}

public class countDistinctElementsInSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result[] = Obj.countDistinct(arr, k);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}
