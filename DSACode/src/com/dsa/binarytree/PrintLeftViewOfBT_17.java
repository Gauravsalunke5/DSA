package com.dsa.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintLeftViewOfBT_17 {

	static int first_node_level = 0;

	// Recursive function to print left view of given binary tree
	public static void printLeftView(Node root, int level) {
		// base case: empty tree
		if (root == null) {
			return;
		}

		// if current node is first node of current level
		if (first_node_level < level) {
			// print the node's data
			System.out.print(root.data + " ");

			// update last level to current level
			first_node_level = level;
		}
		// recur for left and right subtree by increasing level by 1
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);

	}

	// Recursive function to print left view of given binary tree
	public static void printLeftView2(Node root, int level, AtomicInteger visitedLevel) {
		if (root == null)
			return;

		if (visitedLevel.get() < level) {
			System.out.print(root.data + " ");
			visitedLevel.incrementAndGet();
		}
		printLeftView2(root.left, level + 1, visitedLevel);
		printLeftView2(root.right, level + 1, visitedLevel);

	}

	// Function to print left view of given binary tree
	public static void printLeftView(Node root) {
		AtomicInteger visitedLevel = new AtomicInteger(0);
		printLeftView(root, 1);
		printLeftView2(root, 1, visitedLevel);
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

		printLeftView(root);
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
 * Print Left View of Binary Tree
Asked In: Amazon EMC2 SAP-Labs
Printing the left view of a binary tree involves printing the left-most node, at each level, in the binary tree In Time Complexity O(n) and Space Complexity O(n) Asked in : Amazon, EMC2, SAP-Labs

Example:

[O(n) Time Complexity due  simple traversal of the tree of n Nodes] 
[O(n) Space Complexity due to recursive stack calls]
Input: 
                 1
	      /    \
             2       3
           /      /    \
         7       5      4
		/	/
              17       8
Output : 
1,2,7, 17
Hint : Print left node in every Level of BT
Problem level: Medium
*/
