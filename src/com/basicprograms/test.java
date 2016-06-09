import java.util.Comparator;

public class test {
	public int x[];

	public test(int x[]) {
		setx(x);
	}

	public void setx(int newx[]) {
		x = newx;
	}

	public int[] getx() {
		return x;
	}

	public int findSmallest() {
		int i = 0;
		int temp = x[i];

		while (i < x.length) {
			i++;
			if (x[i] < temp) {
				temp = x[i];
			} else {

			}

		}

		return temp;

	}

	public int findLargest() {
		int i = 0;
		int temp = x[i];

		while (i < x.length) {
			i++;
			if (x[i] > temp) {
				temp = x[i];
			} else {

			}

		}

		return temp;

	}

	public double findMean() {
		int i = 0;
		double sum = 0.0;
		double avg = 0.0;

		while (i < x.length) {
			sum += x[i];
			i++;
		}

		avg = sum / x.length;
		return avg;
	}

	public int findTotal() {

		int i = x.length;

		return i;

	}

	public static void main(String args[]) {

		int[] ia = { 1, 2, 3, 4, 5, 6 };

		test intTest = new test(ia);

		System.out.println(intTest.findTotal());

	}

}
