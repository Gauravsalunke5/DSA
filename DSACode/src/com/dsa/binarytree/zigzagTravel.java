package com.dsa.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class zigzagTravel {

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

	zigzagTravel() {
		root = null;
	}

	List<List<Integer>> zigZagTravel(Node node) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (node == null)
			return res;

		Stack<Node> stk1 = new Stack<Node>();
		Stack<Node> stk2 = new Stack<Node>();

		stk1.add(node);

		boolean leftToRight = true;

		List<Integer> temp = new ArrayList<Integer>();
		while (!stk1.isEmpty() || !stk2.isEmpty()) {
			if (leftToRight) {
				node = stk1.pop();
			} else {
				node = stk2.pop();

			}

			System.out.print(node.data + " ");
			temp.add(node.data);

			if (leftToRight) {
				if (node.left != null)
					stk2.add(node.left);

				if (node.right != null)
					stk2.add(node.right);

			} else {
				if (node.right != null)
					stk1.add(node.right);
				if (node.left != null)
					stk1.add(node.left);
			}

			if (leftToRight) {
				leftToRight = stk1.isEmpty() ? false : true;
				if (stk1.isEmpty()) {
					res.add(new ArrayList<Integer>(temp));
					temp.clear();
				}

			} else {
				leftToRight = stk2.isEmpty() ? true : false;
				if (stk2.isEmpty()) {
					res.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
			}

		}
		return res;
	}

	public static void main(String[] args) {
		zigzagTravel tree = new zigzagTravel();
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

		List<List<Integer>> res = tree.zigZagTravel(tree.root);
		System.out.println();
		System.out.println(res);

//		1
//		2   3
//	4 5

	}

}
