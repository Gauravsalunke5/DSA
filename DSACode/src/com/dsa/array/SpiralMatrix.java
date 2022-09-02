package com.dsa.array;

public class SpiralMatrix {
	static void spiralPrint(int m, int n, int matrix[][]) {
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (int i = colBegin; i <= colEnd; i++) {
				System.out.print(matrix[rowBegin][i] + " ");
			}
			rowBegin++;
			for (int i = rowBegin; i <= rowEnd; i++) {
				System.out.print(matrix[i][colEnd] + " ");
			}
			colEnd--;

			if (rowBegin < +rowEnd) {
				for (int i = colEnd; i >= colBegin; i--) {
					System.out.print(matrix[rowEnd][i] + " ");
				}
			}
			rowEnd--;
			if (colBegin <= colEnd) {
				for (int i = rowEnd; i >= rowBegin; i--) {
					System.out.print(matrix[i][colEnd] + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		int R = 4;
		int C = 4;
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spiralPrint(R, C, matrix);
		System.out.println();
		int matrix2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		spiralPrint(R, C, matrix2);
		System.out.println();
		int matrix3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		spiralPrint(R, C, matrix3);
	}
}

/*
 * Try more Inputs case 1: actual = spiralPrint(3,3,[[1,2,3],[4,5,6],[7,8,9]])
 * expected = [[1,2,3,6,9,8,7,4,5]]
 * 
 * case2: actual = spiralPrint(3,4,[[1,2,3,4],[5,6,7,8],[9,10,11,12]]) expected
 * = [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */

/*
 * Techniques to print matrix in spiral order without any extra space Asked In:
 * Microsoft OLA PayTm Oracle
 */
/*
 * you are given a matrix of m x n elements (m rows, n columns), Print all
 * elements of the matrix in spiral order in O(m*n) Time Complexity and O(1)
 * Space Complexity Asked in: Microsoft, OLA, PayTm, Oracle
 */