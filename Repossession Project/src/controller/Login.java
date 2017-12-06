package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExampleDAO;
import dao.LoginDao;
import dao.agenciesDao;
import dao.datasheetdao;
import vo.LoginVo;
import vo.agencies;
import vo.chatvo;
import vo.employee_vehicle;
import vo.list_vehicles;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String forward="";
        String flag = request.getParameter("flag");
        String regno = request.getParameter("regno");
        System.out.println("flag is ="+flag);

        if (flag.equalsIgnoreCase("delete")){
            System.out.println(flag+" "+regno);
            
            list_vehicles v= new list_vehicles();
            v.setReg_No(regno);
            
            LoginDao l1=new LoginDao();
            l1.transfer1(v);
            
            list_busted(request, response);
            list_data(request, response);
            response.sendRedirect("admin/layout1/list_datasheet.jsp");
        }
        if (flag.equalsIgnoreCase("undo")){
            System.out.println(flag+" "+regno);
            
            list_vehicles v= new list_vehicles();
            v.setReg_No(regno);
            
            LoginDao l1=new LoginDao();
            l1.transfer2(v);
            
            list_busted(request, response);
            list_data(request, response);
            response.sendRedirect("admin/layout1/list_busted.jsp");
        }
        if(flag.equals("logout"))
        {
        	String sender=request.getParameter("sender");
        	
        	System.out.println("logout");
        	HttpSession session=request.getSession();
			session.invalidate();
			if(sender.equals("admin"))
			{
				response.sendRedirect("admin/layout1/index.jsp");
			}
			else
			{
				response.sendRedirect("admin/layout1/itsme.jsp");
			}
        }
        
        
        
        
        
        
        
        /*if(flag.equals("login_agent"))
		{
			
			datasheetdao d2=new datasheetdao();
			List list=d2.searchreg();
			
			//System.out.println("servlet = "+((agencies) list.get(0)).getU_name()+" password = "+((agencies)list.get(0)).getP_name());
			
			if(s1.equals(((agencies) list.get(0)).getU_name()) && s2.equals(((agencies) list.get(0)).getP_name()))
			{
				System.out.println("right user name & pass");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("username", ((agencies) list.get(0)).getA_name()) ;
				
				list_regNo(request, response);
				
				response.sendRedirect("admin/layout1/list_datasheet1.jsp");
			}
			else
			{
				System.out.println("wrong");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("error", "Please enter Valid Username Or Password");
			
				response.sendRedirect("admin/layout1/itsme.jsp");
			}
		}*/
        
        if(flag.equals("login_agent"))
		{
			
			ExampleDAO d2=new ExampleDAO();
			List list=d2.searchreg();
			
			HttpSession hs=request.getSession();
			int len=list.size();
			System.out.println("Length is ="+len);
			hs.setAttribute("length", len);
			hs.setAttribute("aaa", list);
			
			/*	
				list_regNo(request, response);
				
			*/	response.sendRedirect("admin/layout1/list_datasheet2.jsp");
			/*}
			else
			{
				System.out.println("wrong");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("error", "Please enter Valid Username Or Password");
			
				response.sendRedirect("admin/layout1/itsme.jsp");
			}*/
		}
    
        
        if(flag.equals("admincall"))
		{
			
			ExampleDAO d2=new ExampleDAO();
			List list=d2.searchreg();
			
			HttpSession hs=request.getSession();
			int len=list.size();
			System.out.println("Length is ="+len);
			hs.setAttribute("length", len);
			hs.setAttribute("aaa", list);
			
			/*	
				list_regNo(request, response);
				
			*/	response.sendRedirect("admin/layout1/SortedData.jsp");
			/*}
			else
			{
				System.out.println("wrong");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("error", "Please enter Valid Username Or Password");
			
				response.sendRedirect("admin/layout1/itsme.jsp");
			}*/
		}
    
        
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		System.out.println("1 Flag is= "+flag);
		
		if(flag.equals("chat"))
		{
			String msg=request.getParameter("msg");
			String sender=request.getParameter("sender");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String time=dateFormat.format(cal.getTime());
			System.out.println(msg+"-"+sender+" "+time);
			
			chatvo v= new chatvo();
			v.setMsg(msg);
			v.setSender(sender);
			v.setTime(time);
			
			LoginDao d1=new LoginDao();
			d1.insert_msg(v);
			
			chatdata(request, response);
			
			if(sender.equals("admin"))
			{
				response.sendRedirect("admin/layout1/msg_admin.jsp");
			}
			else
			{
				response.sendRedirect("admin/layout1/msg_emp.jsp");
			}
		}
		
		if(flag.equals("delete"))
		{
			String regno=request.getParameter("reg_No");
			System.out.println(regno);
			
		}
		
		if(flag.equals("login"))
		{
			String s1=request.getParameter("un");
			String s2=request.getParameter("pw");
			
			LoginVo l1=new LoginVo();
			l1.setUn(s1);
			
			System.out.println("Un:"+s1+" Pw:"+s2);
			
			LoginDao d1=new LoginDao();
			List list=d1.search(l1);
			
			System.out.println("servlet = "+((LoginVo) list.get(0)).getUn()+" password = "+((LoginVo)list.get(0)).getPw());
			
			if(s1.equals(((LoginVo) list.get(0)).getUn()) && s2.equals(((LoginVo) list.get(0)).getPw()))
			{
				System.out.println("right user name & pass");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("username", ((LoginVo) list.get(0)).getUser_type()) ;
				
				list_agencies(request, response);
				list_data(request, response);
				list_busted(request, response);
				
				response.sendRedirect("admin/layout1/dashboard.jsp");
			}
			else
			{
				System.out.println("wrong");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("error", "Please enter Valid Username Or Password");
			
				response.sendRedirect("admin/layout1/index.jsp");
			}
		}
		
		if(flag.equals("login_agent"))
		{
			
			System.out.println("login_agent is here in Post Method");
			datasheetdao d2=new datasheetdao();
			List list=d2.searchreg();
			
			HttpSession hs=request.getSession();
			
			hs.setAttribute("aaa", list);
			
			/*	
				list_regNo(request, response);
				
			*/	response.sendRedirect("admin/layout1/list_datasheet1.jsp");
			/*}
			else
			{
				System.out.println("wrong");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("error", "Please enter Valid Username Or Password");
			
				response.sendRedirect("admin/layout1/itsme.jsp");
			}*/
		}
		
		if(flag.equals("add_agencies"))
		{
			String s1=request.getParameter("a_name");
			String s2=request.getParameter("u_name");
			String s3=request.getParameter("p_name");
			
			System.out.println("a_name:"+s1+" u_name:"+s2+" p_name"+s3);
			
			agencies a1=new agencies();
			a1.setA_name(s1);
			a1.setU_name(s2);
			a1.setP_name(s3);
			
			agenciesDao a2=new agenciesDao();
			a2.insert(a1);
			
			list_agencies(request, response);
			
			response.sendRedirect("admin/layout1/add_agencies.jsp");
		}
	}
	
	protected void list_agencies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		agencies s1=new agencies();
		agenciesDao s2=new agenciesDao();
		
		HttpSession hs=request.getSession();
		List agent_ls=s2.search(s1);
		
		hs.setAttribute("list", agent_ls);
		
		System.out.println(agent_ls);
	}
	
	protected void list_regNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		employee_vehicle v=new employee_vehicle();
		agenciesDao s2=new agenciesDao();
		
		HttpSession hs=request.getSession();
		List agent_V_ls=s2.search1(v);
		
		hs.setAttribute("aaa", agent_V_ls);
		System.out.println("servlet = "+((employee_vehicle) agent_V_ls.get(0)).getFirst2()+" password = "+((employee_vehicle)agent_V_ls.get(0)).getMiddle2());
		System.out.println(v.getFirst2()+" "+v.getMiddle2()+" "+v.getLast4());
		System.out.println(agent_V_ls);
		
	}
	
	protected void list_data(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		list_vehicles s1=new list_vehicles();
		agenciesDao s2=new agenciesDao();
		//datasheet dao=new datasheet();
		
		HttpSession hs=request.getSession();
		List Admin_V_ls=s2.searchall(s1);
		
		hs.setAttribute("alldata", Admin_V_ls);
		
	}
	
	protected void list_busted(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		list_vehicles s1=new list_vehicles();
		agenciesDao s2=new agenciesDao();
		//datasheet dao=new datasheet();
		
		HttpSession hs=request.getSession();
		List busted_ls=s2.busted_list(s1);
		
		hs.setAttribute("busted", busted_ls);
		
	}
	
	protected void chatdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		chatvo c1=new chatvo();
		LoginDao l1=new LoginDao();
		
		HttpSession hs=request.getSession();
		List chat_msg=l1.serch_msg(c1);
		
		hs.setAttribute("chat_msg", chat_msg);
		
	}
	
	
}
