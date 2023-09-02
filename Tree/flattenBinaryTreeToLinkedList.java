import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
Given the root of a binary tree, flatten the tree into a "linked list":
The "linked list" should use the same Node class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Input Format
The first line contains the number of test cases.
For each test case: You are given a string representing the nodes of the tree, N is null .

Output Format
For each test case flatten the binary tree to the linked list.

Example 1
Input
1
1 2 3

        1
       / \
      2   3
      
Output
1 2 3

Explanation
After flattening, the tree looks like this:

    1
     \
      2
       \
        3
The in-order traversal of this flattened tree is 1 2 3.

Example 2
Input
1
1 2 3 4

      1
    /   \
   2     3
 / 
4

Output
1 2 4 3

Explanation
After flattening, the tree looks like this:

    1
     \
      2
       \
        4
         \
          3
The in-order traversal of this flattened tree is 1 2 4 3.

Constraints
1 <= T <= 10
1 <= N <= 1000
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                ob.flatten(root);
                printInorder(root);
                System.out.println();
                    t--;
            
        }
    }
}

class Solution
{
    public static void flatten(Node root){
        Node current = root; 

		while(current!=null){
			if(current.left!=null){
				current.right = attachToRight(current.left,current.right);
				current.left = null; //remove connection on left side
			}
			current = current.right;
		}
    }

	//function to attach the node to the rightMost node 
	private static Node attachToRight(Node root, Node node){
		if(root == null){
			return node;
		}

		root.right = attachToRight(root.right,node);

		return root;
	}
}
