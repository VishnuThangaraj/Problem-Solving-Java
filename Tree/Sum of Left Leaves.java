/*
Given the root of a binary tree, return the sum of all left leaves.
A left leaf is a node that is a left child of another node and has no children of it''s own.

Input Format
The first line contains the number of test cases.
For each test case: You are given a pointer to the root of the binary tree.

Output Format
Complete the function SumLeftLeaves() which returns the required integer.

Example 1
Input
1
1 2 3

Output
2

Explanation
The tree can be imagined as
  1
 / \
2   3
So the left leaves are {2}. Thus the sum of all left leaves is 2.

Example 2
Input
1
1

Output
0

Constraints
1 <= number of testcases <= 10
1 <= number of nodes in the tree <= 1000
1 <= nodes.val <= 1000
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.lang.*;

class Solution {
    int leftSum(TreeNode node, boolean isLeft){
        if(node == null) return 0; 

        if(isLeft && node.left == null && node.right == null)
            return node.data;

        return leftSum(node.left, true) + leftSum(node.right, false);
    }
    int SumLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null)
            return 0;

        return leftSum(root, false);
    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            int ans = ob.SumLeftLeaves(root);
            System.out.println(ans);
            t--;
        }
    }
}
