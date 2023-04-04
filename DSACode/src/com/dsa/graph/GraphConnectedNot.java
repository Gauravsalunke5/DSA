package com.dsa.graph;

import java.util.ArrayList;

public class GraphConnectedNot {

	private static boolean isConnected(ArrayList<ArrayList<Integer>> adj, int V) {

		for (int i = 0; i < V; i++) {
			boolean vis[] = new boolean[V];
			dfs(i, vis, adj);
			for (boolean b : vis) {
				if (!b)
					return false;
			}

		}
		return true;
	}

	private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = true;

		for (Integer it : adj.get(node)) {
			if (!vis[it])
				dfs(it, vis, adj);
		}

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		int V = 6;
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
//		adj.get(4).add(2);
		adj.get(2).add(5);
		adj.get(5).add(2);

		System.out.println(isConnected(adj, V));
	}

}