package com.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MirrorBST {

//	static class Node {
//		int data;
//		Node left, right;
//
//		public Node(int d) {
//			data = d;
//			left = right = null;
//		}
//	}

	Node root;

	MirrorBST() {
		root = null;
	}

	private void inOrder() {
		inOrder(root);
	}

	/*
	 * Helper function to test mirror(). Given a binary search tree, print out its
	 * data elements in increasing sorted order.
	 */
	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	private Node mirror(Node node) {
		if (node == null)
			return node;
		Node leftNode = mirror(node.left);
		Node rightNode = mirror(node.right);

		node.left = rightNode;
		node.right = leftNode;

		return node;
	}

	public static void main(String[] args) {
		MirrorBST tree = new MirrorBST();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);

		tree.root.right.right.left = new Node(10);
		tree.root.right.right.right = new Node(11);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of the constructed tree is");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror(tree.root);

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of the mirror tree is");
		tree.inOrder();

//		1
//		2   3
//	4 5

	}

}
