import java.util.*;

/*
Given a set of N intervals denoted by 2D array A of size N x 2, the task is to find the length of maximal set of mutually disjoint intervals.
Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.
Return a integer denoting the length of maximal set of mutually disjoint intervals.

Input Format
First line contains the size of row of the 2D array i.e. N
Next N line contains array elements

Output Format
Return a integer denoting the length of maximal set of mutually disjoint intervals

Example 1
Input
4
1 4
2 3
4 6
8 9

Output
3

Explanation
Intervals: [ [1, 4], [2, 3], [4, 6], [8, 9] ]. Here, Intervals [2, 3] and [1, 4] overlap. 
We must include [2, 3] because if [1, 4] is included thenwe cannot include [4, 6]. 
We can include at max three disjoint intervals: [[2, 3], [4, 6], [8, 9]]

Example 2
Input
3
1 9
2 3
5 7

Output
2

Explanation
Intervals: [ [1, 9], [2, 3], [5, 7] ]. We can include at max two disjoint intervals: [[2, 3], [5, 7]]

Constraints
1 <= N <= 10^5
1 <= A[i][0] <= A[i][1] <= 10^9
*/

class Solution {
    public static int solve(List<List<Integer>> A) {
	    int count = 0; //count of non-overlaping intervals
		//sort the ArrayList based on starting point
		Collections.sort(A, (a,b) ->{
			return a.get(0) - b.get(0);
		});
		int newStart = 0;

		for(List<Integer> current : A){
			if(current.get(0) > newStart){
				//increase count and update NewStart
				count++;
				newStart = current.get(1);
			}else if(current.get(1) < newStart){
				//small interval found..update new Start
				newStart = current.get(1);
			}
		}

		return count;
	}
}
public class maximumNonOverlapingIntervals{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
