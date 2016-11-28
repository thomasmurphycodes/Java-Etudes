public class BuilderExample {
	// The stereotypical user object
	
	// First, immutable fields
	private final String firstName;	// required
	private final String lastName;	// required
	private final int age;			// optiona;
	private final String phone;	  	// optiona;
	private final String address; 	// optiona;

	// The private constructor
	private BuilderExample(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "This user's name is " + getFirstName() + " " + getLastName() + " and they are " + getAge() + " years old.";
	}

	// The Builder itself, static because it is the Factory, building the object from the chained methods
	public static class UserBuilder {
		// Same fields as above, but only required fields are final in this one
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		// Normal constructor for required fields
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		// One constructor per optional field, assign as normal, then return this
		public UserBuilder age(int age){
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone){
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		// Last, the main public constructor invoking the private constructor above, which takes the "this" value
		// that's built up through the chained methods
		public BuilderExample build() {
			return new BuilderExample(this);
		}
	}
}