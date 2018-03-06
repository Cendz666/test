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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(description = "用户登录验证", urlPatterns = { "/UserLoginServlet" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
	 if(request.getParameter("tel")!=null&&request.getParameter("userPsd")!=null)
	  {
		try{
			UserInfoBean user=new UserInfoBean();
			String pwd=null;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","root");
			PreparedStatement ps=con.prepareStatement("SELECT * FROM reader_info WHERE tel=?;");
			ps.setString(1, request.getParameter("tel"));
			ResultSet res=ps.executeQuery();
			while(res.next()){
				pwd=res.getString("password");
				HttpSession session = request.getSession();
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setSex(res.getString("sex"));
				user.setBirthday(res.getString("birthday"));
				user.setPapertype(res.getString("papertype"));
				user.setPaperNO(res.getString("paperNO"));
				user.setTel(res.getString("tel"));
				user.setEmail(res.getString("email"));
				user.setRemark(res.getString("remark"));
				user.setRegeditTime(res.getDate("regedit_time"));
				session.setAttribute("user",user);
				session.setMaxInactiveInterval(60*60*3);
			}
			if(pwd!=null&&pwd.equals(request.getParameter("userPsd"))){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				out.println("<script language=javascript> alert('请输入正确的手机号或密码！'); window.location.href='login.jsp';</script>" );
			}
			ps.close();
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	 else{
		 out.println("<script language=javascript> alert('请输入手机号或密码！'); window.location.href='login.jsp';</script>" );
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
