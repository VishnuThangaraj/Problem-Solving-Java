import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a string S of distinct character of size N and their corresponding frequency arrayf i.e. 
character S[i] has f[i] frequency. Your task is to build the Huffman tree 
print all the Huffman codes in preorder traversal of the tree.

Note:
While merging if two nodes have the same value, then the node which occurs at first will be taken on the left 
of Binary Tree and the other one to the right, 
otherwise Node with less value will be taken on the left of the subtree and other one to the right.

Input Format
The first line of input contains a string s.
The second line of input contains n space separated integers.

Output Format
Return a vector of strings containing all huffman codes in order of preorder traversal of the tree.

Example 1
Input
abcdef
5 9 12 13 16 45

Output
0 100 101 1100 1101 111

Explanation
HuffmanCodes will be:
f : 0
c : 100
d : 101
a : 1100
b : 1101
e : 111
Hence printing them in the PreOrder of Binary Tree.

Constraints
1 <= n <= 26
string s contains all lower case alphabets.
*/

public class huffmanEncoding
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
	class Node{
		char letter;
		int frequency;
		Node left;
		Node right;
		//constructor
		Node(char letter, int freq){
			this.letter = letter;
			this.frequency = freq;
		}
	}
	public void DFS(Node node, ArrayList<String> result, String Path){
		if(node.letter != '*'){
			// add the path to result
			result.add(Path);
			return;
		}

		//perferm left and right traversals
		DFS(node.left,result,Path+"0");
		DFS(node.right,result,Path+"1");
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Create priority Queue
		PriorityQueue<Node> storage = new PriorityQueue<>( (a,b) -> {
			return a.frequency < b.frequency ? -1 : 1;
		});

		//add all the characters to priorityQueue
		for(int i=0; i<N; i++)
			storage.offer(new Node(S.charAt(i), f[i]));

		while(storage.size() > 1){
			// remove two nodes
			Node first = storage.poll();
			Node second = storage.poll();

			//create new node and add both nodes to left and right
			Node current = new Node('*', first.frequency + second.frequency);
			current.left = first;
			current.right = second;

			// add the newly created node to priorityQueue
			storage.offer(current);
		}

		Node huffmanRoot = storage.poll();

		// preform preOrder traversal and store answers in ArrayList
		ArrayList<String> result = new ArrayList<>();

		DFS(huffmanRoot, result, "");

		return result;
    }
    
}
