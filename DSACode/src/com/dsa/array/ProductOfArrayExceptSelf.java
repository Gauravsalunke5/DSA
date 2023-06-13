package com.dsa.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		int array[] = { 1, 2, 3, 4 };
		int[] res = obj.productOfArrayExceptSelf(array, array.length);
		Arrays.stream(res).forEach(a -> System.out.print(a + " "));
	}

	private int[] productOfArrayExceptSelf(int[] array, int n) {
		int res[] = new int[n];
		int leftProd[] = new int[n];
		int rightProd[] = new int[n];

		leftProd[0] = 1;
		// product of all left except i
		for (int i = 1; i < n; i++)
			leftProd[i] = leftProd[i - 1] * array[i - 1];

		rightProd[n - 1] = 1;
		// product of all right except i
		for (int i = n - 2; i >= 0; i--)
			rightProd[i] = rightProd[i + 1] * array[i + 1];

		for (int i = 0; i < n; i++)
			res[i] += leftProd[i] * rightProd[i];

		return res;
	}
}
//https://leetcode.com/problems/product-of-array-except-self/
/*
238. Product of Array Except Self
Medium
17.9K
987
Companies
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/