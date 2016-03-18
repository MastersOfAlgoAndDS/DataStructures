package stackoverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaluclateArray {

	static List<SoftwareProject> list;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		initialize();

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).cost;

			System.out.println("Sum: " + sum + "\n");
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).cost);
		}

		// System.out.println("Prices of top 5 most expensive: " +
		// list.get(0).cost);
	}

	static void initialize() {
		list = new ArrayList<>();
		SoftwareProject s = new SoftwareProject("5434", 225000.0, 152);
		list.add(s);
		s = new SoftwareProject("1234", 50000.0, 52);
		list.add(s);
		s = new SoftwareProject("2234", 1000.0, 35);
		list.add(s);
		s = new SoftwareProject("2134", 10000.0, 35);
		list.add(s);
		s = new SoftwareProject("2224", 1110000.0, 35);
		list.add(s);
		s = new SoftwareProject("2244", 140000.0, 35);
		list.add(s);
		s = new SoftwareProject("2235", 30000.0, 35);
		list.add(s);
		s = new SoftwareProject("2236", 750000.0, 35);
		list.add(s);
		s = new SoftwareProject("2237", 75000.0, 35);
		list.add(s);
		s = new SoftwareProject("2254", 8000.0, 35);
		list.add(s);
		s = new SoftwareProject("2634", 80000.0, 35);
		list.add(s);
		s = new SoftwareProject("2231", 23000.0, 35);
		list.add(s);
		s = new SoftwareProject("4321", 15000.0, 35);
		list.add(s);

		Collections.sort(list);
	}
}