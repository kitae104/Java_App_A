package basic.inheritance.abstracts.dynaicbinding;

public class Main {

	public static void main(String[] args) {
				
		Shape s;
		
		s = new Line();			// upcast
		s.draw();
		
		s = new Circle();
		s.draw();
		
		s = new Rect();
		s.draw();

		
		
	}

}
