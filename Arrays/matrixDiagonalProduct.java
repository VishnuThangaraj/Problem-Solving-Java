/*
Given a square matrix mat, return the product of the matrix diagonals.
Only include the product of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Input
First line consist of a single integer n denoting dimension of n*n matrix and then next n lines 
contains n integers each where jth integer (1 <= j <= n) in the ith line (1<= i <= n) denote a[i][j] element of matrix

Output
Output product of elements in primary diagonal and elements in secondary diagonal that are not part of primary diagonal.

Constraints:
1 <= N <= 10^3 0 <= a[i][j] <= 100

Sample Input:
3 
1 2 3
4 5 6
7 8 9

Sample Output:
945

Explaination
Explanation: Diagonals sum: 1 x 5 x 9 x 3 x 7 = 945 Notice that element mat[1][1] = 5 is counted only once.
*/

import java.util.*;
import java.io.*;

public class matrixDiagonalProduct {
    public static int getSum(int[][] matrix, int n){
        // Calculate the Diagonal Product
        int sum = 1;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(row == col || row+col == n-1){
                    sum *= matrix[row][col];
                }
            }
        }

        return sum;
    }
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[][] matrix = new int[n][n];
        
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                matrix[row][col] = read.nextInt();
            }
        }
        read.close();

        int result = getSum(matrix, n);
        System.out.println(result);
    }
}
