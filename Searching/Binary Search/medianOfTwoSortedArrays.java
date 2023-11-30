/*
You are given two sorted arrays nums1 and nums2 of size n and m respectively, You have to find the median of the two sorted arrays.
Note : The overall run time complexity should be O(log (m+n)).
Note : You just need to complete findMedianSortedArrays() function.

Input Format
First line contains two space separated-integers n and m.
Second line contains an integer array nums1 of size n.
Third line contains an integer array nums2 of size m.

Output Format
print the median of the two sorted arrays.

Example 1
Input
4 6 
1 3 5 7 
1 2 4 6 8 10

Output
4.5

Explanation
Merged Array : 1 1 2 3 4 5 6 7 8 10 
Two middle values are : 4 and 5 . 
Median : (4+5)/2 = 4.5

Example 2
Input
4 5 
1 3 5 7 
1 2 4 6 8 

Output
4

Explanation
Merged Array : 1 1 2 3 4 5 6 7 8 
Median : 4

Constraints
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6

Topics
Binary Search
*/

import java.util.*; 

class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length, num2 = nums2.length;
        // apply binary search on smaller array for better time complexity
        if(num1 > num2) 
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = num1, left = (num1 + num2 + 1) / 2;
        boolean oddSizeArray = ((num1+num2) % 2 != 0) ? true : false;

        while(low <= high){
            int mid1 = (low+high) / 2, mid2 = left - mid1;

            // left and right pointers
            int left1 = (mid1 > 0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int left2 = (mid2 > 0) ? nums2[mid2-1] : Integer.MIN_VALUE;
            int right1 = (mid1 < num1) ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = (mid2 < num2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
                if(oddSizeArray)
                    return Math.max(left1, left2)*1.0;
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
            else if(left1 > right2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }

        return 1.0; // Dummy Return
    }
}


public class medianOfTwoSortedArrays {
    public static void main(String args[]) {
         
         Scanner scn = new Scanner(System.in); 
         int n = scn.nextInt(); 
         int m = scn.nextInt(); 

         int[] nums1 = new int[n]; 
         int[] nums2 = new int[m];  

         for(int i=0; i<n ;i++){
             nums1[i] = scn.nextInt(); 
         } 

         for(int i=0; i<m ;i++){
             nums2[i] = scn.nextInt(); 
         } 
        
         Solution sol = new Solution(); 
         double ans = sol.findMedianSortedArrays(nums1 , nums2); 

         System.out.println(ans); 


    }
}
