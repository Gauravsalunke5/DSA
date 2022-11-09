package com.dsa.binarytree;

public class PrintNodesAtKDistance_05 {

	Node root;

	void findNode_DistanceDown(Node node, int k) {

		if(node==null)
			return;
		if(k==0) {
			System.out.print(node.data+" ");
			return;
		}else {
			findNode_DistanceDown(node.left,k-1);
			findNode_DistanceDown(node.right, k-1);
		}
	}

	void findALLNode_DistanceDown(Node node, int k) {

		if (node == null)
			return;
		if (k <= 0)
			System.out.print(node.data + " ");
		
		findALLNode_DistanceDown(node.left, k - 1);
		findALLNode_DistanceDown(node.right, k - 1);

	}

	public static void main(String args[]) {
		PrintNodesAtKDistance_05 tree = new PrintNodesAtKDistance_05();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);
		int k = 1;
		tree.findNode_DistanceDown(tree.root, k);
		System.out.println();
		tree.findALLNode_DistanceDown(tree.root, k);
	}
} 


	/* Try more Inputs

	/* Constructed binary tree is           
	             1  
	            / \  
	           2   3  
	          / \ /  
	         4  5 8  
	    */
	/*Case 1:
	Main tree = new Main(); 
	tree.root = new Node(1);  
	tree.root.left = new Node(2);  
	tree.root.right = new Node(3);  
	tree.root.left.left = new Node(4);  
	tree.root.left.right = new Node(5);  
	tree.root.right.left = new Node(8); 
	tree.printLeftView(tree.root,2)
	expected = [4,5,8]*/

	//Case2: 
	/* Constructed binary tree is           
	             10  
	            / \  
	           12  3  
	           \  /  
	            4 5  
	                \
	                 6
	*/
	/*BinaryTree root = newNode(10);
	root.left = newNode(12);
	root.right = newNode(3);
	root.left.right = newNode(4);
	root.right.left = newNode(5);
	root.right.left.right = newNode(6);
	tree.printLeftView(root,2)
	expected = [4,5]
	*/
	
	/*
	Print nodes at k distance from root
	Asked In: Uber Flipkart Samsung
	Print all the nodes which are at k distance from the root. Root of the Binary tree and K is given as Input in Time Complexity O(n) Asked in : Uber, Flipkart, Samsung

	Example:

	[Time Complexity O(N) as we have to traverse the complete tree, N is the number of nodes in a tree]
	Input :
	                 1
		      /    \
	             2       3
	            /       /  \
	           7      6     5   
			 /	   \ 
	               17          8
	K(Distance) = 3
	Output : 17, 8 
	Problem level: Easy
	*/