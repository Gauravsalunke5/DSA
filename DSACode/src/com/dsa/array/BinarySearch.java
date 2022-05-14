package com.dsa.array;

public class BinarySearch {
	public static int binarySearch(int[] array, int left, int right, int key) {
		if (left > right) {
			return -1;
		}
		/*
		 * [Note: we can also use low + (high - low)/2 to avoid overflow. Consider an
		 * example where the data type of the low and high is integer. So integer has an
		 * upper range of 65535 if it is an unsigned integer. Now consider the value of
		 * low as 2048 and high as 65530. Now if you calculate (low + high) .Clearly
		 * 65530 + 2048 is larger that 65535 (max value stored in 2 bytes) and this
		 * would result in an overflow, So, it will give you a wrong result due to
		 * overflow of integer data type. Now if you calculate mid as low + ( high -low
		 * )/2 , it will give you a correct result]
		 */
		int mid = (left + right) / 2;

		// overflow can happen. Use below
		// int mid = left + (right - left) / 2;

		if (key == array[mid]) {
			return mid;
		}
		else if (key < array[mid]) {
			return binarySearch(array, left, mid - 1, key);
		}
		else {
			return binarySearch(array, mid + 1, right, key);
		}
	}

	public static void main(String[] args) {
		int[] A = { 2, 5, 6, 8, 9, 10 };
		int key = 5;

		int left = 0;
		int right = A.length - 1;

		int index = binarySearch(A, left, right, key);

		if (index != -1) {
			System.out.println("Element found at index " + index);
		} else {
			System.out.println("Element not found in the array");
		}
	}
}
