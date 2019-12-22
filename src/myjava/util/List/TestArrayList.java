package myjava.util.List;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		boolean test = arrayList.add(80);
		System.err.println(test);
	}
}

