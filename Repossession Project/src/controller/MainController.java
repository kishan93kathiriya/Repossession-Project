package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Example.ExcelToCSV;
import dao.AttachmentDAO;
import dao.AttachmentMappingDAO;
import dao.CSVImportDAO;
import dao.ListVehiclesDAO;
import dao.datasheetdao;
import vo.AttachmentMappingVO;
import vo.AttachmentVO;
import vo.list_vehicles;
import xlsToJava.XlsToJavaConvertor;

/**
 * Servlet implementation class AttachmentController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mode = request.getParameter("mode");

		if (mode != null && mode.equals("3")) {
			edit(request, response);

		} else if (mode != null && mode.equals("4")) {
			delete(request, response);

		} else if (mode != null && mode.equals("5")) {
			show(request, response);

		} else {
			// default
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int attachmentID = Integer.parseInt(request.getParameter("id"));
		AttachmentVO attachVO = new AttachmentVO();
		attachVO.setAttachmentID(attachmentID);

		AttachmentDAO attachDAO = new AttachmentDAO();
		attachDAO.delete(attachVO);

		show(request, response);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int attachmentMappingID = Integer.parseInt(request.getParameter("id"));
		AttachmentMappingVO attachMPG_VO = new AttachmentMappingVO();
		attachMPG_VO.setAttachmentMappingID(attachmentMappingID);

		AttachmentMappingDAO attachMPG_DAO = new AttachmentMappingDAO();
		attachMPG_DAO.delete(attachMPG_VO);

		show(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");

		System.out.println("mode=" + mode);

		if (mode != null && mode.equals("6")) {
			deleteSelected(request, response);

		} 
		else if (mode != null && mode.equals("1")) {
			insert(request, response);
		}
		else if (mode != null && mode.equals("11")) {
			insert_new(request, response);
		}
		else if (mode != null && mode.equals("22")) {
			addtoFile(request, response);
		}
		else if(mode != null && mode.equals("exportToExcel")){
			exportToExcel(request, response);
		}
		else if(mode != null && mode.equals("exportToPDF")){
			exportToPDF(request, response);
		}
		

	}

	protected void deleteSelected(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] attachmentMappingID = request.getParameterValues("list");

		AttachmentMappingVO attachMPG_VO = new AttachmentMappingVO();
		AttachmentMappingDAO attachMPG_DAO = new AttachmentMappingDAO();

		for (int i = 0; i < attachmentMappingID.length; i++) {

			attachMPG_VO.setAttachmentMappingID(Integer.parseInt(attachmentMappingID[i]));

			attachMPG_DAO.delete(attachMPG_VO);

		}

		show(request, response);

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bankName = request.getParameter("bankName");
		String option = request.getParameter("option");

		AttachmentVO attachmentVO = new AttachmentVO();
		attachmentVO.setAttachmentType(bankName);

		AttachmentDAO attachmentDAO = new AttachmentDAO();
		attachmentDAO.insert(attachmentVO);

		AttachmentMappingVO attachMPGVO = new AttachmentMappingVO();

		attachMPGVO.setAttachmentID(attachmentVO);

		AttachmentMappingDAO attachMPG_DAO = new AttachmentMappingDAO();

		Date dd = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

		String s = ft.format(dd);

		// getting file from Session

		HttpSession session = request.getSession();

		List myList = (List) session.getAttribute("fileList");
		System.out.println("List size" + myList.size());

		Iterator itr = myList.iterator();

		System.out.println("Reading for session");
		int i = 0;
		while (itr.hasNext()) {

			attachMPGVO.setAttachmentName(bankName);
			attachMPGVO.setPath((String) itr.next());
			attachMPGVO.setDate(s);
			attachMPG_DAO.insert(attachMPGVO);

			i++;
		}
		System.out.println(" Bank name is =" + attachmentVO.getAttachmentType());

		String path = (String) session.getAttribute("url");
		System.out.println(path);
		String input = path.concat((String) session.getAttribute("input"));
		String ExcelFileName = (String) session.getAttribute("input");
		String output = path.concat("abc.csv");
		System.out.println("File Name is =" + ExcelFileName);
		datasheetdao d = new datasheetdao();
		int FileID = d.getFileId(ExcelFileName);

		ExcelToCSV.convertToXlsx(input, output, bankName, FileID);
		
		/*
		 * int id=FileIDList.get(0); System.out.println("File id ="+id);
		 */

		if (option.equals("replace")) {
			d.delete_previous(bankName);
		}
		CSVImportDAO x = new CSVImportDAO();
		x.importCSV(output);
		x.deleteDuplicate();
		session.removeAttribute("fileList");

		response.sendRedirect("admin/layout1/dashboard.jsp");

		// show(request, response);

	}
	
	protected void insert_new(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bankName = request.getParameter("bankName");
		String option = request.getParameter("option");

		datasheetdao d = new datasheetdao();
		if (option.equals("replace")) {
			d.delete_previous(bankName);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("bankName", bankName);
		
		AttachmentVO attachmentVO = new AttachmentVO();
		attachmentVO.setAttachmentType(bankName);

		AttachmentDAO attachmentDAO = new AttachmentDAO();
		attachmentDAO.insert(attachmentVO);

		AttachmentMappingVO attachMPGVO = new AttachmentMappingVO();

		attachMPGVO.setAttachmentID(attachmentVO);

		AttachmentMappingDAO attachMPG_DAO = new AttachmentMappingDAO();

		Date dd = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

		String s = ft.format(dd);

		// getting file from Session

		List myList = (List) session.getAttribute("fileList");
		System.out.println("List size" + myList.size());

		Iterator itr = myList.iterator();

		System.out.println("Reading for session");
		int i = 0;
		while (itr.hasNext()) {

			attachMPGVO.setAttachmentName(bankName);
			attachMPGVO.setPath((String) itr.next());
			attachMPGVO.setDate(s);
			attachMPG_DAO.insert(attachMPGVO);

			i++;
		}
		System.out.println(" Bank name is =" + attachmentVO.getAttachmentType());

		String path = (String) session.getAttribute("url");
		System.out.println(path);
		String input = path.concat((String) session.getAttribute("input"));
		String ExcelFileName = (String) session.getAttribute("input");
		//String output = path.concat("abc.csv");
		System.out.println("File Name is =" + ExcelFileName);
//		datasheetdao d = new datasheetdao();
//		int FileID = d.getFileId(ExcelFileName);

		//ExcelToCSV.convertToXlsx(input, output, bankName, FileID);

		
//		int id=FileIDList.get(0); System.out.println("File id ="+id);
//		 
//
//		if (option.equals("replace")) {
//			d.delete_previous(bankName);
//		}
//		CSVImportDAO x = new CSVImportDAO();
//		x.importCSV(output);
//		x.deleteDuplicate();
		
		
		XlsToJavaConvertor xlsToJavaConvertor =  new XlsToJavaConvertor();
		
		Map<Integer,String> map = xlsToJavaConvertor.readXLSHeaders(attachMPGVO);
		
		session.setAttribute("sheetheaders",map);
		session.setAttribute("attachMPGVO", attachMPGVO);
		
		session.removeAttribute("fileList");

		response.sendRedirect(request.getContextPath()+"/admin/layout1/selectHeader.jsp");

		// show(request, response);

	}
	
	private void addtoFile(HttpServletRequest request, HttpServletResponse response){
		
		try{
			
			HttpSession session = request.getSession();
			
			String Loan_No = request.getParameter("Loan_No");
			String Customer_Name = request.getParameter("Customer_Name");
			String Reg_No = request.getParameter("Reg_No");
			String Modal = request.getParameter("Modal");
			String Chasis_No = request.getParameter("Chasis_No");
			String Engine_No = request.getParameter("Engine_No");
			String[] Contact = request.getParameterValues("Contact");
			String bankName = (String) session.getAttribute("bankName");
			
			String time = Calendar.getInstance().getTime().toLocaleString();
			
			List<Integer> fatchHeader = new ArrayList<Integer>();
			fatchHeader.add(Integer.parseInt(Loan_No));
			fatchHeader.add(Integer.parseInt(Customer_Name));
			fatchHeader.add(Integer.parseInt(Reg_No));
			fatchHeader.add(Integer.parseInt(Modal));
			fatchHeader.add(Integer.parseInt(Chasis_No));
			fatchHeader.add(Integer.parseInt(Engine_No));
			
			for(String c: Contact){
				fatchHeader.add(Integer.parseInt(c));
			}
			
			AttachmentMappingVO attachMPGVO = (AttachmentMappingVO) session.getAttribute("attachMPGVO");
			
			XlsToJavaConvertor xlsToJavaConvertor = new XlsToJavaConvertor();
			List<list_vehicles> list_vehicles = xlsToJavaConvertor.readXLS(attachMPGVO, fatchHeader, bankName, time);
			
			ListVehiclesDAO listVehiclesDAO = new ListVehiclesDAO();
			
			for (list_vehicles list_vehicles2 : list_vehicles) {
				listVehiclesDAO.delete(list_vehicles2);
				
				list_vehicles2.setReg_No(convertRegNo(list_vehicles2.getReg_No()));
				
				listVehiclesDAO.insert(list_vehicles2);
				
			}
			
			session.removeAttribute("bankName");
			
			response.sendRedirect("admin/layout1/dashboard.jsp");
			
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
	}
	
	private void exportToExcel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ListVehiclesDAO listVehiclesDAO = new ListVehiclesDAO();
		
		List<list_vehicles> list_vehicle = listVehiclesDAO.search();
		
		System.out.println("No of Data :: "+list_vehicle.size());
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Vehicle List");
		
		int rownum = 1;
		Row row = sheet.createRow(0);
		
		String[] headingArray = {"Loan No.", "Customer Name", "Reg No.", "Model", "Chassis No.", "Engine No.", "Contact"};
		for(int i = 0; i<headingArray.length; i++)
		{
			Cell cell = row.createCell(i);
			cell.setCellValue(headingArray[i]);
		}
		
		Iterator<list_vehicles> itr = list_vehicle.iterator();
		while(itr.hasNext())
		{
			list_vehicles list_vehicle2 = itr.next();
			
			Row rowData = sheet.createRow(rownum++);
			Cell cell = rowData.createCell(0);
			cell.setCellValue(list_vehicle2.getLoanNo());
			Cell cell1 = rowData.createCell(1);
			cell1.setCellValue(list_vehicle2.getCustomerName());
			Cell cell2 = rowData.createCell(2);
			cell2.setCellValue(list_vehicle2.getReg_No());
			Cell cell3 = rowData.createCell(3);
			cell3.setCellValue(list_vehicle2.getModel());
			Cell cell4 = rowData.createCell(4);
			cell4.setCellValue(list_vehicle2.getChasis_No());
			Cell cell5 = rowData.createCell(5);
			cell5.setCellValue(list_vehicle2.getEngine_No());
			Cell cell6 = rowData.createCell(6);
			cell6.setCellValue(list_vehicle2.getContact());
		}
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=VelicleDetail.xls");
		workbook.write(response.getOutputStream());
		response.getOutputStream().close();
		
	}

	private void exportToPDF(HttpServletRequest request, HttpServletResponse response){
		
		ListVehiclesDAO listVehiclesDAO = new ListVehiclesDAO();
		
		List<list_vehicles> listVehicle = listVehiclesDAO.searchOrderByRegNo();
		
		createPDF(listVehicle, response);
		
	}
	
	private void createPDF(List<list_vehicles> listVehicle, HttpServletResponse response)
	{	
		try
		{
			Document document = new Document();
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=VelicleRegistrationList.pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			
			document.open();
			
			Font f = new Font(FontFamily.TIMES_ROMAN, 25, Font.BOLD | Font.UNDERLINE);
			f.setColor(BaseColor.BLUE);
			
			Phrase ph = new Phrase("Poniya Agency", f);
			
			document.add(ph);
			
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100);
			
			String stateName = null;
			String vehicleSeries = null;
			
			Iterator<list_vehicles> itr = listVehicle.iterator();
			while (itr.hasNext()) {
				
				list_vehicles list_vehicles = itr.next();
				String regNo = list_vehicles.getReg_No();
				
				String temp1 = regNo.substring(0, 4);
				String temp2 = null;
				String temp3 = null;
				
				if(stateName != null && !stateName.equals(temp1))
				{
					stateName = temp1;
					
					Font font = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD | Font.UNDERLINE);
					font.setColor(BaseColor.BLUE);
					
					Phrase p = new Phrase(stateName, font);
					PdfPCell cell = new PdfPCell(p);
					cell.setBorder(Rectangle.NO_BORDER);
					cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setPadding(10f);
					table.addCell(cell);
					
				}
				else if(stateName != null && stateName.equals(temp1))
				{
					stateName = temp1;
				}
				else
				{
					Font font = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD | Font.UNDERLINE);
					font.setColor(BaseColor.BLUE);
					
					stateName = regNo.substring(0, 4);
					Phrase p = new Phrase(stateName, font);
					PdfPCell cell = new PdfPCell(p);
					cell.setBorder(Rectangle.NO_BORDER);
					cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setPadding(10f);
					table.addCell(cell);
				}
				
				if(Character.isDigit(regNo.charAt(5)))
				{
					temp2 = regNo.substring(4, 5);
					temp3 = regNo.substring(5, 9);
				}
				else
				{
					temp2 = regNo.substring(4, 6);
					temp3 = regNo.substring(6, 10);
				}
				
				if(vehicleSeries != null && !vehicleSeries.equals(temp2))
				{
					vehicleSeries = temp2;
					
					Font font = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD);
					
					Phrase p = new Phrase(vehicleSeries, font);
					PdfPCell cell = new PdfPCell(p);
					cell.setBorder(Rectangle.NO_BORDER);
					cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setPadding(10f);
					table.addCell(cell);
				}
				else if(vehicleSeries != null && vehicleSeries.equals(temp2))
				{
					vehicleSeries = temp2;
				}
				else
				{
					vehicleSeries = temp2;
					
					Font font = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD);
					
					Phrase p = new Phrase(vehicleSeries, font);
					PdfPCell cell = new PdfPCell(p);
					cell.setBorder(Rectangle.NO_BORDER);
					cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setPadding(10f);
					table.addCell(cell);
				}
				
				Phrase p = new Phrase(temp3);
				PdfPCell cell = new PdfPCell(p);
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				cell.setVerticalAlignment(Element.ALIGN_LEFT);
				cell.setPadding(10f);
				table.addCell(cell);
				
			}
			
			document.add(table);
			document.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private String convertRegNo(String regNo)
	{
		StringBuffer temp = new StringBuffer();
		
		String main = null;
		int confirm = 1;
		main = regNo.replace(",", "").replace(" ", "").replace("\"", "").trim();
		// System.out.println("hehe cell ="+main);
		String s1 = "";
		main = main.replace("-", "").replace("(", "").replace(")", "").replace("{", "")
				.replace("}", "").replace("[", "").replace("]", "").replace(" ", "")
				.replace("/", "").replace("*", "").replace("+", "").replace(";", "")
				.replace(",", "").replace(".", "").replace("#", "").replace("!", "")
				.replace(":", "");

		if (main.length() == 0 || main == null || main.length() < 5 || main.length() > 10) {
			temp.append(",");
		} else if (main.length() <= 10) {
			s1 = main.substring(0, 2);
			int p = 2;
			String ex = null;
			if (main.substring(p, p + 1).matches("[0-9]+")) {
				// s1=s1.concat(main.substring(p,p+1));
				ex = main.substring(p, p + 1);
				p = 3;
				if (main.substring(p, p + 1).matches("[0-9]+")) {
					// s1=s1.concat(main.substring(p,p+1));
					ex = ex.concat(main.substring(p, p + 1));
					p = 4;
				}
				if (ex.length() == 1) {
					s1 = s1.concat("0" + ex);
				} else {
					s1 = s1.concat(ex);
				}

			}
			if (main.substring(p, p + 1).equals("$")) {
				p = p + 1;

			} else if (!main.substring(p, p + 1).matches("[0-9]+")) {
				s1 = s1.concat(main.substring(p, p + 1));
				p = p + 1;
				if (!main.substring(p, p + 1).matches("[0-9]+")) {
					s1 = s1.concat(main.substring(p, p + 1));
					p = p + 1;
				}
			}
			if (main.substring(p).length() > 0) {
				if (main.substring(p, p + 1).matches("[0-9]+")) {
					if (main.substring(p).length() == 3) {
						s1 = s1.concat("0" + main.substring(p));
					} else if (main.substring(p).length() == 2) {
						s1 = s1.concat("00" + main.substring(p));
					} else if (main.substring(p).length() == 3) {
						s1 = s1.concat("000" + main.substring(p));
					} else if (main.substring(p).length() == 4) {
						s1 = s1.concat(main.substring(p));
					} else {
						confirm = 0;
					}

				}
			}
		}
		if (confirm == 1) {
			temp.append(s1);
		} else {
			//temp.append(" ,");
		}
		
		return temp.toString().toUpperCase();
		
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * AttachmentMappingDAO attachDAO = new AttachmentMappingDAO(); List
		 * myList = attachDAO.showAll();
		 * 
		 * HttpSession session = request.getSession();
		 * session.setAttribute("myList", myList);
		 */
		// response.sendRedirect("admin/layout1/dashboard.jsp");

	}

}
