import java.io.*; 
import java.util.*; 
import java.lang.*;

/*
Given N activities with their start and finish day given in array start[ ] and end[ ]. 
Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.

Note
Duration of the activity includes both starting and ending day.

Input Format
The fist line of input contains a single integer N.
The second line of input contains N space separated integers, start[ ].
The third line of input contains N space separated integers, end[ ].

Output Format
Return the maximum number of activities that can be performed by a single person assuming that a person can only work on a single activity at a given day.

Example 1
Input
2
2 1
2 2

Output
1

Explanation
A person can perform only one of the given activities.

Example 2
Input
4
1 3 2 5
2 4 3 6

Output
3

Explanation
A person can perform activities 1, 2 and 4.

Constraints
1 <= n <= 5*103
1 <= start[i],end[i] <= 105
*/

class maximumActivity
{
    public static void main (String[] args) throws IOException  
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputLine[] = br.readLine().trim().split(" ");
        //size of array
        int n = Integer.parseInt(inputLine[0]);
        int start[] = new int[n];
        int end[] = new int[n];
        
        //adding elements to arrays start and end
        inputLine = br.readLine().trim().split(" ");
        for(int i = 0; i < n; i++)
            start[i] = Integer.parseInt(inputLine[i]);
        
        inputLine = br.readLine().trim().split(" ");
        for(int i= 0; i < n; i++)
            end[i] = Integer.parseInt(inputLine[i]);
        
        System.out.println(new Solution().solve(start, end, n));
    
    }
}

class Solution
{
    
    public static int solve(int start[], int end[], int n)
    {
		int[][] timeSlots = new int[n][n];

		for(int ind=0; ind<n; ind++){
			timeSlots[ind][0] = start[ind];
			timeSlots[ind][1] = end[ind];
		}
        // sort the array on basis on start time
		Arrays.sort(timeSlots, (a,b) -> {
			return a[0] > b[0] ? 1 : -1;
		});

		int count = 0;
		int newStart = 0;

		for(int ind=0; ind<n; ind++){
			if(timeSlots[ind][0] > newStart){
				// new intervals found
				count++;
				newStart = timeSlots[ind][1];
			}else if(timeSlots[ind][1] < newStart){
				// better interval found
				newStart = timeSlots[ind][1];
			}
		}
		
		return count;
    }
}
