package basic.inheritance.override.dynaicbinding;

public class Main {

	public static void main(String[] args) {
				
		Shape s = new Shape();
		s.draw();
		
		s = new Line();			// upcast
		s.draw();
		
		s = new Circle();
		s.draw();
		
		s = new Rect();
		s.draw();

		
		
	}

}
