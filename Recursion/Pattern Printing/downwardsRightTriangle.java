package Pattern;
import java.util.*;

public class DownwardsRightTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(); // number of rows
        sc.close(); // close the scanner
        triangle(row,0);
    }

    private static void triangle(int row, int column) {
        if(row==0){ //end if row reach max to 0
            return;
        }
        if(column<row){ //print star while col is less than row
            System.out.print("* ");
            triangle(row,column+1);
        }else{
            System.out.println();
            triangle(row-1,0); // decrease row and make column 0
        }
    }
}
