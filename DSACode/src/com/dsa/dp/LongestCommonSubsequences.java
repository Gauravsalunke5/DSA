package com.dsa.dp;

public class LongestCommonSubsequences {

	private static void recursive(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println("Length of LCS is " + lcs(X, Y, m, n, dp));
	}
	// A Top-Down DP implementation of LCS problem

	// Returns length of LCS for X[0..m-1], Y[0..n-1]
	static int lcs(String X, String Y, int m, int n, int[][] dp) {

		if (m == 0 || n == 0)
			return 0;

		if (dp[m][n] != -1)
			return dp[m][n];

		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
			return dp[m][n];
		}

		dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp), lcs(X, Y, m - 1, n, dp));
		return dp[m][n];
	}

	public static int LCSProblem(String array1, String array2) {
		int m = array1.length(), n = array2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (array1.charAt(i - 1) == array2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String array1 = "ABCDEF", array2 = "AEDNEK";
		// ADE
		// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
		recursive(array1, array2);

		System.out.print("The length of LCS is " + LCSProblem(array1, array2));
	}

}
/*
        	A E D N E K
        	0 0 0 0 0 0
        	
       A 0  1 1 1 1 1 1
       B 0  1 1 1 1 1 1
       C 0  1 1 1 1 1 1
       D 0  1 1 2 2 2 2
       E 0  1 2 2 2 3 3
       F 0  1 2 2 2 3 3

Longest Common Subsequences
Asked In: Linkedin PayPal
Given two strings of length m and n , Find algorithm the length of their longest common subsequence in Time Complexity and Space complexity O(mn) Asked in : Linkedin, PayPal

Example:

Input: text1 = "abcde", text2 = "ace"

Input: text1 = "abc", text2 = "abc"
Output: 3 
Explanation: The longest common subsequence is "ace" and its length is 3.

Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Problem level: Medium
*/