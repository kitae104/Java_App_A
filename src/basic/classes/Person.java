package basic.classes;

public class Person {
	private Name name;   //홍 길동
	private int age;
	private Address addr;
	
	public Person(Name name, int age, Address addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
	
}
