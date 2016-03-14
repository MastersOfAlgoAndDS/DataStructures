package stackoverflow;

import java.util.LinkedList;
import java.util.Scanner;

public class Customer2 {

	private String firstName;
	private String lastName;
	private int accountBalance;
	public int total = 0;
	public static int currentSwitch;

	public static void setCurrentSwitch(int tag) {
		if (tag == 1) {
			currentSwitch = 1;
		} else {
			currentSwitch = 0;
		}
	}

	public static int getCurrentSwitch() {
		return currentSwitch;
	}

	private static Customer2 getCurrentRecord(LinkedList<Customer2> list) {
		if (getCurrentSwitch() == 1) {
			return list.getFirst();
		} else {
			return list.getLast();
		}
	}

	public Customer2(String fName, String lName, int balance) {
		firstName = fName;
		lastName = lName;
		accountBalance = balance;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	public String getFirstName() {

		return firstName;

	}

	public String getLastName() {

		return lastName;

	}

	public double getAccountBalance() {

		return accountBalance;

	}

	public void withdraw(int amount) {
		total = accountBalance - amount;
		accountBalance = total;

	}

	public void deposit(int amount) {
		total = accountBalance + amount;
		accountBalance = total;
	}

	public void menu() {

		System.out.println("a  Show all records");
		System.out.println("r  Remove the current record");
		System.out.println("f  Change the first name in the current record");
		System.out.println("l  Change the last name in the current record");
		System.out.println("n  Add a new record");
		System.out.println("d  Add a deposit to the current record");
		System.out.println("w  Make a withdrawal from the current record");
		System.out
				.println("s Select a record from the record list to become the current record");
	}

	public static void main(String[] args) {
		LinkedList<Customer2> bankRecords = new LinkedList<>();

		bankRecords.add(new Customer2("James", "Shown", 150));

		bankRecords.add(new Customer2("Carl", "Bob", 250));

		Scanner input = new Scanner(System.in);
		System.out.println("Enter Command");
		String x = input.nextLine();

		while (true) {
			if (x.equals("a")) {
				printList(bankRecords);
			} else if (bankRecords.isEmpty()) {
				System.out.println("Records are empty");
			}
			if (x.equals("r")) {
				bankRecords.removeLast();
			}
			if (x.equals("f")) {
				Customer2 currentRecord = getCurrentRecord(bankRecords);
				currentRecord.setFirstName("Jack");
			}
			if (x.equals("l")) {
				Customer2 currentRecord = getCurrentRecord(bankRecords);
				currentRecord.setLastName("Kyle");
			}
			if (x.equals("d")) {
				Customer2 currentRecord = getCurrentRecord(bankRecords);
				currentRecord.deposit(20);
			}
			if (x.equals("w")) {
				Customer2 currentRecord = getCurrentRecord(bankRecords);
				currentRecord.withdraw(10);
			}
			if (x.equals("n")) {
				System.out.print("Enter first name: ");
				String name = input.nextLine();
				System.out.println("Enter Last name");
				String lname = input.nextLine();
				System.out.print("Enter Balance:");
				int balance = input.nextInt();
				bankRecords.add(new Customer2(name, lname, balance));
			}

			if (x.equals("s")) {
				setCurrentSwitch(1);
			}
			if (x.equals("q")) {
				System.exit(1);
			}
		}
	}

	public static void printList(LinkedList<Customer2> list) {

		for (Customer2 data : list) {

			System.out.println(data.getFirstName() + "\t" + data.getLastName()
					+ "\t" + data.getAccountBalance());

		}

	}

}
