import java.util.*;

/*
2^n integers where every integer is in the inclusive range [0, 2^n - 1], an integer appears no more than once in the sequence, 
the binary representation of the first and last integers differs by exactly one bit, the first integer is 0 
and the binary representation of every pair of adjacent integers differs by exactly one bit.

Given an integer n, return any valid n-bit binary sequence roll number with 2^n integers.

Input Format
The First line of input contains an integer n.

Output Format
Any valid n bit sequence of roll numbers.

Input
2

Output
[0,1,3,2]

Explanation
The binary representation of [0,1,3,2] is [00,01,11,10].
00 and 01 differ by one bit
01 and 11 differ by one bit
11 and 10 differ by one bit
10 and 00 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
00 and 10 differ by one bit
10 and 11 differ by one bit
11 and 01 differ by one bit
01 and 00 differ by one bit

Example 2
Input
1 

Output
[0,1]

Explanation
The binary representation of [0,1] is [00,01].
00 and 01 differ by one bit

Constraints
1 <= n <= 16
*/

class Solution {
    public List<Integer> rollnumber(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for(int i=1; i<=n; i++){
            for(int j=result.size()-1; j>=0; j--){
                int current = result.get(j);
                current = current + (1 << (i-1));
                result.add(current);
            }
        }
        return result;
    }
}
public class rollNumber {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        Solution Obj = new Solution();
        sc.close();
          List<Integer> l= new ArrayList<>();
        l= Obj.rollnumber(n);
        for(int i=0;i<l.size();i++)
        {
            System.out.print(l.get(i));
            System.out.print(" ");
        }
    }
}
