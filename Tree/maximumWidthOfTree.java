import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

/*
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

Input Format
The first line of input contains a number n.
The second line of input contains n space seperated integer.

Output Format
Return the maximum width of the given tree.

Example 1
Input
7
1 2 3 4 5 6 7

Output
4

Explanation
The given binary tree is 
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
the maximum width is at 3rd level {4,5,6,7}

Example 2
Input
4
1 2 3 4

Output
2

Explanation
The given tree is
            1
          /   \
         2     3
        /  
       4
The maximum width exists in the second level with length 2 (3,2).

Constraints
1 <= n <= 103
*/

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

class Main {
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
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Solution {

    public int solve(Node root) {
        //get height to traverse each level of tree
        int height = height(root, 0);
		int maxWidth = 0;

		//run the loop height times
		for(int level=1; level<=height; level++){
			maxWidth = Math.max(maxWidth, getWidth(root,level,1));
		}

		return maxWidth;
    }

	//get height of the tree
	public int height(Node node, int level){
		if(node == null){
			return level;
		}

		//max of left and right tree height
		return Math.max(height(node.left,level+1),height(node.right,level+1));
	}

	//get the width of current level
	public int getWidth(Node root, int level, int size){
		if(root == null){
			return 0;
		}
		if(level == 1){
			//System.out.print(root.data+"-");
			return 1;
		}

		if(level>1){
			//left
			size = getWidth(root.left,level-1,size)+ getWidth(root.right,level-1,size);
		}

		return size;
	}
}
