import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
Given the root of a binary tree, return the preorder traversal of its nodes'' values.
Note: You just need to implement the preorderTraversal() function. 
Input and output have been handled in the driver code.

Input Format
First line contains a string representing the tree as described below.
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

Output Format
Print the preorder traversal of the tree.

Example 1
Input
6 5 6 1 1 N 6

Output
6 5 1 1 6 6 

Explanation
The given tree can be represented as:- 
        6
       / \
      5   6
     / \   \
    1   1   6
The preorder traversal of the tree is :- 6 5 1 1 6 6 

Example 2
Input
1 2 3 2 2 N 6 2 N N N N N N N

Output
1 2 2 2 2 3 6 

Explanation
The given tree can be represented as: -

             1
            / \
           2   3
          / \   \
         2   2   6
        /   
       2   
The preorder traversal of the tree is :- 1 2 2 2 2 3 6  

Constraints
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			  tree.preorderTraversal(root);
            
		
	}
}
  


class Solution {

	

	public static void preorderTraversal(Node node) {
		if(node == null){
            return;
        }
        //print node first
        System.out.print(node.data+" ");
        //recursive left 
        preorderTraversal(node.left);
        //recursive right
        preorderTraversal(node.right);
        
	}
}
