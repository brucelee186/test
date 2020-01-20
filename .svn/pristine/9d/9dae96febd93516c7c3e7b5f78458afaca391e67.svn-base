package 常见问题测试;

class Bean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
public class 传参 {
	public static void main(String[] args) {
		System.err.println("******************************* StringBuffer");
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		int i = 5;
		operate(a, b, i);
		System.out.println(a + "," + b + "," + i);
		
		System.err.println("******************************* String");
		String c = new String("A");
		String d = new String("B");
		operate(a, b, i);
		System.out.println(c + "," + d + "," + i);
		
		System.err.println("******************************* Bean");
		// 只要bean要操作过程中地址不改变,操作过程中的赋值就有效
		Bean bean = new Bean();
		operateBean(bean);
		System.err.println(bean.getName());
	}

	// 参数传递只有在引用地址变更的情况下才会变更原始参数值,否则传递的只是附本,不会改变原始参数值
	// 只要地址改变就会对地址变更的新对象做操作,而不会改变原地址的对象
	public static void operate(StringBuffer x, StringBuffer y, int j) {
		// 分配两个变量引用x,y他们和a与b一样都指向一个对象xa指向A,yb指向B
		// x = AB
		// a = AB
		x.append(y);
		System.err.println(x);
		System.err.println(y);
		// y = AB
		// y与x一样指向同一个地原始地址a,同时y地址变更,此时的y已经不指向b了所以,对y操作不会影响到b
		// 但是y与x的地址一样,对y操作会影响到x,所以y.append("C");造成 x = "ABC";
		y = x;
		// y = ABC
		
		y.append("C");
		j = 1;
	}
	
	// 参数传递只有在引用地址变更的情况下才会变更原始参数值,否则传递的只是附本,不会改变原始参数值
	public static void operate(String x, String y, int j) {
		// x = AB
		x = x + y;
		y = x;
		// y = AB
		// y = x;
		// y = ABC
		//y.append("C");
		j = 1;
	}
	
	public static Bean operateBean(Bean bean) {
		// 如果在操作过种中,新建Bean,那么操作的Bean地址发生改变,原始Bean将不会被赋值
		// bean = new Bean();
		bean.setName("test");
		return bean;
	}
}
