import java.util.concurrent.BlockingQueue;

class ConcurrentInfiniteVetrinarian extends Thread {
	protected final BlockingQueue<Appointment<Pet>> appts;
	protected String text = "";
	protected final int restTime;
	private boolean shutdown = false;

	public ConcurrentInfiniteVetrinarian(BlockingQueue<Appointment<Pet>> lbq, int pause) {
		appts = lbq;
		restTime = pause;
	}

	public synchronized void shutdown() {
		shutdown = true;
	}

	@Override
	public void run(){
		while(!shutdown) {
			//Infinite loop
			seePatient();
			try {
				Thread.sleep(restTime);
			} catch (InterruptedException e) {
				shutdown = true;
			}
		}
	}

	public void seePatient() {
		try {
			Appointment<Pet> ap = appts.take();
			Pet patient = ap.getPatient();
			patient.examine();
		} catch (InterruptedException e) {
			shutdown = true;
		}
	}
}