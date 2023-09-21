import java.util.*;

/*
You are given a number N, the number of courses you have to take labeled from 0 t N-1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] 
indicates that you must take course bi first if you want to take course ai.
eg: [2,4] means take course 4 before you can take course 2.

Return the order in which you need to take courses (if multiple orders are possible, print the node with smaller value first).
(You only need to return empty array from the function if no such ordering is possible).

Input Format
The First line of input contain two integers N denoting number of people and M denoting size of prerequisites array.
Next line contains two integer each denoting ai and bi.

Output Format
Print the order in which you need to take courses (if multiple orders are possible, print the node with smaller value first), else return an empty array.

Example 1
Input
4 3
1 2
1 3
1 0

Output
0 2 3 1

Explanation
We need to take course 2,3 and 0 before taking course 1. Since no conflict is there, we can take it.

Example 2
Input
4 3
1 2
2 3
3 1

Output
-1

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
    
    public int[] canFinish(int n, int[][] prerequisites) {
	    //create graph with given prerequisities
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++) graph.add(new ArrayList<Integer>());

		//to keep track of the indegree's
		int[]indegree = new int[n];

		ArrayList<Integer> courseDone = new ArrayList<>();
		
		// STEP - 1 : CALCULATE INDEGREE (INCOMING EDGES)
		for(int[]edge : prerequisites){
			int a = edge[0];
			int b = edge[1];
			graph.get(b).add(a); // b is dependent on a
			indegree[a]++;
		}

		// STEP - 2 : ADD ALL THE NODES TO QUEUE WHO ARE HAVING INDEGREE = 0
		Queue<Integer> queue = new LinkedList<>();
		for(int index=0; index<indegree.length; index++){
			if(indegree[index] == 0) queue.offer(index);
		}

		// STEP - 3 : ADD ALL THE NEIGHBOURS IF THEIR INDEGREE BECOMES 0
		while(!queue.isEmpty()){
			int current = queue.poll();
			courseDone.add(current);

			for(int node : graph.get(current)){
				indegree[node]--;
				if(indegree[node] == 0) queue.offer(node);
			}
		}

		if(courseDone.size() < n){
			//not possible to arrange the course , hence return empty array
			return new int[0];
		}

		//transfer the items in arrayList to array
		int index =0 ;
		int[] result = new int[n];
		for(int course : courseDone){
			result[index++] = course;
		}

		return result;
    }
}
public class courseScheduleKahnsAlgorithm {
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
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}
