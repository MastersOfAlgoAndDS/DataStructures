package stackoverflow.inheritance;

class Triangle extends inheritence {
	String style;

	double area() {
		return getHeight() * getWidth();
	}

	void showStyle() {
		System.out.println("Triangle is " + style);
	}
}
