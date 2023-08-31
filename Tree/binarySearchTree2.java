//package Trees;

// MAIN METHOD
public class binarySearchTree2 {
    public static void main(String[] args) {
        //create the tree
        BST tree = new BST();

        //insert elements
        int[]nums = {7,2,1,5,6,4,10,3,9,8};
        tree.insert(nums);

        //display the tree
        tree.display();

        System.out.println("\n\n"); //divider

        //display in a better manner
        tree.prettyDisplay();

        System.out.println("\n\n"); //divider

        //sorted Array
        BST tree2 = new BST();
        int[]sorted = {1,2,3,4,5,6,7,8,9,10};

        //normal inserting
        tree2.insert(sorted);

        //display the tree
        tree2.prettyDisplay();

        System.out.println("\n\n"); //divider

        //sorted inserting
        BST tree3 = new BST();
        tree3.sortedInsert(sorted);

        //display the tree
        tree3.prettyDisplay();
    }
}


// BINARY SEARCH TREE 
class BST{ //binarySearchTree(BST)
    // NODE
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        //constructor
       public  Node(int value){
            this.value = value;
        }

        //getter (get value)
        public int getValue(){
            return value;
        }
    }

    //root node
    private Node root;

    //constructor
    BST(){
        //empty constructor
    }

    // getting the height
    public int height(Node node){
        if(node==null){
            return -1; //empty
        }
        return node.height;
    }

    //check if the tree is empty
    public boolean isEmpty(){
        if(root == null){
            return true; //empty tree
        }
        return false;
    }

    //inserting
    public void insert(int value){
        //root will be returned in the insert recursive function
        root = insert(root,value);
    }

    //private insert helper function
    private Node insert(Node node, int value) {
        if(node == null){
            return new Node(value); //return new node to insert
        }
        if(node.value > value ){ //smaller elements on the left
            node.left = insert(node.left,value);
        }
        
        if(node.value < value){
            node.right = insert(node.right,value);
        }

        //alter the height of the tree
        node.height = Math.max(height(node.left), height(node.right))+1;

        //return the current node
        return node;
    }

    //insert multiple items
    public void insert(int[]nums){
        for(int item : nums){
            this.insert(item);
        }
    }

    //insert sorted items in tree
    public void sortedInsert(int []sorted){
        sortedInsert(sorted,0,sorted.length-1);
    }

    //private insert for sorted items(binary search method)
    private void sortedInsert(int[]sorted, int start, int end){
        if(start >= end){
            return;
        }
        int mid  = start + (end - start) /2;

        insert(sorted[mid]); //insert the mid in the tree 

        sortedInsert(sorted, start, mid-1);
        sortedInsert(sorted, mid+1, end);
    }

    //check if the tree is balanced or not
    public boolean balanced(){
        return balanced(root);
    }

    //private balance check helper function
    public boolean balanced(Node node){
        if(node == null){
            return true; //empty
        }
        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

    //display function
    public void display(){
        display(root,"Root Node: ");
    }

    // private helper function for display method
    private void display(Node node, String details) {
        //base condition
        if(node == null){
            return;
        }
        System.out.println(details+node.getValue());
        //recursive calls (left to right traverse)
        display(node.left, "Left Child of "+node.getValue()+" : ");
        display(node.right, "Right Child of "+node.getValue()+" : ");
    }

    //display in a pretty-way
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    //private pretty display helper function
    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        //recursive call for right node
        prettyDisplay(node.right, level+1);
        //printing
        if(level!=0){
            for(int i=0; i<level-1; i++){
                System.out.print("|\t");
            }System.out.println("|------>"+node.getValue());
        }else{
           System.out.println(node.getValue()); 
        }

        //recursive call for left node
        prettyDisplay(node.left, level+1);
    }
}
