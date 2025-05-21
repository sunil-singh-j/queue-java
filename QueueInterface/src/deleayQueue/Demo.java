package deleayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		//Thread -safe unbounded blocking queue
		//Elememnts can only be taken form the queue when their delay has expired
		//useful for scheduling tasks to be executed after a certain delay
		//internally priority queue
		
		BlockingQueue<DelayedTask > queue= new DelayQueue<DelayedTask>();
		queue.put(new DelayedTask("task1", 5, TimeUnit.SECONDS));
		queue.put(new DelayedTask("task2",3, TimeUnit.SECONDS));
		queue.put(new DelayedTask("task3",10, TimeUnit.SECONDS));
		
		while(!queue.isEmpty()) {
			DelayedTask task= queue.take();//blocks until a tasks delay has expired
			System.out.println("executed "+task.getTaskName()+" at "+System.currentTimeMillis());
					
		}
		
	} 

}

class DelayedTask implements Delayed{

	private final String taskName;
	private final long startTime;
	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		if(this.startTime<((DelayedTask) o).startTime) {
			return -1;
		}
		if(this.startTime>((DelayedTask) o).startTime) {
			return 1;
		}
		return 0;
	}

	public DelayedTask(String taskName,long delay, TimeUnit unit) {
		super();
		this.taskName = taskName;
		this.startTime = System.currentTimeMillis()+unit.toMillis(delay);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		long remaining = startTime-System.currentTimeMillis();
		return unit.convert(remaining,TimeUnit.MILLISECONDS);
	}
	public String getTaskName() {
		return taskName;
	}
	
}
