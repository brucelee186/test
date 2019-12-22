package 测试;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashMapHashTable {
	public static void main(String[] args) {
		// 因为HashMap允许一个空键,多个空值,所以泛型必须为对象类型,不可使用基本类型int
		// HashMap<int, int> hashMap = new HashMap<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(null, null);
		hashMap.put(null, 2);
		hashMap.put(2, 2);
		hashMap.put(3, null);
		System.err.println(hashMap.get(null));
		System.err.println(hashMap.get(2));
		System.err.println(hashMap.get(3));
		
		// Hashtable不允许null键,可以设置键,但取值时会异常,
		// 不允许null键,可以设置,取值是异常
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		// hashtable.put(null, null);
		// hashtable.put(1, null);
		// System.err.println(hashtable.get(null));
		System.err.println(hashtable.get(1));
	}
}