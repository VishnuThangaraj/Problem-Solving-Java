import java.util.*;
import java.io.*;

/*
Given a singly linked list, delete the middle node of the linked list. 
If there are even nodes, then there would be two middle nodes. We need to delete the second middle element.
After deleting the node, return the head of the linked list.
In the case of a single node, print the head of a linked list containing only one node, which has a value of -1.
You need to complete the given function with the pointer to the head of the linked list.

Input Format
The first line contains the number of test cases.
For each test case: The first line contains an integer N denoting the number of nodes in the linked list.
The second line contains N space-separated integers denoting elements of the linked list.

Output Format
For each test case, return the head of the modified, linked list.

Example 1
Input
1
4
1 2 3 4

Output
1 2 4

Explanation
The Initial Linked List looks like this: 1 -> 2 -> 3 -> 4
There are two middle nodes, 2 and 3.
The second middle node gets deleted, i.e., 3 is deleted.
The Linked List after the operation looks like this: 1 -> 2 -> 4

Example 2
Input
1
5
1 3 5 2 6

Output
1 3 2 6

Explanation
The Initial Linked List looks like this: 1 -> 3 -> 5 -> 2 -> 6
There is only one middle node, 5, which gets deleted.
The Linked List after the operation looks like this: 1 -> 3 -> 2 -> 6

Constraints
1 <= T <= 10
1 <= N <= 10000
1 <= L[i] <= 100000
*/

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class deleteMiddleOfTheLinkedList {
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head); 
            t--;
        }
		sc.close();
    } 
} 
   
class Solution{
    Node deleteMid(Node head){
		if(head.next == null) return null; // single node
		
		Node previous = null;
		Node slow = head;
		Node fast = head;

		// find the middle node
		while(fast!=null && fast.next != null){
			previous = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// remove the middle node
		previous.next = slow.next;
		
		return head;
    }
}
