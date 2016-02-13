

public class IntToString {

	public static void main(String[] args) {
		int number = 123456;
		String str = IntegerToString(number);
		System.out.println(str);
	}

	public static String IntegerToString(int number) {
		int temp = number;
		int length = 0;
		while (temp > 0) {
			length++;
			temp = temp / 10;
		}
		char[] ans = new char[length];
		for (int i = length - 1; i >= 0; i--) {
			int a = number % 10;
			// ascii adjustment
			a = a + 48;
			char b = (char) a;
			ans[i] = b;
			// System.out.println(b);
			number = number / 10;

		}

		String str = String.valueOf(ans);
		return str;
	}
}
