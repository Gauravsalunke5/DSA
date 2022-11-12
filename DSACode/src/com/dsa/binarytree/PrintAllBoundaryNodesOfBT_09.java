package com.dsa.binarytree;

public class PrintAllBoundaryNodesOfBT_09 {

	Node root;
	// function to print leaf nodes of a Binary Tree

	// Function to do boundary traversal of a given binary tree
	void printBoundary(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printLeftExternalNodes(node.left);
		printleafNode(node);
		printRightExternalNodes(node.right);
	}

	private void printLeftExternalNodes(Node node) {
		if (node == null)
			return;

		if (node.left != null) {
			System.out.print(node.data + " ");
			printLeftExternalNodes(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			printLeftExternalNodes(node.right);
		}
	}

	private void printRightExternalNodes(Node node) {

		if (node == null)
			return;

		if (node.right != null) {
			printLeftExternalNodes(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null) {
			printLeftExternalNodes(node.left);
			System.out.print(node.data + " ");
		}

	}

	private void printleafNode(Node node) {
		if (node == null)
			return;
		printleafNode(node.left);
		if (node.left == null && node.right == null)
			System.out.print(node.data + " ");
		printleafNode(node.right);
	}

	public static void main(String args[]) {
		PrintAllBoundaryNodesOfBT_09 tree = new PrintAllBoundaryNodesOfBT_09();

		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.left.right.left.left = new Node(17);
		tree.printBoundary(tree.root);
	}
	
	//****************NOTE
//	https://leetcode.com/problems/binary-tree-right-side-view/
//	Binary Tree Right Side View
//	 public List<Integer> rightSideView(TreeNode root) {
//	        List<Integer> result = new ArrayList<Integer>();
//	        rightView(root, result, 0);
//	        return result;
//	    }
//	    
//	    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
//	        if(curr == null){
//	            return;
//	        }
//	        if(currDepth == result.size()){
//	            result.add(curr.val);
//	        }
//	        
//	        rightView(curr.right, result, currDepth + 1);
//	        rightView(curr.left, result, currDepth + 1);
//	        
//	    }
}
/* Try more Inputs
Case 1:
Main tree = new Main();
tree.root = new Node(20);
tree.root.left = new Node(8);
tree.root.right = new Node(22);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(12);
tree.root.right.left = new Node(10);
tree.root.right.right = new Node(25);
tree.printLeftView(root)
expected = [20,8,4,12,10,25,22]

Case2: 
Main tree = new Main();
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);
tree.root.right.left = new Node(6);
tree.root.right.right = new Node(7);
tree.root.left.left.left = new Node(8);
tree.root.left.left.right = new Node(9);
tree.root.left.right.right = new Node(10);
tree.root.right.right.left = new Node(11);
tree.root.left.left.right.left = new Node(12);
tree.root.left.left.right.right = new Node(13);
tree.root.right.right.left.left = new Node(14);
tree.printLeftView(root)
expected = [1,2,4,8,12,13,10,6,14,11,7,3]
*/

/*
Print all the boundary nodes of Binary Tree
Asked In: FlipkartOLAInMobi
Print all the boundary nodes in the binary tree.Boundary includes left boundary, leaves, and right boundary in anti clockwise direction in O(n) Time Complexity Asked in : Flipkart, OLA, InMobi

Example:

[O(n) : One complete traversal for leaves and two traversals upto depth of binary tree for left and right boundary]
Input:
                 1
	      /     \
             2        3
           /       /   \
         7       6       4
		/  \	   \
              17     9      8
Output: 1 2 7 17 9  8 4 3
Problem level: Medium
*/