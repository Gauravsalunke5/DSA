package com.dsa.dp;

public class StringEditDistanceAlgorithm {
	private static int LCSProblem(String s1, String s2) {
		int m = s1.length(), n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "abcd", s2 = "anc";
		//insert, delete
		System.out.print("Number of operation " + (s1.length() + s2.length() - 2 * LCSProblem(s1, s2)));
	}

}

/*
 * Explaination https://www.youtube.com/watch?v=yMnH0jrir0Q
 * 
 * s1= abcd s2= anc
 * LCS(s1,s2) = ac
 * Deletion = abcd to ac: s1Len - LCS(s1,s2) = 4 - 2 = 2
 * insertion = ac to anc : s2Len - LCS(s1,s2) = 3 - 2 = 1
 * ans = s1Len - LCS(s1,s2) + s2Len - LCS(s1,s2)
 * 		= s1Len + s2Len 0 -  2 * LCS(s1,s2) = 4 + 3 - 2*2 = 7 - 4 = 3
 * 
 * add deleted to convert s1 to s2
 */