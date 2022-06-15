package com.dsa.array;

import java.util.Arrays;

public class FindNextGreaterNumber {

	static void swap(char array[], int i, int j) {

		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Given number as int array, this function finds the greatest number and give
	// the number as integer
	static void findNextNumber(char array[], int n) {
		int i;
		// Start from the right most digit and find the first digit that is smaller than
		// the digit next to it
		for (i = n - 1; i > 0; i--) {
			if (array[i] > array[i - 1]) {
				break;
			}
		}
		// If no such digit found,then all numbers are in descending order, no greater
		// number is possible
		if (i == 0) {
			System.out.println("Not possible");
		} else {
			// Find the smallest digit on the right side of (i-1)'th digit that is greater
			// than number[i-1]
			int x = array[i - 1], min = i;

			for (int j = i + 1; j < n; j++) {
				if (array[j] > x && array[j] < array[min]) {
					min = j;
				}
			}
			// Swapping the above found smallest digit with (i-1)'th
			swap(array, i - 1, min);

			Arrays.sort(array, i, n);
			System.out.print(array);
		}
	}

	public static void main(String[] args) {
		char array[] = { '2', '1', '8', '7', '6', '5' };
		int n = array.length;
		findNextNumber(array, n);
		System.out.println(array.toString());
	}
}
/*
 * Try more Inputs case 1: actual = findNextNumber([1,2,3,4],4) expected = 1243
 * 
 * case2: actual = findNextNumber([5,3,4,9,7,6],6) expected = 536479
 * 
 * case3: actual = findNextNumber([6,9,3,8,6,5,2],7) expected = 6952368
 */

/*
 * Digit rearrangement method to find next greater number with same set of
 * digits Asked In: Morgan Stanley Makemytrip Amazon
 */
/*
 * Write an algorithm to find out next greater number to given number with the
 * same set of digits Asked in : Morgan Stanley, Makemytrip, Amazon
 */
