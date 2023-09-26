import java.util.*;
import java.io.*;
import java.lang.*;

/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. 
The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] 
means that there is a road between intersections ui and vi that takes timei minutes to travel. 
You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 10^9 + 7.

Note: You just need to complete countPaths() function and return the total number of ways.

Input Format
The first line contains two space-separated integers n and m where n denotes the number of intersection points 
in the city and m denotes the number of roads between intersection points. Next m lines contain an array which describes 
the source and destination point as well as time taken to reach the destination from source point .

Output Format
Print the number of ways you can arrive at your destination in the shortest amount of time.

Example 1
Input
7 10
0 6 7
0 1 2
1 2 3
1 3 3 
6 3 3 
3 5 1 
6 5 1 
2 5 1 
0 4 5
4 6 2

Output
4

Explanation
The shortest amount of time it takes to go from  
intersection 0 to intersection 6 is 7 minutes.

The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

Example 2
Input
2 1
1 0 10

Output
1

Explanation
There is only one way to go from intersection 0 to 
intersection 1, and it takes 10 minutes.

Constraints
1 <= n <= 200
n-1 <= m <= n*(n-1)/2
roads[i].length = 3
0 <= ui , vi <= n-1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
*/

@SuppressWarnings("unchecked")
class Solution{
	static class Pair{
		int start;
		int dest;
		int weight;
		//constructor
		Pair(int start, int dest, int weight){
			this.start = start;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static void DFS(ArrayList<ArrayList<Pair>> graph, boolean[]visited, ArrayList<Integer> result,int[] min, int weight, int source){
		if (visited[source] || weight > min[0]){
			return; // already visited
		}
		// reached the destination
		if (source == graph.size()-1){
			if(weight < min[0]){ // current path is smaller than minimum
				min[0] = weight;
				result.clear();
			}
			result.add(weight);
		}
		//mark as visited
		visited[source] = true;

		for(Pair current : graph.get(source)){
			DFS(graph,visited,result,min,weight+current.weight,current.dest);
		}

		// backtracking
		visited[source] = false;
	}
	
    public static int countPaths(int n, int[][] roads){
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

		for(int i=0; i<n; i++) graph.add(new ArrayList<Pair>());
		//create the graph
		for(int[] node : roads){
			int st = node[0];
			int dest = node[1];
			int wt = node[2];
			graph.get(st).add(new Pair (st,dest,wt));
			graph.get(dest).add(new Pair (dest,st,wt));
		}

		boolean[]visited = new boolean[graph.size()];
		ArrayList<Integer> result = new ArrayList<>();
		int[]min = {Integer.MAX_VALUE};
		
		DFS(graph, visited, result, min, 0, 0);

		return result.size();
    }
}
public class numberOfWaysToArriveAtDestination {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for(int i = 0 ; i < m ; ++i){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();

        }
        System.out.print(Solution.countPaths(n,edges));
    }
}
