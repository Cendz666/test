package com.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aboutlib.AboutLibDao;
import com.aboutlib.LibraryBean;

/**
 * Servlet implementation class ManagerLogin
 */
@WebServlet(description = "管理员登录", urlPatterns = { "/ManagerLoginServlet" })
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
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
		String user=request.getParameter("tel");
		String password=request.getParameter("userPsd");
		ManagerDao manager=new ManagerDao();
		if(manager.login(user, password)){
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(60*60*24);
			session.setAttribute("user", user);
			AboutLibDao aboutLib=new AboutLibDao();
			LibraryBean library=aboutLib.getLibrary();
			session.setAttribute("library", library);
			request.getRequestDispatcher(("manager/managerIndex.jsp")).forward(request, response);
		}else{
			out.println("<script language=javascript> alert('请输入正确的管理者账号或密码！'); window.location.href='manager/login.jsp';</script>" );
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
