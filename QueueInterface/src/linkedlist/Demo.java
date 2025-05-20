package linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
	public static void main(String[] args) {
		Queue<Integer> list= new LinkedList<Integer>();
		System.out.println(list.size());//0
		//System.out.println(list.remove(list)); //java.util.NoSuchElementException if empty
		System.out.println(list.poll());//null
		
		System.out.println(list.peek());//null
		//System.out.println(list.element());// //java.util.NoSuchElementException if empty
		
		
		Queue<Integer>queue = new ArrayBlockingQueue<Integer>(2);
		queue.add(1);
		queue.offer(2);
		//queue.add(3);// java.lang.IllegalStateException: Queue full
		queue.offer(3);//null no error(exception)
		
		
	}

}
