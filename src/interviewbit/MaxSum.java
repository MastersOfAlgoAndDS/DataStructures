package interviewbit;

import java.util.ArrayList;

public class MaxSum {

	int i;
	int j;
	int sum;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	MaxSum(int start, int end, int sum) {
		this.i = start;
		this.j = end;
		this.sum = sum;
	}

	MaxSum() {

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, -7, 2, 3 };
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (Integer in : arr) {
			input.add(in);
		}
		MaxSum s = new MaxSum();
		ArrayList<Integer> ans = s.maxset(input);

	}

	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
		ArrayList<MaxSum> m = new ArrayList<MaxSum>();
		int start = 0;
		int end = 0;
		int sum = 0;
		int i = 0;
		while (end < a.size()) {
			if (a.get(end) >= 0) {
				sum += a.get(end);
			} else {
				m.add(new MaxSum(start, end - 1, sum));
				start = end + 1;
				sum = 0;
			}
			end++;
		}
		m.add(new MaxSum(start, end - 1, sum));

		int maxsum = -1;
		int index = -1;
		int indexDiff = 0;
		for (int k = 0; k < m.size(); k++) {
			if (maxsum < m.get(k).getSum()) {
				maxsum = m.get(k).getSum();
				index = k;
				indexDiff = m.get(k).getJ() - m.get(k).getI() + 1;
			} else if (maxsum == m.get(k).getSum()) {
				if ((m.get(k).getJ() - m.get(k).getI()) > indexDiff) {
					maxsum = m.get(k).getSum();
					index = k;
					indexDiff = m.get(k).getJ() - m.get(k).getI() + 1;
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();
		int subArrStart = m.get(index).getI();
		int subArrEnd = m.get(index).getJ();

		int iter = subArrStart;
		while (iter <= subArrEnd) {
			ans.add(a.get(iter));
			iter++;
		}

		return ans;
	}
}
