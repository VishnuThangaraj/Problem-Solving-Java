/*
Given an integer array arr sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. 
The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array arr. 
More formally, if there are k elements after removing the duplicates, then the first k elements of arr should hold the final result. 
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of arr.
Note : Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Input Format
The first line of input contains integer n representing the size of array arr respectively.
The second line of input contains n space-separated integers representing the elements of array arr.

Output Format
The only line of output contains a single integer k representing the size of array after removing duplicates.

Example 1
Input
6
1 1 1 2 2 3

Output
5

Explanation
Your function should return k = 5, with the first five elements of arr being 1, 1, 2, 2 and 3 respectively. 
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2
Input
9
0 0 1 1 1 1 2 3 3

Output
7

Explanation
Your function should return k = 7, with the first seven elements of arr being 0, 0, 1, 1, 2, 3 and 3 respectively. 
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:
1 <= arr.length <= 3 * 10^4
-10^4 <= arr[i] <= 10^4

Topics:
2-Pointers
Sorting
Arrays

Companies:
Microsoft
Adobe
Apple
VMware
Amazon
Facebook
Google
*/

import java.util.*;

class Solution {
    public static int removeDuplicates(int[] arr) {
        int size = arr.length, result = size;
        int duplicates = -2;

        // Two-Pointers
        int first = 0, second = 0;
        
        while(first < size){
            while(second < size && arr[second] == arr[first]){
                duplicates++;
                second++;
            }
            if(duplicates > 0){
                result -= duplicates;
            }
            first = second;
            duplicates = -2; 
        }
        return result;
    }
}

public class removeDuplicatesFromSortedArrayII{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.removeDuplicates(arr));
    }
}
