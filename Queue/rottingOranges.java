import java.util.*;
import java.lang.*;
import java.io.*;

/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Input Format
The first line contains two integers r and c.
The next r lines contains c spaced integers , elements of matrix.

Output Format
Print the minimum number of minutes.

Example 1
Input
3 3
2 1 1
1 1 0
0 1 1

Output
4

Explanation
After 4 min all the fresh oranges becomes rotten.

Example 2
Input
3 3
2 1 1
0 1 1
1 0 1

Output:
-1

Explanation
The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Constraints
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

public class rottingOranges {
	
	  public static void main (String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int [][] arr= new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        Solution obj= new Solution();
	        
	        System.out.println(obj.orangesRotting(arr));
		}
}
class Solution{
	private static class Pair{
		int row;
		int col;
		int time;
		//constructor
		Pair(int row,int col,int time){
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	 public static int orangesRotting(int[][] grid) {
		int timeTaken = 0;
		 Queue<Pair> queue = new LinkedList<>();

		 //add all the rotten oranges to queue with 0 as its time
		 for(int row=0;row<grid.length;row++){
			 for(int col=0;col<grid[0].length;col++){
				 if(grid[row][col] == 2) //rotten orange found
					 queue.offer(new Pair(row,col,0));
			 }
		 }

		 boolean[][]visited = new boolean[grid.length][grid[0].length];

		 while(!queue.isEmpty()){
			 Pair current = queue.poll();

			 int row = current.row;
			 int col = current.col;
			 int time = current.time;

			 if(visited[row][col]) continue; //ignore if already visited
			 visited[row][col] = true; //mark visited if not visited
			 grid[row][col] = 2; //make as rotten
			 

			 //update the timeTaken
			 timeTaken = Math.max(timeTaken, time);
			 
			 //rotten the neighbours
			 if(row>0 && grid[row-1][col] == 1) //up
				 queue.offer(new Pair(row-1,col,time+1));
			 if(row<grid.length-1 && grid[row+1][col] == 1) //down
				 queue.offer(new Pair(row+1,col,time+1));
			 if(col>0 && grid[row][col-1] == 1) //right
				 queue.offer(new Pair(row,col-1,time+1));
			 if(col<grid[0].length-1 && grid[row][col+1] == 1) //left
				 queue.offer(new Pair(row,col+1,time+1));
		 }

		 // CHECK ALL THE ORANGES ARE ROTTEN
		 for(int row=0;row<grid.length;row++){
			 for(int col=0;col<grid[0].length;col++){
				 if(grid[row][col] == 1) //fresh orange found
					 return -1;
			 }
		 }

		 return timeTaken;
	}
}
