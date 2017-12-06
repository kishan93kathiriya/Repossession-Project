package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SpecificSearchDao;

/**
 * Servlet implementation class SpecificSearchController
 */
public class SpecificSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecificSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String searchby=(String)request.getParameter("option");
		String table=(String)request.getParameter("table");
		String keyword=(String)request.getParameter("keyword");
		
		System.out.println(searchby+"   "+table+"   "+keyword);
		
		SpecificSearchDao d=new SpecificSearchDao();
		List ls=null;
		String x=null;
		if(table.equals("busted"))
		{
			x="STATUS='1' AND ";
		}
		else if(table.equals("remaining"))
		{
			x="STATUS='0' AND ";
		}
		else if(table.equals("update"))
		{
			x="";
		}
		
		
		
		if(searchby.equals("Registration No"))
		{
			keyword=keyword.replace(" ", "").replace("-", "").replace(".", "").replace(",", "");
			x=x+"reg_No LIKE '%"+keyword+"%'";
				ls=d.search(x);
		}
		else if(searchby.equals("Chasis No")){
			
			x=x+"chasis_No LIKE '%"+keyword+"%'";
			ls=d.search(x);
			
		}
		else if(searchby.equals("Loan No")){
			
			x=x+"loanNo LIKE '%"+keyword+"%'";
			ls=d.search(x);
			
		}
		else if(searchby.equals("Engine No")){
			
			x=x+"engine_No LIKE '%"+keyword+"%'";
			ls=d.search(x);
			
		}
			
		
		HttpSession s=request.getSession();
		s.setAttribute("list", ls);
		
		response.sendRedirect(request.getContextPath()+"/admin/layout1/SpecificResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
