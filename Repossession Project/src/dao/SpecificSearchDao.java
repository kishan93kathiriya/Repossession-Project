package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SpecificSearchDao {


	public List search(String ss){
		
		List ls=new ArrayList();
		try
		{
			SessionFactory s =new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			String query="from list_vehicles WHERE "+ss;
			System.out.println(query);
			Query q=session.createQuery(query);
			System.out.println("exit");
			ls=q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ls;
	}

	public List searchInvoice(String ss){
		
		List ls=new ArrayList();
		try
		{
			SessionFactory s =new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			String query="from BillList WHERE "+ss;
			System.out.println(query);
			Query q=session.createQuery(query);
			System.out.println("exit");
			ls=q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ls;
	}
	
	
}
