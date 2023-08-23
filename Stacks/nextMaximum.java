import java.util.*;

/*
Given an array A with n positive integers.
Your task is to calculate the distance between every integer and the next closest integer with value greater than it. 
If next greater integer doesn't exist print -1 for that particular integer.

Input Format
The first line contains the number of test cases.
For each test case: The first line contains an integer n denoting the number of elements.
The second line contains n space separated integers denoting the elements of the array A.

Output Format
For each test case print an array in a new line, denoting the distance between the current element and its next maximum element .

Example 1
Input
1
5
1 5 3 4 2

Output
1 -1 1 -1 -1

Explanation
For the first element the next maximum element is at position 2, therefore distance is 1. For second element there is no element after it which has greater value, therefore -1. Similarly, we can see for all element.

Example 2
Input
1
8
73 74 75 71 69 72 76 73

Output
1 1 4 2 1 1 -1 -1

Explanation
For first element the next greater integer is just next therefore value 1. Similarly, we can check for all other elements.

Constraints
1 <= T <= 10
3 <= n <= 10000
0 <= A[i] <= 100000
*/

class Main{
	//finding next Greater element on right
	public static int[] nextMaximum(int[] A,int n){
		//create stack to store the index
		Stack<Integer> storage = new Stack<>();

		int[]result = new int[A.length];
		
		for(int index=A.length-1; index>=0; index--){
			int value = A[index];

			//remove smaller elements in stack
			while(!storage.isEmpty() && value >= A[storage.peek()]){
				storage.pop();
			}

			//stack becomes empty
			if(storage.isEmpty()){
				result[index] = -1; //no greater element is found
			}else{
				//find distance
				result[index] = storage.peek() - index;
			}
			storage.push(index); //add to stack
		}
		
		return result;

	}

	public static void nextMaximum(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int []A=new int[n];
				for(int i=0;i<n;i++){
					A[i]=sc.nextInt();
				}
				int[] ans = nextMaximum(A,n);
				for(int i = 0; i < n; i++)
				{
					System.out.print(ans[i] + " ");
				}
				System.out.println();
				t--;
			}
		}
	}

}
