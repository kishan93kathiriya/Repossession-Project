package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExampleDAO {

	public List searchreg()
	{
		
			int p=0;
			String x="";
			String y="";
			List<String> list=new ArrayList<String>();
			List ls=new ArrayList();
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select Reg_No from list_vehicles ORDER BY `Reg_No` ASC");
				
				
				String[] xxx=new String[100];
				int pq=0;
				int i=0;
				while(rs.next())
				{
					
					String main=(String)rs.getString("Reg_No");
					
					main=main.replace("-", "").replace(" ", "").replace("/", "").replace("*", "").replace("+", "").replace(";", "").replace(",", "").replace(".", "").replace(":", "");
					//System.out.println(" main is ="+main);
					String s1="",s2="",s3="";
				
					if(main.length()==0 || main==null || main.length()<5 || main.length()>10)
					{
						
					}
					else
					{
						s1=main.substring(0, 2);
						p=2;
						String ex=null;
						if(main.substring(p,p+1).matches("[0-9]+"))
						{
							//s1=s1.concat(main.substring(p,p+1));
							ex=main.substring(p,p+1);
							p=3;
							if(main.substring(p,p+1).matches("[0-9]+"))
							{
							//	s1=s1.concat(main.substring(p,p+1));
								ex=ex.concat(main.substring(p,p+1));
								p=4;
							}
							if(ex.length()==1)
							{
								s1=s1.concat("0"+ex);	
							}
							else
							{
								s1=s1.concat(ex);
							}
		
						}
						if(main.substring(p,p+1).equals("$"))
						{
							p=p+1;
							s2="";
							
						}
						else if(!main.substring(p,p+1).matches("[0-9]+"))
						{
							s2=s2.concat(main.substring(p,p+1));
							p=p+1;
							if(!main.substring(p,p+1).matches("[0-9]+"))
							{
								s2=s2.concat(main.substring(p,p+1));
								p=p+1;
							}
						}
						if(main.substring(p).length()>0)
						{
							if(main.substring(p,p+1).matches("[0-9]+"))
							{
								s3=s3.concat(main.substring(p));
							}
							
						}
						
						
						s1=s1.toUpperCase();
						if(s2!=null){
						
							s2=s2.toUpperCase();
						}
						s3=s3.toUpperCase();
						if(s1.equals(x))//NO YES
						{
							if(s2.equals(y))
							{
								list.add(s3);
							}
							else if(s2==null)
							{
								y=s2;
								list.add(s3);
							}
							else
							{
							
								y=s2;
								list.add(s2);
								list.add(s3);
								
								
							}
						}
						else//GJ18
						{
							x=s1;
							y=s2;//GJ18
							list.add(s1);//GJ18
						
							if(s2!=null)
							{
								list.add(s2);//AB
							}
							list.add(s3);//1
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
		

	public List searchreg(String s)
	{
		String query="select * "+s;
		
		
			int n=10000;
			int p=0;
			String x="";
			String y="";
			List<String> list=new ArrayList<String>();
			List ls=new ArrayList();
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
				
				int i=0;
				while(rs.next())
				{
					String main=rs.getString("Reg_No");
				
					main=main.replace("-", "");
					main=main.replace(" ", "");
					
					String s1="",s2="",s3="";
				
					if(main!=null)
					{
					
						s1=main.substring(0, 2);
						p=2;
						if(main.substring(p,p+1).matches("[0-9]+"))
						{
							s1=s1.concat(main.substring(p,p+1));
							p=3;
							if(main.substring(p,p+1).matches("[0-9]+"))
							{
								s1=s1.concat(main.substring(p,p+1));
								p=4;
							}
						}
						if(!main.substring(p,p+1).matches("[0-9]+"))
						{
							s2=s2.concat(main.substring(p,p+1));
							p=p+1;
							if(!main.substring(p,p+1).matches("[0-9]+"))
							{
								s2=s2.concat(main.substring(p,p+1));
								p=p+1;
							}
						}
						if(main.substring(p,p+1).matches("[0-9]+"))
						{
							
							s3=s3.concat(main.substring(p));
							
						}
						
					if(s1.equals(x))
					{
						if(s2.equals(y))
						{
							list.add(s3);
						}
						else
						{
							list.add(s2);
							y=s2;
							list.add(s3);
						}
					}
					else
					{
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
