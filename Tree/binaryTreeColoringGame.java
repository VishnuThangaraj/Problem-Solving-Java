import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
Two players play a turn based game on a binary tree. We are given the root of this binary tree, and the number of nodes n in the tree. 
n is odd, and each node has a distinct value from 1 to n.
Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. 
The first player colors the node with value x red, and the second player colors the node with value y blue.
Then, the players take turns starting with the first player. 
In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node 
(either the left child, right child, or parent of the chosen node.)
If (and only if) a player cannot choose such a node in this way, they must pass their turn. 
If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.

Note: You just need to complete btreeGameWinningMove() function and return true or false.

Input Format
First line contains the array representation of the binary tree. It is in the level order format. 
The second line contains two spaced integers n and x where n denotes the number of nodes in a Tree and x denotes the node value of other player .

Output Format
Print true or false

Example 1
Input
1 2 3 4 5
5 2

Output
false

Explanation
              1
            /   \ 
          2      3 
        /  \ 
       4    5  
1st Player  can color 3 nodes optimally : Either {2 ,1 ,3 } or {2,4,5}
2nd Player can color only 2 nodes optimally : Either {1,3}  or  {4,5} . 
Hence It is not possible to win the game in this condition.

Example 2
Input
1 2 3 4 5
5 1

Output
true

Explanation
              1
            /   \ 
          2      3 
        /  \ 
       4    5  
1st Player  can color only 2 nodes optimally : {1,3}
2nd Player can color 3 nodes optimally : {2,4,5}
Hence It is possible to win the game in this condition.

Constraints
1 <= n <= 100
n must be odd.
1 <= node.val <= n
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


public class binaryTreeColoringGame {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            int n = sc.nextInt();
		    int x = sc.nextInt();
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			boolean ans = tree.btreeGameWinningMove(root,n,x);
			System.out.print(ans);
		
	}
}
  


class Solution{

    static int left , right , value;
    
    public static boolean btreeGameWinningMove(Node root, int n, int x) {
        value = x;
        count(root);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    public static int count(Node node) {
    if (node == null)    return 0;
    int l = count(node.left);
    int r = count(node.right);
    if (node.data == value) {
      left = l;
      right = r;
    }
    return l + r + 1;
  }
    
}

