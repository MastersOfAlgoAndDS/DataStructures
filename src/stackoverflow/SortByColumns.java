package stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortByColumns {

	public static void main(String[] args) {
		// List "lines" is declared above
		Scanner in = new Scanner(System.in);
		in.nextLine();
		String[] lines = null;
		List<List<String>> data = new ArrayList<>();
		List<List<String>> maxValues = new ArrayList<>();

		// clear and separate to clear comparable parts
		for (String s : lines) {
			String parts[] = s.trim().replace("\"", "").split(";");
			List newList = Arrays.asList(parts);
			data.add(newList);
		}

		// naïve algorithm to find the maximum dependent to the another one
		// not sure if working
		for (List l : data) {
			int id = Integer.parseInt(l.get(0).toString());
			int max = 0;
			List<String> tempMaxValues = new ArrayList<>();
			for (int i = 0; i < data.size(); i++) {
				if (Integer.parseInt(l.get(0).toString()) == id) {
					int temp = Integer.parseInt(l.get(1).toString());
					if (temp > max) {
						max = temp;
						tempMaxValues = l;
					}
				}
			}
			maxValues.add(tempMaxValues);
		}
	}

}
