import java.math.*;
import java.util.*;
import java.io.*;

/*
You are given n ropes of l[i] lengths, you need to connect these ropes into one rope. 
The cost to connect two ropes is equal to sum of their lengths. 
Your task is to connect the ropes with minimum cost.
You have to complete minCost function which consist of arr array and its size integer n as inputs and return integer answer as output.

Input Format
Line 1: contains an integer n denoting number of ropes.
Line 2: contains n separated integers denoting length of n ropes.

Output Format
Print a single integer denoting minimum cost to connect all the ropes.

Example 1
Input
4
4 3 2 6

Output
29

Explanation
For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
Finally connect the two ropes and all ropes have connected.
Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. 
Other ways of connecting ropes would always have same or more cost. For example, 
if we connect 4 and 6 first (we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2). 
Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38

Example 2
Input
5
4 2 7 6 9

Output
62

Explanation
First, connect ropes 4 and 2, which makes the array {6,7,6,9}. Cost of this operation 4+2 = 6.
Next, add ropes 6 and 6, which results in {12,7,9}. Cost of this operation 6+6 = 12.
Then, add 7 and 9, which makes the array {12,16}. Cost of this operation 7+9 = 16. And
Finally, add these two which gives {28}.Hence, the total cost is 6 + 12 + 16 + 28 = 62.

Required Time Complexity :
O(n*log(n))

Constraints
1 <= n <= 10^5
1 <= l[i] <= 10^5
*/

class Solution
{
    long minCost(long arr[], int n) 
    {
		long result = 0;
        // add all the elements to priority queue
		PriorityQueue<Long> storage = new PriorityQueue<>();

		for(int ind=0; ind<n; ind++)
			storage.offer(arr[ind]); //min first

		// calcualte the cost of ropes
		while(storage.size() > 1){
			long first = storage.poll();
			long second = storage.poll();

			result += first + second;
			storage.offer(first + second);
		}
		
		return result;
    }
}

class minimumCostsOfRopes
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
        
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
			int n = sc.nextInt();
			long arr[] = new long[n];
			
			for(int i=0; i<n; i++)
				arr[i] = sc.nextLong();
		    out.println(new Solution().minCost(arr, n));
		out.flush();
	}
}
