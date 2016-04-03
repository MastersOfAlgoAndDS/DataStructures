package stackoverflow.inheritance;

public class Driver {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		Rectangle rect = new Rectangle();
		rect.setHeight(10);
		rect.setWidth(20);
		if (rect.isSquare()) {
			System.out.println("Its a square!");
		} else {
			System.out.println("Its not a square");

		}

		System.out.println(t1.getHeight());
		System.out.println(t1.getWidth());
		t1.showDim();
		System.out.println("The area for t1 is " + t1.area());
		t1.style = "Outlined";
		t1.showStyle();

	}
}