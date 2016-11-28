class BuilderClient {
	public static void main(String[] args) {
		BuilderExample myBuilderUser = new BuilderExample.UserBuilder("Thomas", "Murphy").age(28).phone("6469576115").address("123 Fake Street").build();
		System.out.println(myBuilderUser.toString());
	}		
}

