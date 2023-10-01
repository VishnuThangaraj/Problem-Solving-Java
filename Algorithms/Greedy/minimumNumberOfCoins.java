import java.io.*;
import java.util.*;

/*
Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 500} and a target value A.
Find the minimum number of coins and/or notes needed to make the change for Rs A. You must return the list containing the value of coins required.

Input Format
Take input of amount A from the user.

Output Format
Print the number of notes used for each denomination for the given amount in separate lines

Example 1
Input
688

Output
Number Of 500 Rupees Notes: 1
Number Of 100 Rupees Notes: 1
Number Of 50 Rupees Notes: 1
Number Of 20 Rupees Notes: 1
Number Of 10 Rupees Notes: 1
Number Of 5 Rupees Notes: 1
Number Of 2 Rupees Notes: 1
Number Of 1 Rupee Note: 1

Explanation
Above denominations add upto 688.

Example 2
Input
1698

Output
Number of 500 Rupees Notes: 3
Number of 100 Rupees Notes: 1
Number of 50 Rupees Notes: 1
Number of 20 Rupees Notes: 2
Number of 10 Rupees Notes: 0
Number of 5 Rupees Notes: 1
Number of 2 Rupees Notes: 1
Number of 1 Rupees Notes: 1

Explanation
Above denominations add upto 1698.

Constraints
1 <= n <= 2 * 10^5
*/

class Solution{
    public void coinChange(int num){
       // array of currency
		int[] currency = {500, 100, 50, 20, 10, 5, 2 ,1};
		
		for(int index=0; index<currency.length; index++){
			int money = currency[index];
			// calculate the currency required
			int required = num / money;
			if(required > 0)
				num -= required * money;
			// print the money
			System.out.println("Number of "+money+" Rupees Notes: "+required);
		}
    }
}
public class minimumNumberOfCoins
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.coinChange(n);
	}
}
