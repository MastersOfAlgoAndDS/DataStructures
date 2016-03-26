package stackoverflow;

public class Student implements Comparable<Student> {
	String firstname;
	String lastname;

	int id;
	double gpa;

	public Student(String firstname, String lastname, int id, double gpa) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Student o2) {
		int c;
		c = this.lastname.compareToIgnoreCase(o2.lastname);
		if (c == 0) {
			c = Double.compare(this.gpa, o2.gpa);
		}
		return c;
	}

}
