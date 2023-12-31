import java.io.*;
import java.util.*;

/*
  SAMPLE INPUT
  5 (SIZE)
  3 1 5 12 10 (ELEMENTS)

  SAMPLE OUTPUT
  -1 -1 1 5 5
*/

class Solution {
    public int[] prevSmall(int[] row) {
        //find the left smaller element using stack
		//create stack to store the index of elments
		Stack<Integer> storage = new Stack<>();
		//result array
		int[] nearestSupporter = new int[row.length];

		//traverse from first to last of the array
		for(int index=0; index<row.length; index++){
			while(!storage.isEmpty() && row[index] <= row[storage.peek()]){
				storage.pop();
			}

			if(storage.isEmpty()){ //no supporting elements(smaller elements on left)
				nearestSupporter[index] = -1;
			}else{
				nearestSupporter[index] = row[storage.peek()]; //smaller element index in stack
			}
			storage.push(index); //add current index to stack
		}
		return nearestSupporter;
    }
	
	
}

class findTheNearestSupporter {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        int[] res = obj.prevSmall(arr);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
        System.out.println();
        sc.close();
    }
}
