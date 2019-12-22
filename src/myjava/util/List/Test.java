package myjava.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("aaa");
		v.add("bbb");
		v.add("ccc");
		v.add("ddd");
		System.err.println("原始输出方式 开始");
		for (int i = 0; i < v.size(); i++) {
			System.err.println(v.get(i));
		}
		System.err.println("原始输出方式 结束");
		System.err.println("增加输出方式 开始");
		for (String vString : v) {
			System.err.println(vString);
		}
		System.err.println("增强输出方式 开始");
		System.err.println("转换成数组输出方式 开始");
		for (int i = 0; i < v.size(); i++) {
			System.err.println(v.toArray()[i]);
		}
		System.err.println("转换成数组输出方式 结束");
		System.err.println("使用遍历器遍历 开始");
		Iterator<String> iterator = v.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.err.println(string);
		}
		System.err.println("使用遍历器遍历 结束");
		System.err.println("使用原始遍历器遍历 开始");
		for (Enumeration<String> emu = v.elements(); emu.hasMoreElements();) {
			System.err.println(emu.nextElement());
		}
		System.err.println("使用原始遍历器遍历 结束");
		
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("bbb");
		arrayList.add("ddd");
		arrayList.add("aaa");
		arrayList.add("fff");
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("ggg");
		linkedList.add("ccc");
		linkedList.add("eee");
		arrayList.addAll(linkedList);
		//重新排序
		Collections.sort(arrayList);
		//交换位置
		//Collections.swap(arrayList, 0, 1);
		System.err.println("jdk5.0后的遍历方式 开始");
		for (Iterator<String> iList = arrayList.iterator(); iList.hasNext();) {
			System.err.println(iList.next());
		}
		
		System.err.println("jdk5.0后的遍历方式 结束");
		System.err.println("jdk5.0后的反向遍历方式 开始");
		for (ListIterator<String> string = arrayList.listIterator(arrayList.size()); string.hasPrevious();) {
			System.err.println(string.previous());
		}
		System.err.println("jdk5.0后的反向遍历方式 结束");
	}
}
