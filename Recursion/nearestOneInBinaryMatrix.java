/*
Given a binary matrix of size N x M. The task is to find the distance of nearest 1 in the matrix for each cell. 
The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, 
j1 are the row number and column number of the current cell and i2, j2 are the row number and column number of the nearest cell having value 1.

Input Format
The first line contains two integers N and M, denoting the number of rows and columns of the matrix. 
Next N lines contain M integers either 0 or 1. Each element of matrix is either 0 or 1 
It is guaranteed that there is at least one 1 present in the input.

Output
Print N lines. Each line containing M integers denoting the distance from nearest 1.

Example 1
Input
3 3
1 0 0
0 1 0
0 0 0

Output
0 1 2 
1 0 1 
2 1 2 

Explanation
0's at (0,1), (1,2), (2,1) and (2,2) are at a distance of 1, 1, 1 and 2 from 1's at (0,0), (0,2), (2,0) and (1,1) respectively.

Example 2
Input
3 4
0 1 1 0
1 1 0 0
0 0 1 1

Output
1 0 0 1
0 0 1 1
1 1 0 0

Explanation
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1),(0,2), (0,2), (2,3), (1,0) and (1,1) respectively.

Constraints
1 <= N, M <= 500

Topics
2D-Arrays
BFS

Companies
Dunzo Mathworks Flipkart Facebook Wipro Publicis-Sapient
*/

import java.util.*;
import java.lang.*;
import java.io.*;
public class nearestOneInBinaryMatrix
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
class Solution{
    // Funtion to search the nearest One
    public int nearestOne(int row, int col, int n, int m, int[][]grid, boolean[][] visited, int path){
        // Base Case
        if(row < 0 || row >=n || col < 0 || col >= m || visited[row][col])
            return Integer.MAX_VALUE;

        if(grid[row][col] == 1) return path;

        // mark as visited
        visited[row][col] = true;
        int minPath = Integer.MAX_VALUE;

        minPath = Math.min(minPath, nearestOne(row+1, col, n, m, grid, visited, path+1)); // UP
        minPath = Math.min(minPath, nearestOne(row-1, col, n, m, grid, visited, path+1)); // DOWN
        minPath = Math.min(minPath, nearestOne(row, col-1, n, m, grid, visited, path+1)); // LEFT
        minPath = Math.min(minPath, nearestOne(row, col+1, n, m, grid, visited, path+1)); // RIGHT

        // Backtracking
        visited[row][col] = false;

        return minPath;
    }
    public int[][] nearest(int[][] grid){
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][m];

        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(grid[row][col] == 0)
                    result[row][col] = nearestOne(row, col, n, m, grid, visited, 0);
            }
        }

        return result;
    }
}
