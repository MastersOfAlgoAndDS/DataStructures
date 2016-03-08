package stackoverflow;

import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please Enter speed: ");
		double speed = in.nextDouble();
		System.out.print("Please Enter distance: ");
		int distance = in.nextInt();
		double time = distance / speed;
		System.out.println("Your time is: " + time);
	}
}