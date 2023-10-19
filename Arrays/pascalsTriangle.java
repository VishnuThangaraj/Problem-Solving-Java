import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given numRows, generate the first numRows of Pascal's triangle. 
Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Input
First line contains integer K

Output
Print Pascal's triangle

Example 1
Input
5

Output
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

Explanation
The pascal triangle has been printed for the given value.

Constraints
0 <= numRows <= 25
*/

public class pascalsTriangle {

    public static void solve(int A) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(1);

		System.out.println(1);

		for(int row=1; row<A; row++){
			ArrayList<Integer> current = new ArrayList<>();
			current.add(1);

			for(int index=1; index<result.size(); index++){
				current.add(result.get(index-1)+result.get(index));
			}

			current.add(1);
			result = current;

			// print the row
			for(int num : result)
				System.out.print(num+" ");
			System.out.println();
		}
    }
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	  int K = sc.nextInt();
      solve(K);
      
	}
}
