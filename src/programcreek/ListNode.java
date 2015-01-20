package programcreek;

public class ListNode {
    private int val;
    private ListNode next;
    public ListNode(int x) {
        setVal(x);
        setNext(null);
    }
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}
 