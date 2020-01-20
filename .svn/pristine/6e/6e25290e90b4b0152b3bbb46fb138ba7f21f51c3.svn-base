package 多态;

public class Baby  extends Father{

	@Override
	public void talk() {
		System.err.println("i'm a baby");
	}
	
	public static void main(String[] args) {
		Father t = new Baby();
		Baby b = new Baby();
		Father f = new Father();
//		Father f1 = (Father)b;
		Father f1 = (Father)new Baby();
		//t.talk();
		f1.talk();
		//b.talk();
	}
}
