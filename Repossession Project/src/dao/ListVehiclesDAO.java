package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vo.AttachmentVO;
import vo.list_vehicles;
import lscd.*;

public class ListVehiclesDAO {

	public void insert(list_vehicles list_vehicles) {

		Session session = null;

		try {

			session = MyUtility.getSession();

			Transaction t = session.beginTransaction();

			session.save(list_vehicles);

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
			
		} 
			session.close();
		
	}
	
	public List<list_vehicles> search() {

		List<list_vehicles> ls = new ArrayList<list_vehicles>();
		
		Session session = null;

		try {

			session = MyUtility.getSession();

			Query q = session.createQuery("from list_vehicles");
			
			ls = q.list();

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return ls;
	}
	
	public List<list_vehicles> searchOrderByRegNo() {

		List<list_vehicles> ls = new ArrayList<list_vehicles>();
		
		Session session = null;

		try {

			session = MyUtility.getSession();

			Query q = session.createQuery("from list_vehicles ORDER BY reg_No");
			
			ls = q.list();

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return ls;
	}
	
	public void delete(list_vehicles list_vehicles) {

		Session session = null;

		try {

			session = MyUtility.getSession();

			Transaction t = session.beginTransaction();

			Query qr = session.createQuery("delete from list_vehicles where reg_No='"+list_vehicles.getReg_No()+"' ");
			
			qr.executeUpdate();

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
			
		} 
			session.close();
		
	}
}