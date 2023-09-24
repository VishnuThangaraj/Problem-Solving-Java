import java.util.*;

/*
Given a number n and a value k. From the right, set the kth bit in the binary representation of n. 
The position of LSB(or last bit) is 0, second last bit is 1 and so on.

Input Format
The first line of input contains two integers n and k.

Output Format
The only line of output contains a single integer representing the value obtained after doing the above operation.

Example 1:
Input
10 2

Output
14

Explanation: 
Binary representation of '10' is (1010) so making the 2nd bit from right it becomes (1110) which is equivalent to '14'.

Example 2
Input
15 3

Output
15

Explanation: 
Binary representation of '15' is (1111) since 3rd bit from right is already set i.e. '1' so it remains '15'.

Constraints
1 <= n <= 109
0 <= k < x, where 'x' represents the number of bits in the binary representation of 'n'
*/

class Solution {
    public int setKBit(int n, int k) {
        int bitMask = 1 << k;
		return n | bitMask;
    }
}

public class setBitAtKthPosition {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setKBit(n, k));
    }
}
