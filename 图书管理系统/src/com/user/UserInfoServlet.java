package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet(description = "用户资料修改", urlPatterns = { "/UserInfoServlet" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
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
		try{
			HttpSession session = request.getSession();
			UserInfoBean user=(UserInfoBean) session.getAttribute("user");
			String tel=user.getTel();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","root");
			PreparedStatement ps=con.prepareStatement("update reader_info set  "
						+ "username=?,"
						+ "sex=?,"
						+ "remark=?,"
						+ "papertype=?,"
						+ "paperNO=?,"
						+ "birthday=?,"
						+ "email=?"
						+ " WHERE tel=?;");
				ps.setString(1, request.getParameter("userName"));
				ps.setString(2, request.getParameter("sex"));
				ps.setString(3, request.getParameter("remark"));
				ps.setString(4, request.getParameter("papertype"));
				ps.setString(5, request.getParameter("paperNO"));
				ps.setString(6, request.getParameter("birthday"));
				ps.setString(7, request.getParameter("email"));
				ps.setString(8, tel);
				int s=ps.executeUpdate();
				if(s>0){
					out.println("<script language=javascript> alert('修改成功!'); window.location.href='login.jsp';</script>" );
				}else{
					out.println("<script language=javascript> alert('修改失败!'); window.location.href='login.jsp';</script>" );
				}
				ps.close();
			    con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
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