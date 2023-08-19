import java.io.*;
import java.util.*;

/*
  EXAMPLE INPUT
  12 (SIZE)
  0 1 0 2 1 0 1 3 2 1 2 1 (ELEMENTS)

  EXAMPLE OUTPUT
  6 (AMOUNT OF WATER CAN BE STORED)
*/

class Solution {
	//solve this question using two-pointer methods
    public void TappingWater(int[] arr, int n) {
        //variables
		int leftPointer = 0, rightPointer = arr.length-1;
		//max elements
		int leftMax = 0, rightMax = 0;
		//amount of water can be stored
		int water = 0;

		while(leftPointer<=rightPointer){ //O(n) Time complexity

			//leftHeight is smaller
			if(arr[leftPointer] <= arr[rightPointer]){

				if(arr[leftPointer] >= leftMax){
					leftMax = arr[leftPointer];
				}else{
					water += leftMax - arr[leftPointer];
				}
				//increase / move left pointer
				leftPointer++;
			}
			else{
				if(arr[rightPointer] >= rightMax){
					rightMax = arr[rightPointer];
				}else{
					water += rightMax - arr[rightPointer];
				}
				//decrease / move right pointer
				rightPointer--;
			}
		}
        System.out.println(water);
    }
}

public class trappingRainwaterProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}
