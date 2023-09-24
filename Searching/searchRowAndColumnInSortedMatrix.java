import java.util.*;

/*
You are given an N * N matrix of integers where each row and each column is sorted in increasing order. 
You are given a target integer X. Find the position of X in the matrix.
If it exists, then print the pair i j where i represents the row and j represents the column of the array, otherwise print -1 -1

For example: If the given matrix is:
1 2 5
3 4 9
6 7 10 

We have to find the position of 4. We will print {1,1} since A[1][1] = 4.

Input Format
The first line of input contains a single integer T, representing the number of test cases or queries to be run.
Then the T test cases follow.
The first line of each test case contains two space-separated integers N and X, representing the size of the matrix and the target element respectively.
Each of the next N lines contains N space-separated integers representing the elements of the matrix.

Output Format
For each test case, print the position of X, if it exists, otherwise print 1 -1.

Example 1
Input
2
3 4
1 2 5
3 4 9
6 7 10
2 5
4 5
8 6

Output
1 1
0 1

Explanation
The element exists in the array

Example 2
Input
2
3 16
2 4 8
3 6 9
4 7 16
1 10
4

Output
2 2
-1 -1

Explanation
The element exists in one tc and not in another

Constraints
1 ≤ T ≤ 10
1 ≤ N ≤ 10^3
1 ≤ X ≤ 10^6
1 ≤ A[i][j] ≤ 10^6
where 'T' is the number of test cases, 'N' is the number of rows and columns, 'X' is the target value, and A[i][j] is the elements of the matrix.
*/

class Pair{
    int x; int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class searchRowAndColumnInSortedMatrix {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            t--;
            int n=sc.nextInt();
            int x=sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            Pair p = search(arr, x);
            System.out.println(p.x+" "+p.y);
        }
    }

	public static int binarySearch(int[][]matrix, int target, int row, int start ,int end){
		if(start > end){
			return -1; // target not found
		}

		int mid = start + (end - start) / 2;

		if(matrix[row][mid] == target)
			return mid; // target found... return the index

		if(target < matrix[row][mid]) //search left region(before mid)
			return binarySearch(matrix,target,row,start,mid-1);

		return binarySearch(matrix,target,row,mid+1,end); //search right region (after mid)
	}

    public static Pair search(int[][] matrix, int x) {
        // Apply binary search in each row to reduce the time complexity to logN
		Pair result = new Pair(-1,-1);

		for(int row = 0; row<matrix.length; row++){
			result.y = binarySearch(matrix,x,row,0,matrix[0].length-1);
			if(result.y != -1){
				result.x = row; // target found
				break;
			}	
		}

		return result;
      }
}
