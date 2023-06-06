package com.dsa.array;

import java.util.HashMap;

public class DistinctElementEveryWindow {
    // Counts distinct elements in arraydow of size k 
    static void distinctElement(int array[], int k) 
	{
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

		// Traverse the first window and store count of every element in hash map
		for (int i = 0; i < k; i++)
			hMap.put(array[i], hMap.getOrDefault(array[i], 0) + 1);

		// Print count of first window
		System.out.println(hMap.size());

		// Traverse through the remaining array
		for (int i = k; i < array.length; i++) {

			// Remove first element of previous window If there was only one occurrence
			if (hMap.get(array[i - k]) == 1)
				hMap.remove(array[i - k]);
			else // reduce count of the removed element
				hMap.put(array[i - k], hMap.get(array[i - k]) - 1);

			// Add new element of current window If this element appears first time, set its
			// count as 1,
			hMap.put(array[i], hMap.getOrDefault(array[i], 0) + 1);

			// Print count of first window
			System.out.println(hMap.size());
		}

	} 
      
    public static void main(String args[]) 
    { 
        // int array[] = {2, 3, 2, 4, 5, 3, 3, 4},  k = 3; 
         
         int array[] = {1,2,1,3,4,2,3},  k = 4;
            
         distinctElement(array, k); 
    } 
}
/* Try more Inputs
case1:
actual = distinctElement([1,2,1,3,4,2,3],4)
expected = 3,4,4,3

case2:
actual = distinctElement([4,1,1],2)
expected = 2,1

case3:
actual = distinctElement([1,2,1,3,4,3],3)
expected = 2,3,3,2

case4:
actual = distinctElement([1,1,2,2],1)
expected = 1,1,2,2

*/

/*

Distinct Element every window
Asked In: Uber Facebook WalmartLabs
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array in Time Complexity : O(n) and Space Complexity: O(n)

Example:

Input : 1 2 1 3 4 2 3  K = 4

[Hint: Think of counting of the previous window while sliding the window]
Output: 3 4 4 3

Explanation:
Testcase 1 : 
Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
Problem level: Hard

*/