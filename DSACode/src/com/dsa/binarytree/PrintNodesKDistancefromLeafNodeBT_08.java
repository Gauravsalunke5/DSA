package com.dsa.binarytree;

public class PrintNodesKDistancefromLeafNodeBT_08 {

	Node root;

	void printKDistance(Node node, int k, int arr[], boolean visited[], int count) {
		if (node == null)
			return;
		arr[count] = node.data;
		if (node.left == null && node.right == null && count - k >= 0 && !visited[count - k]) {
			System.out.print(arr[count - k] + " ");
			visited[count - k] = true;
			return;
		}
		printKDistance(node.left, k, arr, visited, count + 1);
		printKDistance(node.right, k, arr, visited, count + 1);

	}

	void printKDistantfromLeaf(Node node, int k) {
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		printKDistance(node, k, path, visited, 0);
	}

	public static void main(String args[]) {
		PrintNodesKDistancefromLeafNodeBT_08 tree = new PrintNodesKDistancefromLeafNodeBT_08();

		tree.root = new Node(3);
		tree.root.left = new Node(8);
		tree.root.right = new Node(9);
		tree.root.left.left = new Node(11);
		tree.root.left.right = new Node(7);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(12);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(3);

		System.out.println(" Nodes at distance 2 are :");
		tree.printKDistantfromLeaf(tree.root, 2);
	}

}
/* Try more Inputs
case1:
root = Node(3); 
root.left = Node(8); 
root.right = Node(9); 
root.left.left = Node(11); 
root.left.right = Node(7); 
root.left.right.left = Node(6); 
root.left.right.right = Node(12); 
root.right.left = Node(8); 
root.right.right = Node(3); 
actual = printKDistantfromLeaf(root,3)
expected = 3

case2:
root = Node(3); 
root.left = Node(8); 
root.right = Node(9); 
root.left.left = Node(11); 
root.left.right = Node(7); 
root.left.right.left = Node(6); 
root.left.right.right = Node(12); 
root.right.left = Node(8); 
root.right.right = Node(3); 
actual = printKDistantfromLeaf(root,3)
expected = {3,8}


*/

/*
 Print All Nodes K Distance from Leaf Node in Binary Tree
Asked In: Google Amazon
Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node k distance from a leaf means k levels higher than a leaf node. For example, if k is more than the height of the Binary Tree, then nothing should be printed. Expected time complexity is O(n) where n is the number nodes in the given Binary Tree

Example:

Input: 
            [1]
          /   \
       [2]     [3]
      /  \     /  \
    [4]  [5] [6]  [7]
    /
  [8]
Here Output should be 1, and 2 for K=2 as both are at 2 distance from leaf nodes.?1 is at K=2 distance from 5 and  2 is K=2 distance from 8.
Problem level: Hard
*/
