package com.dsa.graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraphDFS {

	private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean vis[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!vis[i])
				if (dfs(i, vis, adj, -1))
					return true;
		}
		return false;
	}

	private static boolean dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int parent) {
		vis[node] = true;

		for (Integer it : adj.get(node)) {
			if (!vis[it]) {
				if (dfs(it, vis, adj, node))
					return true;
			} else if (it != parent) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int V = 4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(3).add(2);
		adj.get(3).add(1);

		System.out.println(isCycle(adj, V));
	}

}

/*
 Depth-first search method to find cycle in a graph
Asked In: Adobe Makemy TripIntuit
Given a undirected graph, write an algorithm to find out whether graph contains cycle or not in Time Complexity O(Vertex + Edge) and Space Complexity O(Vertex) : Asked in : Adobe, MakemyTrip, Intuit

Example:

Input:
Adjacency matrix
   
    0 1 0 0 0
    1 0 1 1 0
    0 1 0 0 1
    0 1 0 0 1
    0 0 1 1 0
Output:
The graph has cycle.
Hint: Think of DFS or BFS Approach
Problem level: Medium
*/
