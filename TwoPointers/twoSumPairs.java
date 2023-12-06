/*
Given an Array arr of size n have may or may not be repeated elements. 
A target sum 'target' is provided. Return Pair of target sum in which all pairs are unique.
If array have repeated element then return only unique pairs.

NOTE: Complete the twoSum function, input and output is already managed.

Input Format
First line contains two space seprated integers n and target.
Second line contains n space separated integers representing elements of array arr.

Output Format
Print the pairs in space separated format, in sorted order.

Example 1
Input
4 6
2 2 4 4

Output
2 4

Explanation
array is arr = [2, 2, 4, 4], and target = 6 then res have only one pair, i.e. [2, 4] 
all other pairs with sum 6 will be counted repeated.

Example 2
Input
6 60
10 10 30 40 50 20

Output
10 50 
20 40 

Constraints
2 <= n < 10000
10^9 < arr[i] < 10^9

Topics:
2-Pointers
Sorting

Companies:
Microsoft
ByteDance
Apple
Amazon
Facebook
Intuit
Oracle
Google
*/

import java.util.*;

public class twoSumPairs {

    public static List<List<Integer>> twoSum(int[] arr, int target) {
      List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> storage = new HashSet<>();
        Arrays.sort(arr); // Sort the Array
        
        int first = 0, second = arr.length-1; //Two-Pointers

        while(first < second){
            int sum = arr[first]+arr[second];
            if(sum == target){
                List<Integer> current = new ArrayList<>();
                current.add(arr[first++]); current.add(arr[second--]);
                result.add(current);

                // move both pointers and avoid duplicates
                while(first < second && arr[first-1] == arr[first]) first++;
                while(second > first && arr[second+1] == arr[second]) second--;
            }
            else if(sum > target) second--;
            else first++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int target = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
              ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}
