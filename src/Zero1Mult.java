import java.io.IOException;
import java.util.Scanner;

public class Zero1Mult {

	static long numGenerator(long num) {
		String str = String.valueOf(num);
		char[] chars = str.toCharArray();
		int len = str.length();

		boolean flipperFlipped = false;
		for (int i = len - 1; i >= 0 && flipperFlipped == false; i--) {
			if (chars[len-1]== '0') {
				chars[len-1]='1';
				//return num;
				flipperFlipped = true;
			} else if (chars[i] == '1' && chars[i - 1] == '0') {
				chars[i] = 0;
				chars[i - 1] = 1;
				//return Long.parseLong(chars.toString());
				flipperFlipped = true;
			} else // if(chars[i]=='0'){
			{
				String newstr= String.valueOf(chars);
				newstr.replace('1', '0');
				chars = newstr.toCharArray();
				flipperFlipped = true;
			}
		}
		return Long.parseLong(new String(chars));
	}

	static long zero1Mult(int num){
		
		long flipper = 0;
		boolean condition;
		boolean allAre1;
		boolean foundRightmost0;
		
		while(true){
			flipper=numGenerator(flipper);
			if(flipper%num==0)
				return flipper;
			else 
				continue;
		}
		//return -1;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("C:\\");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		long res;
		int _str;
		try {
			_str = in.nextInt();
		} catch (Exception e) {
			_str = -1;
		}

		res = zero1Mult(_str);
		System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();

		// bw.close();
	}

}
