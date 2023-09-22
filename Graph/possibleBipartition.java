import java.util.*;

/*
We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
Each person may dislike some other people, and they should not go into the same group.
Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates 
that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Input Format
The First line of input contain two integers N denoting number of people and M denoting size of dislike array.
Next line contains two integer each denoting ai and bi.

Output Format
print 1 if it is possible to split everyone into two groups else print 0.

Example 1
Input
4 3
1 2
1 3
1 4

Output
1

Explanation
We can divide the array into two parts. The two groups are {1} and {2,3,4}.

Example 2
Input
3 3
1 2
1 3
2 3

Output
0

Explanation
Since 1 hates 2 and 3, it can't be grouped with them, and since 2 hates 3, 2 and 3 can't be together either. 
Hence we need at least three groups to keep all the people who don't like each other separately, but we need to divide only in 2.

Constraints
1 <= N <=2000
0 <= M <= 10^4
1 <= dislikes[i][j] <=2
ai < bi
0 <= |arr[i]| <= 2
*/

class Solution {
	public class Pair{
		int source;
		int color;
		//constructor
		Pair(int source, int color){
			this.source = source;
			this.color = color;
		}
	}
   
    public int possibleBipartition(int n, int[][] dislikes) {
        // create graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=n; i++) graph.add(new ArrayList<Integer>());

		for(int[]nodes : dislikes){
			int a = nodes[0];
			int b = nodes[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int[]partition = new int[n+1]; //n+1 because 1 based indexing
		

		// GRAPH MAY HAVE COMPONENTS ... TRY FOR ALL NODES
		for(int src=1;src<=n;src++){
			if(partition[src] != 0) continue;
			Queue<Pair> queue = new LinkedList<>();
			queue.offer(new Pair(src,1)); //stores source and its color

			while(!queue.isEmpty()){
				Pair current = queue.poll();
	
				//if already coloured continue
				if(partition[current.source] != 0) continue;
				partition[current.source] = current.color;
	
				int oppColor = current.color == 1 ? -1 : 1;
	
				//add the neighbours
				for(int nbrs : graph.get(current.source)){
					if(partition[nbrs] == 0) queue.add(new Pair(nbrs,oppColor));
					else if (partition[nbrs] != oppColor) return 0;
				}
			}
		}
		

		return 1; //possible to 
    }
}
public class possibleBipartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
