class Comet extends Thread {
	public void run() {
		System.out.println("Orbiting");
		orbit();
	}
}

Comet halley = new Comet();
halley.run();