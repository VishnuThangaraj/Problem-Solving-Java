import java.io.*;
import java.util.*;

/*
There are n cities connected by some number of flights. You are given an array flights where 
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.

Input Format
The first line contains n and e, which denotes the number of cities and the number of flights.
Next e lines contains 3 space separated integers fromi, toi and pricei.
Last line contains 3 space separated integers src, dst and k.

Output Format
Return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1
Input
4 5
0 1 100
1 2 100
2 0 100
1 3 600
2 3 200
0 3 1

Output
700

Explanation
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2
Input
3 3
0 1 100
1 2 100
0 2 500
0 2 1

Output
200

Explanation
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Constraints
1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 10^4
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
*/

public class cheapestFlightsWithinKStops {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[e][3];
        for (int i = 0; i < e; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.findCheapestPrice(n, arr, src, dst, k);
        System.out.println(ans);
        sc.close();
    }
}

class Solution {
	class Pair{
		int source;
		int dest;
		int price;
		//constructor
		Pair(int source, int dest, int price){
			this.source = source;
			this.dest = dest;
			this.price = price;
		}
	}
	public void DFS(ArrayList<ArrayList<Pair>> graph, boolean[]visited, int[] min, int src, int dest, int stops, int price){
		if(visited[src] || price > min[0]) return; //already visited or high price
		
		if(src == dest && stops >=0){
			min[0] = price;
		}

		if(stops <= 0) return ; // no more stops to make route

		//mark as visited
		visited[src] = true;

		for(Pair current : graph.get(src)){
			DFS(graph, visited, min, current.dest, dest, stops-1, price+current.price);
		}

		//backtracking
		visited[src] = false;
	}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //create the Directed graph
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		//populate the graph
		for(int i=0;i<n;i++) graph.add(new ArrayList<Pair>());

		for(int[]location : flights){
			// array will be like [start, destination, price]
			int start = location[0];
			int dest = location[1];
			int price = location[2];
			graph.get(start).add(new Pair(start, dest, price));
		}

		int price = 0;
		boolean[]visited = new boolean[n];

		int[] min = {Integer.MAX_VALUE};
		DFS(graph, visited, min, src, dst, k+1, 0);

		return min[0];
    }
}
