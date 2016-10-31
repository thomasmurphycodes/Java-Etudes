public class Hero{
	public String name;
	public int age;

	public Hero(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString(){
		return "The heroes name is: " + name + " and their age is " + age;
	}
}