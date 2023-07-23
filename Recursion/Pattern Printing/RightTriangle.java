package Pattern;

import java.util.*;
public class RightTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(); //Get row size from user
        sc.close(); // close the scanner

        triangle(row,0);
    }

    private static void triangle(int row, int column) {
        if(row==0){
            return; // return if row reaches 0 from user input
        }
        if(column<row){
            triangle(row,column+1); // call function with increased column before printing
            System.out.print("* ");
        }else{
            triangle(row-1,0); // column reaches maximum and hence need to shift to next line
            System.out.println();
        }
    }
}
