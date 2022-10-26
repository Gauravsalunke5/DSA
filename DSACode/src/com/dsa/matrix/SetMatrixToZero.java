package com.dsa.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixToZero {

	public static void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> colSet = new HashSet<Integer>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		for (Integer i : rowSet) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = 0;
			}
		}
		for (int i = 0; i < row; i++) {
			for (Integer j : colSet) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public static void setZeroesWithoutMemory(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int colFlag = 1;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0)
				colFlag = 0;
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
			if (colFlag == 0)
				matrix[i][0] = 0;
		}

	}
	
	
	//leetecode
	public static void main(String[] args) 
	{ 
		int matrix[][] = { { 0, 20, 30, 40 }, 
						{ 15, 25, 36, 46 }, 
						{ 28, 29, 0, 48 }, 
						{ 32, 33, 39, 0 } }; 
	//	int matrix[][] = { { 1},{3}};
		 
		setZeroes(matrix); 
	}

}
