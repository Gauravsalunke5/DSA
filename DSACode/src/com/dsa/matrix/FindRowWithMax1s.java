package com.dsa.matrix;

public class FindRowWithMax1s {

	static int m = 4, n = 4;

	static int binarySearch(int array[], int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || array[mid - 1] == 0) && array[mid] == 1)
				return mid;
			else if (array[mid - 1] == 1)
				return binarySearch(array, low, mid - 1);
			else
				return binarySearch(array, mid + 1, high);
		}
		return -1;
	}

	static int findRow(int matrix[][]) {

		int maxRowIndex = 0, max = -1;
		int row = matrix.length, col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			int index = binarySearch(matrix[i], 0, col - 1);
			if (index != -1 && max < col - index) {
				max = col - index;
				maxRowIndex = i;
			}
		}
		return maxRowIndex;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 0, 1, 1, 1 }, 
				{ 0, 0, 1, 1 }, 
				{ 0, 0, 0, 1 }, 
				{ 1, 1, 1, 1 } }; 
		System.out.println("Index of row with maximum 1s is " + findRow(matrix));

	}
} 

/* Try more Inputs
case1:
 actual = findRow([[0, 1, 1, 1], 
       [0, 0, 1, 1], 
       [1, 1, 1, 1], 
       [0, 0, 0, 0]])
expected = 2

case2:
actual = findRow([[1, 1, 1], 
       [0, 0, 0], 
       [1, 1, 0], 
       [1, 0, 0]])
expected = 0

case3:
actual = findRow([[0, 0, 0, 1, 1], 
       [0, 0, 1, 1, 1], 
       [0, 0, 0, 0, 0], 
       [0, 1, 1, 1, 1],
       [0, 0, 0, 0, 1]])
expected = 4

*/
/*
Find Row with Max 1's
Asked In: Sap LabsIBM ISLMcafee
A 2-D array of 1's and 0's is given. Find the row with max 1's in Time Complexity O(nlogn) and Space Complexity O(1) . The array is sorted row wise (all 0's in a row are followed by all 1's

Example:

Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0
Output: 2
[Hint : Think of using binary search across sorted rows] 
Problem level: Easy
*/