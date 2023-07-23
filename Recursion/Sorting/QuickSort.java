package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[]QuickSortArray={1,8,2,6,3,5,9,4,7}; //unsorted Array
        //Calling sorting function with array, startIndex, EndingIndex
        sorting(QuickSortArray, 0 , QuickSortArray.length-1);

        //Printing QuickSortArray after Sorting
        for(int elements:QuickSortArray){
            System.out.print(elements+" ");
        }
    }

    private static void sorting(int[] QuickSortArray, int startIndex, int endIndex) {
        if(startIndex >= endIndex){
            return; //stops the function if the start index is greater than end index
        }

        int lowIndex = startIndex; // lower index of the range
        int highIndex = endIndex; //higher index of the range
        int mid = startIndex + (endIndex-startIndex) / 2; //middle index to separate into two portions
        // pivot element to store small elements on left of pivot and greater elements on right of pivot
        int pivot = QuickSortArray[mid];

        while(lowIndex <= highIndex){ // for arranging small elements to left and large element to right of pivot
            while(QuickSortArray[lowIndex] < pivot){
                lowIndex++; // no violation found so increase low index
            }
            while(QuickSortArray[highIndex] > pivot){
                highIndex--; // no violation found so increase high index
            }
            if(lowIndex <= highIndex){ // checks the low and high index is not same and hence low index is lesser for swapping
                // Swap Occurs
                int temp = QuickSortArray[lowIndex];
                QuickSortArray[lowIndex] = QuickSortArray[highIndex];
                QuickSortArray[highIndex] = temp;
                lowIndex++;highIndex--;
            }
        }
        sorting(QuickSortArray, startIndex, highIndex); // send first half for sorting
        sorting(QuickSortArray, lowIndex, endIndex); // send second half for sorting
    }
}