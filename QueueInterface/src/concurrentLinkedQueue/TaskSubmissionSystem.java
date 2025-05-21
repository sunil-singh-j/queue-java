package concurrentLinkedQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TaskSubmissionSystem {
	private static ConcurrentLinkedQueue<String > taskQueue=  new ConcurrentLinkedQueue<String>();
	public static void main(String[] args) {
	
		Thread producer= new Thread(()->{
				while(true) {
					try {
						taskQueue.add("Task  creation "+System.currentTimeMillis());
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
		});
		
		
		Thread consumer= new Thread(()->{
			while(true) {
				try {
					String task=taskQueue.poll();
					System.out.println("processing : " + task);
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
	});
		 producer.start();
		 consumer.start();
		 
		 
	}
}


/* OutPut
 * 
 * processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149
processing : Task  creation1747804806149

*/
