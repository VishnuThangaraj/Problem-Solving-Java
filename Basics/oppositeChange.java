import java.util.*;

/*
Given an integer n, you have to flip the bits in the binary representation of n. 
Flipping means changing bit '1' -> '0' and '0' to '1'.

Input Format
The First line of input contains an integer n.

Output Format
Print integer formed after flipping the bits.

Example 1
Input
7

Output
0

Explanation: The binary representation of '7' is (111) which after getting flipped becomes (000) hence answer is '0'.

Example 2
Input
5

Output
2

Explanation: The binary representation of '5' is (101) which after getting flipped becomes (010) i.e. '2'.

Constraints
1 <= n <= 109
*/

class Solution {
 
    public int Opposite(int n) {
        String binary = "";
		// convert to binary
		while(n>0){
			binary = n%2 + binary;
			n/=2;
		}

		// flip the bits
		String flipped = "";
		for(int i=0;i<binary.length(); i++){
			if(binary.charAt(i) == '1') flipped+='0';
			else flipped+='1';
		}

		int convert = Integer.parseInt(flipped,2);

		return convert;
		
    }
}
 
 
public class oppositeChange {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.Opposite(n));
    }
}
