package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDataDao {

	public void delete(){
		SessionFactory s=new Configuration().configure().buildSessionFactory();
		Session session=s.openSession();
		Transaction tr= session.beginTransaction();
		
	String hql = "DELETE FROM list_vehicles where status='0'";
	Query query = session.createQuery(hql);
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
	tr.commit();
	}
	
}
