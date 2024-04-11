package com.dsa.linkedlist;

public class AddTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}

	public ListNode addTwoNumbers_optimal(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode ptr = head;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int d1 = (l1 != null) ? l1.val : 0;
			int d2 = (l2 != null) ? l2.val : 0;

			int sum = d1 + d2 + carry;
			int d = sum % 10;
			carry = sum / 10;

			ListNode temp = new ListNode(d);
			ptr.next = temp;
			ptr = ptr.next;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		return head.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res, t;

		int carry = 0;
		res = new ListNode();
		t = res;

		while (l1 != null && l2 != null) {
			t.next = new ListNode();
			t = t.next;
			int sum = l1.val + l2.val + carry;
			t.val = sum % 10;
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			t.next = new ListNode();
			t = t.next;
			int sum = l1.val + carry;
			t.val = sum % 10;
			carry = sum / 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			t.next = new ListNode();
			t = t.next;
			int sum = l2.val + carry;
			t.val = sum % 10;
			carry = sum / 10;
			l2 = l2.next;
		}
		if (carry != 0) {
			t.next = new ListNode();
			t = t.next;
			int sum = carry;
			System.out.println(sum % 10);
			t.val = sum % 10;
		}
		return res.next;
	}

	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();

		ListNode one = new ListNode(5);
		ListNode two = new ListNode(6);
		ListNode three = new ListNode(4);
		ListNode four = new ListNode(7);
		ListNode five = new ListNode(0);
		ListNode six = new ListNode(8);

		one.next = two;
		two.next = three;
		four.next = five;
		five.next = six;

		atn.addTwoNumbers(one, four);

	}

}

/*
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807. Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100]. 0 <=
 * Node.val <= 9 It is guaranteed that the list represents a number that does
 * not have leading zeros.
 * 
 */