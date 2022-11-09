package com.dsa.binarytree;

public class DeletionBinarySearchTree_06 {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root;

	DeletionBinarySearchTree_06() {
		root = null;
	}

	void deleteKey(int key) {
		root = Delete(root, key);
	}

	Node Delete(Node root, int key) {
		if (root == null)
			return null;
		else if (key < root.key)
			root.left = Delete(root.left, key);
		else if (key > root.key)
			root.right = Delete(root.right, key);
		else {
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			} else if (root.left == null) {
				root = root.right;
				return root;
			} else if (root.right == null) {
				root = root.left;
			} else {
				Node temp = findInorderSuccessor(root.right);
				root.key = temp.key;
				root.right = Delete(root.right, temp.key);
			}
		}

		return root;
	}

	Node findInorderSuccessor(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		return root;
	}

	void inorder() {
		inorderRec(root);
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	public static void main(String[] args) {
		DeletionBinarySearchTree_06 tree = new DeletionBinarySearchTree_06();
		/* Let us create following BST 
		50 
	/	 \ 
	30	 70 
	/ \ / \ 
	20 40 60 80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder traversal of the given tree");
		tree.inorder();

		System.out.println("\nDelete 20");
		tree.deleteKey(20);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();

		System.out.println("\nDelete 30");
		tree.deleteKey(30);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();

		System.out.println("\nDelete 50");
		tree.deleteKey(50);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();
	}

}
/*
Deletion in Binary Search Tree
Asked In: Yahoo Facebook Google
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST. Basically, the deletion can be divided into two stages: Search for a node to remove. If the node is found, delete the node

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

The given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].
Problem level: Hard
*/