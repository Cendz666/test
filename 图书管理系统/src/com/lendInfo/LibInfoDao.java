package com.lendInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibInfoDao {
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
							+ " AND lib1.islended=0"
							+ " AND lib1.isdeleted=0"
							+ " ORDER BY lib1.been_lended_times DESC;");
				}else{
					ps=coon.prepareStatement("select lib1.*,lib2.typename "
							+ " from lib_info AS lib1,lib_type AS lib2 "
							+ " where lib1.typeid=lib2.id"
							+ " AND lib1.typeid=?"
							+ " AND lib1.islended=0"
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
							+ " AND lib1.islended=0"
							+ " AND lib1.isdeleted=0"
							+ " ORDER BY lib1.been_lended_times DESC;");
					ps.setString(1,bookname );
				}else{
					ps=coon.prepareStatement("select lib1.*,lib2.typename "
							+ " from lib_info AS lib1,lib_type AS lib2 "
							+ " where lib1.typeid=lib2.id"
							+ " AND lib1.typeid=?"
							+ " AND lib1.bookname REGEXP ?"
							+ " AND lib1.islended=0"
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
	/**
	 * 查看详情
	 * @param id
	 * @return
	 */
	public LibInfoBean activity(int id){
		LibInfoBean libInfo=new LibInfoBean();
		Connection coon=getConnection();
		try{
			 PreparedStatement ps=coon.prepareStatement("select lib1.*,lib2.typename "
				+ " from lib_info AS lib1,lib_type AS lib2 "
				+ " where lib1.typeid=lib2.id"
				+ " AND lib1.id=?"
				+ " AND lib1.isdeleted=0"
	        	+ " ORDER BY lib1.been_lended_times DESC;");
			ps.setInt(1,id );
			ResultSet res=ps.executeQuery();
			while(res.next()){
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
			}
			ps.close();
			coon.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return libInfo;
	}

	/**
	 * 借书后的业务处理
	 */
	public void submit(int libId,int readerId){
		Connection coon=getConnection();
		try{
			PreparedStatement ps1=coon.prepareStatement("insert into lend_info(lib_id,reader_id,startTime)"
					+ " values(?,?,now())");
			ps1.setInt(1,libId);
			ps1.setInt(2,readerId);
			ps1.executeUpdate();
			ps1.close();
			PreparedStatement ps2=coon.prepareStatement("update lib_info set islended=1,been_lended_times=1+been_lended_times where id=?;");
			ps2.setInt(1,libId);
			ps2.executeUpdate();
			ps2.close();
			coon.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示借过的书
	 * @param id
	 * @return
	 */
	public List<LibInfoBean> returnBook(int id){
		List<LibInfoBean> list=new ArrayList<>();
		Connection coon=getConnection();
		try{
			PreparedStatement ps=coon.prepareStatement("select lib2.* "
							+ " from lend_info AS lib1,lib_info AS lib2 "
							+ " where lib1.lib_id=lib2.id"
							+ " AND lib1.reader_id=?"
							+ " AND lib1.returned=0"
							+ " AND lib2.isdeleted=0;");
			ps.setInt(1,id );
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
	
	/**
	 * 显示借书详情
	 * @param id
	 * @return
	 */
	public LendInfoBean activity1(int id){
		LendInfoBean lendInfo=new LendInfoBean();
		Connection coon=getConnection();
		try{
			 PreparedStatement ps=coon.prepareStatement("select *"
				+ " from lend_info"
				+ " where lib_id=?"
				+ " AND returned=0");
			ps.setInt(1,id);
			ResultSet res=ps.executeQuery();
			while(res.next()){
				lendInfo.setId(res.getInt("id"));
				lendInfo.setLibId(res.getInt("lib_id"));
				lendInfo.setReaderId(res.getInt("reader_id"));
				lendInfo.setStartTime(res.getDate("startTime"));
				lendInfo.setReturned(res.getInt("returned"));
				lendInfo.setAddDays(res.getInt("add_days"));
			}
			ps.close();
			coon.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lendInfo;
	}
	
	public void submit2(int libId){
		Connection coon=getConnection();
		try{
			PreparedStatement ps1=coon.prepareStatement("update lib_info"
					+ " set islended=0"
					+ " where id=?;");
			ps1.setInt(1,libId);
			ps1.executeUpdate();
			ps1.close();
			PreparedStatement ps2=coon.prepareStatement("update lend_info"
					+ " set returned=1"
					+ " where lib_id=?"
					+ " ORDER BY startTime DESC;");
			ps2.setInt(1,libId);
			ps2.executeUpdate();
			ps2.close();
			coon.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void submit3(int renewTime,int libId){
		Connection coon=getConnection();
		try{
			PreparedStatement ps=coon.prepareStatement("update lend_info"
					+ " set add_days=(add_days+?)"
					+ " where lib_id=?"
					+ " AND returned=0;");
			ps.setInt(1,renewTime);
			ps.setInt(2,libId);
			ps.executeUpdate();
			ps.close();
			coon.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
