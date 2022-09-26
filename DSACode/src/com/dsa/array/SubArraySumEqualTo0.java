package com.dsa.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class SubArray {
	int first, second;

	SubArray(int a, int b) {
		first = a;
		second = b;
	}
}

public class SubArraySumEqualTo0 {
	static ArrayList<SubArray> findSubArrays(int[] array, int n) {
		HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
		ArrayList<SubArray> res = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += array[i];
			if (sum == 0)
				res.add(new SubArray(0, i));

			ArrayList<Integer> list = new ArrayList<>();
			if (hMap.containsKey(sum)) {
				list = hMap.get(sum);
				for (int j = 0; j < list.size(); j++) {
					res.add(new SubArray(list.get(j) + 1, i));	
				}
	
			}
			list.add(i);
			hMap.put(sum, list);

		}

		return res;
	}

	public static void main(String args[]) {
		int[] array = { 6, 3, -2, 5, -3, 7, -6, -1, 4 };
		int n = array.length;

		ArrayList<SubArray> out = findSubArrays(array, n);

	}
}

/* Try more Inputs
case1:
actual = findSubArrays([4, 2, -3, 1, 6],5)
expected = True

case2:
actual = findSubArrays([4,2,0,1,6],5)
expected = True

actual = findSubArrays([-3,2,3,1,6],5)
expected = False

actual = findSubArrays([1,2],2)
 expected = False

*/

/*
Find Subarray of Sum Zero in An Array
Asked In: Yahoo Expedia MMT
Array of both positive and negative numbers, the task is to find out the sub array whose sum is Zero in Time Complexity O(n) and Space Complexity O(n)

Example:

Input = [6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7]

[Efficiently it can be implemented using Hashing] 
[ This problem is based on the array but the most efficient approach to solving this problem can be hashing, Please attempt this problem if you already done with Hashing topic or try to solve it without using Hashing techniques] 
Output: 
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6          
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10
Problem level: Hard
*/