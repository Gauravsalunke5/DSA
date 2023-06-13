package com.dsa.array;

public class TrappingRainWaterEfficiently {

	static int findWater(int[] array, int n) {
		// Store the left max and right max of each point in the map
		int maxLeft[] = new int[n];
		int maxRight[] = new int[n];
		// keeps track of the total water as we traverse the elevation map
		int water = 0;

		maxLeft[0] = array[0];
		// filling the left max list
		for (int i = 1; i < n; i++)
			maxLeft[i] = Math.max(maxLeft[i - 1], array[i]);

		maxRight[n - 1] = array[n - 1];
		// filling the right max list
		for (int i = n - 2; i >= 0; i--)
			maxRight[i] = Math.max(maxRight[i + 1], array[i]);

		// calculating the amount of water
		for (int i = 0; i < n; i++)
			water += Math.min(maxLeft[i], maxRight[i]) - array[i];

		return water;

	}

	public static void main(String[] args) {
		int array[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.print(findWater(array, array.length));
	}
}

/* Try more Inputs
case 1: 
actual = findWater([2, 0, 2],3)
expected = 2

case2: 
 actual = findWater([3, 0, 2, 0, 4],5)
 expected = 7
 
case3: 
actual = findWater([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1],12)
expected = 6
*/
/*
Trapping Rain Water Efficiently
Asked In: Microsoft DE-Shaw Amazon Adobe
N non-negative integers representing an elevation map where the width of each bar is 1. Write an algorithm to find how much water it is able to trap after raining in Time Complexity O(n) and Space Complexity O(n) Asked in : Microsoft, DE-Shaw, Amazon, Adobe

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 
Hint1: For Every tower, the water than can store on top it depends on max height tower on left or right
Hint2: Try finding out amount of water store for every tower
Problem level: Medium
*/