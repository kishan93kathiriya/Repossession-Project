package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.LoginVo;
import vo.employee_vehicle;
import vo.list_vehicles;
import vo.caught_vehicles;
import vo.employeevo;;
public class datasheetdao {
	
	public List search(int x){
		
		List ls=new ArrayList();
		try
		{
			SessionFactory s =new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
		
			Query q=session.createQuery("from list_vehicles WHERE status='0'").setFirstResult(100*x).setMaxResults(100);
			System.out.println("exit");
			ls=q.list();
			System.out.println("hehe List size ="+ls.size());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ls;
	}


public List searchreg()
{
	
		int n=10000;
		String x=null;
		String y=null;
		List<String> list=new ArrayList<String>();
		List ls=new ArrayList();
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from list_vehicles where status=0 ORDER BY `Reg_No` ASC");
			String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null;
			
			int i=0;
			while(rs.next())
			{
				System.out.println("in Resultset 4");
				String main=rs.getString("Reg_No");
				main=main.replace("-", "");
				main=main.replace(" ", "");
				System.out.print(main+" ");
				
			
				System.out.println(main.length());
				if(main.length()==0 && main.substring(0,2).matches("[0-9]+") )
				{
					
				}
				else
				{
					s1=main.substring(0, 2);
					System.out.println(s1+"hello");
					if(main.substring(2, 4).matches("[0-9]+"))
					{
						s1=s1.concat(main.substring(2, 4));
						System.out.println(s1+"  ");
						
						if(!main.substring(4, 6).matches("[0-9]+"))
						{
							s2=s2.concat(main.substring(4, 6));
							System.out.println(s2+"  ");
							
							
							if(main.substring(6).length()==4)
							{
								s3=main.substring(6);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(6).length()==3)
							{
							s3.concat("0");
							s3=main.substring(6);
							System.out.println(s3+"  ");
							
							}
							else if(main.substring(6).length()==2)
							{
								s3.concat("00");
								s3=main.substring(6);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(6).length()==1)
							{
								s3.concat("000");
								s3=main.substring(6);
								System.out.println(s3+"  ");
								
							}
						}
						else
						{
							s2=s2.concat(main.substring(4, 5));
						
							if(main.substring(5).length()==4)
							{
								s3=main.substring(5);
								
							}
							else if(main.substring(5).length()==3)
							{
								s3.concat("0");
								
								s3=main.substring(5);
								
							}
							else if(main.substring(5).length()==2)
							{
								s3.concat("00");
								s3=main.substring(5);
								
							}
							else if(main.substring(5).length()==1)
							{
								s3.concat("000");
								s3=main.substring(5);
								
							}
						}
					}
					else
					{
						s1=s1.concat("0");
						s1=s1.concat(main.substring(2, 3));
						if(!main.substring(3,5).matches("[0-9]+"))
						{
							s2=main.substring(3,5);
							if(main.substring(5).length()==4)
							{
								s3=main.substring(5);
								
							}
							else if(main.substring(5).length()==3)
							{
								s3.concat("0");
								s3=main.substring(5);
								
							}
							else if(main.substring(5).length()==2)
							{
								s3.concat("00");
								s3=main.substring(5);
								
							}
							else if(main.substring(5).length()==1)
							{
								s3.concat("000");
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
						}
						else
						{
							s2=main.substring(3,4);
							System.out.println(s2+"  ");
							
							if(main.substring(4).length()==4)
							{
								s3=main.substring(4);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(4).length()==3)
							{
								s3.concat("0");
								s3=main.substring(4);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(4).length()==2)
							{
								s3.concat("00");
								s3=main.substring(4);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(4).length()==1)
							{
								s3.concat("000");
								s3=main.substring(4);
								System.out.println(s3+"  ");
								
							}
							
						}
					}
					
					
				System.out.println(s1+s2+s3);
					
					/*if(main.equals(""))
				{
					
				}
				else
				{
					s1=(String) main.subSequence(0, 4);
					s2=(String) main.substring(2);
					s3="";
					s4="";
					s5="";
					s6="";
									
					if(Character.isDigit( s2.charAt(0)))
					{
						s3=s2.substring(1);
						if(Character.isDigit( s3.charAt(0)))
						{
							s4=s3.substring(1);
						}
						if(Character.isAlphabetic( s3.charAt(0)))
						{
							s4=s3;
						}
						
					}
					else
					{
						s2=s2.substring(1);
						if(Character.isDigit( s2.charAt(0)))
						{
							s3=s2.substring(1);
							if(Character.isDigit( s3.charAt(0)))
							{
								s4=s3.substring(1);
							}
							if(Character.isAlphabetic( s3.charAt(0)))
							{
								s4=s3;
							}
							
						}
					}
					
					if(Character.isAlphabetic( s4.charAt(0)))
					{
						if(Character.isAlphabetic(s4.substring(1).charAt(0)))
						{
							s5=s4.substring(0,2);
							s6=s4.substring(2);
						}
						if(Character.isDigit( s4.substring(1).charAt(0)))
						{
							s5=s4.substring(0,1);
							s6=s4.substring(1);
						}
						
					}
					
					
					int l=s6.length();
					String l2=""+l;
					if(l2.equals("4"))
					{
						s6=s6;
					}
					if(l2.equals("3"))
					{
						s6="0"+s6;
					}
					if(l2.equals("2"))
					{
						s6="00"+s6;
					}
					if(l2.equals("1"))
					{
						s6="000"+s6;
					}
				*/

				if(s1.equals(x))
				{
					if(s2.equals(y))
					{
						System.out.println("hehe m addiinf");
						list.add(s3);
					}
					else
					{
						System.out.println("hehe m");
						list.add(s2);
						y=s2;
						list.add(s3);
					}
				}
				else
				{
					System.out.println("hehe");
					x=s1;
					y=s2;
					list.add(s1);
					list.add(s2);
					list.add(s3);
				}
				
			
				
				
				
				}
				
				//For Adding elements in list
					
					
				
				/*	System.out.println(s1+" "+s5+" "+s6);*/
					/*x[i][0]=s1;
					x[i][1]=s5;
					x[i][2]=s6;
							
					
					System.out.print("x["+i+"][0]="+x[i][0]);
					System.out.print("   x["+i+"][1]="+x[i][1]);
					System.out.println("  x["+i+"][2]="+x[i][2]);
	*/				/*employee_vehicle v1=new employee_vehicle();
					v1.setFirst2(s1);
					v1.setMiddle2(s5);
					v1.setLast4(s6);
					ls.add(v1);
					i++;
					System.out.println(v1.getFirst2()+" "+v1.getMiddle2()+" "+v1.getLast4());*/
				}
			
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return list;
	}
	
	public List search1(int x){
		
		System.out.println("search1");
		List ls=new ArrayList();
		try
		{
			SessionFactory s =new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			Query q=session.createQuery("from list_vehicles ").setFirstResult(100*x).setMaxResults(100);
			ls=q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	public List search22(int x){
		
		List ls=new ArrayList();
		try
		{
			SessionFactory s =new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
		System.out.print("asdasd");
			Query q=session.createQuery("from list_vehicles WHERE status='-1'").setFirstResult(100*x).setMaxResults(100);
			ls=q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}
	public List search2(int x){
	
	List ls=new ArrayList();
	try
	{
		SessionFactory s =new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
	System.out.print("asdasd");
		Query q=session.createQuery("from list_vehicles WHERE status='1'").setFirstResult(100*x).setMaxResults(100);
		ls=q.list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ls;
}
	public void update(list_vehicles v){
		System.out.println("6");
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			System.out.println("7");
			System.out.println("Update query fired with");
			Query q = 	session.createQuery("UPDATE list_vehicles set status =1 WHERE reg_No ='"+v.getReg_No()+"'");
			q.executeUpdate();
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void update_revert(list_vehicles v){
		System.out.println("6");
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			System.out.println("7");
			System.out.println("Update query fired with");
			Query q = 	session.createQuery("UPDATE list_vehicles set status =0 WHERE reg_No ='"+v.getReg_No()+"'");
			q.executeUpdate();
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void caught_delete(list_vehicles v){
		System.out.println("6");
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			System.out.println("7");
			System.out.println("Update query fired with");
			Query q = 	session.createQuery("UPDATE list_vehicles set status =-1 WHERE reg_No ='"+v.getReg_No()+"'");
			q.executeUpdate();
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void delete_previous(String bankName){
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			System.out.println("Update query fired with");
			Query q =session.createQuery("delete list_vehicles WHERE bank ='"+bankName+"'");
			q.executeUpdate();
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
public void insert(caught_vehicles v){
	try
	{
	SessionFactory s =new Configuration().configure().buildSessionFactory();
	Session session = s.openSession();
	Transaction tr = session.beginTransaction();
	session.save(v);
	tr.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
public void insertclient(employeevo v){
	try
	{
	SessionFactory s =new Configuration().configure().buildSessionFactory();
	Session session = s.openSession();
	Transaction tr = session.beginTransaction();
	session.save(v);
	tr.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
public List searchclient(){
	
	List ls=new ArrayList();
	try
	{
		SessionFactory s =new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
	
		Query q=session.createQuery("from LoginVo WHERE user_type='client'");
		ls=q.list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ls;
}
public int getFileId(String name){
	
	List ls=new ArrayList();
	int id = 0;
	try
	{
		SessionFactory s =new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
	
		Query q=session.createQuery("select attachmentMappingID from AttachmentMappingVO WHERE path='"+name+"'");
		ls=q.list();
		id=(int) ls.get(0);
		System.out.println("Id is ="+id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return id;
}

public void change_auth(LoginVo v)
{
	try
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("Update query fired with");
		Query q = 	session.createQuery("UPDATE LoginVo set authent='"+v.getAuthent()+"' WHERE id='"+v.getId()+"'");
		q.executeUpdate();
		tr.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void delete_client(int id)
{
	System.out.println("in delete");
	try
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("Update query fired with");
		Query q = 	session.createQuery("delete LoginVo WHERE id='"+id+"'");
		q.executeUpdate();
		tr.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public List edit(LoginVo v){
	
	List ls=new ArrayList();
	try
	{
		SessionFactory s =new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
	
		Query q=session.createQuery("from LoginVo WHERE id='"+v.getId()+"'");
		ls=q.list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ls;
}
}
