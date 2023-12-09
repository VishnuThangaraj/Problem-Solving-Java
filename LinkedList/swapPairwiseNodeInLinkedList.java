/*
Your are given a linked List consisting of N nodes. Your task is to swap elements pairwise.
You have to complete pairWiseSwap function which consists of head node as input and prints the linkedlist after required operation

Input Format
The first line contains the number of test cases. For each test case:
Second line consists of a single integer n denoting length of linked list.
Third line consists of N space separated integers denoting the elements of linked list.

Output Format
For each test case print an array in a new line, denoting the values of the changed Linked List.

Example 1
Input
1
4
1 2 3 4

Output
2 1 4 3

Explanation
The Initial Linked List looks like:
1 -> 2 -> 3 -> 4
The elements in array are pairwise swapped.
The Linked List after swapping looks like:
2 -> 1 -> 4 -> 3

Example 2
Input
1
4
1 3 5 2

Output
3 1 2 5

Explanation
The elements are pairwise swapped.

Constraints
1 <= T <= 10
1 <= N <= 10^4
1 <= L[i] <= 10^5

Topics:
Linked Lists

Companies:
Microsoft
Amazon
Intuit
*/

import java.util.*;

class Solution{  
	void pairWiseSwap(Node head)
	{
        if(head == null || head.next == null)
            return;

        Node previous = null;
        Node current = head;
        Node next = current.next;

        while(next != null){
            current.next = next.next;
            next.next = current;
            if(previous == null){
                head = next;
            }else{
                previous.next = next;
            }

            // Move nodes
            previous = current;
            current = previous.next;
            if (current == null) break;
            next = current.next;
        }

        Node print = head;

        while(print != null){
            System.out.print(print.data+" ");
            print = print.next;
        }
        System.out.println();
	}
}
public class swapPairwiseNodeInLinkedList {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            LinkedList llist= new LinkedList(); 
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
            {
                int a = sc.nextInt(); 
                llist.addToTheLast(new Node(a));
            }    
			Solution A = new Solution();
	        A.pairWiseSwap(llist.head);
        }  
    }
}

class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
class LinkedList
{
    Node head;  
    Node tail;
    public void addToTheLast(Node node) 
    {
      if (head == null) 
      {
       head = node;
       tail = node;
      } 
      else 
      {
       tail.next = node;
       tail = node;
      }
    }
      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }   
}
