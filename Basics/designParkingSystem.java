/*
Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the ParkingSystem class:
`ParkingSystem(int big, int medium, int small) :`Initializes object of the ParkingSystem class. 
The number of slots for each parking space are given as part of the constructor.
`bool addCar(int carType) :` Checks whether there is a parking space of carType for the car that wants to get into the parking lot. 
carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. 
A car can only park in a parking space of its carType. If there is no space available, 
return false, else park the car in that size space and return true.

Input Format:
The first line contains q which denotes the total number of operations to be performed.
Each query contains a single integer that denotes the size of the parking spaces.

Output Format:
Return the result for every query of the type addCar.

Example 1
Input:
5
2 1 1
3
3
2
2
3

Output:
true
false
true
false
false

Explanation:
Initially 2 Big, 1 Medium, 1 small parking spaces are available.
First query:- a small car enters the parking. Since number of small spaces > 0, return true.
Counter-> 2 Big, 1 Medium, 0 small.
Second query:- a small space is needed. Since number of small spaces = 0, return false.
Counter-> 2 Big, 1 Medium, 0 small.
Third query:- a medium space is needed. Since number of medium spaces > 0, return true.
Counter-> 2 Big, 0 Medium, 0 small.
Fourth query:- a medium space is needed. Since number of medium spaces = 0, return false.
Counter-> 2 Big, 0 Medium, 0 small.
Fifth query:- a small space is needed. Since number of small spaces = 0, return false.
Counter-> 2 Big, 0 Medium, 0 small.

Example 2
Input:
3
2 0 2
3
3
2

Output:
true
true
false

Explanation:
Initially 2 Big, 0 Medium, 2 small spaces are available.
First query:- a small space is needed. Since number of small spaces > 0, return true.
Counter-> 2 Big, 0 Medium, 1 small.
Second query:- a small space is needed. Since number of small spaces > 0, return true.
Counter-> 2 Big, 0 Medium, 0 small.
Third query:- a medium space is needed. Since number of medium spaces = 0, return false.
Counter-> 2 Big, 0 Medium, 0 small.

Constraints:
Number of queries/function calls lies in the range [1,1000].

Topics:
OOP

Companies:
Microsoft
Adobe
Goldman Sachs
Amazon
*/

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class designParkingSystem {

  public static void main(String[] args) throws IOException {
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();  
    int a = sc.nextInt();  
    int b = sc.nextInt();  
    int c = sc.nextInt();  
    ParkingSystem answer = new ParkingSystem(a,b,c);
    for(int i=0;i<n;i++)
    {
      int q = sc.nextInt(); 
      System.out.println(answer.addCar(q));
    }
  }
}

class ParkingSystem {
    private static int big, medium, small;
 
    public ParkingSystem(int small, int medium, int big) {
        ParkingSystem.small = small;
        ParkingSystem.medium = medium;
        ParkingSystem.big = big;
    }

    public boolean addCar(int carType) {
        if(carType == 1){ // small
            if(small == 0) return false;
            small--;
            return true;
        }else if(carType == 2){ // medium
            if(medium == 0) return false;
            medium--;
            return true;
        }else{ // big
            if(big == 0) return false;
            big--;
            return true;
        }
    }
}
