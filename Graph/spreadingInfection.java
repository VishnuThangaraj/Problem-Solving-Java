import java.io.*;
import java.util.*;

/*
You are given a graph, representing people and their connectivity.
You are also given an src person (who got infected) and time t.
You are required to find how many people will get infected in time t, 
if the infection spreads to neighbours of an infected person in 1 unit of time.

Input Format
Input has been managed for you

Output Format
Print the count of people infected by time t

Example 1
Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
6
3

Output
4

Explanation
4 vertices can be infected within 3 seconds

Example 2
Input
4
3
0 1
1 2
2 3
3
2

Output
2

Explanation
2 vertices can be infected within 2 seconds

Constraints
None
*/

public class spreadingInfection {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

	static class Pair{
		int source;
		int time;

		//constructor
		Pair(int source,int time){
			this.source = source;
			this.time = time;
		}
	}

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      int infectedCount = 0;
	   boolean[]affected = new boolean[vtces];

	   // use BFS
	   Queue<Pair> queue = new LinkedList<>();
	   queue.offer(new Pair(src,1));

	   while(!queue.isEmpty()){
		   Pair current = queue.poll();
		   if(affected[current.source]) continue;
		   //mark as affected
		   affected[current.source] = true;
		   
		   //increase affected count for each un-affected neighbours
		   if(current.time <= t) infectedCount++;

		   for(Edge nbrs : graph[current.source]){
			   if(affected[nbrs.nbr] == false){
				   queue.add(new Pair(nbrs.nbr, current.time+1));
			   }
		   }
	   }
	   System.out.println(infectedCount);
   }

}
