import java.util.*;

/*
Gian and Suneo want their heights to be equal so they asked Doraemon for help. 
Doraemon gave a big light to both of them but both big lights have different speeds of magnifying. 
Let us assume the big light given to Gian can increase the height of a person by v1 m/s and that of Suneos big light is v2 m/s. 
At the end of each second Doraemon check if their heights are equal or not.

Given the initial height of Gian and Suneo, your task is to check whether the height of Gian and Suneo will become equal 
at some point or not, assuming they both started at the same time.

Input Format
The only line of the input contains 4 spaced integers, h1(height of Gian), h2(height of Suneo), 
v1(speed of Gian's big light), and v2(speed of Suneo's big light).
You need to complete bigLight function which contains above 4 integer inputs and print/return boolean true or false.

Output Format
Print true if height will become equal at some time else print false.

Example 1
Input
4 2 2 4

Output
true

Explanation
The height of Gian goes as- 4 6 8 10. . 
height of Suneo goes as:- 2 6 10.. at the end of 1 second their height will become equal.

Example 2
Input
5 4 1 6

Output
false

Constraints
1 <= h2 < h1<=10000
1 <= v1 <= 10000
1 <= v2 <=10000
*/

public class bigLight {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int h2 = sc.nextInt();
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		if (v1 == v2) {
			if (h1 == h2) // same height
				System.out.println("true");
			else
				System.out.println("false");
		} else {
			if ((h1 - h2) % (v2 - v1) == 0 && (h1 - h2) / (v2 - v1) > -1)
				System.out.println("true");
			else
				System.out.println("false");
		}
	}
}
