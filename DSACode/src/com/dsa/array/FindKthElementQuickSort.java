package com.dsa.array;

import java.util.Arrays;

public class FindKthElementQuickSort {
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private int partition(int[] array, int low, int high) {
		int pivot = array[high];

		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}

		}
		swap(array, i + 1, high);
		return i + 1;
	}

	private int quickSort(int[] array, int low, int high, int k) {
		if (low < high) {
			int pi = partition(array, low, high);

			if (k < pi)
				quickSort(array, low, pi - 1, k);
			else
				quickSort(array, pi + 1, high, k);
		}
		return array[k];

	}

	// finds the kth position in a given unsorted array i.e this function can be
	// used to find both kth largest and kth smallest element in the array.
	int findKthElement(int array[], int low, int high, int k) {

		return quickSort(array, low, high, k);
	}

	public static void main(String args[]) {
		FindKthElementQuickSort ob = new FindKthElementQuickSort();
		int array[] = { -1,2,0 };
		int n = array.length, k = 2;
		int[] array2 = Arrays.copyOf(array, n);

		System.out.println("K'th smallest element is " + ob.findKthElement(array, 0, n - 1, k));

		System.out.println("K'th Largest element is " + ob.findKthLargestElement(array2, 0, n - 1, k));
	}

	private int findKthLargestElement(int[] array, int low, int high, int k) {
		return quickSortDESC(array, low, high, k);
	}

	private int quickSortDESC(int[] arr, int low, int high, int k) {
		if (low < high) {

			int pi = partitionDESC(arr, low, high);

			if (k <= pi)
				quickSortDESC(arr, low, pi - 1, k);
			else
				quickSortDESC(arr, pi + 1, high, k);
		}
		return arr[k-1];
	}

	private int partitionDESC(int[] arr, int low, int high) {
		int pivot = arr[low];

		int i = high + 1;
		for (int j = high; j > low; j--) {

			if (arr[j] < pivot) {
				i--;
				swap(arr, i, j);
			}

		}
		swap(arr, i - 1, low);
		return i - 1;
	}
}

/* Try more Inputs
case 1: 
actual = findKthElement([7, 10, 4, 3, 20, 15],0,5,3)
expected = 7

case2: 
 actual = findKthElement([7, 10, 4, 3, 20, 15],0,5,4)
 expected = 10
 
case3: 
actual = findKthElement([12, 3, 5, 7, 19],0,4,2)
expected = 5
*/
/*
QuickSelect Algorithm to find the Kth smallest Element in array - 1
Asked In: Vmware SapLabs WalmartLabs
Find kth smallest element in that in an unsorted integer array in Time Complexity O(n) and Space Complexity O(1) Asked in :Vmware, SapLabs, WalmartLabs

Example:

Best and Average Case Complexity : O(n)
[In Quick Select method, choosing one element as a pivot and partitioning the data in two based on the pivot accordingly, as less than or greater than the pivot. However, instead of recursing into both sides as in quicksort, quickselect only recurs into one side – the side with the element it is searching for. Since the pivot is in its final sorted position, all those preceding it in an unsorted order and all those following it in an unsorted order]
Input : A[] = {10, 3, 6, 9, 2, 4, 15, 23}, K = 4

Input : A[] = {5, -8, 10, 37, 101, 2, 9}, K = 6
Output: 6
Output: 37
Hint 1: Unlike quicksort, which processes both sides of the array recursively, this algorithm works on only one side of the partition
Hint2: Recur for either the left or right side according to the position of pivot.
Problem level: Hard
*/