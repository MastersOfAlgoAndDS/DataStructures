package stackoverflow;

public class Factorial {

	public static long factorial(long number) {
		if (number <= 1) // test for base case
			return 1;
		else { // recursion step
			return number * factorial(number - 1);
		}
	}

	// output factorial for values 0-21
	public static void main(String[] args) {
		// calculate factorials 0-21
		String s1 = "";
		for (int counter = 0; counter <= 21; counter++) {
			long x = factorial(counter);
			s1 += " ";
			System.out.printf("%s%d! = %d*%d!=%d%n", s1, counter, counter,
					counter - 1, x);
		}
	}
}