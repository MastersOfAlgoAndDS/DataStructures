package geeksforgeeks.bitmagic;

public class MultiplyBy7 {

	public static int MultiplyBy7(int num1){
		return ((num1<<3) - (num1));
	}
	
	public static void main(String[] args) {
		System.out.println(MultiplyBy7(12));
	}

}
