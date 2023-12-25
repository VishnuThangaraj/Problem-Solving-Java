/*
You are given a pointer to the root of a binary tree. 
A node node of a binary tree is called good, if all the nodes in the path from the root to node have a value less than or equal to the root.
You have to count the number of good nodes in the given tree.
NOTE The input and printing of output will be handled by the driver code.
You need to complete the given function which has the pointer to the root of the binary tree.

Input Format
Input consists of a single line consisting of the tree. N represents Null.

Output Format
Return the count of good nodes.

Example 1
Input
1 2 3

Output
1

Explanation
  1
 / \
2   3
Only the root is good. 2 and 3 are not good because they are greater than root.

Example 2
Input
2 2 1 N N 4

Output
3

Explanation
  2
 / \
2   1
   /
  4
4 is not good because it has a value greater than the root node. 
The rest of the nodes are good because in their respective paths from the root, no node exists with a value greater than the root.

Constraints
1 <= N <= 10000
1<= Value of Node <= 1000000000

Topics
Trees
DFS

Companies
Adobe
Flipkart
Amazon
Atlassian
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

public class goodNodes {
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
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.goodNodes(root);
        System.out.println(ans);  
	}
}
  
class Solution{
    int goodNodes(Node root) {
        if(root == null) return 0;
		return findGood(root, root.data, 0);
    }
    int findGood(Node node, int max, int count){
        if(node == null) return 0;

        if(node.data > max){
            return count;
        }

        return (count+1) + findGood(node.left, max, 0) + findGood(node.right, max, 0);
    }
}
