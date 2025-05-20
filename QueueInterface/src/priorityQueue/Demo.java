package priorityQueue;

import java.util.PriorityQueue;

public class Demo {
	//part of the Queue interface
	//orders elements based on their natural ordering (for primitive lowest first)
	//custom comparator for customised ordering
	//does not allow null elements
	public static void main(String[] args) {
		
	
	PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
	pq.add(15);
	pq.add(10);
	pq.add(30);
	pq.add(5);
	System.out.println(pq);//not sorted
	while(!pq.isEmpty()) {
		System.out.println(pq.poll());
	}
	
	//internal working
	//priorityQueue is implemented as a min-heap by default (for natural ordering)
	
	
	
	}	
	
}
