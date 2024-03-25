package basic.inheritance;

public class B extends A{
	private int b;

	public B(int a, int b) {
		super(a);
		this.b = b;
		System.out.println("B 생성자 호출");		
	}
	
	
}
