package LogicMonitor;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Milind
 *
 * @Problem: Design and implement a data structure for Least Recently Used (LRU)
 *           cache. It should support the following operations: get and set.
 * 
 *           get(key) - Get the value (will always be positive) of the key if
 *           the key exists in the cache, otherwise return -1.
 * 
 *           set(key, value) - Set or insert the value if the key is not already
 *           present. When the cache reached its capacity, it should invalidate
 *           the least recently used item before inserting a new item.
 * 
 * @Solution: http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * 
 *            The key to solve this problem is using a double linked list which
 *            enables us to quickly move nodes. The LRU cache is a hash table of
 *            keys and double linked nodes. The hash table makes the time of
 *            get() to be O(1). The list of double linked nodes make the nodes
 *            adding/removal operations O(1).
 *
 */

public class LRUCacheJava {
	int capacity;
	HashMap<Integer, LRUNode> map = new HashMap<Integer, LRUNode>();
	LRUNode head = null;
	LRUNode end = null;

	public LRUCacheJava(int capacity) {
		this.capacity = capacity;
	}

	public void setHead(LRUNode n) {
		n.next = head;
		n.pre = null;

		if (head != null) {
			head.pre = n;
		}
		head = n;

		if (end == null) {
			end = head;
		}
	}

	public void remove(LRUNode n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else { // n is currently head
			head = n.next;
			head.pre = null;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else { // n is currently end
			end = n.pre;
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			LRUNode n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;

	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			LRUNode old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			LRUNode created = new LRUNode(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);
			} else {
				setHead(created);
			}
			map.put(key, created);
		}
	}

	public Set<Entry<Integer, LRUNode>> entrySet() {
		return map.entrySet();
	}

	public void printLRUCache() {
		LRUNode trav = this.head;
		while (trav != null) {
			System.out.print(trav.value + " ");
			trav = trav.next;
		}
	}

	public static void main(String[] args) {
		LRUCacheJava cache = new LRUCacheJava(5);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		cache.printLRUCache();
		System.out.println();
		cache.set(5, 5);
		cache.printLRUCache();
		System.out.println();
		cache.set(11, 11);
		cache.printLRUCache();
		System.out.println();
		cache.set(3, 3);
		cache.printLRUCache();
	}
}
