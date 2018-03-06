package com.lendInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActivityServlet2
 */
@WebServlet(description = "续借图书的查看详情", urlPatterns = { "/ActivityServlet2" })
public class ActivityServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityServlet2() {
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
		String id=request.getParameter("id");
		int id0 =Integer.parseInt(id);
		LibInfoDao libInfoDao=new LibInfoDao();
		LibInfoBean libInfo=libInfoDao.activity(id0);
		request.setAttribute("libInfo", libInfo);
		LendInfoBean lendInfo=libInfoDao.activity1(id0);
		request.setAttribute("lendInfo", lendInfo);
		request.getRequestDispatcher("lendInfo/activity2.jsp").forward(request,response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
