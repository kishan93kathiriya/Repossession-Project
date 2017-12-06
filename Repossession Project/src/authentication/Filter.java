package authentication;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.LoginVo;
import dao.LoginDao;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String logout = request.getParameter("logout");
		String uri = ((HttpServletRequest)request).getRequestURI();
		String name=null;
		int userId;
		String flag=request.getParameter("flag");
		String type=request.getParameter("user_type");
		
		if(uri.contains("page-404")|| uri.contains("fileupload") || uri.contains("import.jsp") ||uri.contains("page-500") ||uri.contains("login") || uri.contains("index.html") || uri.contains("register")|| uri.contains(".css")|| uri.contains("assets")|| uri.contains("img")|| uri.contains("/fonts")||uri.contains("controller"))
		{
			if(uri.contains("/login.jsp"))
			{
				session.invalidate();
			}
			//requestDispatcher = request.getRequestDispatcher("/Admin/register.jsp");  
			//requestDispatcher.forward(request,response);  
			
			chain.doFilter(request,response);
			
		}
		
		
		else if (request.getParameter("flag") != null && request.getParameter("flag").equals("logout")) {
			
			//session.removeAttribute("userID");
			session.invalidate();
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/admin/layout1/login.jsp");
			rd.forward(request, response);
			
		}
		
		else if(session.getAttribute("userId") != null)
		{
			String h = (String)session.getAttribute("usertype");
			
			if(h!=null ){
				if(h.equals("admin") || h.equals("client") && uri.contains("/bank"))
				chain.doFilter(request,response);
			}
			
			else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/layout1/login.jsp");  
			rd.forward(request,response);  
	
			}
		}
		
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("check") ){
			
			
			String email = request.getParameter("email");
			
			LoginVo mtv = new LoginVo();
			mtv.setUn(email);
			LoginDao mtd = new LoginDao();
			
			List list = mtd.searchEmail(mtv);
			
			session.setAttribute("checkemail", list.size());
			RequestDispatcher rd;
			
			
			rd = request.getRequestDispatcher("/Admin/JSON/loadEmail.jsp");
			rd.forward(request, response);
			
			
			
		}
		
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("login") )
		{
			
			String email = request.getParameter("un");
			String password = request.getParameter("pw");
			String authent=null;
			LoginVo mtv = new LoginVo();
			mtv.setUn(email);
			mtv.setPw(password);
			
			LoginDao mtd = new LoginDao();
			List list = mtd.authentication(mtv);
			
			if(list != null && list.size()>=1){
				
				Iterator itr = list.iterator();
	
				LoginVo user=(LoginVo) itr.next();
				
				long y = user.getId();

				session.setAttribute("userID",y);
				
				
				
				
				
				
				//System.out.println(user.getUser_type());
			
				type=((LoginVo)list.get(0)).getUser_type();
				userId=((LoginVo)list.get(0)).getId();
				authent=((LoginVo)list.get(0)).getAuthent();
				System.out.println("authent is ="+authent);
				session.setAttribute("userId", userId);
				session.setAttribute("usertype",type);
				

				name=((LoginVo)list.get(0)).getName();
				session.setAttribute("name",name);

				type=(String)session.getAttribute("usertype");
				if(authent.equals("yes"))
				{
					if(type.equals("client")){
						requestDispatcher = request.getRequestDispatcher("/admin/layout1/Redirect.jsp");  
						session.setAttribute("user", "client");
						requestDispatcher.forward(request,response);
						}
						
					else if(type.equals("admin")){
							requestDispatcher = request.getRequestDispatcher("/admin/layout1/Redirect.jsp");  
							session.setAttribute("user", "admin");
							requestDispatcher.forward(request,response);
							
						}
				}
				else
				{
					requestDispatcher = request.getRequestDispatcher("/admin/layout1/Redirect.jsp"); 
					
					session.setAttribute("user", "WorngAuth");
					
					requestDispatcher.forward(request,response);
				}

			}
		
           
		else if(flag.equals(null)){

			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/layout1/login.jsp");
			rd.forward(request,response);  
			
			}
		
				/*int check_no = mtd.check(user);*/
			}
		else if(type==null){

			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/layout1/login.jsp");
			rd.forward(request,response);  
			
			}
	}
			/*	}
				else
				{
					//System.out.println("sfsgssgregfdberr");
					requestDispatcher = request.getRequestDispatcher("/Admin/index.jsp");
					requestDispatcher.forward(request,response);  
				}
			}
			
			else{
					System.out.println("sjkgdcf");
					requestDispatcher = request.getRequestDispatcher("/Admin/login.jsp");  
					requestDispatcher.forward(request,response);  		
				}	
		}*/
		

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
