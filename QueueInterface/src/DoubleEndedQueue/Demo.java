package DoubleEndedQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Demo {
	public static void main(String[] args) {
		//double ended queue
		//allows insertion and removel of elements form both ends
		//versatile than regular queue and stacks because they support all the operation of both 
		
		/* 
		 * INSERTION METHODS
		 * addFirst(E a):Insert the specified element at the front.
		 * addLast(E a) :Inserts the specified element at the end;
		 * offerFirst(E e):Inserts the specified element at the front of possible
		 * OfferLast(E e):inserts the specified element at the end if possible 
		 */
		
		/* 
		 * Removal METHODS
		 * removeFirst(E a):retrieves and removes the first element.
		 * removeLast(E a) :retrieves the removes the last element;
		 * pollFirst(E e):retrieves and removes the first element , or returns null if empty
		 * poolLast(E e):retrieves and removes last element or returns null if empty
		 */
		
		/*
		 * EXAMINATION METHODS
		 * getFirst():Retrieves ,but does not remove , the first element;
		 * getLast():Retrieves ,but does not removes ,the last element;
		 * peekFirst();Retrieves , but does not remove , the first element , or returns null if empty
		 * peekLast():Retrieves , but does not remove the last element , or returns null if empty
		 */
		
		/* STACK METHODS
		 * push(E e): Adds an element at the front (equivalant to addFirst(E e).
		 * pop():Removes and returns the first element (equivalent to removeFirst())
		 * 
		 */
		Deque<Integer>deque1= new LinkedList();// if we have insertion and deletion in middle
		deque1.addFirst(10);
		deque1.addLast(20);
		deque1.offerFirst(5);
		deque1.offerLast(25);
		
		//5 10 20 25
		System.out.println(deque1);
		System.out.println("fist ele : "+deque1.getFirst());//fist ele : 5
		System.out.println("last ele : "+deque1.getLast());//last ele : 25
		System.out.println(deque1.removeFirst());//5
		System.out.println(deque1.pollLast());//25
		
		for(int num:deque1) {
			System.out.println(num);
		}
		//10
		//20
		
		
		
		Deque<Integer>deque= new ArrayDeque<Integer>();//faster iteration ,low memory ,no null allowed
		//circular array with head and tail so no need of shifting elements if we remove first element
		//just shift head and tail
		deque.addFirst(10);
		deque.addLast(20);
		deque.offerFirst(5);
		deque.offerLast(25);
		
		//5 10 20 25
		System.out.println(deque);
		System.out.println("fist ele : "+deque.getFirst());//fist ele : 5
		System.out.println("last ele : "+deque.getLast());//last ele : 25
		System.out.println(deque.removeFirst());//5
		System.out.println(deque.pollLast());//25
		
		for(int num:deque) {
			System.out.println(num);
		}
		//10
		//20
		
	}
}
