import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

/*
Given a root of a binary tree, write a function to get the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

Input Format
You are given a string s which describes the nodes of the binary tree. (The first element corresponds to the root, the second is the left child of the root and so on). In the function, you are provided with the root of the binary tree.

Output Format
Return the diameter of the binary tree.

Example 1
Input
8 2 1 3 N N 5

Output
5

Explanation
The longest path is between 3 and 5. The diameter is 5.

Example 2
Input
1 2 N

Output
2

Explanation
The longest path is between 1 and 2. The diameter is 2.

Constraints
1 <= N <= 10^5
1 <= Node Data <= 10^5
*/

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        System.out.println(g.diameter(root1));
    }
}


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    
    public static int diameter(Node root) {
        int[] range = new int[1];
		diameter(root,range);
		return range[0]+1;
    }

	//find diameter
	public static int diameter(Node node,int[]range){
		if(node == null){
			return 0;
		}

		//first left
		int Left = diameter(node.left,range);
		//then right
		int Right = diameter(node.right,range);

		//max of left+right vs range already in array
		range[0] = Math.max(range[0], Left+Right);

		return 1+Math.max(Left,Right);
	}
}
