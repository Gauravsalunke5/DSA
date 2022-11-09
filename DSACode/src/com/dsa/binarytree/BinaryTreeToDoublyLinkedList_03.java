package com.dsa.binarytree;

import java.util.ArrayList;


public class BinaryTreeToDoublyLinkedList_03 {

	// Represent a node of the binary tree
//	public static class Node {
//		int data;
//		Node left;
//		Node right;
//
//		public Node(int data) {
//			this.data = data;
//			this.left = null;
//			this.right = null;
//		}
//	}

	// Represent the root of the binary tree

	public Node root;

	// Represent the head and tail of the doubly linked list
	Node head, tail = null;

	// convertbtToDLL() will convert the given binary tree to corresponding doubly
	// linked list
	public void convertbtToDLL(Node node) {
		if(node==null)
			return;
		
		convertbtToDLL(node.left);
		if(head==null) {
			head=tail=node;
		}else {
			tail.right=node;
			node.left=tail;
			tail=node;
		}
		
		convertbtToDLL(node.right);
	}

	// display() will print out the nodes of the list
	public void display(ArrayList<Integer> result) {
		// Node current will point to head
		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of generated doubly linked list: ");
		while (current != null) {
			// Prints each node by incrementing the pointer.

			result.add(current.data);
			current = current.right;
		}
	}

	public static void main(String[] args) {

		BinaryTreeToDoublyLinkedList_03 bt = new BinaryTreeToDoublyLinkedList_03();
		// Add nodes to the binary tree
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		System.out.print("InOrder :");
		bt.inOrder(bt.root);
		System.out.println();
		// Converts the given binary tree to doubly linked list
		bt.convertbtToDLL(bt.root);

		// Displays the nodes present in the list
		ArrayList<Integer> result = new ArrayList<Integer>();
		bt.display(result);
		System.out.print(result);
	}
	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
}  


/* Try more Inputs
Case 1:
BinaryTree tree = new BinaryTree();
BinaryTree tree = new BinaryTree();
tree.root = new Node(10);
tree.root.left = new Node(12);
tree.root.right = new Node(15);
tree.root.left.left = new Node(25);
tree.root.left.right = new Node(30);
tree.root.right.left = new Node(36);
display(root)
expected = [25 ,12 ,30 ,10 ,36 ,15]

Case 1:
BinaryTree tree = new BinaryTree();
BinaryTree tree = new BinaryTree();
tree.root = new Node(10);
tree.root.left = new Node(12);
display(root)
expected = [12,10]

*/

/*
Binary Tree to Doubly Linked List Conversion
Asked In: Amazon Microsoft Flipkart WalmartLabs
Convert BT to DLL such that the left pointer of the node should be pointing to the previous node in the doubly linked list, and the right pointer should be pointing to the next node in the doubly linked list in Time Complexity O(n) and Space O(Height) Asked in : Amazon, Microsoft, Flipkart, WalmartLabs

Example:

[O(height) memory complexity as it will consume memory on the stack up to the height of binary tree ‘h’. It will be O(log n) for balanced tree and in worst case can be O(n) ] 

     13
   /     \
14        20
/            \
25             28
25=14=28=13=20
Hint : InOrder successor can help to convert BT to DLL
Problem level: Medium
*/