package com.dsa.linkedlist;

public class CheckSingleLinkedListIsPalindrome_02 {
	public static void main(String args[]) {
		Node one = new Node(2);
		Node two = new Node(3);
		Node three = new Node(4);
		Node four = new Node(5);
		Node five = new Node(4);
		Node six = new Node(3);
		Node seven = new Node(2);
		one.ptr = two;
		two.ptr = three;
		three.ptr = four;
		four.ptr = five;
		five.ptr = six;
		six.ptr = seven;
		boolean condition = isPalindrome(one);
		System.out.println("Check Palindrome :" + condition);
	}

	static boolean isPalindrome(Node head) {
		// Write your Code here
		return true;
	}
}

class Node {
	int data;
	Node ptr;

	Node(int d) {
		ptr = null;
		data = d;
	}
}

/*
Check Single Linked List is Palindrome or not
Asked In: Cisco SapLabs
Given a singly linked list, determine if it is a palindrome.

Example:

Input: 1->2->2->1
Output: true
Hint: Find middle and think of reversing
Problem level: Medium
*/