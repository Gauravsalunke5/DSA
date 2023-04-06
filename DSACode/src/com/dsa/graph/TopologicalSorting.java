package com.dsa.graph;

import java.util.ArrayList;

public class TopologicalSorting {

	private void topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub

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

		TopologicalSorting obj = new TopologicalSorting();
		obj.topologicalSort(V, adj);
	}

}
