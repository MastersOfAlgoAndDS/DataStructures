package geeksforgeeks;

public class TwoStacksUsingArray {

	int[] arrayStack;
	int top1 = -1;
	int top2 = -1;
	int length = 0;

	TwoStacksUsingArray(int len) {
		length = len;
		arrayStack = new int[length];
		top2 = length;
	}

	public boolean isStackEmpty(int stackNumber) {
		switch (stackNumber) {
		case 1:
			if (top1 == -1)
				return true;
			else
				return false;
		case 2:
			if (top2 == length)
				return true;
			else
				return false;
		}
		return true;
	}

	public void push(int stackNumber, int val) {
		if (!isStackFull()) {
			switch (stackNumber) {
			case 1:
				arrayStack[++top1] = val;
				break;
			case 2:
				arrayStack[--top2] = val;
				break;
			}
		}
	}

	public boolean isStackFull() {
		if (top2 - top1 == 1)
			return true;
		return false;
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < length; i++) {
			System.out.print(arrayStack[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}

	public int peek(int stackNumber){
		if(!isStackEmpty(stackNumber)){
			switch(stackNumber){
			case 1: return arrayStack[top1];
			case 2: return arrayStack[top2];
			}
		
		}
		return -1;
	}

	public static void main(String[] args) {
		int stackLengthToSet = 10;
		TwoStacksUsingArray s = new TwoStacksUsingArray(stackLengthToSet);
		System.out.println(s.isStackEmpty(1));
		System.out.println(s.isStackEmpty(2));
		System.out.println(s.isStackFull());
		s.print();
		for (int i = 1; i <= 5; i++) {
			s.push(1, i);
		}
		for (int i = 1; i <= 15; i++) {
			s.push(2, i);
		}
		s.print();
		System.out.println(s.peek(1));
		System.out.println(s.peek(2));
	}
}
