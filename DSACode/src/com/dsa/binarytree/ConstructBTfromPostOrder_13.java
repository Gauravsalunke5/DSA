package com.dsa.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBTfromPostOrder_13 {


	// Recursive function to perform inorder traversal of a binary tree
	public static void inorderTraversal(Node root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left, result);
		result.add(root.data);
		inorderTraversal(root.right, result);
	}

	// Recursive function to perform postorder traversal of a binary tree
	public static void postorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	// Recursive function to construct a binary tree from inorder and postorder
	// traversals
	public static Node construct(int start, int end, int[] postorder, AtomicInteger currentIndex,
			Map<Integer, Integer> map) {
		if (start > end)
			return null;
	    //Consider the next item from the end of given postorder sequence.This value would be the root node of subtree formed by inorder[start, end]
		Node node = new Node(postorder[currentIndex.getAndDecrement()]);
		int index = map.get(node.data);
	    //recursively construct the right subtree
		node.right = construct(index + 1, end, postorder, currentIndex, map);
	    //recursively construct the left subtree
		node.left = construct(start, index - 1, postorder, currentIndex, map);
		return node;
	}

	// Construct a binary tree from inorder and postorder traversals. This function
	// assumes that the input is valid i.e. given inorder and postorder sequence
	// forms a binary tree
	public static Node construct(int[] inorder, int[] postorder) {
		int n = inorder.length;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// storing inOder in map
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		AtomicInteger currentIndex = new AtomicInteger(n - 1);

		return construct(0, n - 1, postorder, currentIndex, map);
	}

	public static void main(String[] args) {
	     /* Consider below tree
			  1
			/   \
		   /	 \
		  2		  3
		 /		 / \
		/		/   \
	   4	   5	 6
			  / \
			 /	 \
			7	  8
	*/

		int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
		int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };

		Node root = construct(inorder, postorder);

		ArrayList<Integer> result = new ArrayList<Integer>();
		inorderTraversal(root, result);
		System.out.print("Inorder	  : " + result);
		System.out.print("\nPostorder : ");
		postorderTraversal(root);
	}

}
/* Try more Inputs
Case 1:
int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1};
ArrayList<Integer> result = new ArrayList<Integer>();
Node root = construct(inorder, postorder);
inorderTraversal(root,result);
expected = [4, 2, 1, 7, 5, 8, 3, 6]

Case2: 
int[] inorder = { 9,3,15,20,7 };
int[] postorder = { 9,15,7,20,3};
ArrayList<Integer> result = new ArrayList<Integer>();
Node root = construct(inorder, postorder);
inorderTraversal(root,result);
expected = [9,3,15,20,7]
*/
/*
 * Construct Tree from PostOrder
Asked In: Samsung WalmartLabs
We have the inorder and postorder traversal sequence of a binary tree to generate the Binary tree Asked in : Samsung, WalmartLabs

Example:

inOrder[]   = {5, 9, 3, 6, 2, 7, 4, 8}
postOrder[] = {9, 5, 6, 3, 7, 8, 4, 2} 
Output:
          2
       /     \
     3         4
   /   \     /   \
  5     6    7    8
    \
      9
Hint : Use Inorder traversal and apply recursion on post order traversal to generate tree
Problem level: Hard
*/
