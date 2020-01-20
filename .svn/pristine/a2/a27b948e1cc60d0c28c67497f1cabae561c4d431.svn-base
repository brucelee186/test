package framework.hibernate.one2one.sharePrimaryKey;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tool.CharacterRadom;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName(CharacterRadom.getCharacterRadom());
		IdCard i = new IdCard();
		i.setAuthorizeDate(new Date());
		p.setIdCard(i);
		i.setPerson(p);
		insert(p, i);
		select(p, i);
	}
	
	// 主从表方式,主表与从表共用一个编号
	private static void select(Person p, IdCard i) {
		Session s = new Configuration().configure("framework/hibernate/one2one/sharePrimaryKey/hiberante.cfg.xml").buildSessionFactory().openSession();
		int idPerson = p.getId();
		int idCard1 = i.getId();
		// 先查询从属对象时查询不会关联主对象,而直接查询主对象时会left join从对象,而且如果先查询了主对象,再查从对象时,从对象并不会触发查询,因为在主对象中已经查询过了
		IdCard idCard2 = (IdCard) s.get(IdCard.class, idCard1);
//		Person p1 = (Person) s.get(Person.class, idPerson);
//		System.err.println(p1.getIdCard().getAuthorizeDate());
//		System.err.println("Person id: " + p1.getId() + " name: " + p1.getName());
		System.err.println("IdCard.id : " + idCard2.getId() + " IdCard.AuthorizeDate : " + idCard2.getAuthorizeDate());
		s.close();

	}
	private static void insert(Person p, IdCard i) {
//		Configuration config = new Configuration().addResource("framework/hibernate/one2one/hiberante.cfg.xml");
		// config.configure();表示默认加载src下的hibernate.cfg.xml文件
		//config.configure();
		// 共享主键方式
		Configuration config = new Configuration();
		config.configure("framework/hibernate/one2one/sharePrimaryKey/hiberante.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(p);
		s.save(i);
		t.commit();
		s.close();
	}
}
