import java.util.*;
import java.io.*;

/*
You are given N nodes and have to form BST from it. 
You are given a key K, delete node with value K.

Note If K is not present in the BST, do not modify the BST.

Input Format
The first line inputs N, the number of nodes and K, key.
The second line inputs the value of N nodes of the BST.

Output Format
Print the preorder traversal of the updated BST in a new line.

Example 1
Input
7 42
2 81 42 87 90 41 66

Output
2 81 66 41 87 90 

Explaination
     2
      \
      81
     /  \
   42    87
  /  \    \
 41   66   90
As 42 is present in the given nodes, so the node 42 will deleted and the updated tree will be like 

     2
      \
      81
     /  \
   66    87
  /       \
 41       90
The preorder will be 2 81 66 41 87 90.

Example 2
Input
7 41
2 81 42 87 90 41 66

Output
2 81 42 66 87 90 

Explaination
     2
      \
      81
     /  \
   42    87
  /  \    \
 41   66   90
As 41 is present in the given nodes, so the node 41 will deleted and the updated tree will be like 

     2
      \
      81
     /  \
   42    87
     \    \
      66   90

The preorder will be 2 81 42 66 87 90 .

Constraints
1 <= N <= 1000
-1000 <= Val[node], K <= 1000
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
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
	//left most node
	private int getLeft(Node node){
		if(node.left == null){
			return node.val; //leftmost node found
		}
		//move left
		return getLeft(node.left);	
	}
    public Node deleteNode(Node root, int val){
        //find the node to be deleted
		if(root == null){
			return null;
		}

		//value to be deleted found
		if(root.val == val){
			//no child nodes delete the node directly
			if(root.right == null && root.left == null){
				return null; //node deleted 
			}
			//right is empty for the deleting node
			if(root.right == null){
				return root.left;
			}
			//left is empty for the deleting node
			if(root.left == null){
				return root.right;
			}
			//has left and right nodes
			//get the leftmost node on right side (or) right-most node on the left side
			root.val = getLeft(root.right);
			root.right = deleteNode(root.right,root.val);
		}

		else if(root.val < val){
			//search right
			root.right = deleteNode(root.right,val);
		}
		else{
			//search left
			root.left = deleteNode(root.left,val);
		}

		//return current node
		return root;
    }
}

public class deleteANodeFromBST {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}
