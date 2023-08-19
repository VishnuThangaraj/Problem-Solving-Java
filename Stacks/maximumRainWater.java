import java.util.Stack;

//for optimized code using two-pointers check out : https://github.com/Mr-Vishnu-Thangaraj/ProblemSolvingInJava/blob/main/TwoPointers/trappingRainwaterProblem.java

public class maximumRainWater {
    public static void main(String[] args) {
        //array for calculating maximum rain water
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(water(height));
    }

    private static int water(int[] height) {
        //find the left highest
        int[]left = leftHighest(height);

        //find the right highest
        int[]right = rightHighest(height);

        int water = 0;

        //calculate water
        for(int index=0 ;index<right.length; index++){
            water += Math.min(right[index],left[index]) - height[index];
        }

        return water;
    }

    //rightHighest
    private static int[] leftHighest(int[] height) {
        //use stack to store the highest indexes
        Stack<Integer> storage = new Stack<>();
        //storing result
        int[] result = new int[height.length];

        for(int index=0; index< height.length; index++){

            while(!storage.isEmpty() && height[index] >= height[storage.peek()]){
                storage.pop();
            }
            //if stack is empty assign current index as the highest in left
            if(storage.isEmpty()){
                result[index] = height[index];
                storage.push(index);
            }else{
                result[index] = height[storage.peek()];
            }

        }

        return result;
    }

    //left highest
    private static int[] rightHighest(int[] height) {
        //use stack to store the highest indexes
        Stack<Integer> storage = new Stack<>();
        //storing result
        int[] result = new int[height.length];

        for(int index= height.length-1; index >=0 ; index--){

            while(!storage.isEmpty() && height[index] >= height[storage.peek()]){
                storage.pop();
            }
            //if stack is empty assign current index as the highest in left
            if(storage.isEmpty()){
                result[index] = height[index];
                storage.push(index);
            }else{
                result[index] = height[storage.peek()];
            }
        }

        return result;
    }
}
