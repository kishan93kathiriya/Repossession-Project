package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Example.ExcelToCSV;
import dao.AttachmentDAO;
import dao.AttachmentMappingDAO;
import dao.CSVImportDAO;
import dao.datasheetdao;
import vo.AttachmentMappingVO;
import vo.AttachmentVO;
import vo.LoginVo;

/**
 * Servlet implementation class AttachmentController
 */
@WebServlet("/MainController_old")
public class MainController_old extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController_old() {
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

		} else if (mode != null && mode.equals("1")) {
			insert(request, response);

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
