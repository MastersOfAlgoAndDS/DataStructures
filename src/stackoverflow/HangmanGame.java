package stackoverflow;

import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kybd = new Scanner(System.in);

		System.out.println("Please enter a word: ");
		String wordToGuess = kybd.nextLine();
		char[] underscore = new char[wordToGuess.length()];
		for (int i = 0; i < wordToGuess.length(); i++) {
			underscore[i] = '_';
		}

		int wordLenToGuess = wordToGuess.length();
		int unsuccessfulTries = 6;

		while (wordLenToGuess > 0 && unsuccessfulTries > 0) {
			System.out.println();
			for (int i = 0; i < wordToGuess.length(); i++) {
				System.out.print(" " + underscore[i] + " ");
			}

			System.out.println("You have " + unsuccessfulTries
					+ " tries to make a guess");
			System.out.println("Please enter your guess: ");
			// kybd.nextLine();
			char guess = kybd.nextLine().charAt(0);
			boolean iscorrect = false;
			for (int i = 0; i < underscore.length; i++) {
				if (wordToGuess.charAt(i) == guess) {
					underscore[i] = guess;
					wordLenToGuess--;
					iscorrect = true;
				}
			}

			if (!iscorrect)
				unsuccessfulTries--;
		}

	}

}