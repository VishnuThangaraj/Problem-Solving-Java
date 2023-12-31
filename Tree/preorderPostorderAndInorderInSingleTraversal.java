import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
Given the root of a binary tree, You need to print the Preorder, Inorder and Postorder traversals of the binary tree.
Note: You just need to implement the allTraversal() function and print Preorder, Inorder and Postorder traversals of the tree

Input Format
First line contains a string representing the tree as described below.
The values in the string are in the order of level order traversal of the tree where, 
numbers denote node values, and a character “N” denotes NULL child.

Output Format
Print three lines. In the first line print the preorder traversal of the tree. 
In the second line print inorder traversal of the tree. In the third line print postorder traversal of the tree.

Example 1
Input
6 5 6 1 1 N 6

Output
6 5 1 1 6 6 
1 5 1 6 6 6 
1 1 5 6 6 6 

Explanation
The given tree can be represented as:- 
       *6*
       / \
      5   *6*
     / \    \
    1   1    *6*
Preorder Traversal: 6 5 1 1 6 6 
Inorder Traversal: 1 5 1 6 6 6 
Postorder Traversal: 1 1 5 6 6 6 

Example 2
Input
1 2 3 2 2 N 6 2 N N N N N N N

Output
1 2 2 2 2 3 6 
2 2 2 2 1 3 6 
2 2 2 2 6 3 1 

Explanation
The given tree can be represented as: -
             1
            / \
          *2*  3
          / \   \
        *2* *2*  6
        /   
      *2*  
Preorder Traversal: 1 2 2 2 2 3 6 
Inorder Traversal: 2 2 2 2 1 3 6 
Postorder Traversal: 2 2 2 2 6 3 1 

Constraints
The number of nodes in the tree is in the range [0, 104].
<li><code>-1000 <= Node.val <= 1000</code></li>
<li>The depth of the tree will not exceed <code>1000</code>.</li>
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


public class preorderPostorderAndInorderInSingleTraversal {
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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			tree.allTraversal(root);
            
		
	}
}
  


class Solution {

	static class Pair{
		Node node;
		int occ;
		Pair(Node node, int occ){
			this.node = node;
			this.occ = occ;
		}
	}

	public static void allTraversal(Node root) {
		ArrayList<Integer> inorder = new ArrayList<>();
		ArrayList<Integer> preorder = new ArrayList<>();
		ArrayList<Integer> postorder = new ArrayList<>();

		Stack<Pair> storage = new Stack<>();
		storage.push(new Pair(root,1));

		while(!storage.isEmpty()){
			Pair current = storage.peek(); //dont remove from stack

			if(current.occ == 1){
				preorder.add(current.node.data); //add to preorder in first occurance
				//increase the occurance
				current.occ++;
				//add left node to stack if not null
				if(current.node.left != null)
					storage.push(new Pair(current.node.left, 1));
			}
			else if(current.occ == 2){
				inorder.add(current.node.data); //add to inorder in second occurance
				//increase the occurance
				current.occ++;
				//add right node to stack if not null
				if(current.node.right != null)
					storage.push(new Pair(current.node.right, 1));
			}
			else{
				postorder.add(current.node.data); // add to postOrder in third occurance
				//remove from stack
				storage.pop();
			}
		}

		// print the arraylist containing of orders
		for(int pre : preorder)
			System.out.print(pre+" ");

		System.out.println(); //spacing
		
		for(int in : inorder)
			System.out.print(in+" ");

		System.out.println(); //spacing
		
		for(int post : postorder)
			System.out.print(post+" ");
	}
}
