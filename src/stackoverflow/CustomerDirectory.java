package stackoverflow;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDirectory {
	// Shorten Scanner
	static Scanner keyboard = new Scanner(System.in);

	static ArrayList<CustomerOld> customerOlds = new ArrayList<CustomerOld>();

	public static void main(String[] args) {
	}

	public static void addCustomer() {

		System.out.print("Enter new name: ");
		String name = keyboard.nextLine();
		name = keyboard.nextLine();
		System.out.print("Enter new phone number: ");
		String number = keyboard.nextLine();

		CustomerOld newCustomer = new CustomerOld(name, number);
		customerOlds.add(newCustomer);

	}

	public static void findCustomer() {
		System.out.print("Enter name of customer to find: ");
		String findName = keyboard.nextLine();
		findName = keyboard.nextLine();
		if (findName.equals(" ")) {
			System.out.println("You did not enter a name.");
		} else {
			for (CustomerOld c : customerOlds) {
				if (c.getCustomerName().contains(findName)) {
					System.out.println(c.getCustomerName());
				}
			}
		}
	}

}