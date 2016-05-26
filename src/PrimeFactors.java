import java.util.HashSet;
import java.util.Set;

/**
 * * Java program to print prime factors of a number. For example if input is
 * 15, * then it should print 3 and 5, similarly if input is 30, then it should
 * * display 2, 3 and 5. * * @author Javin Paul
 */
public class PrimeFactors {
	public static void main(String args[]) {
		System.out.printf("Prime factors of number '%d' are : %s %n", 35,
				primeFactors(35));
		System.out.printf("Prime factors of integer '%d' are : %s %n", 72,
				primeFactors(72));
		System.out.printf("Prime factors of positive number '%d' is : %s %n",
				189, primeFactors(189));
		System.out.printf(
				"Prime factors of number '%d' are as follows : %s %n", 232321,
				primeFactors(232321));
		System.out.printf(
				"Prime factors of number '%d' are as follows : %s %n",
				67232321, primeFactors(67232321));
	}

	/**
	 * * @return prime factors of a positive integer in Java. * @input 40 * @output
	 * 2, 5
	 */
	public static Set<Integer> primeFactors(long number) {
		Set<Integer> primefactors = new HashSet<>();
		long copyOfInput = number;
		for (int i = 2; i <= copyOfInput; i++) {
			if (copyOfInput % i == 0) { // if number is divisible by iterator i,
										// then reduce the number by dividing by

				primefactors.add(i);
				copyOfInput /= i;
				i--;
			}
		}
		return primefactors;
	}
}

// Read more:
// http://javarevisited.blogspot.com/2014/05/how-to-find-prime-factors-of-integer-number-java.html#ixzz42uckVW2U