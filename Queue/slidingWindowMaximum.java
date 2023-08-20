import java.util.ArrayDeque;
import java.util.Deque;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        //array
        int[]array = {1,3,-1,-3,5,3,6,7};
        //window size
        int window = 3;

        int result[] = slidingWindow(array,window);

        //print the result
        for(int element: result){
            System.out.println(element+" ");
        }
    }

    private static int[] slidingWindow(int[] array, int window) {
        //array to store the maximum element
        int[]maximum = new int[array.length-(window - 1)];
        int maximumIndex = 0; //index for maximum array

        //create a dequeue to store the index
        Deque<Integer> storage = new ArrayDeque<>();

        //traverse through the array
        for(int index =0 ;index < array.length; index++){
            //remove number out of range in the dequeue
            while(!storage.isEmpty() && storage.peek() <= index - window){
                storage.poll(); //removes from the front
            }

            //remove the smaller number in range
            while(!storage.isEmpty() && array[storage.peek()] <= array[index]){
                storage.pollLast(); //remove the last element in dequeue
            }
            //insert the current index
            storage.offer(index);

            //insert from window-th index
            if(index >= window -1){
                //increase maximumarray index after inserting
                maximum[maximumIndex++] = array[storage.peek()];
            }
        }
        //return the maximum array
        return maximum;
    }
}
