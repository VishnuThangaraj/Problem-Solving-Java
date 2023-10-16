import java.io.*;
import java.util.*;

/*
Compare the data in the nodes of the linked lists to check if they are equal. 
If all data attributes are equal and the lists are of same length, print 1. Otherwise, print 0.

Input Format
The first line contains two integers m and n, the number of nodes in the first linked list and second linked list respectively.
Second line contains m spaced integers, each a value for a data attribute of list 1.
Third line contains n spaced integers, each a value for a data attribute of list 2.

Output Format
Compare the two linked lists and print 1 if the lists are equal. Otherwise, print 0.

Example 1
Input
2 1
1 2
1

Output
0

Explanation
Linked list 1= 1->2->NULL
Linked list 2= 1->NULL
It is clearly visible that the two linked lists are not equal. Therefore, print 0.

Example 2
Input
4 4
1 2 3 4
1 2 3 4

Output
1

Explanation
Linked list 1= 1->2->3->4->NULL
Linked list 2= 1->2->3->4->NULL
It is clearly visible that the two linked lists are equal. Therefore, print 1.

Constraints
1<=n,m<=1000
1<=llist1[i],llist2[i]<=1000
*/

public class compareTwoLinkedList {

static class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
static class LinkedList{
	
    Node head;
	LinkedList(int data){
		Node node = new Node(data);
		head = node;
	}
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
	void checkElement(LinkedList first, LinkedList second){
		Node one = first.head;
		Node two = second.head;
		while(one!=null && two!=null){
			if(one.data != two.data){
				System.out.println(0);
				return;
			}
			one = one.next;
			two = two.next;
		}
		System.out.println(1);
	}
}    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

		//get size;
		int size1 = sc.nextInt();
		int size2 = sc.nextInt();

		LinkedList one = new LinkedList(0);
		LinkedList two =new LinkedList(0);
		
		//add elements
		for(int i=0;i<size1;i++){
			int n =sc.nextInt();
			one.add(n);
		}
		for(int j=0;j<size2;j++){
			int n =sc.nextInt();
			two.add(n);
		}		
		if(size1 != size2){
			System.out.println(0);
			return;
		}

		one.checkElement(one,two);
    }
}
