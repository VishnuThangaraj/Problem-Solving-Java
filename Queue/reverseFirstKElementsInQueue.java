import java.util.*;
import java.io.*;

/*
  SAMPLE INPUT :
  5 3
  1 2 3 4 5
  SAMPLE OUTPUT :
  3 2 1 4 5

  EXPLANATION :
  1 2 3 are first K elements. Thus after reversing them, the final list is 3 2 1 4 5.
*/

public class reverseFirstKElementsInQueue {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
		//input for queue
        int n = input.nextInt(), k = input.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.add(input.nextInt());
        }

		//function to reverse the k elemnts in queue
		q = reverseK(q,k);

		//printing the queue
        while(q.size() > 0){
            System.out.print(q.poll() + " ");
        }
    }

	public static Queue<Integer> reverseK(Queue<Integer> q, int k){
		// create a deque and add till k elements
		Deque<Integer> storage = new ArrayDeque<>();

		//add the elements in q to storage(deque)
		while(!q.isEmpty()){
			if(k>0){
				//insert in the beginning for k times
				storage.addFirst(q.remove());
				k--;
			}else{
				//insert in the end after k times
				storage.addLast(q.remove());
			}
		}

		//shift all the elements from deque to q
		while(!storage.isEmpty()){
			q.add(storage.remove());
		}

		return q;
	}
}
