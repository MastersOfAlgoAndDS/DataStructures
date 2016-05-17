package ctci_5E;

import java.util.Stack;

/**
 * @Problem: In the classic problem of the Towers of Hanoi, you have 3 towers
 *           and N disks of different sizes which can slide onto any tower. The
 *           puzzle starts with disks sorted in ascending order of size from top
 *           to bottom (i.e., each disk sits on top of an even larger one). You
 *           have the following constraints:
 * 
 *           (1) Only one disk can be moved at a time. (2) A disk is slid off
 *           the top of one tower onto the next rod. (3) A disk can only be
 *           placed on top of a larger disk. Write a program to move the disks
 *           from the first tower to the last using Stacks.
 * 
 * @author Milind
 *
 */
public class P3_4_TowerOfHanoi {
	private Stack<Integer> tower;
	private int towerNum;

	public P3_4_TowerOfHanoi(int towerNum) {
		this.towerNum = towerNum;
		this.tower = new Stack<Integer>();
	}

	public Stack<Integer> getTower() {
		return tower;
	}

	public int getTowerNum() {
		return towerNum;
	}

	public void setTowerNum(int towerNum) {
		this.towerNum = towerNum;
	}

	public void moveDisks(int n, P3_4_TowerOfHanoi destination,
			P3_4_TowerOfHanoi buffer) {
		if (n == 1) {
			int top = getTower().pop();
			destination.getTower().push(top);
			System.out.println(">>> Moving  disk-" + top + " from "
					+ getTowerNum() + " to " + destination.getTowerNum());
		} else {
			moveDisks(n - 1, buffer, destination);
			int top = getTower().pop();
			destination.getTower().push(top); // move top to
												// destination
			System.out.println(">>> Moving  disk-" + top + " from "
					+ getTowerNum() + " to " + destination.getTowerNum());
			// Now buffer is source for the remaining part so current tower
			// becomes buffer
			buffer.moveDisks(n - 1, destination, this);
		}
	}

	@Override
	public String toString() {
		return "P3_4_TowerOfHanoi [tower=" + tower + ", towerNum=" + towerNum
				+ "]";
	}

	public static void main(String[] args) {
		P3_4_TowerOfHanoi[] towers = new P3_4_TowerOfHanoi[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new P3_4_TowerOfHanoi(i);
		}
		int towerSize = 3;
		for (int j = towerSize; j > 0; j--)
			towers[0].getTower().push(j);
		System.out.println("======== Before moving");
		for (P3_4_TowerOfHanoi p3_4_TowerOfHanoi : towers) {
			System.out.println(p3_4_TowerOfHanoi);
		}
		towers[0].moveDisks(towerSize, towers[1], towers[2]);
		System.out.println("======== After moving");
		for (P3_4_TowerOfHanoi p3_4_TowerOfHanoi : towers) {
			System.out.println(p3_4_TowerOfHanoi);
		}
	}
}
