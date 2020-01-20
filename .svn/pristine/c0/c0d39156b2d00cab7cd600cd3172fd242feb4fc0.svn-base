package framework.hibernate.compoment;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	/*
	 * 组件compoment相当于继承映射,本类user使用了一个类(组件)Name,name中包含了firstname和lastname,这时生成的表结构会包含的不只是name列,而name
	 * id,组件对应的firstName和lastName,birthday四列
	 */
	public static void main(String[] args) {
		Session session = new Configuration() .configure("/framework/hibernate/compoment/hiberante.cfg.xml") .buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		Name name = new Name();
		name.setFirstName("yin");
		name.setLastName("neo");
		user.setName(name);
		user.setBirthday(new Date());
		session.save(user);
		transaction.commit();
		session.close();
	}
}
