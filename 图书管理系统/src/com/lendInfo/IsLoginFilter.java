package com.lendInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.UserInfoBean;

/**
 * Servlet Filter implementation class LendInfoFilter
 */
@WebFilter(description = "进行图书操作前检查用户登录状态",
filterName="LendInfoFilter",
urlPatterns={"/lendInfo/lendBook.jsp","/lendInfo/renewBook.jsp","/lendInfo/returnBook.jsp"},
initParams={
		@WebInitParam(name="",value="")
})
public class IsLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IsLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		response.setContentType("text/html;charset=utf-8");
		HttpServletResponse res =(HttpServletResponse)response;
		PrintWriter out=res.getWriter();
		HttpServletRequest req=(HttpServletRequest) request;
		request.setCharacterEncoding("utf-8");
		HttpSession session = (HttpSession)req.getSession();
		UserInfoBean user=(UserInfoBean) session.getAttribute("user");
		if(user==null){
			out.print("<script language=javascript >alert('请先登录账号!');window.location.href='../login.jsp'</script>");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
