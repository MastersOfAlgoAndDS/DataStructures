import java.util.ArrayList;

public class MergeArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		// Initialize array list a to some values
		for (int i = 0; i < 9; i++) {
			a.add((i + 1) * (i + 1));
		}
		// Initialize array list b to some values
		b.add(9);
		b.add(7);
		b.add(4);
		b.add(9);
		b.add(11);
		b.add(21);
		System.out.println("ArrayList a is " + a);
		System.out.println("ArrayList b is " + b);
		System.out.println("Merged is " + merge(a, b));
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> x,
			ArrayList<Integer> y) {
		ArrayList<Integer> temp = new ArrayList<Integer>(x.size() + y.size());
		int i = 0, j = 0;
		for (i = 0, j = 0; i < x.size() && j < y.size(); i++, j++) {
			temp.add(x.get(i));
			temp.add(y.get(j));
		}
		while (i < x.size()) {
			temp.add(x.get(i));
			i++;
		}
		while (j < y.size()) {
			temp.add(y.get(j));
			j++;
		}
		return temp;

	}

}
