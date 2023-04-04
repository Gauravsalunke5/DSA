package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraphBFS {

	public class Node {
		int first, second;

		public Node(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	private boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean vis[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!vis[i])
				if (checkForCycle(i, vis, adj))
					return true;
		}
		return false;
	}

	private boolean checkForCycle(int s, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(s, -1));
		vis[s] = true;

		while (!q.isEmpty()) {
			int node = q.peek().first;
			int parent = q.peek().second;
			q.poll();

			for (Integer it : adj.get(node)) {
				if (!vis[it]) {
					vis[it] = true;
					q.add(new Node(it, node));
				} else if (parent != it)
					return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int V = 4;
 		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(3).add(2);
 		adj.get(3).add(1);

 		DetectCycleUndirectedGraphBFS obj = new DetectCycleUndirectedGraphBFS();
		System.out.println(obj.isCycle(adj, V));
	}

}
