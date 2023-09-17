import java.util.*;

/*
You are provided with root of a valid Binary Search Tree and and the lowest and highest boundaries as low and high.
Your task is to trim the tree so that all its elements lies in [low, high]. 
Trimming the tree should not change the relative structure of the elements that will remain in the tree 
(i.e., any node's descendant should remain a descendant). 
It can be proven that there is a unique answer.
A Binary Search Tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, 
and any descendant of Node.right has a value strictly greater than Node.val.

NOTE: You have to complete the function trimTree. The input and output is already handled.

Input Format
First line contains three space separated integers n,low,high denoting the nodes in the BST, lower boundary and the higher boundary.
Second line contains n space-seprated integers denoting InOrder traversal of the tree

Output Format
Output contains the inorder traversal of trimmed tree.

Example 1
Input
6 3 6
2 3 4 5 6 7

Output
3 4 5 6

Explanation
The nodes in the trimmed tree are in range [3,6]

Example 2
Input
6 4 8
2 3 4 5 6 7

Output
4 5 6 7

Explanation
The nodes in the trimmed tree are in range [4,8]

Constraints
1<=n<=10^4
-10^4<=node.val,low,high<=10^4
*/

class Node {
    int val;
    Node left, right;
    public Node(int item){
        val = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)return null;
        int mid=(start+end)/2;
        if(root==null)root=new Node(arr[mid]);
        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);
        return root;
    }

    void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}

class Solution{
    public static Node trimTree(Node root, int low, int high){
        if(root == null){
			return null; //reached end
		}

		if(root.val >= low && root.val <= high){ //root lies in the range
			//check for left and right nodes
			root.left = trimTree(root.left,low,high);
			root.right = trimTree(root.right,low,high);
		}
		
		if(root.val < low){ //root is small see the right side for bigger nodes
			return trimTree(root.right,low,high);
		}else if(root.val > high){ // root is large...see the left side for smaller nodes
			return trimTree(root.left,low,high);
		}

		return root;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int low = sc.nextInt();
        int high = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); 
        }
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        Node ans = A.trimTree(root,low,high);
        bst.printInorder(ans);
    }
}
