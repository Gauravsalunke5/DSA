package com.dsa.binarytree;

public class FindLargestSubtreeInBST_16 {

	static class List {
		int sz;
		int min;
		int max;
		boolean isBST;
		public List(int sz, int min, int max,  boolean isBST) {
			super();
			this.sz = sz;
			this.min = min;
			this.max = max;
			this.isBST = isBST;
		}
	};

	static List largestBST(Node root) {
		if (root == null)
			return new List(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		if (root.left == null && root.right == null)
			return new List(1, root.data, root.data, true);

		List left = largestBST(root.left);
		List right = largestBST(root.right);

		List res = new List(0, 0, 0, false);
		if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
			res.min =  Math.min(left.min, Math.min(root.data, right.min));
			res.max =  Math.max(right.max, Math.max(root.data, left.max));
			res.isBST = true;
			res.sz = 1 + left.sz + right.sz;
			// return res where isBST is true
			return res;
		}
		res.sz = Math.max(left.sz, right.sz);
		// return res where isBST is false
		return res;
	}

	public static void main(String args[]) {

		 /* Let us construct the following Tree
        50
       /  \
      75  45
     /
    40 */
    Node root = new Node(60) ; 
    root.left = new Node(65)  ;
    root.right = new Node(70)  ;
    root.left.left = new Node(50) ;
		List res = largestBST(root);
		System.out.print(" Size of the largest BST is "+res.sz );
	}

}

/* Try more Inputs
case1:
root = new Node(60) ; 
root.left = new Node(65)  ;
root.right = new Node(70)  ;
root.left.left = new Node(50) ;
actual = largestBSTBT(root)
expected = 2

case2:
root = newNode(5)  
root.left = newNode(2)  
root.right = newNode(4)  
root.left.left = newNode(1)
root.left.right = newNode(3)  
actual = largestBSTBT(root)
expected = 3

*/

/*
 * Find largest Subtree in BST
Asked In: AdobeJ P Morgan
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where the largest means subtree with the largest number of nodes in it.

Example:

Input: 
      5
    /  \
   2      4
 /  \
1    3
Output: 3 
The following subtree is the 
maximum size BST subtree 
   2  
 /  \
1    3
Problem level: Hard
*/
