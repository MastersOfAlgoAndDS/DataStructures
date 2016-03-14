package stackoverflow;

import java.util.*;
import java.text.DecimalFormat;

public class Customer {
	private long acctNum;
	private String name;
	private double balance = 0;

	DecimalFormat df = new DecimalFormat("$0.00");

	public Customer(long acctNum, String name) {
		this.acctNum = acctNum;
		this.name = name;
		this.balance = 0.00;
	}

	public void deposit(double in) {
		this.balance = this.balance + in;
	}

	public void withdraw(double out) {
		if ((this.balance - out) < 0.0) {
			System.out.println("Invalid amount to withdraw.");
		} else {
			this.balance = this.balance - out;
		}
	}

	public void calcInterest() {
		if (this.balance <= 0.0) {
			System.out.println("No interest added to an empty account.");
		} else {
			this.balance = (this.balance) * 1.03;
		}
	}

	public double getBalance() {

		return Double.valueOf(this.balance);
	}

}