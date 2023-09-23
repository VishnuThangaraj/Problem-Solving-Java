import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an m x n 2-D binary grid which represents a map of 1s (land) and 0s (water).
Your task is to return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
You have to complete numberOfIslands function which contains grid array of size m*n as inputs and return the single integer answer as output

Input Format
The first line of input contains two numbers m and n(rows and columns of the given array).
The next m lines contains n elements(1 or 0) representing an individual land or water.

Output Format
The only line of input contains an integer representing the number of islands.

Example 1
Input
4 5
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0

Output
1

Explanation
There is only one island possible in the given matrix.

Example 2
Input
4 5
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1

Output
3

Explanation
There are three islands on the indexes
{(0,0),(0,1),(1,0),(1,1)},
{(2,2)},
{(3,3),(3,4)}

Constraints
1 <= m,n <= 300
0 <= grid[i][j] <= 1
*/

class Solution{
    static int numberOfIslands(int[][] grid, int n, int m){
        boolean[][]visited = new boolean[n][m];
		int count = 0;

		for(int row=0; row<n; row++){
			for(int col=0; col<m; col++){
				// visit all the un-visited islands (1)
				if(!visited[row][col] && grid[row][col] == 1){
					DFS(grid,visited,row,col);
					count++; // island found
				}
			}
		}

		return count;
    }

	static void DFS(int[][]grid, boolean[][]visited, int row, int col){
		if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
			  return;
		  }
		if(visited[row][col]) return;
		
		visited[row][col] = true; //mark visited

	  DFS(grid, visited, row, col+1); // left
	  DFS(grid, visited, row, col-1); // right
	  DFS(grid, visited, row+1, col); // down
	  DFS(grid, visited, row-1, col); // up

	  // check the diagonals too
		DFS(grid, visited,row-1,col-1); //up-left
		DFS(grid, visited,row-1,col+1); //up-right
		DFS(grid, visited,row+1,col-1); //down-left
		DFS(grid, visited,row+1,col+1); //down-right
		
	}
}

public class numberOfIslands
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
        int n = sc.nextInt();
    	int M[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = sc.nextInt();
		    }
		}
		System.out.println(Solution.numberOfIslands(M, m, n));
	}
}
