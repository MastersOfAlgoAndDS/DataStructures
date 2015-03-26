public class Fibonacci {
	public static void fibIterative(int n) {
		int fib1 = 1, fib2 = 1;
		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == 2)
				System.out.print(1 + " ");
			else {
				int fibo = fib1 + fib2;
				System.out.print(fibo + " ");
				fib1 = fib2;
				fib2 = fibo;
			}
		}
		System.out.println();
	}

	public static int fibRecursive(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibRecursive(n - 1) + fibRecursive(n - 2);
		}
	}

	public static void main(String[] args) {
		int n = 15;
		fibIterative(n);
		for (int i = 1; i <= n; i++) {
			System.out.print(fibRecursive(i) + " ");
		}
		System.out.println();
	}
}
