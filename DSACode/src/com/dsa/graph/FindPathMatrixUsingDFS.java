package com.dsa.graph;

public class FindPathMatrixUsingDFS {

	static int path = 1;
	static int m, n;

	static boolean DFSTraversal(int matrix[][]) {
		m = matrix.length;
		n = matrix[0].length;
		boolean vis[][] = new boolean[m][n];
		int di = matrix.length - 1;
		int dj = matrix[0].length - 1;
		DFSTraversal(matrix, vis, 0, 0, di, dj);
		if (vis[di][dj])
			return true;
		return false;
	}

	private static void DFSTraversal(int[][] matrix, boolean[][] vis, int si, int sj, int di, int dj) {
		if (si < 0 || si >= m || sj < 0 || sj >= n || matrix[si][sj]!=path || vis[si][sj])
			return;

		if(vis[di][dj])
			return;
		
		System.out.print(si +""+sj+" ");
		vis[si][sj] = true;
		
		DFSTraversal(matrix, vis, si, sj + 1, di, dj);
		DFSTraversal(matrix, vis, si + 1, sj, di, dj);
		DFSTraversal(matrix, vis, si - 1, sj, di, dj);
		DFSTraversal(matrix, vis, si, sj - 1, di, dj);
		return;
	}

	public static void main(String[] args) {
		int matrix[][] = 
				{ { 1, 0, 0, 0, 0 }, 
                { 1, 0, 1, 1, 1 }, 
                { 1, 1, 1, 0, 1 }, 
                { 1, 0, 0, 0, 1 }, 
                { 1, 0, 0, 0, 1 } }; 

		if (DFSTraversal(matrix))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
