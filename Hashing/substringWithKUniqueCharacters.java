import java.util.*;

/*
You are given a string 's'.
You need to print length of longest possible substring that has exactly k unique characters. If there is no such string print -1.

Input Format
First line contains two integers n and k, denoting the length of string and value of k respectively.
Second line contains a string s.

Output Format
Print an integer indicating the length of substring. If not possible print -1.

Example 1
Input
6 1
aabbcc

Output
2

Explanation
Max substring can be any one from {“aa” , “bb” , “cc”}.

Example 2
Input
6 2
aabbcc

Output
4

Explanation
Max substring can be any one from {“aabb” , “bbcc”}

Constraints
1<=|s|<=10^5
1<=k<=10^5
*/
public class Main {

    public static int longestkSubstr(int n, int k,String s){
        //to store only unique characters
        HashMap<Character,Integer> unique = new HashMap<>();

		int first = 0;
		int second = 0;
		int max = -1;

		while(first < s.length()){
			if(second < s.length() && unique.size() <= k){
				unique.put(s.charAt(second), unique.getOrDefault(s.charAt(second),0)+1);
				//update max size
				if(unique.size() == k)
					max = Math.max(max, (second - first)+1);
				second++;
			}else{
				if(unique.get(s.charAt(first)) == 1){
					unique.remove(s.charAt(first));
				}
				else{
					unique.put(s.charAt(first), unique.get(s.charAt(first))-1);
				}
				first++;	
			}
		}

		return max;
    }

    public static void substringWithKUniqueCharacters(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}
