import java.util.*;

/*
CodeMart is a shopping platform and it is distributing gift vouchers to its esteemed users. 
The voucher can be redeemed by providing a fixed amount of shopping credits to the platform.
One credit is sent by a user to the platform by doing one occurance in CodeMart. 
Since there is a huge rush of people you are required to manage the users on the basis of first come first serve.

The user which came first and has exactly k occurrences at last is given the voucher first. 
You are given an array arr with the id's of N users in chronological order of their occurrences .
You are required to print the id of the user which will be given the voucher first. If no such user meets the condition print -1.
Note : You just need to complete Solve() function.

Input Format
First line contains two space-separated integers n and k
Second line consists of n spaced integers

Output Format
print the id of the user which will be given the voucher first. If no such user meets the condition print -1.

EXAMPLE 1
Input
7 2
1 7 4 3 4 8 7

Output
7

EXPLANATION
Both 7 and 4 occur 2 times. But 7 is the first that occurs 2 times. 

EXAMPLE 2
Input
6 1
4 1 6 1 6 4

Output
-1

EXPLANATION
No one occurs exactly 1 time.

CONSTRAINTS
1 ≤ n ≤ 1000
1 ≤ arr[i] ≤ 1000
*/

public class firstComeFirstServe{   
   
    public static void Solve(int[] nums , int k){
		// to store the elements and its occurance
		HashMap<Integer, Integer> storage = new HashMap<>();
		int result = -1;

		for(int num : nums){
			storage.put(num, storage.getOrDefault(num, 0)+1);
		}

        for(int num : nums){
            if(storage.get(num) == k) {
                result = num;break;
            }
        }

        
		System.out.println(result);
    }

	public static void main (String[] args) {
		//your code here 
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int k = sc.nextInt();  

		int[] nums = new int[n]; 
		for(int i=0; i<n ;i++){
			nums[i] = sc.nextInt(); 
		} 
           
        Solve(nums , k); 
		return; 
	}
}
