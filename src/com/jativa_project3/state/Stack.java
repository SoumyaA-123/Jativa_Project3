package com.jativa_project3.state;

import java.text.DecimalFormat;

public class Stack {

	private DLL list = null; // doubly linked-list list 
	
	// constructor
	public Stack() 
	{
		this.list = new DLL(); 
	}
	// push state object into stack
	public void push(State data) 
	{
		list.add(data);
		
	}
	// pop state object from stack
	public State pop() 
	{
		if (isEmpty()) {
			System.out.println("stack is empty");
		}
		State data = peek();
		list.remove(size() - 1);
		//System.out.println("removed");
		return data;// access item, decrement top
	}
	
	// return size of the stack
	public int size(){
		return list.size();
		
		}
	// return top element of the stack
	public State peek() 
	{
		return list.get(size()-1);
	}
	// return true if stack is empty
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}
	public void printStack() {
		//Name MHI VCR CFR Case Rate Death Rate
		DecimalFormat roundoff = new DecimalFormat("#.####"); 
		
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%20s %20s %20s %30s %20s %20s", "Name", "MHI", "VCR", "CFR",
				"Case Rate", "Death Rate");
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------");
		int i=size()-1;
		while(i>=0) {
			State s=list.get(i);
			// to print stack top to bottom without change the stack
			System.out.printf("%20s %20s %20s %30s %20s %20s",s.getName(),s.getMedHouseIncome(),s.getViolCrimeRate(),roundoff.format(s.cfr()),s.caseRate(),roundoff.format(s.deathRate()));
			System.out.println();
			i--;
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
	}



}