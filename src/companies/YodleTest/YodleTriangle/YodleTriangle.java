package companies.YodleTest.YodleTriangle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class YodleTriangle {

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

	YodleTriangle() {
		weight = 0;
		arr = 0;
		memflag = false;
	}

	private static int Calculator(int i, int j, YodleTriangle[][] jt) {
		if (i == jt.length - 1) {
			return jt[i][j].getArr();
		} else if (jt[i][j].isMemflag() == true) {
			return jt[i][j].getWeight();
		} else {
			jt[i][j].setMemflag(true);
			int memoization = jt[i][j].getArr()
					+ Math.max(Calculator(i + 1, j, jt),
							Calculator(i + 1, j + 1, jt));
			jt[i][j].setWeight(memoization);
			return memoization;
		}
	}
	
	public static int getMatrixSize(int inputSize){
		//n2 + n - inputSize = 0
		int d = (int) Math.sqrt(1+4*1*inputSize*2);
		int size= Math.max(-1+d, -1-d);
		size=size/2;
		return size;
	}

	public static void main(String[] args) throws IOException {
		URL url = YodleTriangle.class.getResource("triangle.txt");
		String fileName = url.getPath();
		
		long startTime = System.currentTimeMillis();
		
		Scanner in = new Scanner(new File(fileName));
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		while (in.hasNextLine()) {
			inputList.add(in.nextInt());
		}
		int matrixSize = inputList.size();
		matrixSize= getMatrixSize(matrixSize);
		
		YodleTriangle[][] jt = new YodleTriangle[matrixSize][matrixSize];
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j <= i; j++) {
				jt[i][j] = new YodleTriangle();
			}
		}

		for (int i = 0, k=0; i < matrixSize; i++) {
			for (int j = 0; j <= i; j++) {
				jt[i][j].setArr(0);
				jt[i][j].setArr(inputList.get(k));
				k++;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time for input and data population: " + (endTime-startTime));
		int res = Calculator(0, 0, jt);
		endTime = System.currentTimeMillis();
		System.out.println("Answer is: "  + res);
		System.out.println("Time for calculation: " +  (endTime-startTime));

	}
}
