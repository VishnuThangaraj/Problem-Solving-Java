import java.io.*;
import java.util.*;

/*
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Input Format
First line contains two integers V and E. Here V represent number of vertices and E represents number of edges.
Next E lines contain two integers representing an edge between them.

Output Format
For each student, standing at index i print the distance between the ith student and the student 
having height greater than ith student and standing towards the right of him/her.

Example 1
Input
5 5
1 0
0 2
2 1 
0 3
3 4

Output
1

Example 2
Input
3 2
0 1
1 2

Output
0

Constraints
1 ≤ V, E ≤ 200
*/

class Solution {
	private static boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[]visited,int source){
		Queue<Integer> storage = new LinkedList<>();
		storage.offer(source);

		while(!storage.isEmpty()){
			int current = storage.poll();
			//check if visited
			if(visited[current]) return true; // cycle found
			// mark visited
			visited[current] = true;

			//add the neighbours
			for(int nbrs : adj.get(current)){
				if(!visited[nbrs]) storage.offer(nbrs);
			}
		}

		return false; // no cycle found
	}
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       // visited array
		boolean[]visited = new boolean[V];
	
		for(int source=0;source<V;source++){
			if(!visited[source]){
				boolean isCycle = bfs(adj,visited,source);
				if(isCycle) return true; //cycle found
			}
		}
		return false; // no cycle found
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
