package com.dsa.array;

public class BinarySchToFindKthSmallest2SortedArray {
	static int kth(int[] first, int[] second, int start_f, int start_s, int end_f, int end_s, int k) {

		// calculating medians
		int m1 = median(first, start_f, end_f);
		int m2 = median(second, start_s, end_s);
		
		

		return 0;
	}

	private static int median(int[] array, int start, int end) {
		int n = end - start + 1;
		if (n % 2 == 0) {
			return (array[start + (n / 2)] + array[start + (n / 2 - 1)]) / 2;
		} else {
			return array[start + n / 2];
		}
	}

	public static void main(String[] args) {
		int arr1[] = { 2, 3, 6, 7, 9 };
		int arr2[] = { 1, 4, 8, 10 };
		int k = 6;
		int st1 = 0, st2 = 0;
		System.out.println(kth(arr1, arr2, st1, st2, arr1.length, arr2.length, k));
	}
}

/*
 * Kth Smallest Element Asked In: Google Microsoft Given two sorted arrays of
 * size m and n respectively, you are tasked with finding the element that would
 * be at the k’th position of the final sorted array Time Complexity: O(log n +
 * log m)
 * 
 * Example:
 * 
 * Input : Array 1 - 2 3 6 7 9 Array 2 - 1 4 8 10 k = 5 [Hint : Think of using
 * binary search to kth smallest element] Output : 6 Explanation: The final
 * sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10 The 5th element of this
 * array is 6. Problem level: Hard
 */