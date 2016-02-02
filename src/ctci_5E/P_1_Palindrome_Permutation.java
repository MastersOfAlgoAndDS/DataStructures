package ctci_5E;

public class P_1_Palindrome_Permutation {

	public static void main(String[] args) {
		String input = "Tact Coa";
		P_1_Palindrome_Permutation s = new P_1_Palindrome_Permutation();
		System.out.println(s.isPalindromePermutation(input));
	}

	private boolean isPalindromePermutation(String input) {
		char[] str = input.toCharArray();
		int checker = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] != ' ') {
				checker ^= (1 << str[i] - 'a');
			}
		}
		int crossChecker = checker - 1;
		checker &= crossChecker;
		if (checker == 0)
			return true;
		return false;
	}
}
