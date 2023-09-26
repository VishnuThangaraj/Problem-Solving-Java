import java.util.*;

/*
You are given a linked List consisting of N nodes.
Your task is to rearrange the linked list in such a way that all odd position nodes are together and before all even positions nodes.

Input Format
The first line contains the number of test cases.
For each test case: You are given a head pointer for the linked list.

Output Format
For each test case print an array in a new line, denoting the values of the changed Linked List.

Example 1
Input
1
4
1 2 3 4

Output
1 3 2 4

Explanation:
The Initial Linked List looks like:
1 -> 2 -> 3 -> 4
odd-positioned elements are brought together before all even-positioned elements
The Linked List after the operation looks like this:
1 -> 3 -> 2 -> 4

Example 2
Input
1
4
1 3 5 2

Output
1 5 3 2

Explanation
The odd position elements are brought together.

Constraints
1 <= T <= 10
1 <= N <= 10^4
1 <= L[i] <= 10^5
*/

public class oddEvenLinkedList {
	Node head;
	Node temp;
	
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	public void oddEvenList(Node head) {
		if (head == null) {
			System.out.println();
			return ;
		}
		// odd and even pointers 
		Node odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;

		// reassign the head and print the list
		Node temp =head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;			
		}
		System.out.println();
		return;
	}

	public void push(int new_data)
	{
		if(head == null){
			
			head = new Node(new_data);
			
			temp =head;
			
			return ;
		}
		else{
			Node new_node = new Node(new_data);

			temp.next = new_node;
			
			temp=temp.next;

			return;		
		}
		
	}

	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		Main ob = new Main();
		int t=0;
		t = sc.nextInt();
		while(t-->0){
			ob.head=null;
			int n=0;
			n=sc.nextInt();
			int tn =n;
			while(tn-->0){
				int x=0;
				x = sc.nextInt();
				ob.push(x);
			}
            ob.oddEvenList(ob.head);
		}
		sc.close();
		return;
	}
}
