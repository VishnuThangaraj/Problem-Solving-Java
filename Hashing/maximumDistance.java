import java.util.*;

/*
You have been given an array arr that might contain duplicate elements. 
Your task is to find the maximum possible distance between occurrences of two repeating elements i.e. elements having the same value. 
If there are no duplicate elements in the array, print 0.

Input Format
The first line of input contains an integer N denoting the length of the array.
The second line of input contains N integers denoting the elements of the array arr.

Output Format
The output prints a single line containing an integer denoting the maximum distance.

Example 1
Input
9
1 3 1 4 5 6 4 8 3

Output
7

Explanation
In the above array, the repeating elements are:- (1, 3, 4)
Distance between first and last occurrence of 1 = 2(index2 - index0)
Distance between first and last occurrence of 3 = 7(index8 - index1)
Distance between first and last occurrence of 4 = 3(index6 - index3)
So, for the above array, you must return 7, as this is the maximum possible distance between two repeating elements having the same value.

Example 2
Input
4
1 3 2 4

Output
0

Explanation
There are no repeated elements

Constraints :
0 <= N <= 10^6
-10^9 <= ARR[i] <= 10^9
*/

class Solution{
    static int MaximumDistance(int N,int[] arr){
        //create hashMap for values and its index
		HashMap<Integer, Integer> storage = new HashMap<>();

		int max = 0; //maximum distance between 2 repeating integer
		
		//iterate through the array
		for(int index=0; index<arr.length; index++){
			int value = arr[index];
			//check the value is already there in hashSet
			if(storage.containsKey(value)){
				//measure distance
				int distance = index - storage.get(value);
				//update max if distance is greater than max
				max = (distance > max) ? distance : max;
			}
			else{ //not present in HashMap..so add it
				storage.put(value,index);
			}
		}

		return max;
    }
}

public class maximumDistance {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int ans=obj.MaximumDistance(n,nums);
        System.out.println(ans);
    }
}
