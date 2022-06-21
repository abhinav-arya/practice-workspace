package com.practice.amz;

/*
You are given a linked list where the node has two pointers. The first is the regular next pointer. 
The second pointer is called arbitrary_pointer and it can point to any node in the linked list. 
Your job is to write code to make a deep copy of the given linked list. Here, deep copy means that 
any operations on the original list (inserting, modifying and removing) should not affect the copied list.
*/

class ListNode {
	int data;
	ListNode next;
	ListNode prev;
	
	ListNode() {}
	
	ListNode(ListNode prev, int data, ListNode next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
}

class ArbitraryLinkedList {
	private ListNode head;
	private ListNode curr;
	
	ArbitraryLinkedList() {}
	
	ArbitraryLinkedList(int data) {
		this.head = new ListNode(null, data, null);
		this.curr = this.head;
	}
	
	ArbitraryLinkedList(ListNode prev, int data, ListNode next) {
		new ListNode(prev, data, next);
	}
	
	public void addNode(int data) {
		this.curr.next = new ListNode(this.curr, data, null);
		this.curr = this.curr.next;
	}
	
	public void addNode(ListNode prev, int data, ListNode next) {
		new ListNode(prev, data, next);
	}
	
	public ListNode fetchHeadNode() {
		return this.head;
	}
	
	public void arbitrariseList(int index, int prevTarget) {
		ListNode mover = this.head;
		ListNode source = null, target = null;
		int counter = 0;
		
		while (mover != null) {
			counter++;
			if (counter == index) {
				source = mover;
			}
			if (counter == prevTarget)
				target = mover;
			mover = mover.next;
		}

		source.prev = target;		
	}
	
	public void printLinkedList() {
		ListNode mover = this.head;
		
		System.out.println();
		while (mover != null) {
			if (mover.prev == null)
				System.out.print("(Null)<-");
			else
				System.out.print("(" + mover.prev.data + ")" + "<-");
			System.out.print(mover.data + " :: ");
			mover = mover.next;
		}
		System.out.print("Null\n");
	}
}

public class ArbitraryLinkedListCopy {
	
	public static ArbitraryLinkedList createLinkedListCopy(ListNode head) {
		
		if (head == null)
			return null;
		
		ArbitraryLinkedList new_list = new ArbitraryLinkedList(head.prev, head.data, head.next);
		ListNode mover_orig = head.next;
		
		while (mover_orig != null) {
			new_list.addNode(mover_orig.prev, mover_orig.data, mover_orig.next);
			mover_orig = mover_orig.next;
		}
		
		return new_list;
	}

	public static void main(String[] args) {
		
		ArbitraryLinkedList list1 = new ArbitraryLinkedList(7);
		list1.addNode(14);
		list1.addNode(21);
		System.out.print("\nNew Doubly Linked List:");
		list1.printLinkedList();
		list1.arbitrariseList(1, 3);
		list1.arbitrariseList(2, 0);
		list1.arbitrariseList(3, 1);
		System.out.print("\nArbitrarised Linked List:");
		list1.printLinkedList();
		
		ArbitraryLinkedList list2 = createLinkedListCopy(list1.fetchHeadNode());
		System.out.print("\nCopied Arbitrarised Linked List:");
		list2.printLinkedList();
	}
}
