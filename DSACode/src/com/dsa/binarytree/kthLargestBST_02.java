package com.dsa.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

//class Node {
//	int data;
//	Node left = null, right = null;
//
//	Node(int data) {
//		this.data = data;
//	}
//}

public class kthLargestBST_02 {
	// Binary search insert
	public static Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}

		if (key < root.data) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static int kthLargestBST(Node root, AtomicInteger i, int k) {

		if (root == null)
			return Integer.MAX_VALUE;

		int res = kthLargestBST(root.right, i, k);
		if (i.incrementAndGet() == k)
			return root.data;
		else if (i.get() >= k)
			return res;

		res = kthLargestBST(root.left, i, k);
		return res;
	}
	
	public static int kthSmallestBST(Node root, AtomicInteger i, int k) {

		if (root == null)
			return Integer.MAX_VALUE;

		int res = kthSmallestBST(root.left, i, k);
		if (i.incrementAndGet() == k)
			return root.data;
		else if (i.get() >= k)
			return res;

		res = kthSmallestBST(root.right, i, k);
		return res;
	}

	public static int kthLargestBST(Node root, int k) {
		AtomicInteger i = new AtomicInteger(0);

		return kthLargestBST(root, i, k);
	}
	public static int kthSmallestBST(Node root, int k) {
		AtomicInteger i = new AtomicInteger(0);

		return kthSmallestBST(root, i, k);
	}

	//
	static Node kthlargest(Node root, int k[]) {
		if (root == null)
			return null;

		Node right = kthlargest(root.right, k);
		if (right != null)
			return right;
		k[0]--;

		if (k[0] == 0)
			return root;

		return kthlargest(root.left, k);
	}

	static Node kthsmallest(Node root, int k[]) {
		if (root == null)
			return null;

		Node left = kthsmallest(root.left, k);
		if (left != null)
			return left;
		k[0]--;
		if (k[0] == 0)
			return root;

		return kthsmallest(root.right, k);
	}

	//
	public static void main(String[] args) {
		Node root = null;
		int[] keys = { 5, 3, 6, 2, 4, 1 };

		for (int key : keys) {
			root = insert(root, key);
		}

		int k = 3;
		int res = kthLargestBST(root, k);

		if (res != Integer.MAX_VALUE) {
			System.out.println(res);
		} else {
			System.out.println("Invalid Input");
		}

		res = kthSmallestBST(root, k);
		if (res != Integer.MAX_VALUE) {
			System.out.println(res);
		} else {
			System.out.println("Invalid Input");
		}

		
		int p = k;
 		Node large = kthlargest(root, new int[] { k });
		k = p;
		Node small = kthsmallest(root, new int[] { k });
		if (large == null) {
			System.out.println("Invalid input");
		} else
			System.out.println("kth largest element is  " + large.data);

		if (small == null) {
			System.out.println("Invalid input");
		} else {
			System.out.println("kth smallest element is  " + small.data);
		}
	}
}

/*
 * Try more Inputs
 * 
 * case1: keys = [13, 14, 22, 25, 23, 32, 26,28,40] root = insert(root, key)
 * actual = findKthLargest(root,3) expected = 22
 * 
 * case2: keys = [5,3,6,2,4,1] root = insert(root, key) actual =
 * findKthLargest(root,3) expected = 3
 * 
 */
/*
Find the kth Largest element in BST
Asked In: Uber Akamai Amazon
Given a binary search tree, write a function kth Largest to find the kth Largest element in it.

Example:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Problem level: Easy
*/