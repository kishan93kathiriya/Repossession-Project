package dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;


import vo.LoginVo;

public class EmployeeUpdateDao {

	public void update(LoginVo v)
	{
		
		try
		{
		SessionFactory s=new Configuration().configure().buildSessionFactory();
		Session session= s.openSession();
		Transaction tr= session.beginTransaction();
		System.out.println("UPDATE employeevo WHERE reg_No ='"+v.getId()+"'");
		Query q = 	session.createQuery("UPDATE employeevo set name='"+v.getName()+"',username='"+v.getUn()+"',password='"+v.getPw()+"' WHERE id ='"+v.getId()+"'");
		System.out.println("Transaction Done!");
		q.executeUpdate();
		tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
