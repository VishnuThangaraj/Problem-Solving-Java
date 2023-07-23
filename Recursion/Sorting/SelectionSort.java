package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[]SelectionSortArray = {1,8,2,6,3,5,9,4,7}; //unSorted Array
        Sorting(SelectionSortArray, SelectionSortArray.length-1, 0, 0); //Sorting using the fuction

        //printing after sorting the SelectionSortArray
        for(int element:SelectionSortArray){
            System.out.print(element+" ");
        }
    }

    private static void Sorting(int[] selectionSortArray, int maxIteraton, int currentIndex, int maxValueIndex) {
        if (maxIteraton == 0) {
            return; // return after the end of iteration
        }
        if (currentIndex <= maxIteraton) {
            if (selectionSortArray[currentIndex] > selectionSortArray[maxValueIndex]) { // if maximum element is found in the index update maxValueIndex and call function to check further
                Sorting(selectionSortArray, maxIteraton, currentIndex + 1, currentIndex);
            } else { // if current is not greater than maxValueIndex ... increase the currentIndex
                Sorting(selectionSortArray, maxIteraton, currentIndex + 1, maxValueIndex);
            }
        } else { //start of next Iteration
            //System.out.println(maxValueIndex);
            swap(selectionSortArray, maxIteraton, maxValueIndex); // swap the maxValue to last in range before next iteration
            Sorting(selectionSortArray, maxIteraton - 1, 0, 0);
        }
    }

    private static void swap(int[] selectionSortArray, int maxIteraton, int maxValueIndex) { //swap greater element to last
        int temp = selectionSortArray[maxValueIndex];
        selectionSortArray[maxValueIndex] = selectionSortArray[maxIteraton];
        selectionSortArray[maxIteraton] = temp;
    }
}
