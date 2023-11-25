/*
Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Input Format
Given a root of the tree and target sum, you need to return the boolean variable. N represents null pointer for empty tree value.

Output Format
Return true or false.

EXAMPLE 1
Input
5 4 8 11 N 13 4 7 2 N N N 1 N N N N N N
22

Output
true

EXPLANATION
The root-to-leaf path with the target sum is shown.

EXAMPLE 2
Input
1 2 3 N N N N
5

Output
 false
 
EXPLANATION
There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

CONSTRAINTS
The number of nodes in the tree is in the range [0, 5000].
1 <= Node.val <= 10000
0 <= targetSum <= 10000

Companies :
Amazon
Facebook
Google
*/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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


public class pathSum {
    static Node buildTree(String str){
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
            Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();
		    int sum = sc.nextInt();
			Node root = buildTree(s);
			Solution tree = new Solution();
			boolean result=tree.hasPathSum(root,sum);
			System.out.print(result);
	}
}
  


class Solution{
    public boolean hasPathSum(Node root, int sum) {
        // Base Case
        if(root == null) return false;
	   if(root.left == null && root.right == null){
           if(sum == root.data) return true;
           return false;
       }

        return hasPathSum(root.right, sum - root.data) || hasPathSum(root.left, sum - root.data);
    }
}
