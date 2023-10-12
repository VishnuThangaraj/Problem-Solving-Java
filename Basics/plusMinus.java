import java.util.*;

/*
Given an array arr of N integers, Calculate the ratios of its elements that are positive, negative, and zero to the array size N.
Print the decimal value of each fraction in a new line up to 6 decimal places.

Input Format
The first line contains an integer N, the size of the array.
The second line contains N space-separated integers representing the array arr.

Output Format
Print the 3 required ratios up to 6 decimal places.

Example 1
Input
6
-4 3 -9 -5 4 1

Output
0.500000
0.500000
0.000000

Explanation
There are 3 positive integers, 3 negative integers, and 0 zeroes in the array.
The ratio of occurrence is - Positive: 0.500000, Negative: 0.500000, and Zeroes: 0.000000

Example 2
Input
3
1 0 -1

Output
0.333333
0.333333
0.333333

Explanation
There is 1 positive integer, 1 negative integer, and 1 zero in the array.
The ratio of occurrence is - Positive: 0.333333, Negative: 0.333333, and Zeroes: 0.333333

Constraints
1 <= n <= 10^6
-10^8 <= arr[i] <= 10^8
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        printRatios(arr);
        sc.close();
    }

    public static void printRatios(int[] arr) {
        int positive = 0, negative = 0, zero = 0;

		for(int num : arr){
			if(num == 0) zero++; // zero found
			if(num < 0) negative++; // negative found
			if(num > 0) positive++; // positive found
		}
		double fraction = (1.0) / (arr.length*1.0);
		System.out.format("%.6f", ((positive*1.0)*fraction));
		System.out.println();
		System.out.format("%.6f", ((negative*1.0)*fraction));
		System.out.println();
		System.out.format("%.6f", ((zero*1.0)*fraction));
    }
}
