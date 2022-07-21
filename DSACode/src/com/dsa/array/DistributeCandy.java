package com.dsa.array;

public class DistributeCandy {
	public static int candy(int[] ratings) {

		int n = ratings.length;
		if (ratings == null || n == 0) {
			return 0;
		}

		int[] left = new int[n];
		int[] right = new int[n];
		// configure the first and the last index of the left and right array
		left[0] = 1;
		right[n - 1] = 1;
		int result = 0;

		// traversing from left to right
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			} else {
				// if not ascending, assign 1
				left[i] = 1;
			}
		}

		// from right to left
		for (int i = n - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else {
				// if not ascending, assign 1
				right[i] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			result += Math.max(right[i], left[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		int ratings[] = { 1, 5, 2, 1 };
		// L=1,2,1,1
		// r=1,3,2,1
		int result = candy(ratings);
		System.out.println(result);
	}

}