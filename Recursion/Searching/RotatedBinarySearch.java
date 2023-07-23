package Searching;

// reference kunal kushwaha (Recursion Array Questions) 01:00:06(TimeStamp)
//Recursion on BinarySearch
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[]rotatedAndSorted = {5,6,7,8,9,1,2,3};
        int target = 8; //target to find in the array
        int start = 0; //beginning of search range
        int end = rotatedAndSorted.length-1; //end of search range
        int TargetIndex = binarySearch(rotatedAndSorted,target,start,end); //calling recursive binary search funciton
        System.out.println(TargetIndex); //print the result returned from the binarySearch function
    }
    private static int binarySearch(int[] rotatedAndSorted, int target, int start, int end) {
        int mid = start + (end-start)/2; //calculating the middle element

        if(rotatedAndSorted[mid]==target){ //checks middle is equal to the target element
            return mid; // return the index of the target
        }
        if(start>end){ // out of range
            return -1; //element is not present in the array. return -1;
        }
        if(rotatedAndSorted[start]<=rotatedAndSorted[mid]){ //checks if the range is sorted
            if(rotatedAndSorted[start]<=target && rotatedAndSorted[mid]>=target){ //checks the element lies in before mid
                return binarySearch(rotatedAndSorted,target,start,mid+1); // call function to search for target in the range
            }else{
                return binarySearch(rotatedAndSorted, target, mid+1, end); // element not in range to move the start to mid+1
            }
        }
        if(rotatedAndSorted[mid]<=target && rotatedAndSorted[end]>=target){ //checks for element lies in after mid
            return binarySearch(rotatedAndSorted,target,mid+1,end); // call function to search in the range
        }
        return binarySearch(rotatedAndSorted,target,start,mid-1 ); //checks for element before the mid and unSorted
    }
}
