package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test1 {
	
}

/*
 * 注解接口,包含两个属性,id和描述
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationUser {
	public String id();
	public String description() default "no description";
}


/*
 * 注解类的实现类,引用了自定义注解AnnotationUser,并做了实现,从此全部类都相当于继承了这个类,每次做操作都会调用注解实现类
 */
class PasswordUtil {
	@AnnotationUser(id="47",description="yeah!!")
	public boolean validateUser(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@AnnotationUser(id="48")
	public String encript(String password) {
		return new StringBuffer(password).reverse().toString();
	}
}

public class Test {
	@Deprecated
	public Test() {
	}
	
	public static void main(String[] args) {
		List<Integer> userList = new ArrayList<>();
		Collections.addAll(userList, 47, 48, 49, 50);
		for (Method method1 : PasswordUtil.class.getDeclaredMethods()) {
			AnnotationUser annotationUser = method1.getAnnotation(AnnotationUser.class);
			if (annotationUser != null) {
				System.err.println("Found user annotation: " + annotationUser.id() + " " + annotationUser.description());
				userList.remove(Integer.valueOf(annotationUser.id()));
			}
		}
		for (int userId:userList) {
			System.err.println(userId);
		}
	}
	

}