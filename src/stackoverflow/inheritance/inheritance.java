package stackoverflow.inheritance;

class inheritence {
	private double width;
	private double height;

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	void showDim() {
		System.out.println("Width and height are " + width + " and " + height);
	}
}