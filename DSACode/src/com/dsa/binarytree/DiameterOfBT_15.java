package com.dsa.binarytree;

public class DiameterOfBT_15 {

	static int maxDiameter=0;

	public static int findDiameter(Node root) {
		if (root == null)
			return 0;

		//height of left node
		int leftHeight = findDiameter(root.left);
		//height of right node
		int rightHeight = findDiameter(root.right);
		// current diameter
		int currentDiameter = leftHeight + rightHeight;
		maxDiameter = Math.max(maxDiameter, currentDiameter);
		//return max height of node
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		 findDiameter(root);
		System.out.print("The diameter of the tree is " + maxDiameter);
	}

}


/* Try more Inputs
Case 1:
BinaryTree tree = new BinaryTree();
tree.root = new Node(12);
tree.root.left = new Node(10);
tree.root.right = new Node(30);
tree.root.right.left = new Node(25);
tree.root.right.right = new Node(40);
printLeftView(root)
expected = [12,10,25]

Case2: 
BinaryTree root = newNode(10);
root.left = newNode(12);
root.right = newNode(3);
root.left.right = newNode(4);
root.right.left = newNode(5);
root.right.left.right = newNode(6);
root.right.left.right.left = newNode(18);
root.right.left.right.right = newNode(7);
printLeftView(root)
expected = [10,12,4,6,18]
*/
/*
Diameter of Binary tree
Asked In: Flipkart Amazon Microsoft Facebook Intuit Broadcom
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. Find diameter of tree in Time Complexity O(n) Asked in : Flipkart, Amazon, Microsoft, Facebook, Intuit, Broadcom

Example:

[Time Complexity : O(n), since we must visit each node]
[Space Complexity O(log n), if a balanced tree, O(n) otherwise. Space complexity is due to recursion]
Input:
                 1
	      /     \
             2         3
            /       /   \
           7      6        4
		/   \        \      
              17     9          8
                        \
                          19
Output: 8 
Problem level: Medium*/