import java.io.*;
import java.util.*;

/*
Given an undirected graph of with N vertices and V edges, Your task is to find out if the path 
exist between 2 vertices in this graph, return true, else false.

Input Format
The first line consists of two space separated integers N and M denoting the number of vertices and number of edges.
Then in the next M line are 2 space separated integers u,v denoting an undirected edge between u and v.
The next line consists 2 space separated integers containing vertices for which we have to find the path.

Output Format
Return true if the graph consists a path,else return false.

Example 1
Input
4 2
1 2
3 4
1 4

Output
0

Explanation
1---2 and 3---4, as they are not a part of a single graph the ans is 0, as from 1 we can not reach 4.

Example 2
Input
4 4
1 2
2 3
3 4
4 1
1 3

Output
1

Explanation
The graph is 
     1------2
     |      |
     |      |
     4------3
The graph consists a path from 1 to 3. So the ans is true.

Constraints
1 <= N <= 500
1 <= V <= N*(N+1)/2
1 <= value of each node <= N
*/

public class pathBetween2Vertices {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean DFS(ArrayList<ArrayList<Integer>> graph, boolean[]visited, boolean[]path, int source, int dest){
		if(source == dest){
			return true; //got the destination
		}
		path[source] = true;
		visited[source] = true;

		boolean gotPath = false;
		for(int nodes : graph.get(source)){
			if(!visited[nodes]){
				gotPath = DFS(graph,visited,path,nodes,dest);
				if(gotPath) return true; 
			}
		}

		//backtracking
		path[source] = false;

		return false;
	}
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean[]visited = new boolean[N];
		boolean[]path = new boolean[N];

		// create the graph
		for(int i=0; i<N; i++) graph.add(new ArrayList<Integer>());

		for(ArrayList<Integer> edge : Edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u-1).add(v-1);
			graph.get(v-1).add(u-1);
		}

		// Sort all the internal arrayLists
		for(int i=0;i<N;i++) Collections.sort(graph.get(i));

		boolean got = DFS(graph,visited,path,U-1,V-1);

		return got;
    }
}
