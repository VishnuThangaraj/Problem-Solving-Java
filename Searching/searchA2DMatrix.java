import java.util.*;

/*
You are given a 2D matrix mat of size m x n. Each row of mat has elements sorted from left to right. 
Also the first(leftmost) element of each row is greater than the last(rightmost) element of previous row.
You are also given an integer x, Search for this x in mat, return true if x is present in mat, else return false.

Input Format
First line contains three space-separated integers m n, which is the size of matrix mat
Next m lines contains n space separated integers.
Last line contains a single integer x, which is to be searched in mat

Output Format
Return true or false, according to the conditions given above

Example 1
Input
3 4
1 3 5 7
10 11 16 20
23 30 34 60
10

Output
true

Explanation
x = 10, is present in middle row first column.

Example 2
Input
3 4
1 3 5 7
10 11 16 20
23 30 34 60
12

Output
false

Constraints
1 <= m, n <= 1000
-104 <= mat[i][j] <= 104
*/

public class searchA2DMatrix {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        //use recursive binary search for ease of code
		//matrix, target, row, start index, end index
		return binarySearch2D(mat,x,0,0,mat[0].length-1);
    }
	
	//recursive 2Dbinary search
	public static boolean binarySearch2D(int[][]matrix, int target, int row, int start, int end){
		if(row == matrix.length || start > end){
			 //row out of bound, start crossed end == element not found
			return false;
		}
		int mid = end-start;

		//check the target lies on the particular row
		if(matrix[row][start] <= target && matrix[row][end] >= target){//target may occur in the row
			//search in the particular range
			if(matrix[row][mid] == target){
				return true; //target found
			}
			if(matrix[row][mid] > target){ //search on left half
				return binarySearch2D(matrix,target,row,start, mid-1);
			}
			//search right half
			return binarySearch2D(matrix,target,row,mid+1, end);
		}
		//move to next Row
		return binarySearch2D(matrix,target,row+1,start, end);
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
