package basic.inheritance.override.basic;

public class ABMain {

	public static void main(String[] args) {
		
		AA a1 = new AA();
		AA a2 = new AA();
		BB b1 = new BB();
		BB b2 = new BB();
		
		a1 = a2;
		b1 = b2;
		
		a1 = b1;
//		b2 = a2;
		
		A a = new A();
		a.sort();
		
		B b = new B();
		
		b.sort();
		b.test();
	}

}
