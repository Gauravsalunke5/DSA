package com.dsa.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstringInArray {

 
	public static int lengthOfLongestSubstring(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j++));
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++));
	        }
	    }
	    
	    return max;
	}

	public static void main(String[] args) {
		String s = "accdj";
		System.out.println(lengthOfLongestSubstring(s));

	}
}
