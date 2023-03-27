package com.dsa.linkedlist;

import java.util.ArrayList;

public class SortUsingMergeSort {
	 
    Node head = null; 
    static class Node { 
        int val; 
        Node next; 
  
        public Node(int val) 
        { 
            this.val = val; 
        } 
    } 
  
    Node sortedMerge(Node first, Node second) 
    { 
        Node result = null; 
        if (first == null) 
            return second; 
        if (second == null) 
            return first; 
        //pick either first or second 
        if (first.val <= second.val) { 
            result = first; 
            result.next = sortedMerge(first.next, second); 
        } 
        else { 
            result = second; 
            result.next = sortedMerge(first, second.next); 
        } 
        return result; 
    } 
  
    Node mergeSort(Node node) 
    { 
        //Base case if head is None 
        if (node == null || node.next == null) { 
            return node; 
        } 
        //get the middle of the list
        Node middle = Find_Middle_List(node); 
        
        Node nextofmiddle = middle.next; 
        //set the next of middle node to Null
        middle.next = null; 
        //Apply mergeSort on left list
        Node first = mergeSort(node);
        //Apply mergeSort on right list 
        Node second = mergeSort(nextofmiddle); 
        //Merge the left and right lists
        Node sortedlist = sortedMerge(first, second); 
        return sortedlist; 
    } 
  
    
    public static Node Find_Middle_List(Node head) 
    { 
        if (head == null) 
            return head; 
  
        Node slow = head, fast = head; 
  
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 
  // # insert new value to linked list using insert method 
    void insert(int new_data) 
    {  //Allocate new node
        Node new_node = new Node(new_data); 
  
        new_node.next = head; 
        //Append the new node at the end of the linked list 
        head = new_node; 
    } 
  
    
    void printList(Node headref,ArrayList<Integer> result) 
    { 
        while (headref != null) { 
            result.add(headref.val); 
            headref = headref.next; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
    	SortUsingMergeSort list = new SortUsingMergeSort(); 
        ArrayList<Integer> result = new ArrayList<Integer>();
        list.insert(4); 
        list.insert(2); 
        list.insert(8); 
        list.insert(1); 
        list.insert(6); 
        list.insert(3);
        list.insert(7);
  
        
        list.head = list.mergeSort(list.head); 
        list.printList(list.head,result); 
        System.out.print(result);
    } 

}
/* Try more Inputs
Case 1:
Main list = new Main(); 
ArrayList<Integer> result = new ArrayList<Integer>();
list.insert(3); 
list.insert(2); 
list.insert(1); 
list.head = list.mergeSort(list.head); 
list.printList(list.head,result);
expected = [1,2,3]

Case 2:
Main list = new Main(); 
ArrayList<Integer> result = new ArrayList<Integer>();
list.insert(1); 
list.head = list.mergeSort(list.head); 
list.printList(list.head,result);
expected = [1]
*/

/*
Sort Linked List using Merge Sort
Asked In: Google Amazon Flipkart
You are given a linked list as input , you need to sort it using merge sort algorithm using merge sort in Time Complexity O(nLogn) Asked in : Google, Amazon, Flipkart

Example:

The unsorted Linked-list: 14 20 78 98 20 45
 Linked List  after Sorting: 14 20 20 45 78 98
Problem level: Hard

*/