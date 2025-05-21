package syncronusQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Demo {
	public static void main(String[] args) {
		BlockingQueue<String> queue= new SynchronousQueue<String>();
		Thread producer= new Thread(()->{
			try {
				System.out.println("producer is waiting to transfer ....");
				queue.put("hello from producer");
				System.out.println("Producer has transferred the message. ");
				
			}catch (InterruptedException e) {
				// TODO: handle exception
				Thread.currentThread().interrupt();
				System.err.println("producer was interrupted");
			}
			
		});
		
		Thread consumer= new Thread(()->{
			try {
				System.out.println("consumer is waiting to receive ...");
				String message= queue.take();
				System.out.println("consumer received : "+ message);
				
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				System.err.print("consumer was interrupted");
				
			}
		});
		
		
		
		 producer.start();
		 consumer.start();
		
	}

}
