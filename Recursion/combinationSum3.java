import java.util.*;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers `1` through `9` are used.
Each number is used at most once.
Return a list of all possible valid combinations. 
The list must not contain the same combination twice, and the combinations may be returned in any order.

Input Format
Input is managed for you. (You are given k and n in the combinationSum3() function).

Output Format
Output is managed for you. (You can return the possible valid combinations in any order. The combinations will be automatically printed in sorted order).

Example 1
Input
3 8

Output
1 2 5 
1 3 4 

Explanation
Here all these combinations have sum equal to 8.
(1 2 5) 
(1 3 4)

Example 2
Input
4 10

Output
1 2 3 4

Explanation
Here all these combinations have sum equal to 10.
(1 2 3 4)

Constraints
2 <= k <= 9
1 <= n <= 60
*/

class Solution {
	public void combination(List<List<Integer>> result, int moves, int num, List<Integer> current){
		// check the moves
		if(moves < 0)
			return;
		
		if(num == 0 && moves == 0){
			result.add(new ArrayList<>(current));
			return;
		}

		int start = 0;
		if(current.size() != 0)
			start = current.get(current.size()-1);

		for(int i=start+1; i<=9; i++){
			current.add(i);
			combination(result, moves-1, num-i, current);
			current.remove(current.size()-1); // backtracking
		}
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();

		// find the combination
		combination(result, k, n, current);

		return result;
    }
}
public class combinationSum3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum3(k,n);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
        for (int i = 0; i < ans.size (); i++)
            {
                for (int j = 0; j < ans.get(i).size (); j++)
                {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println();

            }
    }
}
