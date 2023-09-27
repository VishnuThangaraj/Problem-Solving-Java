import java.io.*;
import java.lang.*;
import java.util.*;

/*
Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. 
We earn the profit associated with job if and only if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.

Note
Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.

Input Format
The fist line of input contains a single integer N.
The next line contains N space separated Jobs in the form Job id, Deadline,Profit

Output Format
Returns the count of jobs and maximum profit as a list or vector of 2 elements.

Example 1
Input
4
1 4 20 2 1 10 3 1 40 4 1 30

Output
2 60

Explanation
Job1 and Job3 can be done with maximum profit of 60 (20+40).

Example 2
Input
5
1 2 100 2 1 19 3 2 27 4 1 25 5 1 15

Output
2 127

Explanation
2 jobs can be done with maximum profit of 127 (100+27).

Constraints
1 <= N <= 5*103
1 <= deadline <= n
1 <= profit <= 500
*/

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public class jobSequencingProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n){
		// sort the job based on the Profit
		Arrays.sort(arr, (a,b) -> {
			return b.profit - a.profit;
		});

		boolean[] isOccupied = new boolean[n+1];

		int count = 0;
		int totalProfit = 0;

		for(Job current : arr){
			int profit = current.profit;
			int deadLine = current.deadline;

			//check when to do the job
			for(int day=deadLine; day>0; day--){
				if(!isOccupied[day]){
					isOccupied[day] = true; // occupy the day
					totalProfit += profit;
					count++; //increase profit and job count
					break;
				}
			}
		}
		//return the count and totalProfit in an array
		int[] result = {count, totalProfit};

		return result;
    }
}
