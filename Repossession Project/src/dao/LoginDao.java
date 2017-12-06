package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.LoginVo;
import vo.agencies;
import vo.chatvo;
import vo.impot;
import vo.list_vehicles;

public class LoginDao {
	static int x=0;
	SessionFactory s=null;
	Session session=null;
	public void sessionBuild(){
		
			System.out.println("In SessionBuildddddddddd");
			s =new Configuration().configure().buildSessionFactory();
			session = s.openSession();
			System.out.println("out session");
		}
	
public List authentication(LoginVo mtv){
		
		
			sessionBuild();
			Query q = session.createQuery("from LoginVo where un='"+mtv.getUn()+"' and pw='"+mtv.getPw()+"'");
			
			// select * from master_tabel where un=? and pw=? 
			
			List list =q.list();
			return list;

	}

public List searchEmail(LoginVo mtv){
	

	sessionBuild();
	
	Query q = session.createQuery("from MasterTableVO where user_email_id='"+mtv.getUn()+"'");

	List list =q.list();
	
	return list;
	}
	
	public List search(LoginVo v)
	{
		
		List ls=new ArrayList<LoginVo>();
		
		
		sessionBuild();
		Query q=session.createQuery("from LoginVo");
		List list=q.list();
		System.out.println("hello this is search dao");
		
		return list;
	}
	
	public List search1(agencies v)
	{
		List ls=new ArrayList<agencies>();
		try
		{
		
		System.out.println("in search");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from agencies where User_Name='"+v.getU_name()+"'");
		
		System.out.println("hello");
		
		while(rs.next())
		{
			agencies v1=new agencies();
			
			v1.setA_name(rs.getString("Name"));
			v1.setU_name(rs.getString("User_Name"));
			v1.setP_name(rs.getString("Password"));
			
			/*System.out.println(" Un:"+rs.getString("un")+" PW:"+rs.getString("pw")+" Name:"+rs.getString("name"));*/
			ls.add(v1);
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	
	
	public void insert(String v)
	{
		try {
			System.out.println("------------in-----------");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
			Statement st=con.createStatement();
			System.out.println(v);
			st.executeQuery(v);
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void transfer1(list_vehicles v)
	{
			sessionBuild();
			Query query=session.createQuery("from list_vehicles where Reg_No='"+v.getReg_No()+"'");
			List list=query.list();
			
			Query q=session.createQuery("insert into list_busted(Loan No,Customer Name,Reg_No,Model,Chasis_No,Engine_No,Contact) values('"+v.getLoanNo()+"','"+v.getCustomerName()+"','"+v.getReg_No()+"','"+v.getModel()+"','"+v.getChasis_No()+"','"+v.getEngine_No()+"','"+v.getContact()+"')");
		
			session.delete(v);
				
	}
	
	public void transfer2(list_vehicles v)
	{
		ArrayList ls=new ArrayList<list_vehicles>();
		try {
			System.out.println("------------in-----------");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
			Statement st=con.createStatement();
			System.out.println("----------"+v.getReg_No());
			ResultSet rs=st.executeQuery("select * from list_busted where Reg_No='"+v.getReg_No()+"'");
			
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
				ls.add(v1);
				
				Statement st1=con.createStatement();
				st1.executeUpdate("insert into list_busted(Loan No,Customer Name,Reg_No,Model,Chasis_No,Engine_No,Contact) values('"+v.getLoanNo()+"','"+v.getCustomerName()+"','"+v.getReg_No()+"','"+v.getModel()+"','"+v.getChasis_No()+"','"+v.getEngine_No()+"','"+v.getContact()+"')");
				Statement st2=con.createStatement();
				st2.executeUpdate("DELETE FROM list_busted WHERE Reg_No='"+v1.getReg_No()+"'");
				
			}
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert_msg(chatvo v)
	{
			
			Transaction tr=session.beginTransaction();
			try
			{
				session.save(v);
				tr.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}
	
	public List serch_msg(chatvo v)
	{

		sessionBuild();
		Query q=session.createQuery("from chat order by Time asc");
		
		List ls=q.list();
		return ls;
	}		
}	
	/*	ResultSet rs=st.executeQuery("select * from chat order by Time asc ");
			
			while(rs.next())
			{
				chatvo v1=new chatvo();
				v1.setMsg(rs.getString("Msg"));
				v1.setSender(rs.getString("Sender"));
				v1.setTime(rs.getString("Time"));
				ls.add(v1);
			}
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	*/
	
