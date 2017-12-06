package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
import vo.MasterTableVO;*/

public class MasterTableDAO {

public List searchreg()

{
	
		System.out.println("in DAO to get values");
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
			ResultSet rs=st.executeQuery("select * from list_vehicles where status='0' ORDER BY `Reg_No` ASC");
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
							System.out.println(s2+"  ");
							
							if(main.substring(5).length()==4)
							{
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(5).length()==3)
							{
								s3.concat("0");
								
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(5).length()==2)
							{
								s3.concat("00");
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(5).length()==1)
							{
								s3.concat("000");
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
						}
					}
					else
					{
						s1=s1.concat("0");
						s1=s1.concat(main.substring(2, 3));
						System.out.print(s1+"   ");
						if(!main.substring(3,5).matches("[0-9]+"))
						{
							s2=main.substring(3,5);
							System.out.println(s2+"  ");
							if(main.substring(5).length()==4)
							{
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(5).length()==3)
							{
								s3.concat("0");
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
							}
							else if(main.substring(5).length()==2)
							{
								s3.concat("00");
								s3=main.substring(5);
								System.out.println(s3+"  ");
								
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
					
				}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return list;
	}

}

