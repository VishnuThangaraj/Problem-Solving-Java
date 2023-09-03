import java.io.*;
import java.util.*;

/*
Given a zero based Bitonic array arr of size N. 
You need to find the index of the target value in the array arr, if it is present else -1.

Note
A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Input Format
The first line of input contains a single integer representing N.
The second line of input contains N space seperated integer representing array element.
The third line of input contains the target, element to be searched in the array.

Output Format
Return the positon of target value in the array if present else -1.

Example 1
Input
7
-3 9 18 20 17 5 1
20

Output:
3

Explanation:
Element 20 is found at index 3.

Example 2
Input
3
3 4 1
5

Output:
-1

Explanation:
Element 5 can not be found in the array so we output -1.

Constraints
1 <= N <= 10^5
-10^6 <= arr[i] <= 10^6
*/

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();
        
        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);
    
    }
}


class Accio {
    
    static int findElement(int arr[], int n,int target)
    {
        int mid = binarySearch(arr,0,arr.length-1);
		
		int left = left(arr,target,0,mid);

		if(left!=-1){
			return left;
		}
		int right = right(arr,target,mid+1,arr.length-1);
		
		if(right!=-1){
			return right;
		}
		return -1;

    }
	//recursive binary search to find peak element
	 static int binarySearch(int[]A, int start, int end){
		if(start > end){
			return -1; //base condition is not necessary
		}
		
		int mid = start + (end-start)/2;

		if(mid>=1 && A[mid] > A[mid-1] && A[mid] > A[mid+1]){
			return mid; //element found return the index
		}

		if(mid>=1 && A[mid] > A[mid-1]){ //search right region
			return binarySearch(A,mid+1,end);
		}
		
		return binarySearch(A,start,mid-1); //search left region	
	}

	public static int left(int[]A, int target, int start, int end){
		if(start > end){
			return -1; //element is not found in the array
		}
		int mid = start + (end-start)/2; 

		if(A[mid] == target){ // target found
			return mid; //target found
		}

		if(A[mid] > target){
			return left(A,target,start, mid-1); //search left half
		}

		return left(A,target,mid+1, end); //search right half
	}

	//recursive descending search
	static int right(int[]A, int target, int start, int end){
		if(start > end){
			return -1; //element is not found in the array
		}
		int mid = start + (end-start)/2; 
	
		if(A[mid] == target){ // target found
			return mid; //target found
		}

		if(A[mid] < target){
			return right(A,target,start, mid-1); //search right half
		}
	
		return right(A,target,mid+1, end); //search right half
	}
}
