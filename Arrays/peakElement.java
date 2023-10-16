import java.io.*;
import java.util.*;

/*
An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).
For first and last element consider only the element adjacent to it.
Given an array arr of size n, find the index of first peak element.
If peak element does not exist, print -1.

Input Format
First line contains an integer n.
Second line contains n space separated integers.

Output Format
Return the index of the peak element in zero based indexing if present, else return -1

Example 1
Input
4
5 10 20 15

Output
2

Explanation
20 is greater than both of its neighbours. Hence 20 is the peak element, So output is 2

Example 2
Input
7
10 20 15 2 23 64 67

Output
1

Explanation
20 is greater than both of its neighbors. Hence 20 is the peak element, So output is 1

Constraints
1<=n<=10^6
1<=arr[i]<=10^6
*/

class Solution {
    static int findPeak(int arr[], int n)
    {
		for(int index=0; index<arr.length; index++){
			if(index == 0){ // first num in array wont have left element
				if(arr[index] > arr[index+1])
					return index;
			}
			else if(index == n-1){ // last num in array wont have right element
				if(arr[index] > arr[index-1])
					return index;
			}
			else{
				if((arr[index] > arr[index-1]) && (arr[index] > arr[index+1]))
					return index;
			}
		}

		return -1; // peak index not found
    }
}

public class peakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.findPeak(arr1, n);
        System.out.print(result);        
        System.out.println('\n');
    }
}
