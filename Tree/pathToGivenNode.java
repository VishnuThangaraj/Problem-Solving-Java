import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

/*
Given the root node of a binary tree containg n nodes and an integer b, you need to find the path from root to given node b.

Input Format
The first line of input contains a number n.
The second line of input contains n space seperated integer.
The third line of input contains a single integer b.

Output Format
Return the path from root to the given node b.

Example 1
Input
7
1 2 3 4 5 6 7
5

Output
1 2 5

Explanation
The given binary tree is 
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
the path from 1 to 5 is {1,2,5}.

Example 2
Input
5
1 2 3 4 5
1

Output
1

Explanation
The given tree is
            1
          /   \
         2     3
        / \  
       4   5 
       
Constraints
1 <= n <= 105
1 <= b <= n
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


class Main {
    static Node buildTree(String str){
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

    
	public static void main (String[] args) throws IOException{
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            sc.nextLine();
			String s = sc.nextLine();
            int b=sc.nextInt();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans=tree.solve(root,b);
            for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");

            System.out.println();

            sc.close();			
	}
}
  


class Solution{
    
   public ArrayList<Integer> solve(Node root,int b)
	{
		ArrayList<Integer> result = new ArrayList<>();
        // lets use helper function
		routeToN(root,b,result,new ArrayList<Integer>());
		
        return result;
    }

	public void routeToN(Node node,int target,ArrayList<Integer> result,ArrayList<Integer> current){
		if(node == null){
			return;
		}

		current.add(node.data); //add present node to current
		
		if(node.data == target){
			result.addAll(new ArrayList<>(current));
			return;
		}

		routeToN(node.left,target,result,current); //left
		routeToN(node.right,target,result,current); //right
		
		current.remove(current.size()-1);
	}
}
