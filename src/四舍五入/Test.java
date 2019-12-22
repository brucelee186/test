package 四舍五入;

public class Test {
	public static void main(String[] args) {
		//去掉小数点前两位,并四舍五入
		Long d = Math.round(1.55);
		System.err.println(d);
		double   ret = convert(3.14159);   
	       System.out.println(ret);   
	}
	
	static double convert(double value)
	   {   
	       long l1 = Math.round(value*100);    //四舍五入   
	       double ret = l1/100.0;              //注意：使用100.0而不是100   
	       return ret;   
	   }   
}
