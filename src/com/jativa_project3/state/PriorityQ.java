package com.jativa_project3.state;

import java.text.DecimalFormat;

public class PriorityQ {
	// class representing node of a doubly linked list
	class Node {
		State data;
		int priority;
		Node next, prev;

		public Node(State data, int priority) {
			this.data = data;
			this.priority = priority;
		}
	}

	// head of doubly linked list
	Node head; // head
	Node tail; // tail
	int size = 0; // size of the DDL List
	
	public int size(){
		return size;
		}

	public void push(State data, int priority) {
		// if head is null this is the first node to be inserted
		// mark head as new Node
		if (head == null) {
			Node newNode = new Node(data, priority);
			head = newNode;
			return;
		}
		// create a new node with specified data
		Node node = new Node(data, priority);
		// find the first node having priority less than 'priority'
		Node temp = head, parent = null;
		while (temp != null && temp.priority >= priority) {
			parent = temp;
			temp = temp.next;
		}
		// Case 1 : All the nodes are having priorities less than 'priority'
		if (parent == null) {
			// insert the new node at the beginning of linked list
			node.next = head;
			head.prev = node;
			head = node;
		}
		// Case 2 : All the nodes are having priorities greater than 'priority'
		else if (temp == null) {
			// insert the node at the end of the linked list
			parent.next = node;
			node.prev = parent;
		}
		// Case 3 : Some nodes have priority higher than 'priority' and
		// some have priority lower than 'priority'
		else {
			// insert the new node before the first node having priority
			// less than 'priority'
			parent.next = node;
			node.prev = parent;
			node.next = temp;
			temp.prev = node;
		}
		size++;
	}

	public State peek() {
		// if head is not null, return the element at first position
		if (head != null) {
			return head.data;
		}
		return null;
	}

	public State pop() {
		// if head is not null, delete the element at first position and return its
		// value
		if (head != null) {
			State curr = head.data;
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			return curr;
		}
		return null;
	}

	public boolean isEmpty() {
		return size == 0;

	}
	
	
	
	public  void printQueue() {
		DecimalFormat roundoff = new DecimalFormat("#.####");
		Node temp=head;
		//Node tempnext=temp.next;
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%20s %20s %20s %30s %20s %20s", "Name", "MHI", "VCR", "CFR", "Case Rate", "Death Rate");
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------");

		while(temp!=null) {
			//print temp data
			State s=temp.data;
			System.out.printf("%20s %20s %20s %30s %20s %20s", s.getName(), s.getMedHouseIncome(),
					s.getViolCrimeRate(), roundoff.format(s.cfr()), s.caseRate(), roundoff.format(s.deathRate()));
			System.out.println();
			
				temp=temp.next;
			
			
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
	
	}
}