<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.manager.LookHistoryBean" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lendInfo/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借阅历史</title>
</head>
<body>
<table class="libtypeContent" style="width:500px;">
<tr><td>借书读者编号</td><td>借书时间</td></tr>
<% Object list=request.getAttribute("list");
if(list instanceof List<?>){
	List<LookHistoryBean> list1=(List<LookHistoryBean>)list;
if(list1!=null&&list1.size()>0){
	for(LookHistoryBean lookHistoryBean:list1){ %>
<tr>
<td><a  style="text-decoration:none;" target="_blank" href="<%=request.getContextPath()%>/ReaderDetailsServlet?readerId=<%=lookHistoryBean.getReaderId() %>"><%=lookHistoryBean.getReaderId() %></a></td>
<td><%=lookHistoryBean.getStartTime() %></td></tr>
	<%
	}
}
} %>
</table>
</body>
</html>