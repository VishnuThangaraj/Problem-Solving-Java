import java.util.*;
import java.io.*;

/*
Given the root node of a BST, print its left view i.e print all the nodes from top to bottom that will appear while looking the tree from left.

Input Format
The first line contains an integer n, the number of nodes.
The next line inputs the value of n nodes.

Output Format
Print the left view of the tree as a single line of space-separated values.

Example 1
Input
6
1 2 5 3 4 6

Output
1 2 5 3 4 

Explanation
The BST is like :-
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
So,the left view of tree results in 1,2,5,3,4 as the required result. only 6 is not visible from left view

Example 2
Input
3
1 2 3

Output
1 2 3

Explanation
The BST is like :-
       1
         \
           2
             \
              3
So,the left view will have all three nodes.

Constraints:
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
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution
{
    public static void letfView(Node root)
    {
        if(root == null){
            return; //empty tree
        }

        //create a queue to store the treeNodes
        Queue<Node> storage = new LinkedList<>();

        //add the root to queue
        storage.offer(root);

        while(!storage.isEmpty()){
            int queueSize = storage.size();

            //run loop to queue size times
            for(int i=0; i<queueSize; i++){
                Node parent = storage.remove();

                if(i == 0){ //left most in the current level
                    System.out.print(parent.val+" ");
                }

                //add left and right nodes to the queue
                if(parent.left!=null){
                    storage.offer(parent.left);
                }
                if(parent.right!=null){
                    storage.offer(parent.right);
                }
            }
        }
    }   
}
