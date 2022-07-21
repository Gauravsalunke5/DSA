package com.dsa.array;

public class FindElementLessBeforeGreaterAfter {

	private static int findElement(int[] array, int n) {
		int left[] = new int[n];
		left[0] = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], array[i - 1]);
		}
		int right = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (left[i] < array[i] && array[i] < right)
				return i;
			right = Math.min(right, array[i]);
		}

		return -1;
	}

	public static void main(String[] args) {
		int array[] = { 1,2,3,4,5,6 };
		int n = array.length;

		n = findElement(array, n);
		System.out.println(n);

	}
}
/*
 * Try more Inputs
 * 
 * findElement(array, length_of_array)
 * 
 * 
 * case1: actual = findElement([5, 1, 4, 3, 6, 8, 10, 7, 9],9) expected = 4
 * 
 * case2: actual = findElement([6, 2, 5, 4, 7, 9, 11, 8, 10],9) expected = 4
 * 
 * case3: actual = findElement([5, 1, 4, 4],4) expected = -1
 * 
 */

/*
 * Left Side More Right Side Less Asked In: Amazon Akamai J P Morgan
 */
/*
 * We have an array, we have to find an element before which all elements are
 * less than it, and after which all are greater than it. Finally, return the
 * index of the element, if there is no such element, then return -1: Time
 * complexity O(n) and Space Complexity O(n)
 */