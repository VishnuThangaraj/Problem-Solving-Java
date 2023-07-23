package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[]bubbleSortArray={1,8,2,6,3,5,9,4,7}; //unsorted Array
        Sorting(bubbleSortArray,bubbleSortArray.length-1,0); //Sorting using the function

        //printing the bubbleSortArray after sorting
        for(int elements:bubbleSortArray){
            System.out.print(elements+" ");
        }
    }

    private static void Sorting(int[] bubbleSortArray, int maxLength, int index) {
        if(maxLength==0){
            return; // return after the sorting completed
        }
        if(index < maxLength){ // checks for sorted last indexes to ignore each iteration
            if(bubbleSortArray[index]>bubbleSortArray[index+1]){
                swap(bubbleSortArray,index); // swap elements if the current is smaller than the next element
            }
            Sorting(bubbleSortArray, maxLength, index+1); //next iteration call
        }else{
            Sorting(bubbleSortArray, maxLength-1,0); // next iteration call
        }
    }

    private static void swap(int[] bubbleSortArray, int index) { // Swap the elements
        int temp = bubbleSortArray[index];
        bubbleSortArray[index]=bubbleSortArray[index+1];
        bubbleSortArray[index+1]=temp;
    }
}
