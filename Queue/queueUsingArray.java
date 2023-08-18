import java.util.*;

//INPUT EXAMPLE
/*
  First line contains an integer n, which is the number of operations

Each line i of the n subsequent lines (where 0<=i<n ) defines an operation to be performed. 
Each operation starts with a single integer, op (where op belongs to {1, 2, 3, 4} ), 
denoting a type of operation as defined in the Problem Statement above. 
If the operation requires an argument, op is followed by its space-separated argument. 
For example, if op = 1, and integer to be pushed if 4, then line i will be 1 4

8
1 1
1 2
1 3
1 4
3
2
3
4
 */

class Queue {
    //array
	int[]arr ;
	int start; //starting index 
	int end; //ending index
	int size ; //current size 

	//constructor
    public Queue() {
        arr = new int[1001];
		start = 0;
		end=0;
    }

	//add element in array
    public void push(int newElement) {
        arr[end++] = newElement;
    }
	//remove the element from beginning
    public int pop() {
        return arr[start++];
    }
	//view the element in start index
    public int front() {
        return arr[start];
    }
	//size of the elements added
    public int size() {
        return end-start;
    }
}
public class queueUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.size());
        }
    }
}