package com.dsa.array.string;

import java.util.HashMap;

public class MinimumWindowSubstring {

	static final int no_of_chars = 256;

	public String minWindow1(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0) {
			return "";
		}

		int sLen = s.length();
		int tLen = t.length();

		if (tLen > sLen)
			return "";

		HashMap<Character, Integer> tMap = new HashMap<>();
		for (char ch : t.toCharArray()) {
			tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
		}
		int left = 0;
		int minLeft = 0;
		int minLen = sLen + 1;
		int count = 0;
		for (int right = 0; right < sLen; right++) {
			if (tMap.containsKey(s.charAt(right))) {
				tMap.put(s.charAt(right), tMap.get(s.charAt(right)) - 1);
				if (tMap.get(s.charAt(right)) >= 0) {
					count++;
				}
			}
			while (count == tLen) {
				if (right - left + 1 < minLen) {
					minLeft = left;
					minLen = right - left + 1;
				}
				if (tMap.containsKey(s.charAt(left))) {
					tMap.put(s.charAt(left), tMap.get(s.charAt(left)) + 1);
					if (tMap.get(s.charAt(left)) > 0) {
						count--;
					}
				}
				left++;
			}

		}

		return minLen > sLen ? "" : s.substring(minLeft, minLeft + minLen);
	}

	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
			return new String();
		}
		int[] map = new int[128];
		int count = t.length();
		int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		char[] chS = s.toCharArray();
		while (end < chS.length) {
			if (map[chS[end++]]-- > 0) {
				count--;
			}
			while (count == 0) {
				if (end - start < minLen) {
					startIndex = start;
					minLen = end - start;
				}
				if (map[chS[start++]]++ == 0) {
					count++;
				}
			}
		}

		return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring ms = new MinimumWindowSubstring();
		String str = "ADOBECODEBANC";
		String pat = "ABC";
		test(ms, str, pat, "BANC");

		test(ms, "a", "a", "a");
		test(ms, "zaaskzaa", "zsk", "skz");
		test(ms, "tutorial", "oti", "tori");
		test(ms, "a", "aa", "");
		test(ms, "a", "b", "");
		test(ms, "ab", "b", "b");
		test(ms, "ababcc", "bbc", "babc");
		test(ms, "bba", "ab", "ba");
		test(ms, "acbbaca", "aba", "baca");

//		System.out.print("Smallest window is :\n" + ms.minWindow(str, pat));

	}

	private static void test(MinimumWindowSubstring ms, String str, String ptr, String result) {
		String res = ms.minWindow1(str, ptr);
		System.out.println(res + " " + res.equals(result));
	}
}

/* Try more Inputs
case 1: 
actual = findMinWindow("a","a")
expected = Smallest window is : a

case2: 
 actual = findMinWindow("zaaskzaa", "zsk")
 expected = Smallest window is : skz
 
case3: 
actual = findMinWindow("tutorial","oti")
expected = Smallest window is : tori

*/

/*
Minimum Window Substring - 1
Asked In: WalmartLabs Facebook
Given two strings string1 and string2 , return the minimum window in string1 which will contain all the characters in string2 in Time Complexity O(n) and Space Complexity O(1) Asked-in: WalmartLabs, Facebook

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Hint1: Think of HashMap Ascii 256 method , Every character can have ascii value of 1 to 255
Problem level: Hard
*/
