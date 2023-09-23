import java.io.*;
import java.util.*;

/*
You are given an undirected graph with N vertices. You have to find the number of connected components in the graph.
Note Complete the given function. The input and output would be handled by the driver code.
A set of vertices forms a connected component in an undirected graph if any vertex from the set of vertices can reach any other vertex by traversing edges.

Input Format
The first line of the input contains N.
and next N lines consists of N integers each of the adjacency matrix adj.
If adj[u][v] is 1, it means there is an edge between u and v.

Output Format
Print the answer in a new line.

Example 1
Input
3
1 1 0
1 1 0
0 0 1 

Output
2

Explanation
The graph has two components. [1, 2], and [3].

Example 2
Input
2
1 0
0 1

Output
2

Explanation
The graph has two components. [1], and [2].

Constraints
1 <= N <= 300
0 <= adj[u][v] <= 1
*/

class countComponents {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {
	private static void helper(ArrayList<ArrayList<Integer>> graph, boolean[]visited, int n){
		//mark as visited
		visited[n] = true;

		ArrayList<Integer> current = graph.get(n);

		for(int nbr =0; nbr < current.size(); nbr++){
			if(n != nbr  && current.get(nbr) == 1){
				if(!visited[nbr]){
					helper(graph,visited,nbr);
				}
			}
		}
	}
    int components(ArrayList<ArrayList<Integer>> adj, int N) {
        int componentsCount = 0;

		//visited array to keep track of visited places
		boolean[]visited = new boolean[N];

		for(int source=0;source<N;source++){
			//check if visited, and apply DFS in unvisited nodes
			if(!visited[source]){
				componentsCount++;
				helper(adj,visited,source);
			}
		}
		return componentsCount;
    }
}
