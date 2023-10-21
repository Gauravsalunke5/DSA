package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortElementFreq {

	private static int i = 0;;

	public static void main(String[] args) {
		// int arr[] = { 2, 2, 7, 2, 7, 8, 9, 9, 9, 9 };
		// {9,9,9,9,2,2,2,7,7,8}

		int arr[] = { 1, 1, 2, 2, 2, 3 };

		sortFreq(arr, arr.length);
	}

	private static void sortFreq(int[] arr, int length) {

		HashMap<Integer, Integer> hMap = new LinkedHashMap<Integer, Integer>();

		for (int i : arr) {
			hMap.put(i, hMap.getOrDefault(i, 0) + 1);
		}

		// reverse
//		hMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
//
//			for (int k = 0; k < e.getValue(); k++) {
//				arr[i++] = e.getKey();
//			}
//		});

		hMap.entrySet().stream()
				.sorted((a, b) -> hMap.get(a.getKey()) != hMap.get(b.getKey())
						? hMap.get(a.getKey()) - hMap.get(b.getKey())
						: b.getKey() - a.getKey())
				.forEach(e -> {

					for (int k = 0; k < e.getValue(); k++) {
						arr[i++] = e.getKey();
					}
				});

//		Map<Integer, Integer> mapp = new LinkedHashMap<Integer, Integer>();
//			mapp=	hMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		// count frequency of each number
		Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
		// custom sort
		return Arrays.stream(nums).boxed().sorted((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
				.mapToInt(n -> n).toArray();
	}

	public int[] frequencySort2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int ele : nums) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (a, b) -> {
			if (map.get(a) == map.get(b))
				return b - a;
			else
				return map.get(a) - map.get(b);
		});
		int k = 0;
		for (int ele : list) {
			int r = map.get(ele);
			while (r-- > 0) {
				nums[k++] = ele;
			}
		}
		return nums;
	}

}
