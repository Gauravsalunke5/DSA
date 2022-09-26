package com.dsa.matrix;

public class DiagonalMatrix {

	public static int m, n;

	private static void diagonalPrint1(int matrix[][]) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(matrix[i - j][j] + " ");
			}
		}

		for (int j = 0; j < n; j++) {
			int k = j + 1;
			for (int i = m - 1; i >= j; i--) {
				System.out.print(matrix[i][k++] + " ");
				// System.out.print( (i)+"-"+(k++) + ", ");
			}
		}

	}

	private static void diagonalPrintOpp(int matrix[][]) {
		for (int k = 0; k < n; k++) {
			int i = 0;
			int j = k;
			while (j > 0) {
				System.out.print(matrix[i][j] + " ");
				i++;
				j--;
			}

		}
		for (int k = 1; k < m; k++) {
			int i = k;
			int j = n - 1;
			while (i <= m - 1) {
				System.out.print(matrix[i][j] + " ");
				i++;
				j--;
			}
		}
	}

	// orginal
	private static void diagonalPrint(int matrix[][]) {

		for (int k = 0; k < m; k++) {
			int i = k;
			int j = 0;
			while (i >= 0) {
				System.out.print(matrix[i][j] + " ");
				i--;
				j++;
			}
		}
		for (int k = 1; k < n; k++) {
			int i = m - 1;
			int j = k;
			while (j <= n - 1) {
				System.out.print(matrix[i][j] + " ");
				i--;
				j++;
			}

		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, };

		m = matrix.length;
		n = matrix[0].length;

		diagonalPrintOpp(matrix);
	}
}
/*
 * Expected Output
 * 
 * 1 6 2 11 7 3 16 12 8 4 17 13 9 5 18 14 10 19 15 20
 */
/*
 * 
 * * Print Matrix Diagonally Asked In: Facebook Citrix Flipkart
 */
/*
 * Given a matrix of M x N elements (M rows, N columns), Print all elements of
 * the matrix in diagonal order in Time Complexity O(m*n) and Space Complexity
 * O(1)
 */