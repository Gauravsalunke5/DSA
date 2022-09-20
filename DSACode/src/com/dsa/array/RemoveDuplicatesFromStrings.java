package com.dsa.array;

public class RemoveDuplicatesFromStrings {
	static String removeDuplicatesFromString(String str1) {
		int ascii[] = new int[256];
		String res = "";
		for (int i = 0; i < str1.length(); i++) {
			if (ascii[str1.charAt(i)] == 0) {
				ascii[str1.charAt(i)] = -1;
				res += str1.charAt(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "aabbccdef";
		System.out.println(removeDuplicatesFromString(str));
	}
}

/*
 * Try more Inputs case1: actual = removeDuplicatesFromString('bcabc') expected
 * = 'bca'
 * 
 * case2: actual = removeDuplicatesFromString('cbacdcbc') expected = 'cbad'
 * 
 * case3: actual = removeDuplicatesFromString('aabbccdef') expected = 'abcdef'
 * 
 */
/*
 * Remove Duplicate From String Asked In: LinkedinYahoo String is given as input
 * that contains only lowercase letters, remove duplicate letters so that every
 * letter appears once In O(n) Time Complexity and O(1) Space Complexity
 * 
 * Example:
 * 
 * Input: "bcabc" Input: "cbacdcbc" Output: "bca" Output: "cbad" Hint : Try
 * using ascii[256] array for storing ascii value of the character Problem
 * level: Medium
 */