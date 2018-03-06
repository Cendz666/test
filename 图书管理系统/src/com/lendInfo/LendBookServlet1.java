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
 * Servlet implementation class LendBookServlet1
 */
@WebServlet(description = "提交结果后的处理", urlPatterns = { "/LendBookServlet1" })
public class LendBookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendBookServlet1() {
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
		String[] libIds=request.getParameterValues("wantlend");
		LibInfoDao libInfo=new LibInfoDao();
		HttpSession session = (HttpSession)request.getSession();
		UserInfoBean user=(UserInfoBean) session.getAttribute("user");
		if(user!=null){
			int	readerId=user.getId();
			for(int i=0;i<libIds.length;i++){
				libInfo.submit(Integer.parseInt(libIds[i]), readerId);			}
		}else{
			out.print("<script language=javascript >alert('请先登录账号!');window.location.href='login.jsp'</script>");
		}
		out.print("<script language=javascript >alert('提交成功!');window.location.href='LendBookServlet?libtype=0&libname='</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
