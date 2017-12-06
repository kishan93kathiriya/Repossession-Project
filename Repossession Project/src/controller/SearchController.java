package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.QueryVO;
import dao.SearchByDAO;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		
		
		String flag=(String)request.getParameter("filterlist");
		String x=(String)request.getParameter("tablename");
		int y=Integer.parseInt(x);
		System.out.println(" table list value is ="+y);
		List l=null;
		SearchByDAO d=new SearchByDAO();
		System.out.println("flag is ="+flag);
		if(flag.equals("byDate"))
		{
			String s1=(String)request.getParameter("fromDate");
			String s2=(String)request.getParameter("toDate");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date endDate;
			
			String start=null;
			String end=null;
			if(s1!=null && s2!=null)
			{
				try {
					startDate = df.parse(s1);
				
				endDate =df.parse(s2);
				
				DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy"); 
				start = df2.format(startDate);
				end = df2.format(endDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			System.out.println("Date1 ="+start+"  Date2 ="+end+"   flag is ="+flag);
			
			
			String z=d.status(y);
			String query="from list_vehicles WHERE (date BETWEEN '"+start+"' AND '"+end+"')"+z;
			
			s.setAttribute("sortquery", query);
			
			l=d.searchbydate(query);
		}
		if(flag.equals("byBank"))
		{
			String bank=(String)request.getParameter("bank");
			System.out.println(bank);
			
			String z=d.status(y);
			String query="from list_vehicles WHERE bank='"+bank+"'" +z;

			s.setAttribute("sortquery", query);
			
			l=d.searchbybank(query);
		}
		if(flag.equals("byBoth"))
		{
			String bank=(String)request.getParameter("bank");
			String s1=(String)request.getParameter("fromDate");
			String s2=(String)request.getParameter("toDate");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date endDate;
			
			String start=null;
			String end=null;
			if(s1!=null && s2!=null)
			{
				try {
					startDate = df.parse(s1);
				
				endDate =df.parse(s2);
				
				DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy"); 
				start = df2.format(startDate);
				end = df2.format(endDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
			String z=d.status(y);
			String query="FROM list_vehicles WHERE (date BETWEEN '"+start+"' AND '"+end+"') AND bank ='"+bank+"' "+z;
			
			s.setAttribute("sortquery", query);
			
			l=d.searchbyboth(query);
		}
		
		
		System.out.println(" result searched and list size ="+l.size());
		s.setAttribute("resultlist", l);
		//
		
		response.sendRedirect((request.getContextPath()+"/admin/layout1/ResultData.jsp"));
		/*
		
*/		
	}

}
