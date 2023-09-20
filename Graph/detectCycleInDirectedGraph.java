import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

Input Format:
First line contains two integers denoting V and E respectively.
Next E lines contain two integers u and v in each line, denoting an edge from u to v.

Output Format
Return true if there is a cycle in the graph, else return false.

Example 1
Input
4 6
0 1 
0 2
1 2
2 0
2 3
3 3

Output
True

Explanation
The graph clearly has a cycle 0 -> 2 -> 0.

Example 2
Input
4 4
0 1
0 2
1 2
2 3

Output
False

Explanation
The graph clearly has no cycle.

Constraints
1 <= V <= 10^3
1 <= E <= 10^3
*/

class Solution {
	private boolean dfs(ArrayList<Integer>[] adj, boolean[]visited,boolean[]path,int source){
		path[source] = true;
		visited[source] = true;

		//add the neighbours
		for(int nbrs : adj[source]){
			if(path[nbrs]) return true; //cycle found
			else if(!visited[nbrs]){
				boolean isCycle = dfs(adj,visited,path,nbrs);
				if(isCycle) return true;
			}
		}

		path[source] = false; //backtracking
		return false; // no cycle found
	}
public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
	 // visited array
	boolean[]visited = new boolean[V];
	boolean[]path = new boolean[V];

	for(int source=0;source<V;source++){
		if(!visited[source]){
			boolean isCycle = dfs(adj,visited,path,source);
			if(isCycle) return true; //cycle found
		}
	}
	return false; // no cycle found
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
