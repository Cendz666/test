package com.aboutlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutLibDao {
	/**
	 * 获取数据库连接
	 * @return Connection对象
	 */
	public Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/lib";
			String username="root";
			String password="root";
			conn=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
	public LibraryBean getLibrary(){
		LibraryBean library=new LibraryBean();
		try {
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from library;");
			ResultSet res=ps.executeQuery();
			while(res.next()){
				library.setName(res.getString("name"));
				library.setLibrarier(res.getString("librarier"));
				library.setLinkTel(res.getString("link_tel"));
				library.setLinkEmail(res.getString("link_email"));
				library.setLinkAddress(res.getString("link_address"));
				library.setLibWebsite(res.getString("lib_website"));
				library.setBuildTime(res.getString("build_time"));
				library.setSummary(res.getString("summary"));
				library.setOpenTimeOnWeekday(res.getString("opentime_onweekday"));
				library.setEndTimeOnWeekday(res.getString("endtime_onweekday"));
				library.setOpenTimeOnWeekend(res.getString("opentime_onweekend"));
				library.setEndTimeOnWeekend(res.getString("endtime_onweekend"));
				}
			ps.close();
			conn.close();
			}catch(SQLException e) {
					// TODO 自动生成的 catch 块
				e.printStackTrace();
				}
		return library;
		}

	}

