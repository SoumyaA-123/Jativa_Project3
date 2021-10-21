package com.jativa_project3.state;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project3 {
	// main class
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<State> statelist = new ArrayList<State>();
		CSVfileReader reader = new CSVfileReader();

		// you can change the path of folder or directory where your csv file is stored
		// don't forget to add \\ in the end of the path
		String path = "C:\\Users\\sumansingh01\\eclipse-workspace\\Project3\\";
		System.out.println("COP3530 Project 3");
		System.out.println("Doubly LinkedList");
		System.out.print("Enter the file name:");
		String filename = sc.next();
		// csv reader
		statelist = reader.CSVReader(path, filename);
		// pushing values into stack
		Stack stateStack = new Stack();
		for (State s : statelist) {
			stateStack.push(s); // this to push all states into stack
// below code is to puch only very good, good and fair states in stack			
//			if (s.deathRate() > 150) {
//				// not included because of poor state death rate is greater than 150
//			} else {
//				// pushing states
//				stateStack.push(s);
//				// State o=stateStack.peek(); to check what values pushing on to stack
//				
//			}

		}
		// to print stack
		if (!stateStack.isEmpty()) {
			System.out.println("Stack content:");
			stateStack.printStack();
		}

		// creating 3 priority queues according to the deadth rate
		PriorityQ allStates = new PriorityQ(); // to contain all states
		PriorityQ veryGoodStates = new PriorityQ();
		PriorityQ goodStates = new PriorityQ();
		PriorityQ fairStates = new PriorityQ();
		PriorityQ poorStates = new PriorityQ();

		while (!stateStack.isEmpty()) {
			State s = stateStack.pop();
			int p = 1;
			allStates.push(s, p++);
			if (s != null) {
				if (s.deathRate() < 50) {
					int i = 1;
					veryGoodStates.push(s, i++);
				} else if (s.deathRate() >= 50 && s.deathRate() < 100) {
					int i = 1;
					goodStates.push(s, i++);

				} else if (s.deathRate() >= 100 && s.deathRate() < 150) {
					int i = 1;
					fairStates.push(s, i++);

				} else if (s.deathRate() >= 150) {
					int i = 1;
					poorStates.push(s, i++);
				}
			}

		}

		// printing all priorirty queues
		if (!veryGoodStates.isEmpty()) {
			System.out.println("Very Good States:");
			veryGoodStates.printQueue();

		}
		if (!goodStates.isEmpty()) {
			System.out.println("Good States:");
			goodStates.printQueue();
		}
		if (!fairStates.isEmpty()) {
			System.out.println("Fair States:");
			fairStates.printQueue();
		}
		if (!poorStates.isEmpty()) {
			System.out.println("poor states:");
			poorStates.printQueue();
		}

		boolean flag = true;
		// user input
		
		while (flag) {
			System.out.println("1. Enter a DR interval for deletions");
			System.out.println("2. Print priority queue");
			System.out.println("3. Exit");
			System.out.print("Enter Choice:");
			boolean checkchoice=true;
			int choice=0 ;
				while(checkchoice) {
					try{
						choice= sc.nextInt();
						if(choice>=1 && choice <=3  ) {
							checkchoice=false;
						}else {
							System.out.print("Invalid choice, enter 1-3: ");
						}
					}catch(Exception e) {
						System.out.println("Invalid choice, enter 1-3:");
						sc.next();
					}
						
				}
					switch (choice) {
					case 1:

						System.out.print("Enter DR interval like [x,y]:");
						int x = 0, y = 0;
						boolean check = true;
						while (check) {
							try {
								String input = sc.next().replace("[", " ").replace("]", " ");
								String[] parseinput = input.trim().split(",");
								x = Integer.parseInt(parseinput[0]);
								y = Integer.parseInt(parseinput[1]);

								if (x > y) {
									System.out.print("Invalid interval, first number must be no bigger than the second:");
								} else if (x < y) {
									check = false;
								}
							} catch (Exception e) {
								System.out.print("Invalid interval, enter numbers:");
							}

						}
						List<State> newlist = new ArrayList<>();
						int i = 1;
						while (!allStates.isEmpty()) {

							State s = allStates.pop();
							// System.out.println(s);
							if (s != null) {
								// System.out.println("heii"+s);
								if (s.deathRate() >= x && s.deathRate() <= y) {
									// deleted elements
								} else {
									newlist.add(s);

								}
							} else {
								System.out
										.println("States of priority queue with DRs in [" + x + "," + y + "] are deleted");
								break;
							}

						}
						i = 1;
						for (State s : newlist) {
							allStates.push(s, i++);
						}
						break;
					case 2:
						System.out.println("Priority Queue Content:");
						allStates.printQueue();
						break;
					case 3:
						System.out.println("Have a good day!");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice, enter 1-3:");

					}
					
				
			

		} // while loop end

	}
}
