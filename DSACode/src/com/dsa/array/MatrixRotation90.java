package com.dsa.array;

public class MatrixRotation90 {

	static int N = 4;

	// In-place rotate it by 90 degrees in clockwise direction
	static void matrixRotation(int matrix[][]) {

		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - j][i];
				matrix[N - 1 - j][i] = matrix[N - i - 1][N - 1 - j];
				matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
				matrix[j][N - 1 - i] = temp;

			}
		}
	}

	static void printMatrix(int matrix[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) { 
        int matrix[][] = { { 1, 2, 3, 4 }, 
                { 5, 6, 7, 8 }, 
                { 9, 10, 11, 12 }, 
                { 13, 14, 15, 16 } }; 
        /*13 9 5 1 
		14 10 6 2 
		15 11 7 3 
		16 12 8 4 */
matrixRotation(matrix); 
printMatrix(matrix); 
}
}

	/* Try more Inputs
	case 1: 
	int matrix[][] = { { 1, 2, 3}, 
	                   { 4, 5, 6}, 
	                   { 7, 8, 9}}; 

	actual = matrixRotation(matrix)
	expected = 7  4  1 
	           8  5  2 
	           9  6  3
	*/
	/*
	
	In-place techniques matrix rotation method by 90 degree
	Asked In: Facebook Google Amazon Microsoft
	You are given a square matrix, You need to rotate the matrix in a clockwise direction by 90 degrees in Time Complexity O(m*n) and No Extra Space i.e O(1) Asked in : Facebook, Google, Amazon, Microsoft

	Example:

	Input : 
	If the array is
	[
	    [1, 2],
	    [3, 4]
	]
	Output:
	Rotated array becomes:
	[
	    [3, 1],
	    [4, 2]
	]
	Hint1 : Select 4 numbers from each corner of matrix and rotate clock wise 
	Hint2 : Repeat this process for every layer of matrix
	Problem level: Hard
	*/