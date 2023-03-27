package com.dsa.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class GrapthDFS {

	private ArrayList<Integer> dfsofGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<>();
		boolean vis[] = new boolean[V];

		dfs(0, adj, vis, ans);

		return ans;
	}

	private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
		vis[node] = true;
		ans.add(node);
//		for (Integer it : adj.get(node)) {
//			if (!vis[it]) {
//				dfs(it, adj, vis, ans);
//			}
//		}

		Iterator<Integer> it = adj.get(node).listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!vis[n])
				dfs(n, adj, vis, ans);
		}

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);

		GrapthDFS gp = new GrapthDFS();
		ArrayList<Integer> ans = gp.dfsofGraph(5, adj);
		ListIterator<Integer> listIterator = ans.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
	}

}
