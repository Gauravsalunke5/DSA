package com.dsa.binarytree;

public class CheckBTisBST_10 {

	Node root;

	boolean isBST() {
		return function(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean function(Node node, long min, long max) {
		if (node == null)
			return true;
		if (node.data <= min || node.data >= max)
			return false;

		return function(node.left, min, node.data) && function(node.right, node.data, max);
	}

	public static void main(String args[]) {
		CheckBTisBST_10 tree = new CheckBTisBST_10();
		tree.root = new Node(12);
		tree.root.left = new Node(4);
		tree.root.right = new Node(25);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(9);
		tree.root.right.left = new Node(16);
		tree.root.right.right = new Node(32);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

}

/* Try more Inputs
case1:
 root = Node(12); 
root.left = Node(4); 
root.right = Node(25); 
root.left.left = Node(2); 
root.left.right = Node(9); 
root.right.left = Node(16); 
root.right.right = Node(32); 
actual = isBST(root)
expected = True

case2:
root = Node(2); 
root.left = Node(1); 
root.right = Node(3); 
actual = isBST(root)
expected = True

*/
/*
 *Check whether Binary Tree is Binary Search Tree
Asked In: Amazon Microsoft Vmware
Given a binary tree, determine if it is a valid binary search tree (BST). Assume a BST is defined as follows: The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees

Example:

Example 1:
    2
   / \
  1   3
Input: [2,1,3]
Output: true
Problem level: Medium
*/
