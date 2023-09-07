import java.util.*;
import java.io.*;

/*
You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return true. 
If such a node does not exist, return false.

Input Format
The first line inputs N, the number of nodes and X, value of the node to find.
The second line inputs the value of N nodes of the BST.

Output Format
Print "YES" if node is present else "NO" in a new line.

Example 1
Input
7 87
2 81 42 87 90 42 45 66

Output
YES

Explaination
   2
    \
    81
   /  \
  42   87
 /  \   \
45  66   90
As 87 is present in the given nodes , so the output will be YES.

Example 2
Input
7 69
2 81 42 87 90 42 45 66

Output
NO

Explaination
   2
    \
    81
   /  \
  42   87
 /  \   \
45  66   90
As 69 is not present in the given nodes , so the output will be NO.

Constraints
1 <= N <= 1000
1000 <= val[node] <= 1000
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
    public boolean searchNode(Node root,int k){
        if(root == null){
			return false;
		}

		//check current node
		if(root.val == k){
			return true; //value found
		}

		if(k > root.val){
			//search right
			return searchNode(root.right,k);
		}

		if(k < root.val){
			//search left
			return searchNode(root.left,k);
		}

		return false;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        boolean result= obj.searchNode(t.root,k);
        if(result){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
        
    }
}
