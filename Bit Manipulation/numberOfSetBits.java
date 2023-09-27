import java.util.*;

/*
You are given a single number n. Find the number of set bits in n.

Input Format
The only line of input contains a single integer n.

Output Format
The only line of output contains a single integer representing the number of set bits in n.

Example 1:
Input
6

Output
2

Explanation: The binary representation of '6' is (110) and there are two set bits.

Example 2
Input
8

Output
1

Explanation: The binary representation of '8' is (1000) and there is only one set bit.

Constraints:
1 <= n <= 109
*/

class Solution {
    public int setBits(int n) {
        int count = 0; //count of set bits

		while(n > 0){
			if((n & 1) == 1) count++;
			n = n >> 1;
		}

		return count;
    }
}

public class numberOfSetBits {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}
