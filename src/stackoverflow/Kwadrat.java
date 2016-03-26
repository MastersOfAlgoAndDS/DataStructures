package stackoverflow;

import java.util.ArrayList;
import java.util.Collections;

public class Kwadrat implements Comparable<Kwadrat> {

	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Kwadrat(int a) {
		this.a = a;
	}

	public int get_size() {
		return a * a;
	}

	public int compareTo(Kwadrat b) {
		if (b.get_size() > get_size()) {
			return -1;
		}
		if (b.get_size() < get_size()) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		ArrayList<Kwadrat> list = new ArrayList<Kwadrat>();
		list.add(new Kwadrat(3));
		list.add(new Kwadrat(5));
		list.add(new Kwadrat(1));
		list.add(new Kwadrat(4));
		list.add(new Kwadrat(2));

		for (Kwadrat kwadrat : list) {
			System.out.print(kwadrat.a + " ");
		}
		System.out.println();

		Collections.sort(list);

		for (Kwadrat kwadrat : list) {
			System.out.print(kwadrat.a + " ");
		}

	}
}