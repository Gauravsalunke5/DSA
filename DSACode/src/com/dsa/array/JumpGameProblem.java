package com.dsa.array;

import java.util.Iterator;

public class JumpGameProblem {

	private static int Jump(int[] num) {
		int a = num[0];
		int b = num[0];
		int jump = 1;
		for (int i = 1; i < num.length - 1; i++) {
			if (i == num.length - 1) {
				return jump;
			}
			a--;
			b--;
			if (b < num[i]) {
				b = num[i];
			}
			if (a == 0) {
				a = b;
				jump++;
			}
			if (b == 0)
				return 0;
		}

		return jump;
	}

	public static void main(String[] args) {
		int num[] = { 2, 3, 1, 1, 4 };

		System.out.println("Minimum number of jumps to reach end is : " + Jump(num));
	}
}
/*
 * Try more Inputs case 1: actual = Jump([1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9])
 * expected = 3
 * 
 * case2: actual = Jump([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]) expected = 10
 * 
 * case3: actual = Jump([3,2,1,0,4]) expected = -1 Jump not possible
 */

/*
 * Linear time approach to solve jump game problem Asked In: Adobe Intuit
 */
/*
 * You have an array of non-negative integers,you are initially positioned at
 * the first index of the array.Each element in the array represents your
 * maximum jump length at that position.Determine if you are able to reach the
 * last index in O(n) Time complexity and O(1) Space Complexity Asked in: Adobe,
 * Intuit
 */