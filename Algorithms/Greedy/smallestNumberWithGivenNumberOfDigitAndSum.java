import java.util.*;

/*
Given two positive integers 'S' and 'D'.
Your task is to find the smallest number with given sum of digits as S and number of digits as D. If such number cannot be made return "-1".

Input Format
The first line contains the number of test cases.
For each test case: The first line contains two integer 'S' denoting the sum of digits of number to be found, and 
integer 'D' denoting number of digit in number to be found.

Output Format
For each test case return a string, denoting the number. If no number possible return "-1".

Example 1
Input
1
9 2

Output
18

Explanation
The sum of digit in 18 is 9 and number of digits is 2. There are no number smaller than this which satisfies the condition.

Example 2
Input
1
20 3

Output
299

Explanation
299 is the smallest number possible with sum = 20 and total digits = 3.

Constraints
1 <= T <= 10
1 <= S <= 1000
1 <= D <= 100
*/

class smallestNumberWithGivenNumberOfDigitAndSum{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int k=sc.nextInt();
				Solution ob =new Solution();
				String ans = ob.smallestNumber(n,k);
				System.out.println(ans);
				t--;
			}
		}
	}

}

class Solution{ 
    public String smallestNumber(int S, int D){
        if(S > (D*9))
			return "-1";

		char[] result = new char[D];
		S--;

		for(int index = D-1; index>=1; index--){
			if(S > 9){
				result[index] = '9';
				S -= 9;
			}
			else{
				result[index] = (char) ('0'+S);
				S = 0;
			}
		}

		result[0] = (char) ('0'+S+1);

		return new String(result);
    }
}
