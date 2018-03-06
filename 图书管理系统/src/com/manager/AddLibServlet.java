package com.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLibServlet
 */
@WebServlet(description = "管理员添加图书", urlPatterns = { "/AddLibServlet" })
public class AddLibServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLibServlet() {
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
		String barcode=request.getParameter("barcode");
		String bookname=request.getParameter("bookname");
		String author=request.getParameter("author");
		String translator=request.getParameter("translator");
		String price=request.getParameter("price");
		String page=request.getParameter("page");
		String bookcase=request.getParameter("bookcase");
		int    typeid=Integer.valueOf(request.getParameter("typename"));
		int    canReadDays=30;
		if(request.getParameter("canReadDays")!=""){
			canReadDays=Integer.valueOf(request.getParameter("canReadDays"));
		}
		ManagerDao manager=new ManagerDao();
		int n=manager.addLib(barcode, bookname, author, translator, 
				price, page, bookcase, typeid, canReadDays);
		if(n>0){
			out.print("<script>alert('添加成功!');window.location.href='QueryBookServlet?libtype=0&libname=';</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
