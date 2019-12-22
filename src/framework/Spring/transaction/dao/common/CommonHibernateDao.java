package framework.Spring.transaction.dao.common;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CommonHibernateDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	public void closeSession(Session session) {
		if (null != session && session.isOpen()) {
			session.close();
		}
	}
	
	public List<?> searchByHql(String hql) {
		List<?> list = null;
		Session session = null;
		try {
			session = this.openSession();
			list = session.createQuery(hql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public List<?> searchBySql(String sql) {
		List<?> list = null;
		Session session = null;
		try {
			session = this.openSession();
			list = session.createSQLQuery(sql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(null != session && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public boolean save(Object object) {
		boolean result = true;
		Session session = null;
		try {
			session = this.openSession();
			session.save(object);
			session.flush();
		} catch (HibernateException e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
	
	public boolean update(Object object) {
		boolean result = true;
		Session session = null;
		try {
			session = this.openSession();
			session.update(object);
			session.flush();
		} catch (HibernateException e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
	
	public boolean saveOrUpdate(Object object) {
		boolean result = true;
		Session session = null;
		try {
			session = this.openSession();
			session.saveOrUpdate(object);
			session.flush();
		} catch (HibernateException e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
	
	public boolean delete(Object object) {
		boolean result = true;
		Session session = null;
		try {
			session = this.openSession();
			session.delete(object);
			session.flush();
		} catch (HibernateException e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
}
