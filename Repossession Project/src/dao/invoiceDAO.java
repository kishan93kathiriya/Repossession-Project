package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BillList;

public class invoiceDAO {

	public List insert(BillList b){
		
				List ls=new ArrayList();
				try
				{
					SessionFactory s =new Configuration().configure().buildSessionFactory();
					Session session = s.openSession();
					Transaction t= session.beginTransaction();
						
					  session.save(b);
					  
					  t.commit();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return ls;
			}
	public List searchInvoice(){
				
				List ls=new ArrayList();
				try
				{
					SessionFactory s =new Configuration().configure().buildSessionFactory();
					Session session = s.openSession();
				
					Query q=session.createQuery("from BillList");
					
					ls=q.list();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return ls;
	}
}
