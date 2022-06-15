package com.dsa.array;

public class RemoveDuplicatesArray {

	static int removeDuplicates(int array[], int n) {
		if (n == 0 || n == 1)
			return n;
		int j = 0;

		for (int i = 0; i < n - 1; i++) {
			if (array[i] != array[i + 1]) {
				array[++j] = array[i + 1];
			}
		}

		return j + 1;
	}

	public static void main(String[] args) {
		int array[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int n = array.length;

		n = removeDuplicates(array, n);

		for (int i = 0; i < n; i++)
			System.out.print(array[i] + " ");
	}

}

/*
 * Try more Inputs
 * 
 * case1: actual = removeDuplicates([1,1,2],3) expected = 2
 * 
 * case2: actual = removeDuplicates([2, 2, 2, 2, 2],5) expected = 1
 * 
 * case3: actual = removeDuplicates([1, 2, 2, 3, 4, 4, 4, 5, 5],9) expected = 5
 * 
 * case4: actual = removeDuplicates([1,2,3,4,5],5) expected = 5
 * 
 */

/*
 * Remove Duplicates From Sorted Array Asked In: Microsoft Amazon
 */
/*
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, Time complexity O(n) and Space complexity O(1)
 */