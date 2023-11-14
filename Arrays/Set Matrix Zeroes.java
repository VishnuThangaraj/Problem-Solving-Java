import java.util.*;

/*
You are given an m x n integer matrix arr. If any element in arr is 0, set all the elements in that row and column to 0.

Input Format
The first line of input contains the integers m and n.
The next m lines contain n numbers each that are space-separated, representing the integer matrix arr.

Output Format
The output should contain m lines with n numbers space separated each, after performing the operation described above.

Example 1
Input
2 2
0 1
1 0

Output:
0 0 
0 0 

Example 2
Input
4 5
0 1 1 0 2
1 1 1 1 0
1 1 1 1 3
1 2 3 0 5

Output:
0 0 0 0 0 
0 0 0 0 0 
0 1 1 0 0 
0 0 0 0 0 

Constraints
1 <= m,n <= 200
0 <= arr[i][j] <= 10^9
*/

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution.setMatrixZeroes(arr);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    static void setZero(int[][] matrix, int row, int col){
        matrix[row][col] = -1;
        // Row
        for(int Nrow=0; Nrow<matrix.length; Nrow++){
            if(matrix[Nrow][col] != 0)
                matrix[Nrow][col] = -1;
        }

        // Column
        for(int Ncol=0; Ncol<matrix[0].length; Ncol++){
            if(matrix[row][Ncol] != 0)
                matrix[row][Ncol] = -1;
        }
    }
  static void setMatrixZeroes(int[][] matrix) {
      for(int row=0; row<matrix.length; row++){
          for(int col=0; col<matrix[0].length; col++){
              if(matrix[row][col] == 0)
                  //Set the entire row and column to zero
                  setZero(matrix, row, col);
          }
      }

      // Fixing
      for(int row=0; row<matrix.length; row++)
          for(int col=0; col<matrix[0].length; col++)
              if(matrix[row][col] == -1)
                  matrix[row][col] = 0;
  }
}
