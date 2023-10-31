import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. 
This path may or may not pass through the root.
The length of the path between two nodes is represented by the number of edges between them.
Note: You just need to implement the longestUnivaluePath() function. Input and output have been handled in the driver code.

Input Format
First line contains a string representing the tree as described below.
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

Output Format
Print the length of the longest path, where each node in the path has the same value

Example 1
Input
6 5 6 1 1 N 6

Output
2 

Explanation
The given tree can be represented as:- 
       *6*
       / \
      5   *6*
     / \    \
    1   1    *6*
The longest path is of length 2 which consists of all 6.
The nodes in the path are reprsented by *.

Example 2
Input
1 2 3 2 2 N 6 2 N N N N N N N

Output
3 

Explanation
The given tree can be represented as: -
             1
            / \
          *2*  3
          / \   \
        *2* *2*  6
        /   
      *2*   
The longest path is of length 2 which consists of all 6.
The nodes in the path are reprsented by *.

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


public class longestUnivaluePath {
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
			  System.out.print(tree.longestUnivaluePath(root));
            
		
	}
}
  


class Solution {

    static int ans;

    public static int findPath(Node root){
        if(root == null) return 0;

        // Sub-Trees
        int left = findPath(root.left);
        int right = findPath(root.right);

        int leftMax = 0, rightMax = 0;
        // check for same values
        if(root.left != null && root.left.data == root.data){
            leftMax += left + 1;
        }
        if(root.right != null && root.right.data == root.data){
            rightMax += right + 1;
        }

        // Update answer
        ans = Math.max(ans, leftMax+rightMax);
        return Math.max(leftMax, rightMax);
    }

	public static int longestUnivaluePath(Node root) {
		ans = 0;
        findPath(root);
        return ans;
	}
}
