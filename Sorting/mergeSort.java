import java.util.*;
import java.io.*;

/*
Given an array A[] of size N, containing positive integers. You need to sort the elements of array using the merge sort algorithm.

Input
The input consists of two lines.
The first line of input is the size of array N and the second line consists of N array elements separated by space.

Output
Print the sorted array in a new line.

Example 1
Input
5
4 1 3 9 7

Output
1 3 4 7 9 

Explanation
The array after performing merge sort: 1 3 4 7 9.

Example 2
Input
10
10 9 8 7 6 5 4 3 2 1

Output
1 2 3 4 5 6 7 8 9 10

Explanation
The array after performing merge sort: 1 2 3 4 5 6 7 8 9 10.

Constraints
1 <= N <= 10^5
-10^6 <= A[i] <= 10^6
*/

class Solution {
	static void mergeSort(int[] arr,int start,int end){
		if(start==end){
			return; // return if its single element
		}
		 int mid = (start+end)/2; //find the mid element to seperate into two parts
	
		mergeSort(arr,start,mid); //first half
		mergeSort(arr,mid+1,end); //second half
	
		SortIt(arr,start,mid,end); // sort the part
	}

	static void SortIt(int[]arr,int start,int mid, int end){
		int firstPointer = start; //pointing start of first half
		int secondPointer = mid+1; //pointing start of second half
		// create new array
		int[]newArr=new int[(end-start)+1];
		int newArrPointer = 0; // pointer for newly created array (newArr)

		while(firstPointer <= mid && secondPointer <=end){
			if(arr[firstPointer]<arr[secondPointer]){ //if first half element is smaller add to new array
				newArr[newArrPointer] = arr[firstPointer];
				firstPointer++;
			}else{ // if second half element is smaller add to new array
				newArr[newArrPointer] = arr[secondPointer];
				secondPointer++;
			}
			newArrPointer++; // increase newArray pointer after a element is added in the new Array
		}
		// if there is any balance unadded element in first half will be added now else skip
		while(firstPointer<=mid){
			newArr[newArrPointer] = arr[firstPointer];
				firstPointer++;newArrPointer++;
		}
		//if there is any balance unadded element in second half will be added now else skip
		while(secondPointer<=end){
			newArr[newArrPointer] = arr[secondPointer];
				secondPointer++;newArrPointer++;
		}
		//add the sorted elements of the range in default array
		for(int add=0;add<newArr.length;add++){
			arr[start+add]=newArr[add];
		}
	}
}
public class mergeSort {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] a=new int[n];
		for(int i= 0; i < n; i++)
			a[i] = input.nextInt();
		Solution Obj = new Solution();
		Obj.mergeSort(a,0,n-1);
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}
}
