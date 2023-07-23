package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[]MergeSortArray={1,8,2,6,3,5,9,4,7}; //unsorted Array
        //calling function with array, starting , ending
        Sorting(MergeSortArray, 0, MergeSortArray.length-1);

        //printing the MergeSortArray after sorting
        for(int element:MergeSortArray){
            System.out.print(element+" ");
        }
    }

    private static void Sorting(int[] MergeSortArray, int start, int end) {
        if(start == end){
            return; // returns when the start and end points same element
        }
        int mid = (start+end)/2; //finding the mid-element to separate into two

        Sorting(MergeSortArray, start, mid); //calling function with first-half
        Sorting(MergeSortArray, mid+1, end); //calling function with second-half

        swapElements(MergeSortArray, start, mid, end);//making the array sorted
    }

    private static void swapElements(int[] MergeSortArray, int start, int mid, int end) {
        int first = start; //starting range of first part of array
        int second = mid+1; //starting range of second part of array

        int[]NewArray=new int[(end-start)+1]; //new array for storing sorted elements
        int newIndex = 0; //index for NewArray

        while(first <= mid && second <= end){ //runs until the index of separated array is int the range
            if(MergeSortArray[first]<MergeSortArray[second]){ //if element from first half is small add to new Array
                NewArray[newIndex] = MergeSortArray[first];
                first++;
            }else{ //if element from second half is small add to new array
                NewArray[newIndex] = MergeSortArray[second];
                second++;
            }
            newIndex++;
        }
        while(first <= mid){ //if first half is unfinished (Not added in new Array)
            NewArray[newIndex] = MergeSortArray[first];
            first++;
            newIndex++;
        }
        //Either any one of the while loop will be executed hence any one half will be finished
        //above while loop or below while loop any one
        while(second <= end){ //if second half is unfinished (Not added in new Array)
            NewArray[newIndex] = MergeSortArray[second];
            second++;
            newIndex++;
        }

        for(int l=0;l< NewArray.length;l++){ //insert the elements of NewArray(sorted) to old Array in the start to end range
            MergeSortArray[start+l] = NewArray[l];
        }
    }
}