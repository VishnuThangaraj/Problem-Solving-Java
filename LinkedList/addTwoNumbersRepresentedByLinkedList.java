import java.util.*;
import java.io.*;

/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.
The sum list is a linked list representation of the addition of two input numbers from the last.

Input Format
The first line inputs N and M ,the size of two linked lists.
The second line inputs the value of N nodes of 1st linked list.
The third line inputs the value of M nodes of 2nd linked list.

Output Format
Print the sum list.

Example 1
Input
2 3
4 5 
3 4 5

Output
3 9 0

Explaination
For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).

Example 2
Input
3 3
5 4 1 
7 2 5

Output
1 2 6 6 

Explaination
For the given two linked
list (5 4 1) and (7 2 5, after adding
the two linked list resultant linked
list will be (1 2 6 6 ).

Constraints:
1 <= N, M <= 5000
0<= |value of each node| <=9
*/

public class addTwoNumbersRepresentedByLinkedList {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        for(int i = 0; i < n; i++){
            a.add(input.nextInt());
        }
        for(int i = 0; i < m; i++){
            b.add(input.nextInt());
        }
        LinkedList ans = new LinkedList();
        Solution A = new Solution();
        ans.head = A.addTwoLinkedLists(a.head, b.head);
        ans.printList();

    }
}


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
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


class Solution
{
	// function to reverse the linkedlist
	public static Node reverse(Node head){
		Node previous = null;
		Node current = head;
		Node next = current.next;

		while(current!=null){
			current.next = previous;
			previous = current;
			current = next;
			if(next!=null){
				next = next.next;
			}
		}

		return previous;
	}

    public static Node addTwoLinkedLists(Node head1, Node head2)
    {
        //reverse both list
		Node rev1 = reverse(head1);
		Node rev2 = reverse(head2);

		Node result = new Node(0);
		Node resultHead = result;
		int sum =0;
		int carry =0;

		while(rev1!=null && rev2!=null){
			sum = rev1.data + rev2.data + carry;
			carry = 0;
			if(sum > 9){
				carry = sum/10;
				sum%=10;
			}
			result.next = new Node(sum);
			result = result.next;
			rev1 = rev1.next;
			rev2 = rev2.next;
		}

		// if any one of the linked list is small.. perform addition on it
			if(rev1!=null){
				if(carry!=0){
					while(rev1!=null){
						sum = rev1.data+ carry;
						carry = 0;
						if(sum > 9){
							carry = sum/10;
							sum%=10;
						}
						result.next = new Node(sum);
						result = result.next;
						rev1 = rev1.next;
					}
				}else{
						result.next = rev1;
					}
				
			}else if(rev2!=null){
				if(carry!=0){
					while(rev2!=null){
						sum = rev2.data + carry;
						carry = 0;
						if(sum > 9){
							carry = sum/10;
							sum%=10;
						}
						result.next = new Node(sum);
						result = result.next;
						rev2 = rev2.next;
					}
				}else{
						result.next = rev2;
				}
			}

		// carry is remaining after the calculation
			if(carry!=0){
				result.next =  new Node(carry);
				carry = 0;
			}


		resultHead = reverse(resultHead.next);

		return resultHead;
    }
    
}
