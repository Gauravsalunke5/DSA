package com.dsa.array;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class FindTwoNonRepeatingNumber {

	public void find2Element(int[] nums) { // Create a Map Set to store the numbers
		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		int n = nums.length;

		/*
		 * Iterate through the array and check if each element is present or not in the
		 * set. If the element is present, remove it from the array otherwise add it to
		 * the set
		 */

		for (int i = 0; i < n; i++) {
			if (set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
		}

		// Iterator is used to traverse through the set
		Iterator<Integer> i = set.iterator();

		/*
		 * Since there will only be 2 non-repeating elements we can directly print them
		 */
		System.out.println("The 2 non repeating numbers are : " + i.next() + " " + i.next());
	}

	public static void main(String[] args) {
		FindTwoNonRepeatingNumber t = new FindTwoNonRepeatingNumber();
		int[] array = { 2, 4, 7, 9, 2, 4 };
		t.find2Element(array);

	}
}

	/* Try more Inputs

	case1:
	actual = find2Element([2,4,7,9,2,4])
	expected = 7,9

	case2:
	actual = find2Element([4,5,4,5,3,2,9,3,9,8])
	expected = 2,8

	case3:
	actual = find2Element([1,1,2,2,3,3,4,5,5,6,7,7])
	expected = 6,4
	        

	*/

/*
Find Two Non Repeating Number
Asked In: Google OLA
Given an array in which all numbers except two are repeated once. (i.e. we have 2n+2 numbers and n numbers are occurring twice and the remaining two have occurred once). Find those two numbers in the most efficient way

Example:

int [] arrA = {4,5,4,5,3,2,9,3,9,8};
Output: 2 and 8
Problem level: Hard
*/