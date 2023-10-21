package com.dsa.dp;

import java.util.Iterator;

public class StringEditDistanceIDRAlgorithm {
	private static int editDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			dp[i][0] = i;
		for (int j = 0; j <= n; j++)
			dp[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1] // insert
							, dp[i - 1][j]) // remove
							, dp[i - 1][j - 1]); // replace
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "horse", s2 = "ros";
		// Insert delete replace
		// Output: 3 

		System.out.print("Number of insertion, deletion, replace operation " + (editDistance(s1, s2)));
	}

}

/*
             ''  r o s
           '' 0  1 2 3
               
            h 1  1 2 3
            o 2  2 1 2
            r 3  2 2 2
            s 4  3 3 2
            e 5  4 4 3
 
 * Explaination https://www.youtube.com/watch?v=eMnyEDYGobA
 * Minimum Edit Distance Problem | DP | Dynamic Programming | DSA-One Course #91
 * 
 * 
 * String Edit Distance Algorithm Asked In: Amazon Microsoft Myntra Cisco
 * 
 * Given two words word1 of length m and word2 of length n, find the minimum
 * number of operations required to convert word1 to word2 in Time and Space
 * Complexity O(mn). You have the following 3 operations permitted on a word: 1.
 * Insert a character 2. Delete a character 3. Replace a character Asked in :
 * Amazon, Microsoft, Myntra, Cisco
 * 
 * Example:
 * 
 * Input: word1 = "horse", word2 = "ros" 
 * Output: 3 
 * Explanation: horse -> rorse (replace h with r) 
 * rorse -> rose (remove r) 
 * rose -> ros (remove e) 
 * Problem level: Medium
 */