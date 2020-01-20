package myjava.util.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * HashMap和Hashtable的区别。 
 * @author hp
 *
 */
public class DifferentHashMapAndHashTable {
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "tom");
		hashMap.put(2, null);
		hashMap.put(null, null);
		// hashTable不允许有空值,hashTable要比hashMap慢,因为他是线程同步的,它同一时刻只允许一个方法执行,所以慢,而且它有排序方法
		Map<Integer, String> hashTable = new Hashtable<>();
		hashTable.put(1, "tom");
		hashTable.put(1, "tom");
		hashTable.put(3, "jim");
		hashTable.put(4, "neo");
		System.err.println(hashMap);
		System.err.println(hashTable);
	}
}
