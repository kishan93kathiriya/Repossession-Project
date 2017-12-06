package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.datasheetdao;

/**
 * Servlet implementation class PaginationController
 */
public class PaginationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String pageNo=(String)request.getParameter("pageNo");
		System.out.println("Page No="+pageNo);
		int p_no=Integer.parseInt(pageNo);
		session.setAttribute("pageIndex", p_no);
		datasheetdao dao= new datasheetdao();
		
		List l = dao.search1(p_no);
		
		session.setAttribute("updatelist", l);
		response.sendRedirect("admin/layout1/list_update.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
