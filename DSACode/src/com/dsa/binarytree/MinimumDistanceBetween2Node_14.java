package com.dsa.binarytree;

public class MinimumDistanceBetween2Node_14 {
	public static Node LowestCommonAncestor(Node root, int n1, int n2) {
		if (root == null || root.data == n1 || root.data == n2)
			return root;
		Node left = LowestCommonAncestor(root.left, n1, n2);
		Node right = LowestCommonAncestor(root.right, n1, n2);
		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	public static int findDistnace(Node root, int key, int level) {
		if (root == null)
			return -1;
		if (root.data == key)
			return level;
		int left = findDistnace(root.left, key, level + 1);
		if (left == -1)
			return findDistnace(root.right, key, level + 1);

		return left;
	}

	public static int findDistance(Node root, int a, int b) {
		Node LowestCommonAncestor = LowestCommonAncestor(root, a, b);

		int d1 = findDistnace(LowestCommonAncestor, a, 0);
		int d2 = findDistnace(LowestCommonAncestor, b, 0);

		return d1 + d2;
	}

	public static void main(String[] args) {

		Node  
		root =new Node(5) ;
				root.left =new Node(3) ;
				root.right =new Node(6) ;
				root.left.left =new Node(2) ;;
				root.left.right =new Node(4) ;
				root.left.left.left =new Node(1) ;
				root.right.right =new Node(7) ;;
				root.left.right.right =new Node(8) ;

		System.out.println(findDistance(root, 1, 8));
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
root.right.left.right = Node(10) 
actual = findDistance(root,6,7)

case2:
root = Node(5) 
root.left = Node(3) 
root.right = Node(6) 
root.left.left = Node(2) 
root.left.right = Node(4) 
root.left.left.left = Node(1) 
root.right.right = Node(7) 
root.left.right.right = Node(8) 
actual = findDistance(root,1,8)
expected = 5


*/
/*
Distance Between two Nodes
Asked In: BroadcomQualcomm
Find the distance between two keys in a binary tree, no parent pointers are given. Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.

Example:

Input: 
         5
        / \
       3   6
      / \     \
     2   4       8
    /      \
   1          7
The distance between 1 and 4 is 3: [1 -> 2 -> 3 -> 4]

The distance between 1 and 8 is 5: [1 -> 2 -> 3 -> 5 -> 6 -> 8]
Problem level: Easy
*/