package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SpecificSearchDao;
import dao.invoiceDAO;
import vo.BillList;

/**
 * Servlet implementation class InvoiceController
 */
public class InvoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=(String) request.getParameter("flag");

		
		HttpSession s=request.getSession();
		
		if(flag.equals("invoiceDB"))
		{
			invoiceDAO dd=new invoiceDAO();
			List ls=dd.searchInvoice();
			s.setAttribute("list", ls);
			response.sendRedirect("admin/layout1/AllInvoice.jsp");
		
		}
		if(flag.equals("search"))
		{
			String searchby=(String)request.getParameter("option");
			String table=(String)request.getParameter("table");
			String keyword=(String)request.getParameter("keyword");
			SpecificSearchDao d=new SpecificSearchDao();
			List ls=null;
			String x=null;
			if(table.equals("invoice"))
			{
			
				
				if(searchby.equals("Vehicle No"))
				{
					
					x="reg_No LIKE '%"+keyword+"%'";
						ls=d.searchInvoice(x);
				}
				else if(searchby.equals("Loan No")){
					
					x="loan_No LIKE '%"+keyword+"%'";
					ls=d.searchInvoice(x);
					
				}
				else if(searchby.equals("Bill No")){
					
					x="bill_No LIKE '%"+keyword+"%'";
					ls=d.searchInvoice(x);
					
				}
				
				System.out.println("List size ="+ls.size());
				s.setAttribute("list", ls);
				
				response.sendRedirect(request.getContextPath()+"/admin/layout1/InvoiceResult.jsp");
		
			}
		}	
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=(String) request.getParameter("flag");
		invoiceDAO dd=new invoiceDAO();
		HttpSession s=request.getSession();
		System.out.println("Flag is ="+flag);
		if(flag.equals("invoiceDB"))
		{
			List ls=dd.searchInvoice();
			s.setAttribute("list", ls);
			response.sendRedirect("admin/layout1/AllInvoice.jsp");
		
		}
		
		
		if(flag.equals("invoiceBill"))
		{
		
			
			String loan=(String) s.getAttribute("loan");
			String bank=(String) s.getAttribute("bank");
			String reg=(String) s.getAttribute("reg");    
			String model=(String) s.getAttribute("model");
			String hirer= (String) request.getParameter("hirer");
			String repossesed= (String) request.getParameter("repossesed");
			String place= (String) request.getParameter("place");
			String policestation= (String) request.getParameter("policestation");
			String parked= (String) request.getParameter("parked");
			String repcharge= (String) request.getParameter("repcharge");
			String extracharge= (String) request.getParameter("extracharge");
			String tax= (String) request.getParameter("tax");
			int total= Integer.parseInt((String) request.getParameter("total"));
			String word= (String) request.getParameter("word");
			
			Date d=new Date();
			SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
			String date = ft.format(d);
			
			
			BillList b=new BillList();
			b.setBill_Amount(total);
			b.setBill_Date(date);
			b.setFinance(bank);
			b.setLoan_No(loan);
			b.setReg_No(reg);
			b.setStatus("pending");
			b.setBill_No(0);
			dd.insert(b);
			
			String x="?loan="+loan+"&bank="+bank+"&reg="+reg+"&model="+model+"&hirer="+hirer+"&repossesed="+repossesed+"&place="+place+"&policestation="+policestation+"&parked="+parked+"&repcharge="+repcharge+"&extracharge="+extracharge+"&tax="+tax+"&total="+total+"&word="+word+"";
			
			
			response.sendRedirect("admin/layout1/Invoice.jsp"+x);
		}
	}

}
