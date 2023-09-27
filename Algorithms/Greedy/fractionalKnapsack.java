import java.io.*;
import java.lang.*;
import java.util.*;

/*
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

Note
Unlike 0/1 knapsack, you are allowed to break the item.

Input Format
The first line of input contains two integer N and W denoting the number of items and capacity of knapsack respectively.
The next line will contain N space separated integers denoting the values of items.
The line next to it will contain N space separated integers denoting the weight of items.

Output Format
The only line of output will contain a double value representing the maximum total value in knapsack.

Example 1
Input
3 50
60 100 120
10 20 30

Output
240.00

Explanation
Total maximum value of item we can have is 240.00 from the given capacity of sack.. (Complete item 1 and item 2 and 2/3 of item 3)

Example 2
Input
2 50
60 100
10 20

Output
160.00

Explanation
Total maximum value of item we can have is 160.00 from the given capacity of sack.

Constraints
1 <= N <= 100000
1 <= W <= 100000
1 <= weight, values <= 1000
*/

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class fractionalKnapsack {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n){
       // sort the array based on porfit per unit (DESCENDING)
		Arrays.sort(arr, (a,b) -> {
			double profitA = (1.0 * a.value) / (1.0 * a.weight);
			double profitB = (1.0 * b.value) / (1.0 * b.weight);
			return profitB < profitA ? -1 : 1;
		});

		double totalProfit = 0.0;
		int bagCapacity = W;

		for(Item loot : arr){
			double weight = loot.weight;
			double value = loot.value;

			if(bagCapacity >= weight){
				// loot the current item completely
				bagCapacity -= weight;
				totalProfit += value;
			}else if( bagCapacity < weight){
				// loot the current item partially to fill the bag
				totalProfit += (value/weight) * bagCapacity;
				bagCapacity = 0;
				break;
			}
		}

		return totalProfit;
    }
}
