import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class PeriodicReads {
	private ScheduledExecutorService stpe;
	private ScheduledFuture<?> hndl;

	private BlockingQueue<WorkUnit<String>> lbq = new LinkedBlockingQueue<>();

	private void run(){
		stpe = Executors.newScheduledThreadPool(2);

		final Runnable msgReader = new Runnable(){
			public void run(){
				String nextMsg = lbq.poll().getWork();
				if(nextMsg != null) System.out.println("Message Received: " + nextMsg);
			}
		};
		hndl = stpe.scheduleAtFixedRate(msgReader, 10, 10, TimeUnit.MILLISECONDS);

	}

	public void cancel() {

	}
}