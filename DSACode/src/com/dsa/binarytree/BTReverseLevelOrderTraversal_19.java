package com.dsa.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTReverseLevelOrderTraversal_19 {

	Node root;

	// Function to print reverse level order traversal of given binary tree
	void reverseLevelOrder(Node node) {
		// create a stack to reverse level order nodes
		Stack<Node> stack = new Stack<Node>();
		// create an empty queue and enqueue root node
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) { // process each node in queue and enqueue their children
			node = queue.poll();
			// push current node to stack
			stack.push(node);
			// important - process right node before left node
			if (node.right != null)
				queue.add(node.right);

			if (node.left != null)
				queue.add(node.left);
		}
		// pop all nodes from the stack and print them

		while (!stack.empty()) {
			node = stack.pop();
			System.out.print(node.data + " ");
		}

	}

	public static void main(String args[]) {
		BTReverseLevelOrderTraversal_19 tree = new BTReverseLevelOrderTraversal_19();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);

		System.out.println("Revrese Level Order traversal :");
		tree.reverseLevelOrder(tree.root);
		System.out.println();
		tree.LevelOrder(tree.root);

	}

	private void LevelOrder(Node node) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);

		}

	}

}

/* Try more Inputs
case1:
Main tree = new Main(); 
tree.root = new Node(1); 
tree.root.left = new Node(2); 
tree.root.right = new Node(3); 
actual = reverseLevelOrder(tree)
expect = 2 3 1

case2: 
Main tree = new Main(); 
tree.root = new Node(1); 
tree.root.left = new Node(2); 
tree.root.right = new Node(3); 
tree.root.right.left = new Node(-4); 
tree.root.right.right = new Node(-5); 
expect = -4 -5 2 3 1
*/

/*
 * Binary Tree Reverse Level Order Traversal
Asked In: Sap Labs Cisco
Algorithm to print Binary Tree nodes level by level in reverse order. It means all the nodes at the last level should be printed first followed by the nodes of second last level and so on in Time Complexity O(n) and Space Complexity O(n) and Asked in: Sap Labs, Cisco

Example:

[Time Complexity : O(n) for traversing the nodes of Binary Tree of n nodes] 
[Space Complexity ; O(n) ,Operations on Queue + Stack together is 2*O(N) ~ O(N)]
Problem level: Medium
*/
