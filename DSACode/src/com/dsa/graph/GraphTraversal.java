package com.dsa.graph;

import java.util.ArrayList;

public class GraphTraversal {

	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	boolean visited[];
	int v;

	public GraphTraversal(int v) {
		this.v=v;
		this.visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}
	}

	private void addedge(int i, int j) {

		this.adj.get(i).add(j);

	}

	private void visit() {
		for(int i=0; i<v;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				System.out.print(i+" ");
				for(Integer it : adj.get(i)) {
					if(visited[it]==false) {
						visited[it]=true;
						System.out.print(it +" ");
					}
				}
			}
		}
	}
	
	private void ini() {
	    adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

	}

	public static void main(String[] args) {
		GraphTraversal g = new GraphTraversal(5);
		g.ini();
		// add edge from 0 to 1 and so on ..
//		g.addedge(0, 1);
//		g.addedge(1, 2);
//		g.addedge(1, 4);
//		g.addedge(2, 4);
//		g.addedge(3, 0);
//		g.addedge(3, 4);

		g.visit();
	}

}
