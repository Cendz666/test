package com.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibServlet
 */
@WebServlet(description = "�������Ա�ύ���޸���Ϣ", urlPatterns = { "/LibraryServlet" })
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String buildTime=request.getParameter("buildTime");
		String libWebsite=request.getParameter("libWebsite");
		String openTimeOnWeekday=request.getParameter("openTimeOnWeekday");
		String openTimeOnWeekend=request.getParameter("openTimeOnWeekend");
		String endTimeOnWeekday=request.getParameter("endTimeOnWeekday");
		String endTimeOnWeekend=request.getParameter("endTimeOnWeekend");
		String librarier=request.getParameter("librarier");
		String linkTel=request.getParameter("linkTel");
		String linkEmail=request.getParameter("linkEmail");
		String linkAddress=request.getParameter("linkAddress");
		String summary=request.getParameter("summary");
		ManagerDao manager=new ManagerDao();
		manager.submitLibInfo(name, buildTime, libWebsite,
		openTimeOnWeekday, endTimeOnWeekday, openTimeOnWeekend, 
		endTimeOnWeekend, librarier, linkTel, linkEmail, linkAddress, summary);
		out.println("<script>alert('�ύ�ɹ�!');window.location.href='manager/login.jsp';</script>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
