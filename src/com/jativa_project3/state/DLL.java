package com.jativa_project3.state;

// DDL List means doubly linked list 
public class DLL {
	// node
	class Node {
		State data;
		Node next;
		Node prev;

		public Node(State data) {
			this.data = data;
		}
	}

	Node head; // head
	Node tail; // tail
	int size = 0; // size of the DDL List

	// to add new node to DDL list
	public void add(State data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	// add element to particular index
	public void add(State data, int index) {

		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of bound");
			return;
		}
		Node newNode = new Node(data);
		Node curr = findNode(index);

		Node prevNode = curr.prev;

		prevNode.next = newNode;
		newNode.prev = prevNode;
		newNode.next = curr;
		curr.prev = newNode;

		size++;
	}

	// find node
	private Node findNode(int index) {
		int mid = (size - 1) / 2;
		if (mid > index) {
			return findForward(index);
		}
		// find in reverse direction
		return findReverse(index);
	}

	// remove
	public void remove(int index){
		if(index<0 || index>(size-1)){
		 System.out.println("Index out of bound");
		 return;
		}
		Node curr=findNode(index);
		
		Node prevNode=curr.prev;
		Node nextNode=curr.next;
		
		if(curr==head){
		
		head=head.next;
		if(head != null){
			head.prev=null;
		}else{
			head=tail=null;
		}
		//head.prev=null;
		
		}
		else if(curr==tail){
		
		prevNode.next=null;
		tail=prevNode;
		
		}else{
		prevNode.next=nextNode;
		nextNode.prev=prevNode;
		}
		
		
		
		curr.next=curr.prev=null;
		
		size--;
		
	}

	// to get value
	public State get(int index) {

		if (index < 0 || index > (size - 1)) {
			System.out.println("index out of bound");
			return null;

		}
		int mid = (size - 1) / 2;
		Node target = null;
		if (mid > index) {
			// find in forward direction
			target = findForward(index);
		} else {
			// find in reverse direction
			target = findReverse(index);
		}
		return target.data;

	}
	// to find data in forward direction
	private Node findForward(int index) {
		int i = 0;
		Node curr = head;
		while (curr != null && i != index) {
			curr = curr.next;
			i++;
		}
		return curr;
	}
	// to find node reversely
	private Node findReverse(int index) {
		int i = size - 1;
		Node curr = tail;
		while (curr != null && i != index) {
			curr = curr.prev;
			i--;
		}
		return curr;
	}	
	public int size(){
	return size;
	}
	// to check weather list is empty or not
	public boolean isEmpty(){
		return size==0;

	}
	// to clear the list
	public void clear(){
			head = tail =null;
			size=0;
		}
	// to set value in list
	public void set(State data, int index){
		if(index <0 || index>(size-1)){
		System.out.println("Index out of Bound");
		return;
		}
		Node curr=findNode(index);
		curr.data=data;
	}
}
