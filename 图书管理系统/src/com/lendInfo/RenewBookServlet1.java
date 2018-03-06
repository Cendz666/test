package com.lendInfo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.UserInfoBean;

/**
 * Servlet implementation class RenewBookServlet1
 */
@WebServlet(description = "续借后的业务处理", urlPatterns = { "/RenewBookServlet1" })
public class RenewBookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenewBookServlet1() {
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
		HttpSession session = (HttpSession)request.getSession();
		UserInfoBean user=(UserInfoBean) session.getAttribute("user");
		if(user==null){
			PrintWriter out=response.getWriter();
			out.print("<script language=javascript >alert('请先登录账号!');window.location.href='login.jsp'</script>");
		}else{
			String libId=request.getParameter("id");
			int libId0=Integer.parseInt(libId);
			String renewTime=request.getParameter("renewTime");
			int renewTime0=Integer.parseInt(renewTime);
			LibInfoDao libInfo=new LibInfoDao();
			libInfo.submit3(renewTime0,libId0);
     		request.getRequestDispatcher("lendInfo/return.html").forward(request, response);
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
