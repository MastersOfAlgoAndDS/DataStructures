import java.util.LinkedList;

public class DecimalToBinary {
	public static void main(String[] args) {
		int input = 101235;
		decToBin(input);
	}

	private static void decToBin(int input) {
		LinkedList<Character> output = new LinkedList<Character>();
		int remainder = 0;
		int i = 0;
		while (input > 1) {
			remainder = input % 2;
			output.addFirst((char) (remainder + 48));
			input = input / 2;
		}
		if (input == 1)
			output.addFirst((char) (input + 48));
		while (!output.isEmpty()) {
			System.out.print(output.removeFirst());
			i--;
		}
	}
}
