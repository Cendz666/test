package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegeditServlet
 */
@WebServlet(description = "用户注册业务", urlPatterns = { "/UserRegeditServlet" })
public class UserRegeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegeditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","root");
			PreparedStatement ps=con.prepareStatement("select * from reader_info where tel=?");
			ps.setString(1, request.getParameter("tel"));
			ResultSet res=ps.executeQuery();
			if(res.next()){
				ps.close();
				con.close();
				out.print("<script> alert('该账号已被注册过!'); window.open('regedit.jsp','_self'); </script>;");
			}else{
			PreparedStatement ps1=con.prepareStatement("INSERT INTO reader_info"
					+ "(username,password,tel,regedit_time) VALUES(?,?,?,Now())");
			request.setCharacterEncoding("utf-8");
			ps1.setString(1, request.getParameter("userName"));
		    ps1.setString(2, request.getParameter("userPsd"));
			ps1.setString(3, request.getParameter("tel"));
		    ps1.executeUpdate();
			ps1.close();
			con.close();
			out.print("<script> alert('注册成功!登录试试？'); window.open('login.jsp','_self'); </script>;");
			}	
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
