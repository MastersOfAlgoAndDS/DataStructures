package stackoverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort<T extends Comparable<? super T>> {
	ArrayList<T> arraylist;

	public Sort() {
		arraylist = new ArrayList<T>();
	}

	public void add(T element) {

		arraylist.add(element);

		Collections.sort(arraylist);

	}

	public static void main(String[] args) {
		Sort<Kwadrat> toSortList = new Sort<Kwadrat>();
		toSortList.add(new Kwadrat(3));
		toSortList.add(new Kwadrat(5));
		toSortList.add(new Kwadrat(1));
		toSortList.add(new Kwadrat(4));
		toSortList.add(new Kwadrat(2));

		for (String string : args) {

		}
		for (Kwadrat kwadrat : toSortList.arraylist) {
			System.out.print(kwadrat.getA() + " ");
		}
		System.out.println();

	}
}