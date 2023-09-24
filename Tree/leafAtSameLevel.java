import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given the root node of a binary tree, your task is check if all the leaf nodes are at same level or not.

Input Format
The first line of input contains a string representing the nodes.

Output Format
Return true if all the leaf nodes are at same level, else retrun false.

Example 1
Input
1 2 3

Output
1

Explanation
leaf node 2 and 3 are at same level.

Example 2
Input
10 20 30 10 15

Output
0

Explanation
            10
          /    \
        20      30
       /  \        
     10    15
node 10,15 and 30 are not all at same level.

Constraints
1 <= total number of nodes <= 103
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

public class leafAtSameLevel
{
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the storage
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node''s value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }


    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String s = br.readLine();
        Node root = buildTree(s);
    
        Solution g = new Solution();
        boolean b = g.check(root);
        if(b == true)
            System.out.println(1);
        else
            System.out.println(0);
    
    }
}

class Solution
{
    
    boolean check(Node root)
    {
	    Queue<Node> storage = new LinkedList<>();
		storage.offer(root);
		boolean leaf = false;

		while(!storage.isEmpty()){
			if(leaf) return false; //node found next level of leaf

			int size = storage.size();

			for(int i=0; i<size; i++){
				Node current = storage.poll();

				if(current.left == null && current.right == null)
					leaf = true; //leaf found at the level

				// ADD THE LEFT AND RIGHT CHILDS TO QUEUE
				 if(current.left != null)
					storage.offer(current.left);
				if(current.right != null)
					storage.offer(current.right);
			}
		}
		return true;
    }
}
