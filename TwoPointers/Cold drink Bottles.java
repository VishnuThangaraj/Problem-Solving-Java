/*
Rick is very fond of cold drinks and recently he attended his friend's birthday party. In the party, various cold drinks were arranged in a row and there might 
be a cold drink appearing more than once. Each different type of cold drink is represented by a number and same cold drinks are represented by the same number. 
Rick wants to try these cold drinks so he decided to select the smallest possible continuous sequence of cold drinks from the given row of cold drinks making 
sure he can taste exactly k distinct cold drinks. Help Rick determining the starting and ending position of this 
smallest possible continuous sequence of cold drinks satisfying the above condition.

Note: If there are multiple such solutions, return the one which is lexicographically smallest. 
Eg. {1, 4} is lexicographically smaller than {2, 4} since '1' appears before '2' at the corresponding position. 
There maybe same cold drinks in the selected sequence but since we have to consider only the distinct cold drinks, 
it will be counted only once. E.g. {1, 2, 1, 3} has '3' distinct cold drinks.

Complete the function coldDrink which receives input array, size of array and k as parameters and returns the starting and ending position 
of the required continuous sequence of cold drinks satisfying the above condition and if no solution exists, then returns '-1'.

Input Format
The first line of input contains two integers n representing the number of cold drink bottles and another number k.
The second line of input contains n space-separated integers representing the cold drink bottles.

Output Format
The only line of output contains '2' space-separated integers representing the starting and ending position of the smallest possible continuous sequence 
of cold drinks that can enable him to taste exactly k distinct types of cold drinks.

Note: If no such continuous sequence exists, print '-1'.

Example 1
Input
8 3
1 1 2 2 3 3 4 5

Output
5 7

Explanation: Smallest possible continuous sequence having exactly '3' distinct cold drinks is of length '3' extending from index '5' to '7' (0-based indexing).

Example 2
Input
5 3
1 1 2 1 2

Output
-1

Explanation: Since no continuous sequence having '3' distinct cold drinks can be found, '-1' is printed.

Constraints:
1 <= n <= 2*104
1 <= k, arr[i] <= n
*/

import java.io.*;
import java.util.*;

class Solution {

    public List<Integer> coldDrink(int arr[], int n, int k) {
        // write code here
        List<Integer> result = new ArrayList<>();
        int start = 0, end = n+n;

        //Two-Pointers
        int first = 0, second = 0;
        HashMap<Integer, Integer> storage = new HashMap<>();

        while(first < n){
            if(second < n && storage.size()<k){
                storage.put(arr[second], storage.getOrDefault(arr[second],0)+1);
                second++;
            }else{
                if(storage.get(arr[first]) == 1)
                    storage.remove(arr[first]);
                else
                    storage.put(arr[first], storage.get(arr[first])-1);

                first++;
            }

            //Update result
            if(storage.size() == k && (end-start) > (second-first)){
                start = first;
                end = second;
            }
        }

        if(start == 0 && end == n+n)
            result.add(-1);
        else{
            result.add(start);
            result.add(end-1);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        List<Integer> ans = Obj.coldDrink(arr, n, k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        sc.close();
    }
}
