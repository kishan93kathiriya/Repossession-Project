package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.LoginVo;
import vo.list_vehicles;
import vo.employeevo;
import vo.caught_vehicles;
import dao.EmployeeUpdateDao;
import dao.ExampleDAO;
import dao.datasheetdao;
/**
 * Servlet implementation class datasheet
 */
@WebServlet("/datasheet")
public class datasheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datasheet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		
		String page = request.getParameter("page");
		int x=0;
		if(page!=null)
		{
			x=Integer.parseInt(page);
		}
		System.out.println(flag);
		System.out.println("oyee");
		if(flag.equals("search"))
		{
			datasheetdao dao= new datasheetdao();
			System.out.println("hi");
			List l = dao.search(x);
			System.out.println("hiii size ="+l.size());
			
			if(l.size()==0)
			{
				response.sendRedirect("admin/layout1/No_data.jsp");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("datalist", l);
				
				response.sendRedirect("admin/layout1/list_datasheet.jsp");
			}
		}
		else if(flag.equals("update"))
		{
			int id=Integer.parseInt((String)request.getParameter("id"));
			System.out.println("In Update");
			String name=(String)request.getParameter("name");
			String uname=(String)request.getParameter("uname");
			String password=(String)request.getParameter("password");
			
			LoginVo v=new LoginVo();
			v.setId(id);
			v.setName(name);
			v.setUn(uname);
			v.setPw(password);
			System.out.println("id="+id);
			
			EmployeeUpdateDao d=new EmployeeUpdateDao();
			d.update(v);
			
			datasheetdao dao= new datasheetdao();
			
			List l = dao.searchclient();
			
			HttpSession session = request.getSession();
			session.setAttribute("client", l);
			response.sendRedirect("admin/layout1/list_client.jsp");
			
			
		}
		else if(flag.equals("caught"))
		{
			System.out.println("in caught");
			String loanNo = request.getParameter("loanNo");
		//	String customerName = request.getParameter("Customer Name");
			String reg_No= request.getParameter("reg");
			String model= request.getParameter("Model");
			String chasis_No = request.getParameter("chasis_No");
			String engine_No = request.getParameter("engine_No");
			String bank= request.getParameter("bank");
			System.out.println("bank name is " + bank);
			//String contact = request.getParameter("Contact");
			String status="1";
			
			System.out.println("1"+loanNo+"\n2"+reg_No+"\n3"+chasis_No+"\n4"+engine_No);
			
			list_vehicles v =  new list_vehicles();
			v.setReg_No(reg_No);;

			/*caught_vehicles lv =  new caught_vehicles();
			lv.setLoanNo(loanNo);;
			//lv.setCustomerName(customerName);;
			lv.setReg_No(reg_No);;
			//lv.setModel(model);
			lv.setChasis_No(chasis_No);
			lv.setEngine_No(engine_No);
			//lv.setContact(contact);
			lv.setStatus(status);
			*/
			datasheetdao dao= new datasheetdao();
			System.out.println("5");
			//dao.insert(lv);
			dao.update(v);
			HttpSession session = request.getSession();
			session.setAttribute("bank", bank);
			session.setAttribute("reg_no", reg_No);
			session.setAttribute("loan_no", loanNo);
			session.setAttribute("model", model);
			/*List l = dao.search(0);
			
			HttpSession session = request.getSession();
			session.setAttribute("datalist", l);
			response.sendRedirect("admin/layout1/list_datasheet.jsp");*/
			response.sendRedirect("admin/layout1/Invoice.jsp");
		}
		else if(flag.equals("caught_revert"))
		{
			System.out.println("in caught revert");
			String loanNo = request.getParameter("loanNo");
		//	String customerName = request.getParameter("Customer Name");
			String reg_No= request.getParameter("reg");
			//String model= request.getParameter("Model");
			//String chasis_No = request.getParameter("chasis_No");
			//String engine_No = request.getParameter("engine_No");
			//String contact = request.getParameter("Contact");
			String status="0";
			
		//	System.out.println("1"+loanNo+"\n2"+reg_No+"\n3"+chasis_No+"\n4"+engine_No);
			
			list_vehicles v =  new list_vehicles();
			v.setReg_No(reg_No);;

			/*caught_vehicles lv =  new caught_vehicles();
			lv.setLoanNo(loanNo);;
			//lv.setCustomerName(customerName);;
			lv.setReg_No(reg_No);;
			//lv.setModel(model);
			lv.setChasis_No(chasis_No);
			lv.setEngine_No(engine_No);
			//lv.setContact(contact);
			lv.setStatus(status);
			*/
			datasheetdao dao= new datasheetdao();
			System.out.println("5");
			//dao.insert(lv);
			dao.update_revert(v);
			List l = dao.search2(x);
			
			HttpSession session = request.getSession();
			session.setAttribute("bustedlist", l);
			response.sendRedirect("admin/layout1/list_busted.jsp");
		}
		else if(flag.equals("caught_delete"))
		{
			System.out.println("in caught delete");
			String loanNo = request.getParameter("loanNo");
			String reg_No= request.getParameter("reg");
			
			list_vehicles v =  new list_vehicles();
			v.setReg_No(reg_No);
			
			datasheetdao dao= new datasheetdao();
			System.out.println("5");
			//dao.insert(lv);
			dao.caught_delete(v);
			List l = dao.search2(x);
			
			HttpSession session = request.getSession();
			session.setAttribute("bustedlist", l);
			response.sendRedirect("admin/layout1/list_busted.jsp");
		}
		else if(flag.equals("search_update"))
		{
			
			System.out.println("hello update");

			datasheetdao dao= new datasheetdao();
			
			List l = dao.search1(x);
			if(l.size()==0)
			{
				response.sendRedirect("admin/layout1/No_updatedata.jsp");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("updatelist", l);
				response.sendRedirect("admin/layout1/list_update.jsp");
			}
		}
		else if(flag.equals("search_busted"))
		{
			
			datasheetdao dao= new datasheetdao();
			
			List l = dao.search2(x);
			if(l.size()==0)
			{
				response.sendRedirect("admin/layout1/No_caughtdata.jsp");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("bustedlist", l);
				response.sendRedirect("admin/layout1/list_busted.jsp");
			}
		}
		else if(flag.equals("search_deleted"))
		{
			
			datasheetdao dao= new datasheetdao();
			
			List l = dao.search22(x);
			if(l.size()==0)
			{
				response.sendRedirect("admin/layout1/No_deleteddata.jsp");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("deletedlist", l);
				response.sendRedirect("admin/layout1/list_delete.jsp");
			}
		}
		else if(flag.equals("add_agencies"))
		{
			String name= request.getParameter("a_name");
			String username= request.getParameter("u_name");
			String password= request.getParameter("p_name");
			String user_type= request.getParameter("user_type");
			
			employeevo ev = new employeevo();
			ev.setName(name);
			ev.setUsername(username);
			ev.setPassword(password);
			ev.setUser_type(user_type);
			ev.setAuthent("yes");
			
			datasheetdao dao= new datasheetdao();
			
			dao.insertclient(ev);

			response.sendRedirect("admin/layout1/add_clients.jsp");
		}
		else if(flag.equals("search_client"))
		{
			list_vehicles v =  new list_vehicles();

			datasheetdao dao= new datasheetdao();
			
			List l = dao.searchclient();
			
			HttpSession session = request.getSession();
			session.setAttribute("client", l);
			response.sendRedirect("admin/layout1/list_client.jsp");
		}
		else if(flag.equals("change_auth"))
		{
			int id=Integer.parseInt((String)request.getParameter("id"));
			String authent=(String)request.getParameter("authent");
			LoginVo lv = new LoginVo();
			lv.setId(id);
			lv.setAuthent(authent);
			
			datasheetdao dao= new datasheetdao();
			dao.change_auth(lv);
			List l = dao.searchclient();
			
			HttpSession session = request.getSession();
			session.setAttribute("client", l);
			response.sendRedirect("admin/layout1/list_client.jsp");
		
		}
		else if(flag.equals("edit"))
		{
			int id= Integer.parseInt(request.getParameter("id"));
			
			LoginVo lv = new LoginVo();
			lv.setId(id);
			
			datasheetdao dao= new datasheetdao();
			
			List l=dao.edit(lv);
			
			HttpSession session = request.getSession();
			session.setAttribute("data", l);
			response.sendRedirect("admin/layout1/edit_clients.jsp");
		}
		else if(flag.equals("delete"))
		{
			int id= Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			
			datasheetdao dao= new datasheetdao();
			dao.delete_client(id);
			List l = dao.searchclient();
			
			HttpSession session = request.getSession();
			session.setAttribute("client", l);
			response.sendRedirect("admin/layout1/list_client.jsp");
			
		}
    
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
