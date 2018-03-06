package com.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.UserInfoBean;

/**
 * Servlet implementation class ReaderDetailsServlet
 */
@WebServlet(description = "查看用户信息", urlPatterns = { "/ReaderDetailsServlet" })
public class ReaderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String readerId=request.getParameter("readerId");
		int readerId0=Integer.parseInt(readerId);
		ManagerDao managerDao=new ManagerDao();
		UserInfoBean userInfo=managerDao.readerDetails(readerId0);
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("manager/readerInfo.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
