package BlockingQueue;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Producer implements Runnable{

	private BlockingQueue<Integer> queue;
	private int value=0;
	
	public Producer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				System.out.println("Producer produced : "+value +"  size  = "+queue.size());
				queue.put(value++);
				Thread.sleep(1000);
			} catch (Exception e) {
				Thread.currentThread().interrupt();// TODO: handle exception
				System.out.println("producer interrupted");
			}
			
		}
		
	}

}



class Consumer implements Runnable{

	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Integer value= queue.take();
				System.out.println("Consumer  consumed : "+value +"  size  = "+queue.size());
				
				Thread.sleep(2000);
			} catch (Exception e) {
				Thread.currentThread().interrupt();// TODO: handle exception
				System.out.println("consumer interrupted");
			}
			
		}
		
	}

}



public class Demo {
	 public static void main(String[] args) {
		//thread safe queue
		// wait for queue to become non empty / wait for space
		//simplify concurrency problem like producer-consumer
		//standard queue  -->immediately
		 	//empty--->remove (no waiting)
		 	//full -->add(no waiting)
		 //Blocking Queue
		 	//put-->Blocks if the queue is full until space becomes avialable
		 	//take-->Blocks if the queue is empty until an element becomes avilable
		 	//offer -->Waits for space to become available ,up to the specified timeout;
		 
		 BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
		 //A bounded ,blocking queue backed by an circular array
		 //low memory overhaed
		 //single lock, producer and consumer block each other i.e ueses single lock for enque and deque
		 //more threads -->problem
		 Thread producer= new Thread(new Producer(queue));
		 Thread consumer= new Thread(new Consumer(queue));
		 producer.start();
		 consumer.start();
		 System.out.println(queue);
		 
		 
		 BlockingQueue<Integer> queue1 = new LinkedBlockingQueue();
		 //optionally bounded backed by linked list
		 //Uses two separate locks for enqueue and dequeue operations
		 //Higher concurrency betweeen producers and consumers
		 
		 BlockingQueue<String> queue2= new PriorityBlockingQueue<String>(11,Comparator.reverseOrder());
		 //optionally bounded
		 //binary heap as array and can grow dynamically
		 //head  is  based on their natural ordering or a provided Comparator like priority queue
		 
		 queue2.add("apple");
		 queue2.add("banana");
		 queue2.add("cheerry");
		 System.out.println(queue2);//[cheerry, apple, banana]
		 
		 
	}
}



/*OUTPUT
 * []
Producer produced : 0  size  = 0
Consumer  consumed : 0  size  = 0
Producer produced : 1  size  = 0
Producer produced : 2  size  = 1
Consumer  consumed : 1  size  = 0
Producer produced : 3  size  = 1
Consumer  consumed : 2  size  = 1
Producer produced : 4  size  = 1
Producer produced : 5  size  = 2
Consumer  consumed : 3  size  = 2
Producer produced : 6  size  = 2
Producer produced : 7  size  = 3
Consumer  consumed : 4  size  = 3
Producer produced : 8  size  = 3
Producer produced : 9  size  = 4
Consumer  consumed : 5  size  = 4
Producer produced : 10  size  = 4
Producer produced : 11  size  = 5
Consumer  consumed : 6  size  = 5
Producer produced : 12  size  = 5
Consumer  consumed : 7  size  = 4
Producer produced : 13  size  = 5
Consumer  consumed : 8  size  = 4
Producer produced : 14  size  = 5
*/
