import java.util.*;
import java.io.*;

/*
Determine the shortest path between the specified vertices in the directed graph given in the input data.

Input Format
First line consist of the numbers V, K (number of vertices, number of edges).
Then K lines follow, each containing the following numbers separated by a single space:
ai, bi, ci
It means that the graph being described contains an edge from ai to bi, with a weight of ci.
Below the graph description a line containing a pair of integers A, B is present.
The goal is to find the shortest path from vertex A to vertex B.

Output Format
Your program should output (in a separate line) a single number C - the length of the shortest path from vertex A to vertex B. 
In case there is no such path, your program should output a single word "NO" (without quotes)

Example 1
Input
3 2
1 2 5
2 3 7
1 3

Output
12

Example 2
Input
3 3
1 2 4
1 3 7
2 3 1
1 3

Output
5

Example 3
Input
3 1
1 2 4
1 3

Output
NO

Constraints:
All numbers in the input data are integers in the range 0 to 10000.
*/

class Node{
    int v, wt;
    Node(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}

class Pair{
	int source;
	int wsf; //weight so far
	//constructor
	Pair(int source, int wsf){
		this.source = source;
		this.wsf = wsf;
	}
}
class nodeComparator implements Comparator<Node>{
    public int compare(Node node1, Node node2){
        return node1.wt - node2.wt;
    }
}
class graph{
    static ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
    graph(int n){
        for(int i=0; i<n; i++){
            g.add(new ArrayList<Node>());
        }
    }
    static void addNode(int u, int v, int wt){
        g.get(u).add(new Node(v, wt));
    }

    static void findPath(int start, int end){
        PriorityQueue<Pair> storage = new PriorityQueue<>((a,b) -> {
			return a.wsf > b.wsf ? 1 : -1;
		});

		int result = Integer.MAX_VALUE;

		boolean[] visited = new boolean[g.size()];
		//add the start
		storage.offer(new Pair(start, 0));

		while(!storage.isEmpty()){
			Pair current = storage.poll();

			if(visited[current.source]) continue;

			//mark as visited
			visited[current.source] = true;

			if(current.source == end){
				// potential destination
				result = Math.min(result, current.wsf);
				//System.out.println(current.wsf);
			}

			for(Node node : g.get(current.source)){
				//System.out.println(node.wt);
				storage.offer(new Pair(node.v, current.wsf+node.wt));
			}
		}

		if(result == Integer.MAX_VALUE)
			System.out.println("NO");
		else
			System.out.println(result);
    }
}

public class easyDijkstraProblem {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        graph g = new graph(n);
        for(int i=0; i < m; i++){
            int u = input.nextInt(), v = input.nextInt();
            int wt = input.nextInt();
            g.addNode(u-1, v-1, wt);
        }
        int start = input.nextInt(), end = input.nextInt();
        graph.findPath(start-1, end-1);
    }
}
