package com.dsa.matrix;

public class FindCelebrityProblem {
	static int matrix[][] = { { 0, 0, 1, 0 },
							{ 0, 0, 1, 0 }, 
							{ 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0 } };

	static boolean knows(int a, int b) {
		return matrix[a][b] == 1;
	}

    // Returns -1 if celebrity is not present. If present,returns id (value from 0 to n-1). 
   static int findCelebrity(int n)  
	{
	   //if X Knows Y, Then X must not be celebrity
	   // if X does't know Y, then Y must not be celebrity
		int X = 0;
		int Y = n - 1;

		while (X < Y) {
			if (knows(X, Y))
				X++;
			else
				Y--;
		}
		// Check if X is actually a celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't know 'X' or 'X' doesn't know any person, return -1
			if (i != X && (knows(X, i) || !knows(i, X)))
				return -1;
		}
		return X;
	} 

	public static void main(String[] args) {
		int n = 4;
		int result = findCelebrity(n);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println("Celebrity is " + result);
	}
} 


/* Try more Inputs
case 1: 
static int matrix[][] = {{0 1 0}, 
         {0 0 0}, 
         {0 1 0}};
expected = 1

case2: 
static int matrix[][] = {{0 1},
        {1 0}};
expected = -1

Note: The two people at the party both
know each other. None of them is a celebrity

case 3: 
static int matrix[][] = { {0, 0, 1, 0},
            {0, 0, 1, 0},
         {0, 1, 0, 0},
         {0, 0, 1, 0} };
expected = -1
*/

/*
Array puzzle of solving celebrity problem
Asked In: Google Flipkart Amazon 	Microsoft
You are in a party of N people, where only one person is known to everyone. Such a person may be present at the party, if yes, (s)he doesn’t know anyone at the party. Your task is to find the celebrity at the party in Time Complexity O(n) Asked in: Google, Flipkart, Amazon, Microsoft

Example:

Input: 
matrix = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. matrix[i][j] = 1 means person i knows person j, otherwise matrix[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.

Hint1: create boolean matrix to find wether person A knows person B or not
Hint2 : No constraint for space complexity but time complexity should be O(n)
Problem level: Easy

*/