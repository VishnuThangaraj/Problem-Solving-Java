/*
Yash has a sorted array of size N. This array has every element repeated twice except one number which occurs only one time. 
Yash want to find this unique number. Can you help him?
Your task is to complete the function uniqueElement which receives the input array as parameter and returns the unique number.

Input Format:
The first line of input contains an integer N denoting the size of array.
The second line of input contains N space-separated integers denoting the elements of the array.

Output Format:
The only line of output will be an integer denoting the unique number of the array.

Example 1:
Input:
5
2 2 4 6 6

Output:
4

Explanation: 
Given array is [2, 2, 4, 6, 6]. Here, 4 occurs once in the array. So, the answer is 4.

Example 2:
Input:
7
3 3 5 5 6 8 8

Output:
6

Explanation: 
Given array is [3, 3, 5, 5, 6, 8, 8]. Here, 6 occurs once in the array. So, the answer is 6.

Constraints:
1 <= N <= 10^5
1 <= arr[i] <= 10^9
where arr[i] denotes the ith element of the array.

Topics : 
Bit Manipulation

Companies : 
Microsoft
Adobe
Apple
Bloomberg
Amazon
Facebook
Atlassian
Airbnb
Yahoo
SAP
TCS
Zoho
Uber
Twitter
Google
*/

import java.util.*;

public class uniqueNumber {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            arr.add(sc.nextInt());
        }
        int ans = Solution.uniqueElement(arr);
        System.out.println(ans);
    }
}
class Solution {
    static int uniqueElement(ArrayList < Integer > arr) {
        int result = 0;

        for(int num : arr)
            result = result ^ num;

        return result;
    }
}
