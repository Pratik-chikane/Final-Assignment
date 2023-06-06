package assignment.FinalAssignment.CoreJava;

//Inside Interface methods are by default public and abstract

interface Iinterface {

	public String saveName(String name);

	public String saveAddress(String addr);

	public String saveAge(Integer age);

}

//Creating abstract class that provides the implementation of one method of Iinterface interface

//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods
class Person implements Iinterface {

	@Override
	public String saveName(String name) {

		return "Name saved-" + name;
	}

	@Override
	public String saveAddress(String addr) {

		return "Address saved" + addr;
	}

	@Override
	public String saveAge(Integer age) {
		// TODO Auto-generated method stub
		return "Age saved " + age;
	}

}

//Creating a Main class that calls the methods of Iinterface interface  
public class Q5 {

	public static void main(String[] args) {

		Iinterface person = new Person();
		person.saveName("Pratik");
		person.saveAddress("Pune");
		person.saveAge(23);

	}

}