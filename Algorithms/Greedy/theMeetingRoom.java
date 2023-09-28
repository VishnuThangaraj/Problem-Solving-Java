import java.io.*;
import java.util.*;
import java.lang.*;

/*
A multinational company has a room where meetings are held. There are N meetings in the form of (start[i], end[i]) 
where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room 
when only one meeting can be held in the meeting room at a particular time?

Note
Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Input Format
The first line conatins an integer N.
The next two lines contains N space-seperated integers representing the value of the array start and end.

Output Format
Return the maximum number of meetings that can be held in the meeting room.

Example 1
Input
6
1 3 0 5 8 5
2 4 6 7 9 9

Output
4

Explanation
Maximum four meetings can be held with given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)

Example 2
Input
3
10 12 20
20 25 30

Output
1

Explanation
Only one meetings can be held with given start and end timings.

Constraints
1 ≤ N ≤ 10^5
0 ≤ start[i] < end[i] ≤ 10^5
*/

public class theMeetingRoom {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(inputLine[0]);

		int start[] = new int[n];
		int end[] = new int[n];

		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++)
			start[i] = Integer.parseInt(inputLine[i]);

		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) 
			end[i] = Integer.parseInt(inputLine[i]);
			
		int ans = new Solution().maxMeetings(start, end, n);
		System.out.println(ans);
    }
}

class Solution 
{
    public int maxMeetings(int start[], int end[], int n) {
        // store the start and end pointers in 2D array
		int[][] slots = new int[n][2];

		for(int ind=0; ind<n; ind++){
			slots[ind][0] = start[ind];
			slots[ind][1] = end[ind];
		}
		
		//sort on basis on start time
		Arrays.sort(slots, (a,b) -> a[0] - b[0]);

		int count = 0;
		int newStart = -1;

		for(int ind=0; ind<n; ind++){
			if(slots[ind][0] > newStart){
				//increase count and update NewStart
				count++;
				newStart = slots[ind][1];
			}else if(slots[ind][1] < newStart){
				//small interval found..update new Start
				newStart = slots[ind][1];
			}
		}

		return count;
    }
}
