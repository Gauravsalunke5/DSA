package com.dsa.string;

import java.util.Stack;
import java.util.stream.Collectors;

public class BasicCalculator {

	public int calculate1(String s) {
		Stack<String> stk = new Stack<>();
		s = s.replaceAll("\\s+", "");

		for (char ch : s.toCharArray()) {
			String c = ch + "";
			if (ch >= '0' && ch <= '9' && isOperatorInStackTop(stk)) {

				calculate1(stk, c);
			} else if (c.equals(")")) {

				String temp = stk.pop();
				stk.pop();
				calculate1(stk, temp);

			} else {
				stk.push(c);
			}
		}

		return stk.isEmpty() ? 0
				: stk.size() == 1 ? Integer.valueOf(stk.pop())
						: Integer.valueOf(stk.stream().map(x -> x.toString()).collect(Collectors.joining()));

	}

	private boolean isOperatorInStackTop(Stack<String> stk) {
		return stk.isEmpty() ? false : stk.peek().contains("+") || stk.peek().contains("-");
	}

	private int calculate1(Stack<String> stk, String c) {
		if (isOperatorInStackTop(stk)) {

			String operator = stk.pop();
			if (stk.isEmpty() || stk.peek().equals("(")) {
				return calculate1(stk, operator + c);
			}
			int x = Integer.valueOf(stk.pop());
			int y = Integer.valueOf(c);

			switch (operator) {
			case "+":
				calculate1(stk, String.valueOf(x + y));
				break;
			case "-":
				calculate1(stk, String.valueOf(x - y));
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + stk.pop());
			}
		} else {
			stk.push(c);
		}
		return 0;
	}

	public static void main(String[] args) {
		BasicCalculator br = new BasicCalculator();
		String s = "(1+(4+5+2)-3)+(6+8)";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));
//
//		s = "2147483647";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));
//
//		s = "1-(     -2)";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));
//
//		s = "-2+ 1";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));
//
//		s = "1-11";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));
//		
//		s = "2+1-(-3+2)";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));

//		s="(7)-(0)+(4)";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));

//		s = "(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-6)))))))";
//		System.out.println(br.calculate(s, new int[] { 0 }, s.length()));
		s ="- (3 + (4 + 5))";
		System.out.println(br.calculateWithoutStack(s, new int[] { 0 }, s.length()));

		
		// System.out.println(br.calculate1(s));

	}

	public int calculate(String s, int[] index, int n) {
		Stack<Integer> stk = new Stack<>();
		for (int i = index[0]; i < n; i++) {
			char ch = s.charAt(i);
			// System.out.println(ch);
			if (ch == '(') {
				index[0] = ++i;
				stk.push(calculate(s, index, n));
				i = index[0];
			} else if (ch >= '0' && ch <= '9') {
				int val = ch - '0';
				while (i + 1 < n && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					ch = s.charAt(++i);
					val *= 10;
					val += ch - '0';
				}
				stk.push(val);
			} else if (ch == ')') {
				index[0] = i;
				// return stk.stream().mapToInt(k -> k.intValue()).sum();
				return stk.stream().mapToInt(Integer::intValue).sum();

			} else if (ch == '-') {
				int val = 0;
				while(i + 1 < n && s.charAt(i + 1) == ' ')
					i++;
				
				if (s.charAt(i + 1) == '(') {
					index[0] = i + 2;
					val = calculate(s, index, n);
					i = index[0];
				} else {
					while (i + 1 < n && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
						ch = s.charAt(++i);
						val *= 10;
						val += ch - '0';
					}

				}
				val *= -1;
				stk.push(val);
			}
		}

		return stk.isEmpty() ? 0 : stk.stream().mapToInt(Integer::intValue).sum();

	}
	
	// faster 
	public int calculateWithoutStack(String s, int[] index, int n) {
		int res = 0;
		for (int i = index[0]; i < n; i++) {
			char ch = s.charAt(i);
			// System.out.println(ch);
			if (ch == '(') {
				index[0] = ++i;
				res += calculateWithoutStack(s, index, n);
				i = index[0];
			} else if (ch >= '0' && ch <= '9') {
				int val = ch - '0';
				while (i + 1 < n && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					ch = s.charAt(++i);
					val *= 10;
					val += ch - '0';
				}
				res += val;
			} else if (ch == ')') {
				index[0] = i;
				return res;

			} else if (ch == '-') {
				int val = 0;
				while (i + 1 < n && s.charAt(i + 1) == ' ')
					i++;

				if (s.charAt(i + 1) == '(') {
					index[0] = i + 2;
					val = calculateWithoutStack(s, index, n);
					i = index[0];
				} else {
					while (i + 1 < n && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
						ch = s.charAt(++i);
						val *= 10;
						val += ch - '0';
					}

				}
				val *= -1;
				res += val;
			}
		}

		return res;

	}

}

/*
 * 
"- (3 + (4 + 5))"
"5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))"
"2+1-(-3+2)"
"1 + 1"
" 2-1 + 2 "
"(1+(4+5+2)-3)+(6+8)"
"2147483647"
"-2+ 1"
"(7)-(0)+(4)"

 */
/*
https://leetcode.com/problems/basic-calculator/
224. Basic Calculator
Hard
5.7K
424
Companies
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */