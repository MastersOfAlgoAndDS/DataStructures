package hackerrank;

import java.util.Scanner;

public class EulerCode {
	
	private int arr;
	private boolean memflag;
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getArr() {
		return arr;
	}

	public void setArr(int arr) {
		this.arr = arr;
	}

	public boolean isMemflag() {
		return memflag;
	}

	public void setMemflag(boolean memflag) {
		this.memflag = memflag;
	}

	EulerCode(){
		weight = 0;
		arr=0;
		memflag=false;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numTC = in.nextInt();
		for (int k = 0; k < numTC; k++) {
			int m = in.nextInt();
			EulerCode[][] eu = new EulerCode[m][m];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j <= i; j++) {
					eu[i][j] = new EulerCode();
				}
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j <= i; j++) {
					eu[i][j].setArr(0);
					eu[i][j].setArr(in.nextInt());
				}
			}
			int res = Calculator(0, 0, eu);
			System.out.println(res);
		}
	}

	private static int Calculator(int i, int j, EulerCode[][] eu) {
		if (i == eu.length - 1){
			return eu[i][j].getArr();
		}
		else if (eu[i][j].isMemflag() == true) {
			return eu[i][j].getWeight();
		} else {
			eu[i][j].setMemflag(true);
			int memoization = eu[i][j].getArr() + Math.max(Calculator(i + 1, j, eu),
					Calculator(i + 1, j + 1, eu));
			eu[i][j].setWeight(memoization);
			return memoization;	
		}

	}
}

/*
 * Input 1 4 3 7 6 2 4 8 8 5 9 3
 */
