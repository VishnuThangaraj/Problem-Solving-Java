import java.util.*;

/*
You are given two arrays of size N each. They represent the postorder and inorder traversals of a binary tree.
You need to construct the original binary tree with their help and return a pointer to the head of the tree.

NOTE: You need to complete the given function. The input and printing of output will be handled by the driver code.

Input Format
For each test case: You are given an integer N, denoting the size of the tree.
The second line contains N space-separated integers denoting the postorder traversal.
The third line contains N space-separated integers denoting the in-order traversal.

Output Format
For each test case, return the root of the binary tree. For reference, preorder traversal is shown in the output.

Example 1
Input
5
23 24 11 35 12 10
23 11 24 10 35 12

Output
10 11 23 24 12 35

Explanation
The tree looks like this:

    10
   /  \
  11   12
 / \   /
23 24 35
You can check the preorder from the given tree.

Example 2
Input
4
4 3 2 1
1 2 4 3

Output
1 2 3 4

Explanation
The tree looks like this:
1
 \
  2
   \
    3
   /
  4  
You can check the preorder from the given tree.

Constraints
1 <= N <= 10000
1 <= pos[i] <= 100000
1 <= in[i] <= 100000
*/

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class Main {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main ip = new Main();
        int T = 1;
        while (T > 0) {
            int n = sc.nextInt();
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            Solution g = new Solution();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
        sc.close();
    }
}

class Solution {
    Node buildTree(int in[], int post[], int n){
        if(post.length==0){
			return null; //if any of the array become 0 (in or post)
		}

		int root = post[post.length-1];
		int index=0;

		//find the root in 
		for(int ind =0 ; ind<in.length; ind++){
			if(in[ind] == root){
				index = ind;
				break; //parent / root node index found
			}
		}

		//create the node
		Node node = new Node(root);

		//find the left and right of the current node
		node.left = buildTree(Arrays.copyOfRange(in,0,index),Arrays.copyOfRange(post,0,index),n);
		node.right = buildTree(Arrays.copyOfRange(in,index+1,in.length),Arrays.copyOfRange(post,index,post.length-1),n);

		return node;
    }
}
