package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LexicographicalOrderMethodNextSsmallestPalindrome {

	static void utilityFunction1(int array[], int n) {

		// find the index of mid digit
		int mid = n / 2;
		// end of left side is always 'mid -1'
		int i = mid - 1;
		// Beginning of right side depends if n is odd or even
		int j = (n % 2 == 0) ? mid : mid + 1;

		while (i >= 0 && array[i] == array[j]) {
			i--;
			j++;
		}
		int carry = 0;

		// increment +1 if all same or left is smaller than right
		if (i < 0 || array[i] < array[j]) {
			// reset i and j value since there is increment 
			i = mid - 1;
			if (n % 2 == 0) {
				j = mid;
				array[i] += 1;
				carry = array[i] / 10;
				array[i] %= 10;
				array[j++] = array[i--];
			} else {
				j = mid + 1;
				array[mid] += 1;
				carry = array[mid] / 10;
				array[mid] %= 10;
			}

		}

		// replace remaining 
		while (i >= 0) {
			array[i] += carry;
			carry = array[i] / 10;
			array[i] %= 10;
			array[j++] = array[i--];
		}

	}

	static void utilityFunction(int array[], int n) {
		// find the index of mid digit
		int mid = n / 2;
		// end of left side is always 'mid -1'
		int i = mid - 1;
		// Beginning of right side depends if n is odd or even
		int j = (n % 2 == 0) ? mid : mid + 1;
		// A bool variable to check if copy of left side to right is sufficient or not
		boolean leftsmaller = false;

		while (i >= 0 && array[i] == array[j]) {
			i--;
			j++;
		}
		// Find if the middle array(s) need to be incremented or not (or copying left
		// side is not sufficient)
		if (i < 0 || array[i] < array[j]) {
			leftsmaller = true;
		}
		// Copy the mirror of left to right
		while (i >= 0) {
			array[j++] = array[i--];
		}
		// Handle the case where middle digit(s) must be incremented.  
		if (leftsmaller) {
			int carry = 1;
			// If there are odd digits, then increment the middle digit and store the carry
			if (n % 2 == 1) {
				array[mid] += 1;
				carry = array[mid] / 10;
				array[mid] %= 10;
			}
			i = mid - 1;
			j = (n % 2 == 0 ? mid : mid + 1);
			// Add 1 to the rightmost digit of the left side, propagate the carry towards
			// MSB digit and simultaneously copying mirror of the left side to the right
			// side
			while (i >= 0 && carry > 0) {
				array[i] = array[i] + carry;
				carry = array[i] / 10;
				array[i] %= 10;
				array[j] = array[i];
				i--;
				j++;
			}

		}
	}

	static void nextPalindromeProblem1(int array[], int n) {

		// System.out.println("Next Palindrome is:");

		if (isAl9l(array)) {
			System.out.print("1");
			for (int i = 0; i < n - 1; i++)
				System.out.print("0");
			System.out.println("1");
		} else {
			utilityFunction1(array, n);
			printarray(array);
		}
	}

	// The function that prints next palindrome of a given number array[] with n
	// digits.
	static void nextPalindromeProblem(int array[], int n) {

		// System.out.println("Next Palindrome is:");

		if (isAl9l(array)) {
			System.out.print("1");
			for (int i = 0; i < n - 1; i++)
				System.out.print("0");
			System.out.println("1");
		} else {
			utilityFunction(array, n);
			printarray(array);
		}
	}

	private static boolean isAl9l(int[] array) {
		for (int i : array) {
			if (i != 9)
				return false;
		}
		return true;
	}

	static void printarray(int array[]) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]);
		System.out.print(" ");
	}

	public static void main(String[] args) {
		int array[] = { 8, 3, 1, 7, 7, 9, 7, 9, 3, 2, 3 };
		run(array);
		run(new int[] { 1, 2, 1 });
		run(new int[] { 2, 3, 5, 4, 5 });
		run(new int[] { 2, 4, 3, 6 });
		run(new int[] { 2, 4, 8, 6 });
		run(new int[] { 2, 4, 1, 3, 6 });
		run(new int[] { 2, 4, 1, 8, 6 });
		run(new int[] { 2, 4, 9, 3, 6 });
		run(new int[] { 2, 1, 4, 4, 8, 8, 3, 6 });
		run(new int[] { 2, 9, 9, 9, 6 });
		run(new int[] { 2, 9, 9, 6 });
		run(new int[] { 2, 2, 2, 2 });

		String str="121";
		int[] arr = Arrays.stream(str.substring(0, str.length()).split(""))
			    .map(String::trim).mapToInt(Integer::parseInt).toArray();
		run(arr);
		System.out.println(	);
	}

	private static void run(int[] array) {
		int array1[] = Arrays.copyOf(array, array.length);
		printarray(array);
		nextPalindromeProblem(array, array.length);
		nextPalindromeProblem1(array1, array1.length);
		System.out.println(Arrays.compare(array, array1) == 0);
	}
}

	/* Try more Inputs
	case 1: 
	actual = nextPalindromeProblem([9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2],11)
	expected = 94188088149

	case2: 
	 actual = nextPalindromeProblem([1,2,1],3)
	 expected = 131
	 
	case3: 
	actual = nextPalindromeProblem([2,3,5,4,5],5)
	expected = 23632
	*/

/*

Lexicographical order method to solve next smallest palindrome
Asked In: Flipkart Oracle
Find next smallest palindrome larger than this given number Asked in: Flipkart, Oracle

Example:

[if the number is 125, next smallest palindrome is 131.] 
[if the input number is “2 3 5 4 5”, the output should be “2 3 6 3 2”]
Input number is “2 3 5 4 5”

input number is “9 9 9”
output should be “2 3 6 3 2”

Output should be “1 0 0 1”

Hint1: Check symmetry for making a number a palindrome
Hint2: Start checking from mid point of a given number for palindrome
Problem level: Hard
*/