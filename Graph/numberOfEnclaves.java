import java.util.*;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Input Format
First line consists of the number of rows m and columns n of the matrix mat
The next m lines contains n integers each, either 0(sea) or 1(land)

Output Format
Print the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves

Example 1
Input
4 4
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0

Output
3

Explanation
There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2
Input
4 4
0 1 1 0
0 0 1 0
0 0 1 0
0 0 0 0

Output
0

Explanation
All 1s are either on the boundary or can reach the boundary.

Constraints
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1
*/

public class numberOfEnclaves {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

  public static void destroy(int[][]grid, int row, int col){
	  if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
		  return;
	  }
	  //destroy the unsafe land
	  grid[row][col] = 0;

	  destroy(grid, row, col+1); // left
	  destroy(grid, row, col-1); // right
	  destroy(grid, row+1, col); // down
	  destroy(grid, row-1, col); // up
  }

  public static int numEnclaves(int[][] grid) {
      int col = grid[0].length;
	  int row = grid.length;
	  int safeCount = 0;

	  //TRAVEL ON THE BOUNDRY AND DESTROY THE UN-SAFE LANDS
	  // top
	  for(int j=0; j<col; j++){
		  if (grid[0][j] == 1) destroy(grid,0,j);
	  }

	  // bottom
	  for(int j=0; j<col; j++){
		  if (grid[row-1][j] == 1) destroy(grid,row-1,j);
	  }

	  // left
	  for(int i=0; i<row; i++){
		  if (grid[i][0] == 1) destroy(grid,i,0);
	  }

	  // right
	  for(int i=0; i<row; i++){
		  if (grid[i][col-1] == 1) destroy(grid,i,col-1);
	  }

	  // count the safe lands
	  for(int i=0; i<row; i++){
		  for(int j=0;j<col;j++){
			  if(grid[i][j] == 1) safeCount++;
		  }
	  }

	  return safeCount;
  }
}
