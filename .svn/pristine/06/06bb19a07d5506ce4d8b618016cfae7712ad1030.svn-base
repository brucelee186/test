package 继承;

public class Child extends Father {
	public Child() {
		System.err.println("I'm the child");
	}
	
	public void print() {
		System.err.println("this is a test child");
	}
	public static void main(String[] args) {
		//他会先调用父类构造生成一个对象,再调子类构造生成另一个对象,然后全并两个对象
		//结果:I'm the father
		//    I'm the child
		//Father f = new Child();
		//结果:I'm the father
		//Father f = new Father();
		//father类型最大
		Father f = new Child();
		f.print();
		//结果:father
		System.err.println(f.getName());
	}
}
