package com.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.lendInfo.LibInfoBean;
import com.user.UserInfoBean;

public class ManagerDao {
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
	
	public boolean login(String username,String password){
		boolean bool=true;
		Connection conn=getConnection();
			try {
				String pwd = null;
				PreparedStatement ps=conn.prepareStatement("SELECT * "
						+ "from admin "
						+ "where username=?;");
				ps.setString(1,username);
				ResultSet res=ps.executeQuery();
				while(res.next()){
					pwd=res.getString("password");
				}
				if(pwd!=null&&pwd.equals(password)){
					bool=true;
				}else{
					bool=false;
				}
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return bool;
	}
	
	public void submitLibInfo(String name,String buildTime,String libWebsite,
			String openTimeOnWeekday,String endTimeOnWeekday,
			String openTimeOnWeekend,String endTimeOnWeekend,
			String librarier,String linkTel,String linkEmail,
			String linkAddress,String summary){
		Connection conn=getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("update library set "
					+ "name=?,"
					+ "librarier=?,"
					+ "link_tel=?,"
					+ "link_email=?,"
					+ "link_address=?,"
					+ "lib_website=?,"
					+ "build_time=?,"
					+ "summary=?,"
					+ "opentime_onweekday=?,"
					+ "opentime_onweekend=?,"
					+ "endtime_onweekday=?,"
					+ "endtime_onweekend=? "
					+ "where id=1;");
			ps.setString(1,name);
			ps.setString(2,librarier);
			ps.setString(3,linkTel);
			ps.setString(4,linkEmail);
			ps.setString(5,linkAddress);
			ps.setString(6,libWebsite);
			ps.setString(7,buildTime);
			ps.setString(8,summary);
			ps.setString(9,openTimeOnWeekday);
			ps.setString(10,openTimeOnWeekend);
			ps.setString(11,endTimeOnWeekday);
			ps.setString(12,endTimeOnWeekend);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 显示所有图书信息
	 * @param typeid
	 * @param bookname
	 * @return
	 */
	public List<LibInfoBean> find(int typeid,String bookname){
		List<LibInfoBean> list=new ArrayList<>();
		Connection coon=getConnection();
		try{
			PreparedStatement ps=null;
			if(bookname==""){
				if(typeid==0){
					ps=coon.prepareStatement("select lib1.*,lib2.typename "
							+ " from lib_info AS lib1,lib_type AS lib2 "
							+ " where lib1.typeid=lib2.id"
							+ " AND lib1.isdeleted=0"
							+ " ORDER BY lib1.been_lended_times DESC;");
				}else{
					ps=coon.prepareStatement("select lib1.*,lib2.typename "
							+ " from lib_info AS lib1,lib_type AS lib2 "
							+ " where lib1.typeid=lib2.id"
							+ " AND lib1.typeid=?"
							+ " AND lib1.isdeleted=0"
							+ " ORDER BY lib1.been_lended_times DESC;");
					ps.setInt(1,typeid );
				}
			}else{
				if(typeid==0){
					ps=coon.prepareStatement("select lib1.*,lib2.typename "
							+ " from lib_info AS lib1,lib_type AS lib2 "
							+ " where lib1.typeid=lib2.id"
							+ " AND lib1.bookname REGEXP ?"
							+ " AND lib1.isdeleted=0"
							+ " ORDER BY lib1.been_lended_times DESC;");
					ps.setString(1,bookname );
				}else{
					ps=coon.prepareStatement("select lib1.*,lib2.typename "
							+ " from lib_info AS lib1,lib_type AS lib2 "
							+ " where lib1.typeid=lib2.id"
							+ " AND lib1.typeid=?"
							+ " AND lib1.bookname REGEXP ?"
							+ " AND lib1.isdeleted=0"
							+ " ORDER BY lib1.been_lended_times DESC;");
					ps.setInt(1,typeid );
					ps.setString(2,bookname );
				}
			}

			ResultSet res=ps.executeQuery();
			while(res.next()){
				LibInfoBean libInfo =new LibInfoBean();
				libInfo.setId(res.getInt("id"));
				libInfo.setBarcode(res.getString("barcode"));
				libInfo.setBookname(res.getString("bookname"));
				libInfo.setAuthor(res.getString("author"));
				libInfo.setTranslator(res.getString("translator"));
				libInfo.setPrice(res.getDouble("price"));
				libInfo.setPage(res.getString("page"));
				libInfo.setBookcase(res.getString("bookcase"));
				libInfo.setGetInTime(res.getString("getInTime"));
				libInfo.setTypeid(res.getInt("typeid"));
				libInfo.setTypename(res.getString("typename"));
				libInfo.setCanReadDays(res.getInt("can_read_days"));
				libInfo.setBeenLendedTimes(res.getInt("been_lended_times"));
				libInfo.setIsLended(res.getInt("islended"));
				list.add(libInfo);
			}
			ps.close();
			coon.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public LibDetailsBean lookDetails(int id0) {
		// TODO 自动生成的方法存根
		LibDetailsBean libDetailsBean=new LibDetailsBean();
		Connection coon=getConnection();
		try{
			PreparedStatement ps=coon.prepareStatement("select lib1.*,lib2.typename "
					+ "from lib_info AS lib1,lib_type AS lib2 "
					+ "where lib1.id=? "
					+ "AND lib1.isdeleted=0 "
					+ "AND lib1.typeid=lib2.id");
			ps.setInt(1, id0);
			ResultSet res=ps.executeQuery();
			while(res.next()){
				libDetailsBean.setId(res.getInt("id"));
				libDetailsBean.setBarcode(res.getString("barcode"));
				libDetailsBean.setBookname(res.getString("bookname"));
				libDetailsBean.setAuthor(res.getString("author"));
				libDetailsBean.setTranslator(res.getString("translator"));
				libDetailsBean.setPrice(res.getDouble("price"));
				libDetailsBean.setPage(res.getString("page"));
				libDetailsBean.setBookcase(res.getString("bookcase"));
				libDetailsBean.setGetInTime(res.getString("getInTime"));
				libDetailsBean.setTypeid(res.getInt("typeid"));
				libDetailsBean.setTypename(res.getString("typename"));
				libDetailsBean.setCanReadDays(res.getInt("can_read_days"));
				libDetailsBean.setBeenLendedTimes(res.getInt("been_lended_times"));
				libDetailsBean.setIsLended(res.getInt("islended"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return libDetailsBean;
	}
	
	public int alterLib(int libId,String barcode,String bookname,String author,
			String translator,String price, String page, String bookcase,
			int typeid,int canReadDays){
		int n=0;
		Connection conn=getConnection();
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("UPDATE lib_info set"
						+ " barcode=?,bookname=?,author=?,translator=?,price=?,page=?,bookcase=?,"
						+ "typeid=?,can_read_days=? "
						+ "where id=?;");
			ps.setString(1,barcode);
			ps.setString(2,bookname);
			ps.setString(3,author);
			ps.setString(4,translator);
			ps.setString(5,price);
			ps.setString(6,page);
			ps.setString(7,bookcase);
			ps.setInt(8,typeid);
			ps.setInt(9,canReadDays);
			ps.setInt(10,libId);
			n=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return n;
	}
	
	public int delete(int libId){
		int n=0;
		Connection conn=getConnection();
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("update lib_info set isdeleted=1 where id=?;");
				ps.setInt(1,libId);
				n=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return n;
	}
	
	public List<LookHistoryBean> lookHistory(int libId){
		List<LookHistoryBean> list=new ArrayList<>();
		LookHistoryBean lookHistoryBean=new LookHistoryBean();
		try{
			Connection coon=getConnection();
			PreparedStatement ps=coon.prepareStatement("select id,reader_id,Date(startTime) AS startTimeDate "
					+ "from lend_info "
					+ "where lib_id=? "
					+ "ORDER BY startTime DESC;");
			ps.setInt(1, libId);
			ResultSet res=ps.executeQuery();
			while(res.next()){
				lookHistoryBean.setLendInfoId(res.getInt("id"));
				lookHistoryBean.setReaderId(res.getInt("reader_id"));
				lookHistoryBean.setStartTime(res.getDate("startTimeDate"));
				list.add(lookHistoryBean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public UserInfoBean readerDetails(int readerId){
		UserInfoBean userInfo=new UserInfoBean();
		try{
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM reader_info WHERE id=?;");
			ps.setInt(1,readerId);
			ResultSet res=ps.executeQuery();
			while(res.next()){
				userInfo.setId(res.getInt("id"));
				userInfo.setUserName(res.getString("username"));
				userInfo.setPassword(res.getString("password"));
				userInfo.setSex(res.getString("sex"));
				userInfo.setBirthday(res.getString("birthday"));
				userInfo.setPapertype(res.getString("papertype"));
				userInfo.setPaperNO(res.getString("paperNO"));
				userInfo.setTel(res.getString("tel"));
				userInfo.setEmail(res.getString("email"));
				userInfo.setRemark(res.getString("remark"));
				userInfo.setRegeditTime(res.getDate("regedit_time"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public int addLib(String barcode,String bookname,String author,
			String translator,	String price, String page, String bookcase,
			int typeid ,int canReadDays){
		int n=0;
		Connection conn=getConnection();
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("insert into lib_info"
						+ "(barcode,bookname,author,translator,price,page,bookcase,"
						+ "getInTime,typeid,can_read_days)"
						+ "VALUES(?,?,?,?,?,?,?,Now(),?,?)");
			ps.setString(1,barcode);
			ps.setString(2,bookname);
			ps.setString(3,author);
			ps.setString(4,translator);
			ps.setString(5,price);
			ps.setString(6,page);
			ps.setString(7,bookcase);
			ps.setInt(8,typeid);
			ps.setInt(9,canReadDays);
			n=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return n;
	}
}
