/*
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Input
line 1: contains an integer n denoting size of array.
line 2: contains n spaced integers denoting elements of array A.
line 3: contains n spaced integers denoting elements of array B.

Output
Print true if the two arrays are equal otherwise print false.

Example 1
Input
5
1 2 5 4 0
2 4 5 0 1

Output
true

Explanation
Both the arrays contain the same set of elements same number of times.

Example 2
Input
5
1 2 5 0 0
2 5 5 0 1

Output
false

Explanation
Both the arrays contain the same set of elements same but the frequency is different.

Constraints
1<=n<=10^6
1<=A[i],B[i]<=10^6

Topics
Hashing
Arrays

Companies
Goldman Sachs
*/

import java.io.*;
import java.util.*;

class Solution{
    public static boolean equalArray(int a[], int b [], int n){
        HashMap<Integer,Integer> storage = new HashMap<>();
        // Add to HashMap
        for(int num : a)
            storage.put(num, storage.getOrDefault(num, 0)+1);

        // Validate second array
        for(int num : b){
            if(storage.containsKey(num)){
                storage.put(num, storage.get(num)-1);
            }else
                return false; // Not equal
        }

        // Check the Hashmap for missing nums
        for(int key : storage.keySet()){
            if(storage.get(key) != 0)
                return false;
        }

        return true;
    }
}
public class checkIfTwoArraysAreEqualOrNot {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = input.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.equalArray(a,b,n));
    }
}
