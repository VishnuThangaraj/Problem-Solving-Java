import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
You need to complete a function that traverses a binary tree using a preorder traversal and prints all the nodes that have only one child.
The traversal and printing of the nodes should be done in separate lines.

The input and output for the function have already been implemented.

Input Format
Input has been already implemented (it is a pre-order traversal of the tree)

Output Format
You need to print the single nodes in a preorder fashion.

Example 1
Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Output
30 70

Explanation
            50
    25              75
12      37      62      87
      30           70

Here we can see that only 30 and 70 have parents who have only 1 child.

Example 2
Input
15
50 25 12 n n n 75 62 30 n n n 87 n n

Output
12 30

Explanation
            50
    25              75
12                62      87
                30

Here we can see that only 12 and 30 have parents who have only 1 child.

Constraints
1 <= numOfNodes <=10^5
-10^6 <= node.data <= 10^6
*/

class Node {
    int data;
    Node left;
    Node right;

    Node() {

    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }
}

class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }

}

class Solution {

    public void printSingleChildNodes(Node node, Node parent) {
        if(node == null || node.left == null && node.right == null){
			return;
		}

		if(node.left == null || node.right == null){
			
			if(node.left !=null){
				System.out.print(node.left.data+" ");
			}else{
				System.out.print(node.right.data+" ");
			}
		}
		printSingleChildNodes(node.left, node);
		printSingleChildNodes(node.right, node);
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        Node root = new Node();
        root = root.construct(arr);
        Solution obj = new Solution();
        obj.printSingleChildNodes(root, null);
    }
}
