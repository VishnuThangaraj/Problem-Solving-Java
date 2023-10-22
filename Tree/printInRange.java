import java.util.*;

/*
You are a given a head node of partially constructed BST. 
You have also been a given 2 integer a and b, your task is to print all the nodes between a and b in increasing order.

Input Format
The first line of input contains a number n, representing the number of nodes.
The second line of input contains an integer array representing the nodes.
The third line of input contains a single integer a.
The fourth line of input contains a single integer b.

Output Format
You need to print all the nodes between the range of a and b in increasing order, present in the given BST.

Example 1
Input
3
2 1 3
1
3

Output
1
2
3

Explanation
  2
 / \
1   3
The given tree has all the nodes between 1 and 3.

Example 2
Input
5
2 4 15 6 3
6
100

Output
6
15

Explanation
  2
   \
    4
   /  \
  3   15
      /
      6
The given bst has just 6 and 15 in range of 6 and 100.

Constraints
1 <= N <= 1000
1 <= value of each node <= 104
1 <= a <= b <= 104
*/

class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}

public class printInRange {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt(); 
        }
        int a=sc.nextInt();
        int b=sc.nextInt();

        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
            
        Solution A = new Solution();
        A.solve(root,a,b);
        
    }
}

class Solution
{
    public static void solve(Node node,int a,int b)
    {
        if(node == null) return;

		solve(node.left,a,b);
		
		if(node.data >= a && node.data <=b)
			System.out.println(node.data);
		
		solve(node.right,a,b);
		
    }
}
