package com.dsa.array;

public class MaximumValueOfArrj_Arri {

	int findDiff(int arr[], int n) {
		int rightMaxIndex[] = new int[n];
		int leftMaxIndex[] = new int[n];

		int maxDiff = -1;

		rightMaxIndex[n - 1] = n - 1;
		for (int i = n - 2; i >= 0; i--)
			rightMaxIndex[i] = arr[i] > arr[rightMaxIndex[i + 1]] ? i : rightMaxIndex[i + 1];

		leftMaxIndex[0] = 0;
		for (int i = 1; i < n; i++)
			leftMaxIndex[i] = arr[i] < arr[leftMaxIndex[i - 1]] ? i : leftMaxIndex[i - 1];

		int i = 0, j = 0;
		while (i < n && j < n) {
			if (arr[leftMaxIndex[i]] < arr[rightMaxIndex[j]]) {
				maxDiff = Math.max(maxDiff, rightMaxIndex[j] - leftMaxIndex[i]);
				j++;
			} else
				i++;
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		MaximumValueOfArrj_Arri assign = new MaximumValueOfArrj_Arri();
		int arr[] = { 35, 9, 12, 3, 2, 70, 31, 33, 1 };
		int n = arr.length;
		int maxDiff = assign.findDiff(arr, n);
		System.out.println(maxDiff);
	}
}

/* Try more Inputs
case1:
actual = findDiff([35, 9, 12, 3, 2, 70, 31, 33, 1])
expected = 6

case2:
actual = findDiff([1, 2, 3, 4, 5, 6])
expected = 5

case3:
actual = findDiff([9, 2, 3, 4, 5, 6, 7, 8, 18, 0])
expected = 8

case4:
actual = findDiff([6, 5, 4, 3, 2, 1])
expected = -1

*/

/*
Maximum value of |arr[i] - arr[j]
Asked In: Google Amazon Microsoft
Given an array A[] of N positive integers. The task is to find the maximum of j - i with the constraint of A[i] <= A[j]. Time Complexity : O(n) Space Complexity : O(n)

Example:

Input 34 8 10 3 2 80 30 33 1

Hint: [Think of traversing the array from the end and keep a track of the maximum number to the right of the current index]
Output 6
Problem level: Hard


*/