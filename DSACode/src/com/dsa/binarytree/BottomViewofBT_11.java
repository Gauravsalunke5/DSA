package com.dsa.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NodeLevel<U, V> {
	public final U level;
	public final V value;

	private NodeLevel(U level, V value) {
		this.level = level;
		this.value = value;
	}

	public static <U, V> NodeLevel<U, V> of(U a, V b) {

		return new NodeLevel<>(a, b);
	}
}

public class BottomViewofBT_11 {

	public static void bottamView(Node node, int d, int l, Map<Integer, NodeLevel<Integer, Integer>> map) {
		if (node == null)
			return;
		if (!map.containsKey(d) || l > map.get(d).level) {
			map.put(d, NodeLevel.of(l, node.data));
		}
		bottamView(node.left, d - 1, l + 1, map);
		bottamView(node.right, d + 1, l + 1, map);
	}

	// Function to print the bottom view of given binary tree
	public static ArrayList<Integer> bottamView(Node root) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		Map<Integer, NodeLevel<Integer, Integer>> map = new HashMap<>();
		bottamView(root, 0, 0, map);

		map.forEach((K, V) -> res.add(V.value));
		return res;
	}

	public static int bottamView1(Node root) {
		int res = 0;
		Map<Integer, NodeLevel<Integer, Integer>> map = new HashMap<>();

		int maxLevel = 0;
		for(NodeLevel<Integer,Integer> m : map.values()) {
			if (m.level > maxLevel) {
				res = m.value;
				maxLevel = m.level;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		System.out.print(bottamView(root));
	}
	//*******************NOTE************
	//https://leetcode.com/problems/find-bottom-left-tree-value/
//	class Solution {
//	    public int findBottomLeftValue(TreeNode root) {
//
//	        return findBottomLeftValue(root, 1, new int[]{0,0});
//	    }
//	   //[0]- res   [1]- level
//	    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
//	        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
//	        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
//	        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
//	        return res[0];
//	    }
//	}

}


/* Try more Inputs
Case 1:
result = []
Node root = new Node(20);
root.left = new Node(8);
root.right = new Node(22);
root.left.left = new Node(5);
root.left.right = new Node(3);
root.right.left = new Node(4);
root.right.right = new Node(25);
root.left.right.left = new Node(10);
root.left.right.right = new Node(14);
result = bottamView(root)
expected = [5,10,4,14,25]

Case2: 
Node root = new Node(20);
root.left = new Node(8);
root.right = new Node(22);
root.left.left = new Node(5);
root.left.right = new Node(3);
printLeftView(root)
expected = [5,3,22]
*/

/*
 * Bottom View of Binary Tree
Asked In: Paypal Amazon Paytm
Given a binary tree, print the values of nodes which would be present in bottom of view of binary tree Asked in : Paypal, Amazon, Paytm

Example:

        24
     /    \ 
   8         20
  /  \          \
5      3          28
       /
     13
5 13  3   20 28 
[ Node 13 hides Node 8 so from bottom 8 is not visible] 
Hint: Think of using horizontal distance concept 
Problem level: Medium

*/
