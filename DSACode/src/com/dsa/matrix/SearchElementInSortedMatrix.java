package com.dsa.matrix;

import java.util.Iterator;

public class SearchElementInSortedMatrix {

	private static void searchElement(int[][] matrix, int x, int value) 
	{
		int r = matrix.length;
		int c = matrix[0].length;
		int i = 0, j = c - 1;
		while (i < r && j >= 0) {
			if (matrix[i][j] == value) {
				System.out.println("Found " + i + " " + j);
				return;
			}
			if (matrix[i][j] > value)
				j--;
			else
				i++;
		}
		System.out.println("Not Found");
	} 
	
	public static void main(String[] args) 
	{ 
		int matrix[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 36, 46 }, 
						{ 28, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } }; 
	//	int matrix[][] = { { 1},{3}};
		 
		searchElement(matrix, 2, 32); 
	} 
} 

/* Try more Inputs

case1:
 actual = searchElement([[10, 20, 30, 40], 
		[15, 25, 36, 46], 
		[27, 29, 37, 48],
		[32, 33, 39, 50]],4,32)
 expected = True
 
case2:
actual = searchElement([[10, 20, 30, 40],
		[15, 25, 36, 46], 
		[27, 29, 37, 48], 
		[32, 33, 39, 50]],4,59)
expected = False

*/

/*
 * Search Element in Matrix
Asked In: Cisco Vmware Amazon
Matrix n*n is given, where all elements in any individual row or column are sorted. In such a matrix, we have to find the position of a value in O(n) Time Complexity and O(1) Space Complexity

Example:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Problem level: Medium
*/
