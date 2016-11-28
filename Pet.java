class Pet {
	protected final String name;

	public Pet(String name) {
		this.name = name;
	}

	public void examine() {
		System.out.println("I am a pet and my name is " + name);
	}
}