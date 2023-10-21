package com.dsa.array;

import java.util.ArrayList;
import java.util.Iterator;

public class FindStockProfit {

	static class Interval {
		int buy=-1, sell=-1;
		
		 
	}

	// Stock Buy Sell to Maximize Profit using Valley Peak Approach
	void findProfit1(int prices[], int n) {

		int maxProfit = 0;
		for (int i = 1; i < n; i++)
			if (prices[i] > prices[i - 1])
				maxProfit += prices[i] - prices[i - 1];

		System.out.println(maxProfit);
	}
	
	void findProfit2(int prices[], int n) {

		int maxProfit = 0;
		ArrayList<Interval> sol = new ArrayList<Interval>();

		Interval e = new Interval();

		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				if (e.buy == -1)
					e.buy = i - 1;
				maxProfit += prices[i] - prices[i - 1];
			} else {
				if (e.buy != -1) {
					e.sell = i-1;
					sol.add(e);
					e = new Interval();
				}
			}
		}
		if (e.buy != -1) {
			e.sell = n-1;
			sol.add(e);
			e = new Interval();
		}
		
		if (sol.isEmpty())
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (Interval it : sol) {
				System.out.println("Buy on day: " + it.buy + "        " + "Sell on day : " + it.sell);
			}

		System.out.println();
		System.out.println(maxProfit);
	}

	// This function finds the buy sell schedule for maximum
	// profit
	void findProfit(int price[], int n) {// Prices must be given for at least two days
		if (n == 1)
			return;

		int count = 0;

		// solution array
		ArrayList<Interval> sol = new ArrayList<Interval>();

		// Traverse through given price array
		int i = 0;
		while (i < n - 1) {
			// Find Local Minima. Note that the limit is
			// (n-2) as we are comparing present element to
			// the next element.
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			// If we reached the end, break as no further
			// solution possible
			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++;
			// Store the index of minima

			// Find Local Maxima. Note that the limit is
			// (n-1) as we are comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			// Store the index of maxima
			e.sell = i - 1;
			sol.add(e);

			// Increment number of buy/sell
			count++;
		}

		// print solution
		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++)
				System.out.println("Buy on day: " + sol.get(j).buy + "        " + "Sell on day : " + sol.get(j).sell);
	}

	public static void main(String args[]) {
		FindStockProfit stock = new FindStockProfit();

		 int array[] = {45, 4,8,10,3,20,25,2 };

	//	int array[] = { 1, 2, 3, 4, 5 };
		int n = array.length;
		
		stock.findProfit(array, n);
		
		System.out.println();
		stock.findProfit1(array, n);
		
		System.out.println();
		stock.findProfit2(array, n);
	}
}

/*
 * Try more Inputs case 1: actual = findProfit([7,1,5,3,6,4],6) expected = 2
 * 
 * Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3
 * 
 * case2: actual = findProfit([1,2,3,4,5],5) expected = 4 Buy on day 1 (price =
 * 1) and sell on day 5 (price = 5), profit = 5-1 = 4
 * 
 * case3: actual = findProfit([7,6,4,3,1],5) expected = 0 In this case, no
 * transaction is done, i.e., max profit = 0
 */

/*
 * Linear time approach to solve Stock Buy Sell Problem Asked In: Amazon,
 * Microsoft, Flipkart, DE-Shaw
 */
/*
 * An array is given as Input where ith element is the price of a given stock on
 * day You were permitted to complete unlimited transaction. Derive an algorithm
 * to find the maximum profit in O(n) Time complexity and O(n) Space Complexity
 * Asked in: Amazon, Microsoft, Flipkart, DE-Shaw
 */
/*
 * Example:
 * 
 * Input: [7,1,5,3,6,4]
 * 
 * Input: [7,6,4,3,1] Output: 7 Explanation: Buy on day 2 (price = 1) and sell
 * on day 2 (price = 5) and Buy on day 3 (price = 3) and sell on day 4 (price =
 * 4), profit = (5-1) + (6-3) = 7. Not 7-1 = 6, as selling price needs to be
 * larger than buying price. Output: 0 Explanation: In this case, no transaction
 * is done, i.e. max profit = 0. Hint 1: find out the maximum difference (which
 * will be the maximum profit) between two numbers in the given array Hint2: You
 * need to solve this problem in O(n) time complexity Problem level: Medium
 */