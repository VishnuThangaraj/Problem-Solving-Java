import java.util.*;

/*
There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other. 
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
Now your target is to make the whole group sit together i.e. next to each other, 
without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

In one jump a person can move to the adjacent seat (if available).
NOTE: 1. Return your answer modulo 10^7 + 3.

Input Format
The first and only argument is a string A of size N.

Output Format
Return an integer denoting the minimum number of jumps required.

Example 1
Input
....x..xx...x..

Output
5

Explanation
Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) . . . . x . . x x . . . x . . 
Now to make them sit together one of approaches is - . . . . . . x x x x . . . . . Steps To achieve this:
Move the person sitting at 4th index to 6th index: Number of jumps by him = (6 - 4) = 2
Bring the person sitting at 12th index to 9th index: Number of jumps by him = (12 - 9) = 3 
So, total number of jumps made: 2 + 3 = 5 which is the minimum possible.
If we other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

Example 2
Input
....xxx

Output
0

Explanation
They are already together. So, the cost is zero.

Constraints
1 <= N <= 1000000
A[i] = 'x' or '.'
*/

class Solution {

    public int seat(String s) {
        //store the position of seat in arrayList
		int count =0 ;
		ArrayList<Integer> seat = new ArrayList<>();
		int length = s.length();

		for(int ind=0; ind<length; ind++){
			if(s.charAt(ind) == 'x'){ // occupied
				seat.add(ind - count);
				count++;
			}
		}

		if(count == 0 || count == length){
			return 0; // no jumps required
		}

		int mid = (count -1)/2;
		int result = 0; 

		int mid_position = seat.get(mid);

		//move all other seats near mid
		for(int ind=0; ind<seat.size(); ind++){
			result += Math.abs(mid_position - seat.get(ind));
		}
		
		return result;
    }
}


public class seatArrangement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine(); 
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.seat(str));
    }
}
