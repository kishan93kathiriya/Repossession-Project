package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExampleDAO;

/**
 * Servlet implementation class ResultSortController
 */
public class ResultSortController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultSortController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		String s=(String)hs.getAttribute("sortquery");
		System.out.println("Query is ="+s);
		
		ExampleDAO d2=new ExampleDAO();
			List list=d2.searchreg(s);
			
		
			int len=list.size();
			System.out.println("Length is ="+len);
			hs.setAttribute("length", len);
			hs.setAttribute("sortlist", list);
			
			response.sendRedirect("admin/layout1/ResultSortedData.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
