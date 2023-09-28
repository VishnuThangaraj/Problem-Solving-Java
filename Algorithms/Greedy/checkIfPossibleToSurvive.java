import java.util.*;

/*
You are a poor citizen of an island that has only one shop for groceries, which is open six days a week and is closed on Sundays.
The first day of the week is Monday. You can buy ‘n’ units of food from a day’s work. 
Now each day, you need ‘x’ units of food to survive. You are making a boat to escape the island, which will require ‘d’ days to be made. 
You need to survive at least ‘d’ days on the island. You are given three integers n, x, and d.

Your task is to determine if you can escape the island

Input Format:
The first and the only line contains three space-separated integers n, x, and d.

Output Format:
Print YES if it is possible to survive on the island; else, print NO.

Example 1:
Input:
16 2 10

Output:
YES

Explanation:
One possible solution is to buy food on the first day (Monday). 
It’s sufficient to eat from this food up to the 8th day (Monday) inclusive. On the 9th day (Tuesday), 
repurchase food and use the food to survive the 9th and 10th day.

Example 2:
Input:
2 4 20

Output:
NO

Explanation:
We can not survive as we make only two units of food per day, but we consume four units of food, so we will not be able to survive.

Constraints:
1<= n, x, d<=10^8
*/

public class checkIfPossibleToSurvive {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int d = sc.nextInt();
        boolean ans = Solution.isPossibleToSurvive(n, x, d);
        if(ans) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
class Solution {
    
    static boolean isPossibleToSurvive(int n, int x, int d )
    {
		// RETURN FALSE IF food bought for 6 days is less than consumed for 7days
		// or daily consume is more than daily purchase
         if ( ((n * 6) < (x * 7) && d > 6) || x > n)
            return false;
  
        else 
			 return true;
    }  
}
