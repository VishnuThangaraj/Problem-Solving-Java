import java.io.*;
import java.util.*;

/*
First line contains q of queries.
Followed by q lines.
Query of type 1 is followed by an integer x to push element in the stack.
Query of type 2 is for pop the top value from the stack and print it.

5
1 2
1 3
2
1 4
2
*/

class Stack
{
	//queue using stak
	Queue<Integer> stack;
	

	//constructor
	Stack(){
		stack = new LinkedList<>();
	}

	//add element in the last
    void push(int a) //takes O(n)
    {
		Queue<Integer> temp = new LinkedList<>();
		//create temp queue and add the element
        temp.add(a);

		//add all the elements from old queue(Stack)
		while(!stack.isEmpty()){
			temp.add(stack.remove());
		}

		//make temp as stack(OLD QUEUE)
		stack = temp;
    }

	//remove element in the front
    int pop() //takes O(1) constant
    {
        if(stack.isEmpty()){
			return -1; //no elements in queue
		}
		return stack.remove();
    }	
}
public class implementStackUsingQueues {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);    
        Stack g = new Stack();			
        int q = sc.nextInt();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                    g.push(a);
            }
            else if(QueryType == 2){
                    System.out.print(g.pop()+" ");
            }
            q--;
        }	
    }
}
