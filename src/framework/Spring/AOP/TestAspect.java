package framework.Spring.AOP;

import org.aspectj.lang.JoinPoint;

public class TestAspect {
	public void doAfter(JoinPoint jp) {
		System.err.println("doAfter");
	}
	
	public void doBefore(JoinPoint jp) {
		System.err.println("doBefore");
	}
	
	public void doAround(JoinPoint jp) {
		System.err.println("doAround");
	}
	
	public void doThrowing(JoinPoint jp) {
		System.err.println("doThrowing");
	}
}
