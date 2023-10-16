import java.util.*;
import java.io.*;

/*
You are given the number of nodes present in the tree. You have to input the nodes and form a Binary Search Tree (BST).
BST should be formed in ways like:
Let us consider an array named Val having the values of the nodes. Here, Val[0] will be the root of BST. 
Then, you have to insert Val[1] in the BST, then insert Val[2] in the BST, and so on...
After forming the BST, convert it into its mirror.
Print the Inorder traversal of the mirror tree.

Input Format
The first line contains an integer n, the number of nodes.
The next line inputs the value of n nodes.

Output Format
Print the Inorder traversal of the mirror tree as a single line of space-separated values.

Example 1
Input
6
1 2 5 3 4 6

Output
6 5 4 3 2 1  

Explanation
The BST is like this:-
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
Its mirror view is:

       1
      /
     2
    /            
   5
  / \
 6   3
    /
   4 
So,the inorder order traversal of mirror tree results in 6,5,4,3,2,1 as the required result.

Example 2
Input
3
2 1 3

Output
3 2 1

Explanation
The BST is like this:-

    2
   / \
  1   3
Its mirror view is:
    2
   / \
  3   1
So, the in-order traversal of mirror tree results in 3,2,1 as the required result.

Constraints
1 <= n <= 500
-100 <= val[node] <= 100
*/

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val > root.val){
            root.right = insert(root.right, val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }
    Node mirror(Node mainRoot, Node mirrorRoot){
        // create mirror node
		mirrorRoot = new Node(mainRoot.val);

		if(mainRoot.left != null)
			// copy left root to right of mirroRoot
			mirrorRoot.right = mirror(mainRoot.left, mirrorRoot.right);

		if(mainRoot.right != null)
			// copy right root to right of mirroRoot
			mirrorRoot.left = mirror(mainRoot.right, mirrorRoot.left);

		return mirrorRoot;
    }
}

public class mirrorImageOfTheBinaryTree {
    public static void traversal(BST t, Node curr){
        if(curr == null)
            return;
        traversal(t, curr.left);
        System.out.print(curr.val + " ");
        traversal(t, curr.right);
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        BST mirror = new BST();
        mirror.root = t.mirror(t.root, mirror.root);
        traversal(mirror, mirror.root);
    }
}
