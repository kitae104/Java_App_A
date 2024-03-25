package basic.string;

public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = new String("Java");
		String s3 = "Java";
		String s4 = "Java";
		
		if(s1.equals(s2)) {
			System.out.println("OK");
		} else {
			System.out.println("NO");
			
		}
	}

}
