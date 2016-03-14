package geeksforgeeks;

public class StringReverse {

	public static void reverseLinearSpace(String input) {
		String[] arr = input.split(" ");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}

	public static String reverseConstantSpace(char[] input) {
		int i = 0;
		int j = 0;
		// Pass 1
		while (j < input.length) {
			if (input[j] == ' ') {
				reverseConstantSpaceHelper(input, i, j - 1);
				i = j + 1;
			} else if (j == input.length - 1) {
				reverseConstantSpaceHelper(input, i, j);
			}
			j++;
		}

		// Pass 2
		reverseConstantSpaceHelper(input, 0, input.length - 1);

		return String.valueOf(input);
	}

	public static void reverseConstantSpaceHelper(char[] input, int start,
			int end) {
		while (start < end) {
			char temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		String input = "i like java programming";
		System.out.println(input);
		reverseLinearSpace(input);
		System.out.println();
		char[] inputChar = input.toCharArray();
		System.out.println(reverseConstantSpace(inputChar));
	}
}
