package com.dsa.array;

public class CountFrequenciesOfArrayElements {

	// Function to find counts of all elements present in arr[0..n-1]. The array
	// elements must be range from 1 to n
	public static void countfrequenciesEfficient(int input[]) {

		int n = input.length;

		for (int i = 0; i < n; i++) {
			input[i]--;
		}
		for (int i = 0; i < n; i++) {
			input[input[i] % n] += n;
		}
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " " + input[i] / n);
			input[i] = input[i] % n + 1;
		}

	}

	public static void main(String[] args) {
		int[] input = { 2, 3, 3, 2, 5 };
		countfrequenciesEfficient(input);
	}
}

/*
 * Try more Inputs case 1: actual = countfrequenciesEfficient([1, 2, 2, 1, 1, 2,
 * 3, 2]) expected = [[1 3],[2 4],[3 1]]
 * 
 * case2: actual = countfrequenciesEfficient([1, 2, 2]) expected = [[1 1],[2 2]]
 * 
 * case3: actual = countfrequenciesEfficient([4, 4, 4, 4}]) expected = [[4 4]]
 */

/*
 * 
 * Count frequencies of array elements in O(n) time complexity Asked In: PayTm
 * VmWare Amazon
 */
/*
 * Array of length n having integers 1 to n with some elements being repeated.
 * Count frequencies of all elements from 1 to n in Time Complexity O(n) and
 * Space Complexity O(1) Asked in : : PayTm, VmWare, Amazon
 */