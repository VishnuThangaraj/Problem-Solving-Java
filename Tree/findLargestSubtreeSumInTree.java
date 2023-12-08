/*
You are given the root of the tree, find the largest subtree sum in the tree.

Input Format
The only line of input contains the nodes of the tree in level order traversal.

Output Format
The only line of output contains a single integer representing the largest subtree sum in the given tree.

Example 1
Input
1 2 3

Output
6

Explanation: Maximum subtree sum possible is 6.

Example 2
Input
-5 3

Output
3

Explanation: Subtree containing the single node 3 given maximum subtree sum equal to 3.

Constraints:
1 <= Number of nodes <= 1000
-104 <= Node.val <= 104

Topics:
Trees

Companies:
Amazon
Google
Ola
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class findLargestSubtreeSumInTree {
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
            if (i >= ip.length)
                break;
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
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution g = new Solution();
        sc.close();
        int ans = g.largestSubtree(root);
        System.out.println(ans);
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
    Integer subTreeSum = Integer.MIN_VALUE;

    public int helper(Node node){
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);
        int newSum = node.data + left + right;
        
        int maxSub = Math.max(left, right);

        subTreeSum = Math.max(subTreeSum, Math.max(maxSub, newSum));

        return newSum;
    }

    int largestSubtree(Node root) {
        helper(root);
        return subTreeSum;
    }
}
