package com.dsa.binarytree;

//class Node { 
//	int data; 
//	Node left, right; 
//	Node(int d) 
//	{ 
//		data = d; 
//		left = right = null; 
//	} 
//} 

public class HeightBalancedTree_04 {
	Node root;

	//difference between the left and the right subtree for any node is not more than one
	boolean isTreeBalanced(Node node) {
		int right, left;
		if (node == null)
			return true;
		
		left = findHeight(node.left);
		right = findHeight(node.right);
		if (Math.abs(left - right) <= 1 && isTreeBalanced(node.left) && isTreeBalanced(node.right))
			return true;
		return false;
	}

	int findHeight(Node node) {
		if (node == null)
			return 0;

		return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}

	public static void main(String args[]) {
		HeightBalancedTree_04 tree = new HeightBalancedTree_04();
//		tree.root = new Node(2);
//		tree.root.left = new Node(3);
//		tree.root.right = new Node(4);
//		tree.root.left.left = new Node(5);
//		tree.root.left.right = new Node(6);
//		tree.root.left.left.left = new Node(9);

		tree.root = new Node(3);
		tree.root.left = new Node(9);
		tree.root.right = new Node(20);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(7);
 		
		if (tree.isTreeBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
} 

/* Try more Inputs
case1:
root = Node(2) 
root.left = Node(3) 
root.right = Node(4) 
root.left.left = Node(5) 
root.left.right = Node(6) 
root.left.left.left = Node(9)
actual = isTreeBalanced(root)
expected = True

case2:
root = Node(2) 
root.left = Node(3) 
root.right = Node(4) 
root.left.left = Node(5) 
root.left.left.left = Node(6) 
root.left.left.left.left = Node(9)
actual = isTreeBalanced(root)
expected = False

*/

/*
Height Balanced Tree
Asked In: Cisco Intuit
For this problem, a height-balanced binary tree is defined as: a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example:

Given the following tree [3,9,20,null,null,15,7]:
     3
   /   \
  9     20
        /  \
      15    7
Return true
Problem level: Easy

*/