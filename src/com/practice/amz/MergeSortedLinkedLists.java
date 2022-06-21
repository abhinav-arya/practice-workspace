/*
 * Given two sorted linked lists, merge them so that the resulting linked list is 
 * also sorted.
 * 
 	Input: list1 = [1,2,4], list2 = [1,3,4]
	Output: [1,1,2,3,4,4]
 */

package com.practice.amz;

class Node {
	int element;
	Node next;
	
	Node(int ele) {
		this.element = ele;
		this.next = null;
	}
	
	Node(int ele, Node node) {
		this.element = ele;
		this.next = node;
	}
}

class LinkedList {
	Node head;
	Node curr;
	
	LinkedList() {
	}
	
	LinkedList(int ele) {
		addNode(ele);
	}
	
	public void printLinkedList() {
		Node currNode = this.head;
		while (currNode != null) {
			System.out.print(" " + currNode.element);
			currNode = currNode.next;
		}
		System.out.println(" ");
	}
	
	public void addNode(int element) {
		if (head == null) {
			head = new Node(element);
			curr = head;
		} else {
			curr.next = new Node(element);
			curr = curr.next;
		}
	}
}

public class MergeSortedLinkedLists {
	
	public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
		LinkedList list3 = new LinkedList();
		Node n1 = list1.head;
		Node n2 = list2.head;
		
		while (n1 != null || n2 != null) {
			if (n1 == null) {
				list3.addNode(n2.element);
				n2 = n2.next;
			} else if (n2 == null) {
				list3.addNode(n1.element);
				n1 = n1.next;
			} else {
				if (n1.element > n2.element) {
					list3.addNode(n2.element);
					n2 = n2.next;
				} else {
					list3.addNode(n1.element);
					n1 = n1.next;
				}
			}
		}
		
		return list3;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(3);
		LinkedList list2 = new LinkedList(1);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(8);
		list1.addNode(9);
		list2.addNode(1);
		list2.addNode(2);
		list2.addNode(4);
		list2.addNode(6);
		list1.printLinkedList();
		list2.printLinkedList();
		
		LinkedList list3 = mergeSortedLists(list1, list2);
		list3.printLinkedList();
	}
}
