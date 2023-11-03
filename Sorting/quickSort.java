import java.util.*;
import java.io.*;

/*
Given an array A[] of size N, containing positive integers. You need to sort the elements of array using the Quick sort algorithm.

Input Format
The first line of input N is the size of array and the second line consists of N array elements separated by space.

Output Format
Print the sorted array in a new line.

Example 1
Input
5
4 1 3 9 7

Output
1 3 4 7 9 

Explanation
The array after perfoming Quick sort: 1 3 4 7 9.

Example 2
Input
10
10 9 8 7 6 5 4 3 2 1

Output
1 2 3 4 5 6 7 8 9 10

Explanation
The array after performing Quick sort: 1 2 3 4 5 6 7 8 9 10.

Constraints
1 <= N <= 10^5
-10^6 <= A[i] <= 10^6
*/

class Solution{
	static void quickSort(int[] arr,int start,int end){
        if(start>=end){
			return; // stops from further call if its single element
		}

		int lowIndex = start; //lesser than pivot side
		int highIndex = end; //greater than pivot side
		int mid = start + (end-start)/2; //mid point
		int pivot = arr[mid]; // pivot element ..can take first or last element as pivot also

		while(lowIndex <= highIndex){ //iterates utill the first and last pointer reach the pivot or center
			while(arr[lowIndex]<pivot){ //runs untill the condition violates as larger element is on left of the pivot
				lowIndex++;
			}
			while(arr[highIndex]>pivot){ //runs untill the condition violates as smaller element is on right of pivot
				highIndex--;
			}
			if(lowIndex<=highIndex){ //recheck to verify indexs are on its range and swap the violation
				int temp = arr[lowIndex];
				arr[lowIndex]=arr[highIndex];
				arr[highIndex]=temp;
				lowIndex++;highIndex--; 
			}
		}

		quickSort(arr,start,highIndex); //call function with first half
		quickSort(arr,lowIndex,end); //call function with second half
    }
}

public class quickSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
		Obj.quickSort(arr,0,arr.length-1);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        sc.close();
    }
}
