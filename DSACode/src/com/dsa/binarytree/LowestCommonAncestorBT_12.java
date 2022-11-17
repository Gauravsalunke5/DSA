package com.dsa.binarytree;

public class LowestCommonAncestorBT_12 {

	Node root;

	Node lowestCommonAncestor(Node node, int data1, int data2) {
		if (node == null || node.data == data1 || node.data == data2)
			return node;
		Node left = lowestCommonAncestor(node.left, data1, data2);
		Node right = lowestCommonAncestor(node.right, data1, data2);
		if (left != null && right != null)
			return node;
		return left != null ? left : right;
	}

	public static void main(String args[]) {
		LowestCommonAncestorBT_12 tree = new LowestCommonAncestorBT_12();
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(9);

		Node lca = tree.lowestCommonAncestor(tree.root, 6, 7);
		if (lca != null)
			System.out.println("LCA(4, 5) = " + lca.data);
		else
			System.out.println("Keys are not present");

	}
}

/* Try more Inputs
case1:
root = Node(3) 
root.left = Node(4) 
root.right = Node(5) 
root.left.left = Node(6) 
root.left.right = Node(7) 
root.right.left = Node(8) 
root.right.right = Node(9) 
actual = findLCA(root,4,9)
expected = 3

case2:
root = Node(3) 
root.left = Node(4) 
root.right = Node(5) 
root.left.left = Node(6) 
root.left.right = Node(7) 
root.right.left = Node(8) 
root.right.right = Node(9) 
actual = findLCA(root,6,7)
expected = 4

*/
/*
Lowest Common Ancestor of BT
Asked In: Intuit Thoughtworks Aricent
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants

Example:

 input:
           3
        /   \
       5        1
      /  \ 
     6      2
For the above tree, the LCA of nodes 5 and 1 is 3
Problem level: Easy
*/