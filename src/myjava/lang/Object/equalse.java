package myjava.lang.Object;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Student extends Object{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}

class Student1 extends Object{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		Student1 s = (Student1)obj;
		String name = s.getName();
		int age = s.getAge();
		return age == this.age && name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return age*name.hashCode();
	}
}

public class equalse {
	public static void main(String[] args) {
		// hashCode
		// 新增集合对象时,本对象会自动生成一个唯一编码,先去查询唯一编码对应的元素是否存在,如果不存在,那么分配内存单元,生成新对象,如果存在,比较元素是否相同,如果相同,那么不存这个元素,直接把新地址指向这个元素,所以在内在中可能存在这样的对象,他们的地址不同,但却指向同一个相同的对象,如果不同,重新生成hashCode并分配对象
		// 为了提高对象比对效率,每次增加新对象时先查询一下本对象的唯一编号是否在对象集合中存在,如果存在更新对象,不存在
		// 因为hashCode生成规则不同,只能相对的保证hashCode不重复,实际上在极端的情况下,hashCode是很有可能重复的,因为hashCode只是一个生成唯一
		// 码的方式,而并没有去真正遍历每一个集合中的元素,所以hashCode相同并不一定无素会相同,而hashcode相同,无素一定相同,要不然equals方法就无效了
		String s1 = new String("test");
		String s2 = new String("test");
		System.err.println("s1 == s2" + s1 == s2);
		System.err.println("s1.equals(s2)" + s1.equals(s2));
		System.err.println("s1.hashCode()" + s1.hashCode());
		System.err.println("s2.hashCode()" + s2.hashCode());
		Set<String> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		Iterator<String> i = set.iterator();
		while(i.hasNext()){
			System.err.println(i.next());;
		}
		HashSet<Student> hashSet = new HashSet<>();
		hashSet.add(new Student("tom", 11));
		hashSet.add(new Student("tom", 11));
		hashSet.add(new Student("neo", 22));
		hashSet.add(new Student("palu", 12));
		Iterator<Student> i1 = hashSet.iterator();
		while (i1.hasNext()) {
			System.err.println(i1.next().getName());
		}
		
		System.err.println("equals rewrite");
		HashSet<Student1> hashSet1 = new HashSet<>();
		hashSet1.add(new Student1("tom", 11));
		hashSet1.add(new Student1("tom", 11));
		hashSet1.add(new Student1("neo", 22));
		hashSet1.add(new Student1("palu", 12));
		Iterator<Student1> i2 = hashSet1.iterator();
		while (i2.hasNext()) {
			System.err.println(i2.next().getName());
		}
	}
}
