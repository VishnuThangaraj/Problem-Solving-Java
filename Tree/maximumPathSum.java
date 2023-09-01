import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
You are given a binary tree.
Your task is to find the maximum path sum in the given binary tree.

Note
The path can start and end at any node.
You are given a pointer to the root of the binary tree.
You don't need to take input. You need to complete the given function.

Input Format
Input has been managed for you.
In example input, the first line contains the number of test cases.
The next line contains the input to the graph.

Output Format
For each test case, return an integer denoting the maximum sum.

Example 1
Input
1
1 2 3 N N N N

Output
6

Explanation
The tree looks like this:
    1
   / \
  2   3
Path 2 -> 1 -> 3 gives the maximum sum. Thus, the answer is 6.

Example 2
Input
1
5 4 3 -5 N N N N N

Output
12

Explanation
The tree looks like this:
      5
    /   \
   4     3
  /
 -5
Path 4 -> 5 -> 3 gives the maximum sum. Thus, the answer is 12.

Constraints
1 <= Number of nodes <= 1000
-1000 <= Value of node <= 1000
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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Solution tr=new Solution();
	            int sum=tr.findMaxSum(root);
	            System.out.println(sum);
	        }
	}
}

class Solution
{
    int findMaxSum(Node node){
       //use helper function
		int[]route = new int[1];
		route[0] = Integer.MIN_VALUE;
		findMaxSum(node,route);
		return route[0];
    }   

	int findMaxSum(Node node, int[]route){
		if(node == null){
			return 0;
		}

		int left = findMaxSum(node.left,route);
		int right = findMaxSum(node.right,route);

		//decide to take left or right or the node alone
		int takeNode = Math.max(Math.max(left,right)+node.data,node.data);

		//decide to take left and right or the take node
		int top = Math.max(takeNode,left+right+node.data);
		
		route[0]= Math.max(top,route[0]);

		return takeNode;
	}
}
