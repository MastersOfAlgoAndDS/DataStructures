package companies.LogicMonitor;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author Milind
 *
 * @param <K>
 * @param <V>
 * 
 * @Problem: http://chriswu.me/blog/a-lru-cache-in-10-lines-of-java/
 * 
 *           A LRU Cache in 10 Lines of Java
 * 
 * @Solution: Last Recently Used Cache Eviction To accomplish cache eviction we
 *            need to be easily able to:
 * 
 *            * Query the last recently used item
 * 
 *            * mark an item as the most recently used item
 * 
 *            A linked list allows for both operations. Checking for the least
 *            recently used item can just return the tail. Marking an item as
 *            recently used can be simply removing it from its current position
 *            and moving it to the head. The missing puzzle piece is finding
 *            this item in the linked list quickly.
 * 
 *            Java already provides this for us in the form of a LinkedHashMap!
 *            It even provides an overridable eviction policy method
 *            (removeEldestEntry). The only catch is that by default the linked
 *            list order is the insertion order, not access. However one of the
 *            constructor exposes an option use the access order instead.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cacheSize;

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public LRUCache(int cacheSize) {
		super(cacheSize, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		return size() >= cacheSize;
	}

	@Override
	public String toString() {
		return "LRUCache [cacheSize=" + cacheSize + "]";
	}

	public static void main(String[] args) {
		LRUCache<Integer, Integer> cache = new LRUCache<>(5);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		for (Entry<Integer, Integer> entry : cache.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();
		cache.put(5, 5);
		for (Entry<Integer, Integer> entry : cache.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();
		cache.put(1, 1);
		for (Entry<Integer, Integer> entry : cache.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();
		cache.put(4, 4);
		for (Entry<Integer, Integer> entry : cache.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
