package LogicMonitor;

public class LRUNode {
	int key;
	int value;
	LRUNode pre;
	LRUNode next;

	public LRUNode(int key2, int value2) {
		this.key = key2;
		this.value = value2;
		this.pre = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LRUNode [key=" + key + ", value=" + value + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
