package com.lendInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.UserInfoBean;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet(description = "展示借过的书", urlPatterns = { "/ReturnBookServlet" })
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
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
		UserInfoBean user=(UserInfoBean) session.getAttribute("user");
		if(user==null){
			out.print("<script language=javascript >alert('请先登录账号!');window.location.href='login.jsp'</script>");
		}else{
			int id=user.getId();
			LibInfoDao libInfo=new LibInfoDao();
			List<LibInfoBean> list=libInfo.returnBook(id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("lendInfo/returnBook.jsp").forward(request,response);
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
