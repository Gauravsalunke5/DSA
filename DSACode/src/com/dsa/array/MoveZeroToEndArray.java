package com.dsa.array;

public class MoveZeroToEndArray {

	static void MoveZeroToEnd(int array[], int n) {
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				int temp = array[cnt];
				array[cnt++] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int array[] = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int n = array.length;
		MoveZeroToEnd(array, n);
		System.out.println("result is: ");
		for (int i = 0; i < n; i++)
			System.out.print(array[i] + " ");
	}
}

/*
 * Try more Inputs case1: actual = MoveZeroToEnd([1,3,0,0,4,0,9],7) expected =
 * [1,3,4,9,0,0,0]
 * 
 * case2: actual = MoveZeroToEnd([0,1,0,3,12],5) expected = [1,3,12,0,0]
 * 
 * case3: actual = MoveZeroToEnd([0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9],13)
 * expected = [1,9,8,4,2,7,6,9,0,0,0,0,0]
 * 
 */