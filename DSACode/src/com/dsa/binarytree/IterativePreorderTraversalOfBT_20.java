package com.dsa.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterativePreorderTraversalOfBT_20 {

	Node root;

	void preorder() {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.empty()) {
			root = stack.pop();
			System.out.print(root.data + " ");
			if (root.right != null)
				stack.add(root.right);
			if (root.left != null)
				stack.add(root.left);
		
		}
	}

	public static void main(String args[]) {

		IterativePreorderTraversalOfBT_20 tree = new IterativePreorderTraversalOfBT_20();
		tree.root = new Node(6);
		tree.root.left = new Node(4);
		tree.root.right = new Node(10);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(12);
		tree.root.right.left = new Node(8);
		tree.preorder();
	}

}
/* Try more Inputs
case1:
root = Node(6); 
root.left = Node(4); 
root.right = Node(10); 
root.left.right = Node(5); 
root.right.right = Node(12); 
root.right.left = Node(8);
actual = preOrder(root)
expected = {6,4,5,10,8,12}

case2:
root = Node(1);  
root.right = Node(2); 
root.right.left = Node(3); 
actual = preOrder(root)
expected = [1,2,3]

*/
/*
Iterative Preorder Traversal of Binary Tree
Asked In: FlipkartVerizon
Given a binary tree, return the Iterative  preorder traversal of its nodes' values

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,2,3]
Problem level: Medium
*/