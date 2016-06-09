package com.basicprograms;
import java.util.Scanner;

public class ProgramSpeedOfSound {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String input;

		System.out.println("Enter Air, water or steel ");
		input = keyboard.nextLine().toUpperCase();

		if (input.equals("Air")) {

			System.out.println("what is the Distance? ");
			int Distance = keyboard.nextInt();
			int var = 1100;
			double time = Distance / var;

			System.out.println("it would take " + time);

		} else if (input.equals("Water")) {

			System.out.println("what is the Distance? ");
			int Distance = keyboard.nextInt();

			double time = (((Distance / 4900)));

			System.out.println("it would take " + time);
		} else {

			System.out.println("what is the Distance? ");

			int Distance = keyboard.nextInt();

			double time = (float)Distance / 16400;

			System.out.println("it would take " + time);

		}
	}
}