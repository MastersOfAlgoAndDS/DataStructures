package stackoverflow;

import java.util.ArrayList;

public class PalindromeWierd {
	public static void main(String[] args) {
		ArrayList<Character> palim = new ArrayList<Character>();
		palim.add('m');
		palim.add('a');
		palim.add('d');
		palim.add('a');
		palim.add('m');
		System.out.println("Palim with vowels: ");
		for (Character character : palim) {
			System.out.print(character);
		}
		System.out.println();

		ArrayList<Character> palimWithoutVowels = new ArrayList<Character>();
		for (Character character : palim) {
			if (character != 'a' && character != 'e' && character != 'i'
					&& character != 'o' && character != 'u') {
				palimWithoutVowels.add(character);
			}
		}
		System.out.println("Palim without vowels: ");
		for (Character character : palimWithoutVowels) {
			System.out.print(character);
		}
		System.out.println();

	}
}
