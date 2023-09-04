import java.util.*;
import java.io.*;

/*
You are given two arrays of size N each. They represent the preorder and inorder traversals of a binary tree.
You need to construct the original binary tree with their help. You need to print the postorder traversal of the formed tree.
NOTE You need to complete the given function and return the head node. The input and printing of output will be handled by the driver code.

Input Format
You are given an integer N, denoting the size of the tree.
The second line contains N space-separated integers denoting the preorder traversal.
The third line contains N space-separated integers denoting the in-order traversal.

Output Format
Print the postorder traversal of the tree.

Example 1
Input
6
10 11 23 24 12 35
23 11 24 10 35 12

Output
23 24 11 35 12 10

Explanation
You can check the postorder from the given tree.

Example 2
Input
4
1 2 3 4
1 2 4 3

Output
4 3 2 1

Explanation
You can check the postorder from the given tree.

Constraints
1 <= N <= 10000
*/

class Node{
    int data; 
    Node left, right;
    Node(int key){
        data = key;
        left = right = null;
    }
}

class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for(int i = 0; i < n; i++)
          preorder[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
          inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }
    
    public static void postOrdrer(Node root){
        if(root == null)
          return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}


class Solution{
    public static Node buildTree(int inorder[], int preorder[], int n){
        if(preorder.length == 0){
			return null; //check any one inorder or preorder
		} 

		int root = preorder[0]; //root node
		int index =0;
		
		//find the root index in the inorder
		for(int ind=0; ind<inorder.length; ind++){
			if(inorder[ind] == root){
				index = ind;
				break; // root in in-order found
			}
		}

		Node node = new Node(root); //root or parent

		//find for left and right side of tree
		//make copy of the Array
		node.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(preorder,1,index+1),n);
		node.right = buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),Arrays.copyOfRange(preorder,index+1,preorder.length),n);

		return node;
    }
}
