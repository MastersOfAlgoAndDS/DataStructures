package ctci_5E;

import java.util.Arrays;

/**
 * @Problem: Describe how you could use a single array to implement three
 *           stacks.
 * 
 * @Solution: FixedDivision of stacks and all stacks of same size. Here there
 *            can be a problem of space like some of the stack may be full while
 *            other stacks may be empty.
 * 
 *            In such case we can have a check on to see which stack is full or
 *            empty or some other condition. Or we can create a MultiStack with
 *            flexible division. But it is complex to implement especially with
 *            array because of lot of shifting will be required..
 * 
 *            However we can use an array and linked list to do this. We can
 *            have an array to have the head or top pointers of each of the
 *            stack. And do all the operations on the corresponding stack.
 * 
 * 
 * 
 * @author Milind
 *
 */
public class P3_1_FixedMultiStack {
	private int numOfStacks;
	private int stackCapacity; // this is stack capacity of each stack
	private int[] values;
	private int[] sizes;

	/**
	 * @param numOfStacks
	 * @param stackCapacity
	 */
	public P3_1_FixedMultiStack(int numOfStacks, int stackCapacity) {
		super();
		this.numOfStacks = numOfStacks;
		this.stackCapacity = stackCapacity;
		this.values = new int[numOfStacks * stackCapacity];
		this.sizes = new int[numOfStacks];
		for (int i = 0; i < numOfStacks; i++) {
			sizes[i] = -1;
		}
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] < 0;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	public int getTopOfStack(int stackNum) {
		int offset = stackNum * stackCapacity; // start of stack.
		int size = sizes[stackNum]; // current size of stack i.e. top
									// within the stack
		return offset + size; // top of the stack is start of stack + current
								// size of stack
	}

	public void push(int stackNum, int value) throws Exception {
		if (isFull(stackNum))
			throw new Exception("Stack is full");
		sizes[stackNum]++; // this step is important to be done first to
		// maintain top of stack and use it in the next step
		values[getTopOfStack(stackNum)] = value;
	}

	public int pop(int stackNum) throws Exception {
		if (isEmpty(stackNum))
			throw new Exception("Stack is empty");
		int value = values[getTopOfStack(stackNum)];
		sizes[stackNum]--; // its important to do this step after above step.
		return value;
	}

	public int peek(int stackNum) throws Exception {
		if (isEmpty(stackNum))
			throw new Exception("Stack is empty");
		return values[getTopOfStack(stackNum)];
	}

	@Override
	public String toString() {
		return "P3_1_FixedMultiStack [numOfStacks=" + numOfStacks
				+ ", stackCapacity=" + stackCapacity + ", values="
				+ Arrays.toString(values) + ", sizes=" + Arrays.toString(sizes)
				+ "]";
	}

	public static void main(String[] args) {
		P3_1_FixedMultiStack ms = new P3_1_FixedMultiStack(3, 3);
		System.out.println(ms.toString());
		try {
			ms.push(2, 3);
			ms.push(2, 4);
			ms.push(2, 5);
			ms.pop(2);
			ms.pop(2);
			ms.peek(2);
			ms.pop(2);
			ms.push(1, 3);
			ms.push(2, 4);
			ms.push(0, 5);
			ms.pop(0);
			ms.pop(1);
			ms.peek(2);
			ms.pop(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ms);
	}
}
