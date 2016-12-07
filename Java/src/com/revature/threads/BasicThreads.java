package com.revature.threads;

public class BasicThreads {

	public static void main(String[] args) throws InterruptedException {
		int runs = 0;
		// create 2 threads
		// implements Runnable?   pass to Thread()
		Thread job = new Thread(new Job());
		// extends Thread? make the object
		Work work = new Work();

		// configure the thread before we start
		job.setPriority(Thread.MAX_PRIORITY);
		work.setPriority(1);
		Thread main = Thread.currentThread();
		main.setPriority(1);
		
		job.start();
		work.start();

		for(;;) {			
			runs++;
			System.out.println("Main runs " +runs);
			// randomly escape
			/*if(Math.random() > .8){
				break;
			}*/
		}
		
		/*// only when all threads are done
		job.join();
		work.join();
		System.out.println("All threads complete!");*/
	}
	
}

class Job implements Runnable{
	int runs = 0;
	@Override
	// what happens when we start the thread
	public void run() {
		for(; ;){
			runs++;
			System.out.println("Job runs " + runs);
			
/*			// randomly escape
			if(Math.random() > .8){
				break;
			}*/
		}
	}
}
class Work extends Thread{
	int runs = 0;
	@Override
	public void run() {
		while(true){
			runs++;
			System.out.println("Work runs " + runs);
			
			/*// randomly escape
			if(Math.random() > .8){
				break;
			}*/
		}
	}
}



