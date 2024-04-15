package basic.inheritance.abstracts;

public abstract class ACalc {
	
	private int test;		// 인스턴스 변수 
 
	public static final int MAX = 1000; // 상수 
	int abc = 100;
	int bbb; 
	
	public void test() {
		System.out.println("AAA");
	}
	
	public abstract int add(int x, int y); 	// 추상 메소드 
	public abstract int sub(int x, int y); 	// 추상 메소드 
	public abstract int mul(int x, int y); 	// 추상 메소드 
	public abstract int div(int x, int y); 	// 추상 메소드 
	
	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
	

}
