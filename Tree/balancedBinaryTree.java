import java.util.*;

/*
Given a binary tree, determine if it is height-balanced.
A height balanced tree is a tree in which absolute difference of the left and right subtrees for every node is less than or eual to 1.

Input Format
First line consists of an integer n, the number of nodes in the binary tree
The next line contains n spaced integers, representing the level order traversal of the binary tree

Output Format
Print true if the binary tree is height balanced else print false

Example 1
Input
5
3 9 20 15 7

Output
false

Explanation
Left and right subtree difference for atleast one node is > 1

Example 2
Input
7
1 2 2 3 3 4 4

Output
false

Explanation
Left and right subtree difference for node 1 itself is 2 (> 1)

Constraints
0 <= n <= 5000
-10^4 <= node.value <= 10^4
*/

public class balancedBinaryTree {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  // function to construct a BST from
  // its level order traversal
  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  public static boolean isBalanced(Node root) {
     if(root == null){
		 return true;
	 }

	  //find height
	  return Math.abs(height(root.left,0) - height(root.right,0)) <=1 && isBalanced(root.left) && isBalanced(root.right);
  }

  //FUNCTION TO FIND THE HEIGHT
	static  int height(Node root,int height){
		if(root == null){
			return height;
		}

		return Math.max(height(root.left,height+1),height(root.right,height+1));
	}

	

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    if (isBalanced(root)) System.out.println("true"); else System.out.println(
      "false"
    );
  }
}

class Node {

  int data;
  Node left, right;
}
