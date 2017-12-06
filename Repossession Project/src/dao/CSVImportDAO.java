package dao;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CSVImportDAO {

	public void importCSV(String path)
	{
		String x=null;
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/poniyaag_bank","root","");
			Statement st=con.createStatement();
			
			
			String query="LOAD DATA LOCAL INFILE '"+path+"' INTO TABLE poniyaag_bank.list_vehicles FIELDS TERMINATED BY ',' ENCLOSED BY '\"' ";
			query=query.replace('\\', '/');
			query=query.concat("LINES TERMINATED BY '\\n' IGNORE 1 ROWS;");
			
			
			st.executeUpdate(query);
			con.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		/*path.replace("\\", "/");
		session.createSQLQuery("LOAD DATA INFILE :filename INTO TABLE list_vehicles FIELDS TERMINATED BY ','(Appl, Apac, Party_Name, Bucket, No_Of_EMI_OS, Chasis_NO, Engine_No, Location, Reg_No, Asset_Category, status, bank, date)").setString("filename", path).executeUpdate();
		*/
		
		
		//session.createSQLQuery(query).executeUpdate();
		/*session.createQuery(query).executeUpdate();*/
	}
	
	public void deleteDuplicate()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
			Statement st=con.createStatement();
			
			String query1="DELETE FROM list_vehicles WHERE CHAR_LENGTH(Reg_No)<=4 OR CHAR_LENGTH(Reg_No) >10 or Reg_No='' or Reg_No is Null or Reg_No LIKE '%.%'or Reg_No LIKE '%#%' or Reg_No LIKE '%(%' or Reg_No LIKE '%)%' OR Reg_No REGEXP '^[0-9]+' or Reg_No NOT REGEXP '^[a-z][a-z]+' OR Reg_No REGEXP '[a-z]$'";
			System.out.println("Query is ="+query1);
			
			
			/*String query="DELETE e1 FROM list_vehicles e1 , list_vehicles e2 WHERE (e1.id < e2.id) AND (e1.`Reg_No` =e2.`Reg_No`)";
			System.out.println("Query is ="+query);
			*/
			st.executeUpdate(query1);
			
			//st.executeUpdate(query);
			System.out.println("Deleted");
			con.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
	}
	
	
	
}
