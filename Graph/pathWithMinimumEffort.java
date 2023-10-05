import java.util.*;

/*
You are a hiker preparing for an upcoming hike. 
You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). 
You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Input Format
First line consists of the number of rows rows and the number of columns columns of the matrix respectively
The next rows lines contains columns elements each representing the heights of that cells

Output Format
Print the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1
Input
3 3
1 2 2
3 8 2
5 3 5

Output
2

Explanation
The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2
Input
3 3
1 2 3
3 8 4
5 3 5

Output
1

Explanation
The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Constraints
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
*/

public class pathWithMinimumEffort {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt(), columns = sc.nextInt();
    int[][] heights = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        heights[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(minimumEffortPath(heights));
  }

	static class Pair{
		int distance;
		int row;
		int col;
		//constructor
		Pair(int row, int col, int distance){
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
	}
	public static int minimumEffortPath(int[][] heights) {
		PriorityQueue<Pair> storage = new PriorityQueue<>( (a,b) -> {
			return a.distance - b.distance;
		});
		int h = heights.length; // height
		int w = heights[0].length; // width
		int[][] distance = new int[h][w];

		//fill the distance array with MAXVALUE
		for(int r=0;r<h;r++)
			for(int c=0; c<w; c++)
				distance[r][c] = Integer.MAX_VALUE;

		distance[0][0] = 0; // starting point

		// add the starting point
		storage.offer(new Pair(0, 0, 0));

		int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1};

		while(!storage.isEmpty()){
			Pair current = storage.poll();
			int Curreffort = current.distance;
			int row = current.row;
			int col = current.col;

			// reached the destination
			if(row == h-1 && col == w-1) return Curreffort;

			// add the other four sides to the queue
			for(int i=0; i<dr.length; i++){
				int newR = row + dr[i]; // new Row
				int newC = col + dc[i];

				// check for validity of the row and col
				if(newR >= h || newR <0 || newC >= w || newC < 0)
					continue;

				int effort = Math.max(Math.abs(heights[newR][newC] - heights[row][col]),Curreffort);

				if(effort < distance[newR][newC]){
					distance[newR][newC] = effort;
					storage.offer(new Pair(newR, newC, effort));
				}
			}
		}
		return 0; // unreachable 
	}
}
