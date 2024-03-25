package basic.classes;

public class PersonMain {

	public static void main(String[] args) {
		
		Name name = new Name("홍", "길동");
		Address addr = new Address("인천 미추홀구", "인하로 100");
		
		Person hong = new Person(name, 0, addr);
		System.out.println(hong);
		
		String firstName = hong.getName().getFirstName();		
		System.out.println(firstName);
		
		hong.getName().setLastName("천재");
		System.out.println(hong);

		Address addr2 = hong.getAddr();
		
		
	}

}
