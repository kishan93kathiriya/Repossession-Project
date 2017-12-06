package dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.QueryVO;

public class SearchByDAO {
	
	SessionFactory s=null;
	Session session=null;
	public void sessionBuild(){
		
			s =new Configuration().configure().buildSessionFactory();
			session = s.openSession();
		}
	
	public String status(int x)
	{
		String s=null;
		if(x==0)
		{
			s=" AND status='"+x+"'";
		}
		else if(x==1)
		{
			s=" AND status='"+x+"'";
			System.out.println("status 1"+x);
		}
		else
		{
			s="";
			System.out.println("status -1"+x);
		}
		return s;
	}
	
	public List searchbydate( String query)
	{
		sessionBuild();
		
		Query q = session.createQuery(query);
		QueryVO v=new QueryVO();
		v.setQuery(query);
		
		
		
		List list =q.list();
		return list;
	}
	public List searchbybank(String query)
	{
		sessionBuild();
		
		Query q = session.createQuery(query);
		
		QueryVO v=new QueryVO();
		v.setQuery(query);
		
		
		List list =q.list();
		System.out.println("List size ==================== "+list.size());
		return list;
	}
	public List searchbyboth(String query)
	{
		sessionBuild();
		Query q = session.createQuery(query);
		
		QueryVO v=new QueryVO();
		v.setQuery(query);
		
		
		List list =q.list();
		return list;
	}
	

}
