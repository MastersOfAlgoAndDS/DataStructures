package stackoverflow;

import java.util.HashMap;
import java.util.Map;

class Phone {

	int number;

	Phone(int number) {
		this.number = number;
	}

	public int hashCode() {
		return number;
	}

	public boolean equals(Object o) {
		if (o != null && o instanceof Phone)
			return (number == ((Phone) o).number);
		else
			return false;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + "]";
	}

	public static void main(String args[]) {
		Map<Phone, String> map = new HashMap<>();
		Phone num1 = new Phone(2500);
		map.put(num1, "John");
		System.out.println(map.get(new Phone(2500)));
		num1.number = 100;

		System.out.println(map);
		System.out.println(num1);
		System.out.println(map.entrySet());
		System.out.println(map.get(num1)); // why does it print null
		System.out.println(map.get(new Phone(100)));
		
		
	}
}