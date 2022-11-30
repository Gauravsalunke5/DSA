package com.dsa.linkedlist;

import java.util.ArrayList;

class Node  
{ 
    int data; 
    Node next; 
    Node(int d) {data = d; 
                 next = null;} 
} 

public class MergetwoSortedLinkedList_01 {

	Node head, tail;

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	static Node merge_sort(Node first, Node second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		Node head = null, cur = null;
		if (first.data < second.data) {
			head = first;
			first = first.next;
		} else {
			head = second;
			second = second.next;
		}

		cur = head;
		while (first != null && second != null) {
			if (first.data < second.data) {
				cur.next = first;
				first = first.next;
			} else {
				cur.next = second;
				second = second.next;
			}
			cur = cur.next;
		}
		if (first != null) {
			cur.next = first;
		}
		if (second != null) {
			cur.next = second;
		}

		return head;
	}

	public static void printList(Node head, ArrayList<Integer> result) {
		Node ptr = head;
		while (ptr != null) {
			result.add(ptr.data);
			ptr = ptr.next;
		}
	}

	public static void main(String args[]) {
		MergetwoSortedLinkedList_01 list1 = new MergetwoSortedLinkedList_01();
		MergetwoSortedLinkedList_01 list2 = new MergetwoSortedLinkedList_01();
		ArrayList<Integer> result = new ArrayList<Integer>();
		list1.addToTheLast(new Node(2));
		list1.addToTheLast(new Node(4));
		list1.addToTheLast(new Node(5));
		list1.addToTheLast(new Node(8));

		list2.addToTheLast(new Node(1));
		list2.addToTheLast(new Node(3));
		list2.addToTheLast(new Node(6));
		list2.addToTheLast(new Node(7));

		list1.head = merge_sort(list1.head, list2.head);
		list1.printList(list1.head, result);
		System.out.println(result);

	}

}

/* Try more Inputs
Case 1:
 Main list1 = new Main(); 
 Main list2 = new Main();
 ArrayList<Integer> result = new ArrayList<Integer>();
 list1.addToTheLast(new Node(1)); 
 list1.addToTheLast(new Node(4)); 
 list1.addToTheLast(new Node(5));
 
 list2.addToTheLast(new Node(2)); 
 list2.addToTheLast(new Node(3)); 
 list2.addToTheLast(new Node(6));
 list1.head = merge_sort(list1.head, list2.head);
 list1.printList(list1.head,result);
 expected = [1,2,3,4,5,6]
 
 Case 2:
 Main list1 = new Main(); 
 Main list2 = new Main();
 ArrayList<Integer> result = new ArrayList<Integer>();
 list1.addToTheLast(new Node(1)); 
 list1.addToTheLast(new Node(3)); 
 
 list2.addToTheLast(new Node(2)); 
 list1.head = merge_sort(list1.head, list2.head);
 list1.printList(list1.head,result);
 expected = [1,2,3]
*/
/*
Merge two Sorted Linked List
Asked In: WalmartLabs Amazon EMC2
Given two sorted linked lists, merge them so that the resulting linked list is also sorted in Time Complexity O(n) and Space Complexity(1) Asked in : WalmartLabs, Amazon, EMC2

Example:

Problem level: Medium
*/