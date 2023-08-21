import java.util.*;

//https://leetcode.com/problems/gas-station/

/*
Suppose there is a circle. There are N petrol pumps in that circle. You will be given two sets of data.
The amount of petrol that every petrol pump has.
Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note Assume for 1 litre of petrol, the truck can go 1 unit of distance.

Input Format
The first line contains a single integer N denoting the number of petrol pumps.
The next line contains N integers denoting petrol in each petrol pump.
Next line contains N integers denoting distance from petrol pump to next petrol pump.

Output Format
Print the starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Print -1 if no solution exist

Example 1
Input

4
4 6 7 4
6 5 3 5
Output

1
*/

public class gasStation
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); //size of input
		int[]petrol = new int[size];
		int[]distance = new int[size];

		//receivce petrol input
		for(int i=0; i<size; i++){
			petrol[i] = sc.nextInt();
		}
		//receive distance input
		for(int i=0; i<size; i++){
			distance[i] = sc.nextInt();
		}
		sc.close();
		
			System.out.println(new Solution().tour(petrol,distance));
	}
}
class Solution
{
	int tour(int petrol[], int distance[]){ //O(n) time and O(1) constant space
		int position = 0; //position of index to be returned
		int total = 0; //total usage of petrol
		int sum = 0;
		
		//traverse throught the array
		for(int index=0; index< petrol.length; index++){
			sum += petrol[index] - distance[index];

			if(sum < 0){ //not possible to move next location if < 0
				//increase position to next index
				position = index +1;
				total+=sum;
				sum = 0; //reset the sum
			}
		}
		total+=sum;

		//if total is less than zero ... circular tour cant be done
		return total>=0 ? position : -1;
	}
}
