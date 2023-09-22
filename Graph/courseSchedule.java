import java.util.*;

/*
You are given a number N, the number of courses you have to take labeled from 0 t N-1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] 
indicates that you must take course bi first if you want to take course ai.
eg: [2,4] means take course 4 before you can take course 2.

Input Format
The First line of input contain two integers N denoting number of people and M denoting size of prerequisites array.
Next line contains two integer each denoting ai and bi.

Output Format
print 1 if it is possible to finish all the courses else print 0.

Example 1
Input
4 3
1 2
1 3
1 0

Output
1

Explanation
We need to take course 2,3 and 0 before taking course 1. Since no conflict is there, we can take it.

Example 2
Input
4 3
1 2
2 3
3 1

Output
0

Explanation
The prerequisites for each course can be mapped as
1 -> 2
2 -> 3
3 -> 1
Any two of these courses can be done without any issue, but when the third course comes in, 
the prerequisite of the prerequisite becomes one the course you need to take and it's impossible to take all of it.

Constraints
1 <= N <=2000
0 <= M <= 5000
1 <= prerequisite[i][j] < N
*/

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int canFinish(int n, int[][] prerequisites) {
        // create the Graph and calculate indegree
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<n;i++) graph.add(new ArrayList<Integer>());

		int[]indegree = new int[n];

		for(int[]node : prerequisites){
			int courseA = node[0];
			int courseB = node[1];
			graph.get(courseB).add(courseA);
			indegree[courseA]++;
		}

		// ADD ALL THE COURSE TO QUEUE WHICH HAS INDEGREE AS 0
		Queue<Integer> queue = new LinkedList<>();
		for(int ind=0; ind<n; ind++)
			if(indegree[ind] == 0) queue.offer(ind);

		while(!queue.isEmpty()){
			int current = queue.poll();

			// add nbrs to queue if they have indegree 0 after reducing
			for(int nbrs : graph.get(current)){
				indegree[nbrs]--;
				if(indegree[nbrs] == 0) queue.add(nbrs);
			}
		}

		// traverse the INDEGREE array to find any nodes are left
		for(int nodes : indegree)
			if(nodes != 0) return 0;  // not possible to arrange courses

		return 1; //possible to arrange courses
		
    }
}
public class courseSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}
