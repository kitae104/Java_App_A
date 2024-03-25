package basic.classes;

public class Name {
	private String firstName;   // 성 
	private String lastName; 	// 이름
	private int a;
	
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public void test() {
		a = 10;
	}
	
	public void test2() {
		System.out.println(a);
	}
	
	
}
