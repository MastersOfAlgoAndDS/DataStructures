package stackoverflow;

import java.util.ArrayList;
import java.util.Collections;

public class Sort_MultipleField {

	public static void main(String[] args) {

		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Milind", "Gokhale", 1, 7.73));
		studentList.add(new Student("Milind", "Gokhale", 1, 7.70));
		studentList.add(new Student("Zach", "Doe", 1, 7.8));
		System.out.println("--Unsorted--");

		for (Student student : studentList) {
			System.out.print(student.firstname + " " + student.lastname + ": ");
			System.out.print(student.gpa);
			System.out.println();
		}
		System.out.println();

		Collections.sort(studentList);
		System.out.println("--Sorted--");

		for (Student student : studentList) {
			System.out.print(student.firstname + " " + student.lastname + ": ");
			System.out.print(student.gpa);
			System.out.println();
		}
	}
}
