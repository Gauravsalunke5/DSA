package com.dsa.binarytree;

public class CheckNodesofBTisCousins_18 {

	public boolean areCousins(Node root, Node x, Node y) {

		if (findDepth(root, x, 1) != findDepth(root, y, 1))
			return false;
		else {
			if (sameParents(root, x, y) == false) {
				return true;
			} else {
				return false;
			}
		}
	}

	public int findDepth(Node root, Node x, int height) {
		if (root == null)
			return 0;
		if (root.data == x.data)
			return height;
		int left = findDepth(root.left, x, height + 1);
		if (left != 0)
			return left;
		return findDepth(root.right, x, height + 1);
	}

	public boolean sameParents(Node root, Node x, Node y) {
		if (root == null)
			return false;

		return (root.left == x && root.right == y) || (root.left == y && root.right == x)
				|| sameParents(root.left, x, y) || sameParents(root.right, x, y);
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(1);
		Node x1 = new Node(2);
		Node y1 = new Node(3);
		root.left = x1;
		root.right = y1;
		root.left.left = new Node(4);
		root.right.left = new Node(6);
		Node x2 = new Node(7);
		Node y2 = new Node(9);
		root.right.left.left = new Node(8);
		root.right.left.right = y2;
		root.left.left.left = x2;

		CheckNodesofBTisCousins_18 i = new CheckNodesofBTisCousins_18();
		System.out
				.println("Node " + x1.data + " and Node " + y1.data + " are cousins??? " + i.areCousins(root, x1, y1));
		System.out
				.println("Node " + x2.data + " and Node " + y2.data + " are cousins??? " + i.areCousins(root, x2, y2));

		// better approach
		https: // leetcode.com/problems/cousins-in-binary-tree/submissions/
		System.out.println(
				"Node " + x1.data + " and Node " + y1.data + " are cousins??? " + i.isCousins(root, x1.data, y1.data));
		xParent = null;
		yParent = null;
		xDepth = -1;
		yDepth = -1;
		System.out.println(
				"Node " + x2.data + " and Node " + y2.data + " are cousins??? " + i.isCousins(root, x2.data, y2.data));
	}

	public boolean isCousins(Node root, int x, int y) {
		getDepthAndParent(root, x, y, 0, null);
		return (xDepth == yDepth) && (xParent != yParent) ? true : false;
	}

	// get both the depth and parent for x and y
	public void getDepthAndParent(Node root, int x, int y, int depth, Node parent) {
		if (root == null)
			return;

		if (root.data == x) {
			xDepth = depth;
			xParent = parent;
		} else if (root.data == y) {
			yDepth = depth;
			yParent = parent;
		} else if (xDepth == -1 || yDepth == -1) {
			getDepthAndParent(root.left, x, y, depth + 1, root);
			getDepthAndParent(root.right, x, y, depth + 1, root);
		}
		return;
	}

	static Node xParent = null;
	static Node yParent = null;
	static int xDepth = -1;
	static int yDepth = -1;

}
/*
 * Check Nodes of Binary Tree is Cousins
Asked In: Oracle Citrix
Two nodes of a binary tree are cousins if they have the same depth, but have different parents. We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree. Return true if and only if the nodes corresponding to the values x and y are cousins

Example:

Input 
      6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE
Problem level: Medium
*/
