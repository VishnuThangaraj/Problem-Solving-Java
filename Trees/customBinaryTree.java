//package Trees;

import java.util.Scanner;

class customTree {
    //    NODE CLASS
    private static class Node{
        int value;
        Node left;
        Node right;
        // constructor
        Node(int value){
            this.value = value;
        }
    }

    //BINARY TREE

    private Node root;
    // constructor
    customTree(){

    }

    //inserting element
    public void populate(Scanner read){
        System.out.println("Enter the root Node value: ");
        int value = read.nextInt(); //get value from user
        root = new Node(value);
        populate(read, root);
    }

    //helper function for inserting element (private)
    private void populate(Scanner read, Node node) {
        //insertin in the left of the node
        System.out.println("Do you want to insert left of "+node.value);
        boolean inserting = read.nextBoolean();
        if(inserting){
            System.out.println("Enter the value to be inserted in the left "+node.value+":");
            int value = read.nextInt();
            node.left = new Node(value);
            //recursion call
            populate(read, node.left);
        }

        //insertin in the right of the node
        System.out.println("Do you want to insert right of "+node.value);
        inserting = read.nextBoolean();
        if(inserting){
            System.out.println("Enter the value to be inserted in the right "+node.value+":");
            int value = read.nextInt();
            node.right = new Node(value);
            //recursion call
             populate(read, node.right);
        }
    }

    //display function
    public void display(){
        display(root,"");
    }

    //display helper function
    private void display(Node node, String indent){
        //base condition
        if(node==null){
            return; 
        }
        //print the node
        System.out.println(indent+node.value);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
 
    }

    //display nodes in a pretty way
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    //helper function 
    private void prettyDisplay(Node node, int level) {
        //base condition
        if(node == null){
            return;
        }
        //print right node first
        prettyDisplay(node.right, level+1);

        //indentations
        if(level!=0){
            for(int i=0; i<level-1; i++){
                System.out.print("| \t");
            }System.out.println("|------>"+node.value);
        }else{
            System.out.println(node.value);
        }

        //print left region next
        prettyDisplay(node.left, level+1);
    }


}

        //   MAIN METHOD

public class customBinaryTree{

    public static void main(String[] args) {
        Scanner read= new Scanner(System.in);
        customTree tree = new customTree();
        //add nodes to the tree
        tree.populate(read);

        //display the tree
        tree.display();

        System.out.println("\n\n"); //divider

        //display in a cleaner way
        tree.prettyDisplay();
    }
}
