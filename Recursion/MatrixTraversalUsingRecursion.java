import java.util.*;

/*
You are given a matrix of size m * n. Your task is to print all the elements of this matrix row wise.

Note: Solve this question using Recursion.

Input Format
First line contains two space separated integers m and n
Next m lines contains n space separated integers

Output Format
Complete the function MatTraverseRecur() which prints the elements of array in the following format
Each row in new line
Each element of same row have a space in between

Example 1
Input
2 5
14 2 26 11 14
11 4 9 1 16

Output
14 2 26 11 14
11 4 9 1 16

Example 2
Input
7 7
4 22 28 23 11 22 12
42 7 32 12 33 40 7
13 46 29 16 2 36 17
42 6 42 36 11 44 27
9 18 27 29 12 32 38
28 27 20 40 19 29 24
39 35 14 36 10 50 25

Output
4 22 28 23 11 22 12
42 7 32 12 33 40 7
13 46 29 16 2 36 17
42 6 42 36 11 44 27
9 18 27 29 12 32 38
28 27 20 40 19 29 24
39 35 14 36 10 50 25

Constraints
1 <= m, n <= 50
*/

class Solution {
    public void traversal(int[][] mat, int row, int col){
        if(row >= mat.length) return;
        if(col >= mat[0].length ){
            System.out.println();
            traversal(mat, row+1,0);
            return;
        }
        System.out.print(mat[row][col]+" ");
        traversal(mat,row,col+1);
    }
    
    public void MatTraverseRecur(int[][] mat) {
        traversal(mat, 0, 0);
    }
}

public class MatrixTraversalUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] mat = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
	    Solution Obj = new Solution();
        Obj.MatTraverseRecur(mat);
    }
}
