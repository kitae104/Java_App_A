package basic.inheritance.interfaces.calc;

public interface ICalc {
	//private int test;
	
	public static final int MAX1 = 1000;
	public final int MAX2 = 1000;
	static final int MAX3 = 1000;
	public static int MAX4 = 1000;
	int MAX5 = 1000;
	
	public abstract int add(int x, int y); 	// 추상 메소드 
	abstract int sub(int x, int y); 	// 추상 메소드 
	public int mul(int x, int y); 	// 추상 메소드 
	int div(int x, int y); 	// 추상 메소드 
	
	
	public default void test() {
		System.out.println("AAA");
	}
}
