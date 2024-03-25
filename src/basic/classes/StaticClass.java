package basic.classes;

public class StaticClass {
	public static void main(String[] args) {
		int a = 10;
		int b = 20; 
		
		StaticClass sc = new StaticClass();
		int result = sc.add(a, b);
		System.out.println(result);
		
		
		
	}

	private int add(int a, int b) {
		return a + b;
	}
}
