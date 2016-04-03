package stackoverflow.inheritance;

public class Rectangle extends Triangle {
	boolean isSquare() {
		if (getWidth() == getHeight()) {
			return true;
		} else {
			return false;
		}

	}

	public double area() {
		return getWidth() * getHeight();
	}
}