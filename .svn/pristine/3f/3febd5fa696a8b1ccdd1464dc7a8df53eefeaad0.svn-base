package 构造器;

//有重写父类方法的作用,括号体中为重写的方法,注,此方法父类中必须存在,且参数相同
public class test {

	public static void main(String[] args) {

		System.err.println(main1());
	}
	
	public static String main1() {
		Student st = new Student(){
		protected String getString(String name){
			String msg = name + ": I'm OK";
			return msg;
		}
	};
		return st.getString("Taddy");
	}
}
