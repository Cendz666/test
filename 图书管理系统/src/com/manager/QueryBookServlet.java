package com.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lendInfo.LibInfoBean;

/**
 * @Servlet implementation class QueryBookServlet
 */
@WebServlet(description = "显示查询结果", urlPatterns = { "/QueryBookServlet" })
public class QueryBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBookServlet() {
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
		HttpSession session = (HttpSession)request.getSession();
		String user=(String) session.getAttribute("user");
		if(user==null){
			out.print("<script language=javascript >alert('请先登录账号!');window.location.href='manager/login.jsp';</script>");
		}else{
			String libtype=request.getParameter("libtype");
			String libname=request.getParameter("libname");
			int typeid =Integer.parseInt(libtype);
			ManagerDao manager=new ManagerDao();
			List<LibInfoBean> list=manager.find(typeid, libname);
			request.setAttribute("list", list);
			request.getRequestDispatcher("manager/managerLib.jsp").forward(request,response);
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
