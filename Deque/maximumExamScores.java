import java.util.*;

/*
Imagine you are a teacher at a school and you have been asked to grade your students' exams. 
You have a list of N scores and you want to find the highest score in each group of K scores. 
For example, if the list of scores is [87, 99, 75, 90, 82, 80] and K is 3, 
you would want to find the maximum score in the following groups of K scores: [87, 99, 75], [99, 75, 90], [75, 90, 82], and [90, 82, 80].

Can you write a function to solve this problem?

Input Format
Input consists of three lines.
First line contains an integer N which is the size of the array.
Next line contains N spaced integers of the array.
Last line contains an integer K which is the size of the window.

Output Format
Print the maximum element in contiguous group of K students

Example 1
Input
7
1 2 1 3 4 2 3
4

Output
3 4 4 4

Explanation
Window 1 of size `k = 4` is `1 2 1 3`. Maximum element is 3. 
Window 2 of size `k = 4` is `2 1 3 4`. Maximum element is 4.
Window 3 of size `k = 4` is `1 3 4 2`. Maximum element is 4.
Window 4 of size `k = 4` is `3 4 2 3`. Maximum element is 3.

Example 2
Input
3
4 1 1
2

Output
4 1

Explanation
Window 1 of size `k = 2` is `4 1`. Maximum element is 4
Window 2 of size `k = 2` is `1 1`. Maximum element is 1.

Constraints
1 <= k <= n <= 10^5
1 <= arr[i] <= 10^3
*/

class Solution {
    static void printMax(int arr[], int N, int K)
    {
         // Store the index of marks
        Deque<Integer> storage = new ArrayDeque<>();

        int index = 0;

        // add till the window size
        for(; index<K; index++){
            while(!storage.isEmpty() && arr[storage.peekLast()] <= arr[index])
                storage.pollLast();

            storage.offerLast(index);
        }

        // printing the max in window size
        for(; index<N; index++){
            System.out.print(arr[storage.peek()]+" ");

            // Remove elements out of the window range
            while(!storage.isEmpty() && storage.peekFirst() <= index-K)
                storage.pollFirst();

            while(!storage.isEmpty() && arr[storage.peekLast()] <= arr[index])
                storage.pollLast();

            storage.offerLast(index);
        }

        // Print the last window
        System.out.print(arr[storage.peek()]);
    }
}

public class maximumExamScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        Obj.printMax(arr1, n ,k);
        System.out.println('\n');
    }
}
