import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

/*
Given the root node of a tree, whose nodes have their values in the range of integers. 
You are given two nodes x, y from the tree. You have to print the lowest common ancestor of these nodes.
Lowest common ancestor of two nodes x, y in a tree or directed acyclic graph is the lowest node that has both nodes x, y as its descendants.
Your task is to complete the function findLCA which receives the root of the tree, x, y as its parameters and returns the LCA of these values.

Input Format:
The first line contains the values of the nodes of the tree in the level order form.
The second line contains two integers separated by space which denotes the nodes x and y.

Output Format:
Print the LCA of the given nodes in a single line.

Example 1
Input
1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
7 5

Output
1

Explanation
      1
    /   \
  2      3
 /      / \
4      5   6
 \
  7
The root of the tree is the deepest node which contains both the nodes 7 and 5 as its descendants, hence 1 is the answer.

Example 2
Input
1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
4 2

Output
2

Explanation
      1
    /   \
  2      3
 /      / \
4      5   6
 \
  7
The node will value 2 of the tree is the deepest node which contains both the nodes 4 and 2 as its descendants, hence 2 is the answer.

Constraints:
1 <= nodeVal <= 10^9
All the nodes have unique values.
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
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root,x,y);
        System.out.println(ans.data);
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
    public static Node findLCA(Node node,int n1,int n2) {
       // base condition
		if (node == null){
			return null;
		}

		if(node.data ==n1 || node.data == n2){
			return node;
		}

		//check left
		Node left = findLCA(node.left,n1,n2);
		//check right
		Node right = findLCA(node.right,n1,n2);

		//both nodes found
		if(left!=null && right!=null){
			return node;
		}
		
		if(left!=null){
			return left; //both nodes lies left side
		}

		return right; //both nodes will lies on right side
    }
}
