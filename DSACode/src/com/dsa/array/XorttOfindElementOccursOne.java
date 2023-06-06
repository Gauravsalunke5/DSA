package com.dsa.array;

public class XorttOfindElementOccursOne {

	static int findSingle(int array[], int array_size) {
		int res = array[0];
		for (int i = 1; i < array.length; i++) {
			res = res ^ array[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int array[] = { 6, 2, 4, 3, 4, 2, 3 };
		int n = array.length;
		System.out.println("Element is " + findSingle(array, n) + " ");
	}
} 

/* Try more Inputs
case 1: 
actual = findSingle([-1,2,-1,3,2],5)
expected = 3

case2: 
 actual = findSingle([9,4,9,6,4],5)
 expected = 6
 
case3: 
actual = findSingle([1,1,2,2,3,3,4],7)
expected = 4
*/

/*

Xor method to find the element that occurs one
Asked In: Flipkart Amazon PayTm
Given an array where every element occurs two times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space Asked in : Flipkart, Amazon, PayTm

Example:

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Input: [2,2,1]
Input: [4,1,2,1,2]
Output: 1
Output: 4
Hint: Think of Xor Method
Problem level: Easy
*/