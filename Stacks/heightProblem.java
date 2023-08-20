import java.util.*;

/*
n people are standing in a line numbered 1 to n from left to right. 
Each person wants to know the height of the person to left of him having height less than him. 
If there are multiple such people he wants to know the height of the person closest to him. 
If there is no such person report -1.

INPUT FORMAT :
line 1: contains an integer n denoting the size of array.

line 2: contains n separated integers denoting elements of array.

OUTPUT FORMAT :
The output should contain n space separated integers, the ith integer should be the height of the 
closest person on the left with a height less than that person (-1 if no person to the left is found whose height is less).

SAMPLE INPUT :
5 (SIZE)
1 2 3 4 5 (HEIGHTS)

SAMPLE OUTPUT :
-1 1 2 3 4
*/


class Accio{
    static int[] HeightProblem(int n,int[] arr){
        //stacks to store the height
		Stack<Integer> storage = new Stack<>();

		//array for storing the result
		int[]result = new int[arr.length];

		//traverse throught the given array
		for(int index=0; index<arr.length; index++){
			//remove elements greater then current index
			while(!storage.isEmpty() && arr[index] <= arr[storage.peek()]){
				storage.pop();
			}

			//if stack is empty mark as -1
			if(storage.isEmpty()){
				result[index] = -1;
			}else{ //assign top item in stack to result
				result[index] = arr[storage.peek()];
			}
			//addd current index to stack
			storage.push(index);
		}

		//return the result
		return result;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int[] ans=obj.HeightProblem(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
