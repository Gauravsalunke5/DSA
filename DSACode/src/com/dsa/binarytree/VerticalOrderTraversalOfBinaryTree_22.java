package com.dsa.binarytree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfBinaryTree_22 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class ListNode {
		public HashMap<Integer, List<Integer>> data;
		ListNode prev, next;

		ListNode(ListNode prev, ListNode next) {
			this.data = new HashMap<>();
			this.prev = prev;
			this.next = next;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		ListNode curr = new ListNode(null, null);
		verticalTraversal(root, curr, 0, 0);

		while (curr != null && curr.prev != null)
			curr = curr.prev;

		while (curr != null) {
			List<Integer> r = new ArrayList<>();
			curr.data.values().forEach(S -> {
				S.sort(Comparator.naturalOrder());
				r.addAll(S);
			});
			res.add(r);
			curr = curr.next;
		}

		return res;
	}

	private void verticalTraversal(TreeNode root, ListNode curr, int x, int y) {
		if (root == null)
			return;

		int index = Math.max(x, y);
		if (!curr.data.containsKey(index))
			curr.data.put(index, new ArrayList<Integer>());

		curr.data.get(index).add(root.val);

		if (root.left != null && curr.prev == null)
			curr.prev = new ListNode(null, curr);

		if (root.right != null && curr.next == null)
			curr.next = new ListNode(curr, null);

		verticalTraversal(root.left, curr.prev, x + 1, y - 1);
		verticalTraversal(root.right, curr.next, x + 1, y + 1);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);

		VerticalOrderTraversalOfBinaryTree_22 a = new VerticalOrderTraversalOfBinaryTree_22();
		a.verticalTraversal(root);
	}
}
