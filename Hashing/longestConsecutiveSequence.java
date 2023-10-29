import java.util.*;
import java.lang.*;
import java.io.*;

/*
You are given an unsorted array A of N integers. Find the length of the longest sequence with consecutive elements.
Solve this problem in O(N) time
Note Complete the given function. The input and output would be handled by the driver code.

Input Format
The first line contains a single integer N.
The second line contains N space-separated integers.

Output Format
Print the answer in a new line.

Example 1
Input
5
2 1 3 6 4

Output
4

Explanation
The longest possible consecutive sequence is 1, 2, 3, 4. It has length 4.

Example 2
Input
3
2 3 5

Output
2

Explanation
The longest possible consecutive sequence is 2, 3. It has length 2.

Constraints
1 <= N <= 10000
1 <= A[i] <= 100000
*/

public class longestConsecutiveSequence {
    
    public static long longestConsecutiveSequence(int A[], long n) 
    { 
       long result = 0;
        HashSet<Integer> storage = new HashSet<>();

        for(int index=0; index<A.length; index++) storage.add(A[index]);

        for(int index=0; index<A.length; index++){
            if(!storage.contains(A[index]-1)){
                long count = 0;
                int num = A[index];

                while(storage.contains(num)){
                    count++;
                    storage.remove(num++);
                }
                // update result
                result = Math.max(result, count);
            }
        }

        return result;
    } 
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        System.out.println(longestConsecutiveSequence(arr, n));
		
	}
}



