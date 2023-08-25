import java.io.*;
import java.util.*;

/*
You have been given a non-empty grid MAT with N rows and M columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
Your task is to find the index of the row that has the maximum number of ones.
Note: If two rows have the same number of ones, consider the one with a smaller index.

Input Format
The first input line contains two space separated integers N and M representing the number of rows and columns of the grid, respectively.
From the second line, the next N lines represent the rows of the grid. Every row contains M single space-separated integers.

Output Format
Print the index of the row with the maximum number of ones.

Example 1
Input
2 2
1 1
1 1

Output:
0

Explanation For the given grid, both rows have an equal number of ones. Since the row with index 0 has a smaller index. Hence the answer is 0.

Example 2
Input
3 4
0 0 1 1
0 0 0 1
0 1 1 1

Output:
2

Explanation For the given grid, third row has highest number of 1s. So, output is 2 (0 based index).

Constraints
1 <= N <= 500
1 <= M <= 500
0 <= MAT[i][j] <= 1
*/

public class rowWithMaximum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr,n,m));
        
    }
}

class Solution {
	//recursive binary search
	public static int binarySearch(int[][] arr, int row, int start, int end, int max, int resultRow){
		if(row >= arr.length){
			return resultRow; 
		}

		int mid = start + (end-start)/2;

		if(mid == 0 || arr[row][mid] > arr[row][mid-1]){
			if(arr[0].length-mid > max){
				max = arr[0].length-mid;
				resultRow = row;
			}
			return binarySearch(arr,row+1,0,arr[0].length-1,max,resultRow); //search in next row
		}

		if(arr[row][mid] == 1){
			return binarySearch(arr,row,start,mid-1,max,resultRow); //search left region
		}
		return binarySearch(arr,row,mid+1,end,max,resultRow); //search right region
	}
    public static int rowWithMaximumOnes(int arr[][], int n, int m) {
		//recursive 2D binary Search
		return binarySearch(arr,0,0,arr[0].length-1,-1,0);
    }
}
