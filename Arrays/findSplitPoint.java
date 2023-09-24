import java.io.*;
import java.util.*;

/*
Write a program to Partition an array into two subarrays with the same sum. 
Take input of size of array and the array elements then find if it is possible to split the 
array in two subarrays (without reordering the elements), such that the sum of the two subarrays is the same.

Input Format
Input consists of two lines.
First line contains an integer N denoting size of array
Second line contains N integers denoting the array elements separated by single space

Output Format
Print the two partitioned subarray in two lines. Print "Not Possible" if it is not possible to partition the array into subarrays of equal sum.
Note:- Print left subarray in first line and right subarray in second line.

Example 1
Input
5
6 -4 3 2 -3

Output
6 -4 
3 2 -3

Explanation 
Sum of 6+(-4) is equal to Sum of 3+2+(-3)

Example 2
Input
4
4 3 2 1

Output
Not Possible

Explanation 
No partition of the array will make the left and right sum equal

Constraints
1<= arr.size() <= 10000
*/

public class findSplitPoint {
    static void findSplitPoint(int arr[], int n) {
        int leftSum = 0;
		for(int num : arr) leftSum+=num;
		int rightSum = 0;

		int ind = 0;
		for(ind=arr.length-1; ind>=0; ind--){
			rightSum+=arr[ind];
			leftSum-=arr[ind];
			if(leftSum == rightSum){
				break;
			}
		}

		if(leftSum == rightSum){
			for(int i=0;i<arr.length; i++){
				if(i == ind){
					System.out.println();
				}
				System.out.print(arr[i]+" ");
			}
		}else{
			System.out.println("Not Possible");
		}
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findSplitPoint(arr, n);

    }
}
