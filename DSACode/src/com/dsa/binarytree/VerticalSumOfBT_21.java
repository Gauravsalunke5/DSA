package com.dsa.binarytree;

class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class ListNode {
	int data;
	ListNode prev, next;

	ListNode(int data, ListNode prev, ListNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}

public class VerticalSumOfBT_21 {

	// Function to find and print the vertical sum of given binary tree
	public static void verticalSum(TreeNode root) {

		// create a linked list node corresponding to the vertical line through
		// root node
		ListNode curr = new ListNode(0, null, null);
		// calculate vertical sum and store it in doubly linked list
		VirticalSum(root, curr);
		// print the linked list
		print(curr);

	}

	private static void print(ListNode curr) {

		while (curr != null && curr.prev != null)
			curr = curr.prev;
		
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr=curr.next;
		}

	}

	  // Recursive function to do a pre-order traversal of the tree and calculate the
	  // vertical sum of given binary tree.
	  // Each node of doubly linked list will store the sum of tree nodes at
	  // corresponding vertical line in a binary tree
		private static void VirticalSum(TreeNode root, ListNode curr) {

			if (root == null) {
				return;
			}
			// update the data of linked list node corresponding to the vertical line
			// passing through current tree node
			curr.data += root.data;
			// create a new linked list node corresponding to the vertical line passing
			// through root's left child, if not already.
			// This node would be the prev pointer of current linked list node
			if (root.left != null && curr.prev == null) {
				curr.prev = new ListNode(0, null, curr);
			}
			// create a new linked list node corresponding to the vertical line through
			// through root's right child, if not already.
			// This node would be the next pointer of current linked list node
			if (root.right != null && curr.next == null) {
				curr.next = new ListNode(0, curr, null);
			}
			// recur for left and right subtree
			VirticalSum(root.left, curr.prev);
			VirticalSum(root.right, curr.next);
		}

	public static void main(String[] args) {
		/*
		 * Construct below tree 1 / \ / \ 2 3 / \ / \ 5 6 / \ / \ 7 8
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		verticalSum(root);
	}

}

/* Try more Inputs
TreeNode root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(7);
verticalSum(root)
expected = [4, 2, 12, 3, 7]
*/
/*
Vertical sum of Binary Tree
Asked In: FacebookOLAMyntra
Binary tree is given and you need find vertical sum of the nodes that are in same vertical line in Time and Space Complexity O(n) Asked in : Facebook, OLA, Myntra

Example:

[Space Complexity O(n) due to the use of HashMap] 
Input : 
      1
    /   \
  2       3
 /     /    \
4   5  6     7
4, 2, 12, 3 and 7

Hint: Think of Doubly Linked List with vertical distance
Problem level: Medium

*/	