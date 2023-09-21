import java.io.*;
import java.util.*;

/*
A Hamilton path is a path in an undirected graph that visits each vertex exactly once. 
Given an undirected graph, the task is to check if a Hamilton path is in it or not.

Input Format
The first line consists of two space separated integers N and M denoting the number of vertices and number of edges.
Then in the next M line are 2 space separated integers u,v denoting an undirected edge between u and v.

Output Format
Return true if the graph consists Hamilton cycles, else return false.

Example 1
Input
4 3
1 2
2 3
2 4

Output
0

Explanation
It can be proved that there is no hamilton path in the graph.

Example 2
Input
4 4
1 2
2 3
3 4
2 4

Output
1

Explanation
The graph is 
  1-----2-----3-----4
        |           |
        |           |
        |------------

The Hamilton path is 1-2-3-4

Constraints
1 <= N <= 10
1 <= M <= 15
1 <= value of each node <= N
*/

public class hamiltonPath {
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
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean DFS(ArrayList<ArrayList<Integer>> graph, boolean[]path, ArrayList<Integer> pathSoFar, int source){
		int size = graph.size() -1;

		if(path[source]) return false;
		//mark as visited and add path
		path[source] = true;
		pathSoFar.add(source);

		//check all paths are visited or not
		if(pathSoFar.size() == size){
			return true;
		}

		//check all the neighbours
		for(int nbrs : graph.get(source)){
			boolean gotPath = DFS(graph, path, pathSoFar, nbrs);
			if(gotPath) return true;
		}

		//backtrack
		path[source] = false;
		pathSoFar.remove(pathSoFar.size()-1);

		return false; //path not found
	}
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // create graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());

		for(ArrayList<Integer> edge : Edges){
			int i = edge.get(0);
			int j = edge.get(1);
			graph.get(i).add(j);
			graph.get(j).add(i);
		}

		boolean[]path = new boolean[N+1];
		ArrayList<Integer> pathSoFar = new ArrayList<>();

		for(int node=1; node<=N; node++){
			boolean gotPath = DFS(graph, path, pathSoFar, node);
			if(gotPath) return true;
		}
		

		return false;
    
    }
}
