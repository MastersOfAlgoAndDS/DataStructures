package stackoverflow;

public class ClassPeriod {
	private int myNumStudents;
	private Student[] myStudents;
	private String myClassName;
	int N = 10;

	public ClassPeriod(String classname) {
		myClassName = classname;
		myNumStudents = 0;
		myStudents = new Student[N];
	}

	// add the Student to the myStudents array. If the array is full, create a
	// new
	// one twice the size of the current one. Update myNumStudents accordingly.
	public void addStudent(Student st) {
		for (int i = 0; i < 1; i++) {
			if (myNumStudents == 10 || myNumStudents == 20) {// student array
																// size is 10,
																// if 10 is
																// reached,
																// double its
																// size
				N = 2 * myNumStudents;
				myStudents = new Student[N];
			}
			switch (myNumStudents) {
			case 0:
				myStudents[0] = st;
				break;
			case 24:
				myStudents[24] = st;
				break;
			default:
				break;
			}
			myNumStudents++;// increment myNumStudents by 1
		}
		for (int j = 0; j < N; j++) {
			System.out.println("Students: " + myStudents[j]);
		}
	}

	public Student[] getStudents() {
		System.out.println("myNumStudents: " + myNumStudents);
		Student temp[] = new Student[myNumStudents];
		for (int i = 0; i < myNumStudents; i++) {
			temp[i] = myStudents[i];
		}
		System.out.println("temp: " + temp.length);
		return temp;
	}

	public String toString() {
		String s = new String(myClassName + "\n");
		int i;
		for (i = 0; i < myNumStudents - 1; i++)
			s += myStudents[i].toString() + "\n";
		s += myStudents[myNumStudents - 1];
		return s;
	}
}