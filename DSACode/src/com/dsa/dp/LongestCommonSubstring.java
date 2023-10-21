package com.dsa.dp;

public class LongestCommonSubstring {

	 

	public static int LCStringProblem(String array1, String array2) {
		int m = array1.length(), n = array2.length();

		int[][] dp = new int[m + 1][n + 1];

		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (array1.charAt(i - 1) == array2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String array1 = "zxabcdezy", array2 = "yzabcdezx";
			//abcdez 6
 
		System.out.print("The length of LCS is " + LCStringProblem(array1, array2));
	}

}
/*
			 y z a b c d e z x
			 0 0 0 0 0 0 0 0 0
			
		z 0  0 1 0 0 0 0 0 1 0
		x 0  0 0 0 0 0 0 0 0 1
		a 0  0 0 1 0 0 0 0 0 0
		b 0  0 0 0 2 0 0 0 0 0
		c 0  0 0 0 0 3 0 0 0 0
		d 0  0 0 0 0 0 4 0 0 0
		e 0  0 0 0 0 0 0 5 0 0
		z 0  0 1 0 0 0 0 0 6 0   max=6
		y 0  1 0 0 0 0 0 0 0 0

Find Longest Common Substring
Asked In: Uber Akamai Flipkart
Given two strings Str and Ptr, find the length of the longest common substring.

Example:

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
The longest common substring is “abcdez” and is of length 6.
Problem level: Medium
*/