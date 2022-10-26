package com.dsa.binarytree;

//01
public class TraversBinaryTree_01 {
	static class Node {
		int data;
		Node left, right;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	Node root;

	TraversBinaryTree_01() {
		root = null;
	}

	void postOrder() {
		postOrder(root);
	}

	void inOrder() {
		inOrder(root);
	}

	void preOrder() {
		preOrder(root);
	}

	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	void preOrder(Node node) {
		if (node == null)
			return;
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	public static void main(String[] args) {
		TraversBinaryTree_01 tree = new TraversBinaryTree_01();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
//		1
//		2   3
//	4 5

		tree.preOrder();
		System.out.println();
		tree.inOrder();
		System.out.println();
		tree.postOrder();
		System.out.println();
	}

}

/*
Binary Tree Traversal Implementation
Asked In:
Traversal scheme is core Concept of BT. Almost all the problems of Binary tree involves the complete understanding of traversal process.

Example:

Problem level: Medium*/