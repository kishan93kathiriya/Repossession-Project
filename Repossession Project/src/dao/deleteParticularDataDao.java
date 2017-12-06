package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class deleteParticularDataDao {

	public void deleteByBank(String bankName){
		SessionFactory s=new Configuration().configure().buildSessionFactory();
		Session session=s.openSession();
		Transaction tr= session.beginTransaction();
		
		String hql = "DELETE FROM list_vehicles where bank='"+bankName+"'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		tr.commit();
		
	}
	public void deleteByBoth(String bankName, String date){
		SessionFactory s=new Configuration().configure().buildSessionFactory();
		Session session=s.openSession();
		Transaction tr= session.beginTransaction();
		
		String hql = "DELETE FROM list_vehicles where bank='"+bankName+"' and date='"+date+"'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		tr.commit();
		
	}
	
	
}
