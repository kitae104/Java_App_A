package basic.inheritance.abstracts;

public class Main {

	public static void main(String[] args) {
		ACalc cal = new RealRealCalc();
		int result = cal.div(0, 0);
		System.out.println(result);
		

	}

}
