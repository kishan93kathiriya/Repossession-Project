package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.agencies;
import vo.employee_vehicle;
import vo.list_vehicles;
public class agenciesDao {

		SessionFactory s=null;
		Session session=null;
		public void sessionBuild(){
			
			System.out.println("In SessionBuildddddddddd");
			s =new Configuration().configure().buildSessionFactory();
			session = s.openSession();
		}
	
public void insert(agencies v)
	{
		try
		{
		
			System.out.println("in db");
			sessionBuild();
			Transaction tr= (Transaction) session.beginTransaction();
			session.save(v);
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public List search(agencies v)
	{
		List ls=new ArrayList<agencies>();
		try
		{
		
		System.out.println("in search");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","poniyaag_bank","abcd12345");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from agencies");
		
		System.out.println("hello");
		
		while(rs.next())
		{
			agencies v1=new agencies();
			
			v1.setA_name(rs.getString("Name"));
			v1.setU_name(rs.getString("User_Name"));
			v1.setP_name(rs.getString("Password"));
			ls.add(v1);
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	public List search12(list_vehicles v)
	{
		List ls=new ArrayList<list_vehicles>();
		try
		{
		
		System.out.println("in search");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","poniyaag_bank","abcd12345");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from list_vehicles ORDER BY `Reg_No` ASC");
		
		while(rs.next())
		{
			list_vehicles v1=new list_vehicles();
			v1.setReg_No(rs.getString("Reg_No"));
			
			ls.add(v1);
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	
	
	public List search1(employee_vehicle v)
	{
		List ls=new ArrayList<employee_vehicle>();
		try
		{
		
			System.out.println("in search");
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","poniyaag_bank","abcd12345");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from list_vehicles ORDER BY `Reg_No` ASC");
			
			
			
			while(rs.next())
			{
				String main=rs.getString("Reg_No");
				System.out.print(main+" ");
				String s1,s2,s3,s4,s5,s6;
				
				if(main.equals(""))
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
					
					System.out.println(s1+"--- "+s5+" "+s6);
					
					employee_vehicle v1=new employee_vehicle();
					v1.setFirst2(s1);
					v1.setMiddle2(s5);
					v1.setLast4(s6);
					ls.add(v1);
					
					System.out.println(v1.getFirst2()+" "+v1.getMiddle2()+" "+v1.getLast4());
				}
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	
	
	
	public List searchall(list_vehicles v)
	{
		List ls=new ArrayList<list_vehicles>();
		try
		{
		
		System.out.println("in search");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","poniyaag_bank","abcd12345");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from list_vehicles");
		
		while(rs.next())
		{
			list_vehicles v1=new list_vehicles();
			v1.setLoanNo(rs.getString("Loan No"));
			v1.setCustomerName(rs.getString("Customer Name"));
			v1.setModel(rs.getString("Model"));
			v1.setChasis_No(rs.getString("Chasis_No"));
			v1.setEngine_No(rs.getString("Engine_No"));
			v1.setContact(rs.getString("Contact"));
			v1.setReg_No(rs.getString("Reg_No"));
			v1.setStatus("remaining");
			
			ls.add(v1);
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	public List busted_list(list_vehicles v)
	{
		List ls=new ArrayList<list_vehicles>();
		try
		{
		
		System.out.println("in search");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","poniyaag_bank","abcd12345");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from list_busted");
		
		while(rs.next())
		{
			list_vehicles v1=new list_vehicles();
			v1.setLoanNo(rs.getString("Loan No"));
			v1.setCustomerName(rs.getString("Customer Name"));
			v1.setModel(rs.getString("Model"));
			v1.setChasis_No(rs.getString("Chasis_No"));
			v1.setEngine_No(rs.getString("Engine_No"));
			v1.setContact(rs.getString("Contact"));
			v1.setReg_No(rs.getString("Reg_No"));
			v1.setStatus("busted");
			
			
			ls.add(v1);
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
}
