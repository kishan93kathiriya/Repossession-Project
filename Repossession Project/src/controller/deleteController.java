package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.deleteParticularDataDao;

/**
 * Servlet implementation class deleteController
 */
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s=request.getSession();
		
		
		String flag=(String)request.getParameter("deleteList");
		System.out.println("Flag is ="+flag);
		deleteParticularDataDao d=new deleteParticularDataDao();
		
		System.out.println("hehehe in delete controller");
		if(flag.equals("byBank"))
		{
			String bankName=(String)request.getParameter("bank");
			System.out.println("bank Name is ="+bankName);
			d.deleteByBank(bankName);
			
		}
		else if(flag.equals("byBoth"))
		{

			String bankName=(String)request.getParameter("bank");
			String date =(String) request.getParameter("date");
			System.out.println("bank Name is ="+bankName);
			

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			
			
			String start=null;
			
			if(date!=null)
			{
				try {
					startDate = df.parse(date);
				
				
				DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy"); 
				start = df2.format(startDate);
			
				} catch (ParseException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Date selected is "+start);
			
				d.deleteByBoth(bankName, start);
			}
			
		}
		response.sendRedirect("admin/layout1/dashboard.jsp");
		
	}

}
