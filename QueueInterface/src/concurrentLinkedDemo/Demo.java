package concurrentLinkedDemo;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Demo {
	public static void main(String[] args) {
		//non blocking ,thread safe ended queue
		//cas
		
		ConcurrentLinkedDeque<String > deque = new ConcurrentLinkedDeque<String>();
		
		deque.add("Element1 ");
		deque.addFirst("element0");
		deque.addLast("Element2");
		System.out.println(deque);//[element0, Element1 , Element2]
		
		
		String first = deque.removeFirst();
		String last = deque.removeLast();
		System.out.println(first);//[element0, Element1 , Element2]
		System.out.println(last);//[element0, Element1 , Element2]
		
	}

}
