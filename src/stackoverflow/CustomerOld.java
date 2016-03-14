package stackoverflow;

public class CustomerOld {

	public String customerName;
	public String telePhone;

	public CustomerOld(String customerName, String telePhone) {
		setCustomerName(customerName);
		setTelePhone(telePhone);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		// Make the user input lowercase
		customerName = customerName.toLowerCase();
		if (customerName.equals("")) {
			System.out
					.println("You did not enter a name. Did not create new  customer.");
		} else if (customerName.length() > 25) {
			this.customerName = customerName.substring(0, 25);
		} else {
			this.customerName = customerName;
		}

	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		if (telePhone.equals("")) {
			System.out
					.println("You did not enter a telephone number. Did not create new customer.");
		} else {
			this.telePhone = telePhone;
		}
	}
}
