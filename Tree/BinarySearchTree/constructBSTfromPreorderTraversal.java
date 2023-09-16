import java.util.*;

/*
You are given an array preOrder consisting of PreOrder Traversal of a valid Binary Search Tree.
Your task is to create a unique Binary Search Tree are return the head node of the tree.
A Binary Search Tree is a binary tree where for every node, any descendant of Node.
left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

NOTE
You just need to complete the CreateTree function and return the head node of the tree generated.

Input Format
First line contains an integer n denoting the nodes in the BST.
Second line contains n space-seprated integers denoting PreOrder traversal of the tree

Output Format
For each node in the array print the a line in folowing format:
Node.left.val->Node.val<-Node.right.val
If, Any node is null print ..

Example 1
Input
6
3 2 1 6 5 7

Output
2->3<-6
1->2<-.
.->1<-.
5->6<-7
.->5<-.
.->7<-.

Explanation
The Binary Search Tree for Following input would be

          3
        /   \
       2     6
      /     / \
     1     5   7
Hence the output shows the child nodes for each node.

Example 2
Input
6
8 5 1 7 10 12

Output
5->8<-10
1->5<-7
.->1<-.
.->7<-.
.->10<-12
.->12<-.

Explanation
The Binary Search Tree for Following input would be

          8
        /   \
       5     10
      / \     \
     1   7     12
Hence the output shows the child nodes for each node.

Constraints
0 <= n <= 10^9
-10^9 <= preOrder[i] <= 10^9


*/

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode CreateTree(int n,int[] preOrder) {
        if(preOrder.length == 0){
			return null; //bottom of the tree / empty tree
		}

		TreeNode root = new TreeNode(preOrder[0]); //first element will be parent/root in preorder

		int left = 1;
		// range till left elements in array
		for(int index=1; index<preOrder.length; index++){
			if(preOrder[index]>preOrder[0]){
				left = index;
				break;
			}
		}

		//child nodes
		root.left = CreateTree(n,Arrays.copyOfRange(preOrder,1,left));
		root.right = CreateTree(n,Arrays.copyOfRange(preOrder,left,preOrder.length));

		return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
