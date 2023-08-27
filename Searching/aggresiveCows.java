import java.io.*;
import java.util.*;
import java.util.*;

/*
Given an array of length N, where each element denotes the position of a stall. 
You are also given an integer K which denotes the number of cows that are aggressive. 
To prevent the cows from hurting each other, you need to assign the cows to the stalls, 
such that the minimum distance between any two of them is as large as possible. Return the largest minimum distance.

Input Format
The first line contains 'N' and 'K' denoting the number of elements in the array/list and the number of aggresive cows.
The second line contains 'N' single space-separated integers denoting the elements of the array.
"NOTE: " You do not need to print anything; it has already been taken care of.
Just Complete the funtion.

Output Format
Print the majority element.

Example 1
Input
3 2
1 2 3

Output:
2

Explanation:
The largest minimum distance will be 2 when 2 cows are placed at positions {1,3}.

Example 2
Input
6 4
0 3 4 7 10 9

Output:
3

Explanation:
The largest distance will be 3 when 4 cows are placed at positions {0,3,7,10}.

Constraints
2<=N<=20000
2<=C<=N
0<=arr[i]<=10^9
*/

class Solution{
	//check if possible to place cows
	public static boolean placeCows(int[]a, int cows, int distance){
		int placedCows = 1; int location = a[0];

		for(int index=1; index<a.length; index++){
			if(a[index] - location >= distance){
				//update placedCows and location
				placedCows++;
				location = a[index];
			}
			if(placedCows >= cows){
				//System.out.println("S");
				return true;
			}
		}

		return false; //cows cant be placed in the given distance
	}

    public static int aggressiveCows(int a[],int cows){
		//sort the Array before proceeding
		Arrays.sort(a);
		
       //binary search
		int start = 1;
		int end = a[a.length-1] - a[0];
		int answer = 0;
		
		while(start <= end){
			int mid = (start+end)/2; //get the mid
			if(placeCows(a,cows,mid)){ //can place cows
				answer = mid;
				//search right region
				start = mid+1;
			}else{
				//search left region
				end = mid-1;
			}
		}

		return answer;
    }


}

class aggresiveCows {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution obj=new Solution();
		System.out.println(obj.aggressiveCows(nums,k));

    }
}
