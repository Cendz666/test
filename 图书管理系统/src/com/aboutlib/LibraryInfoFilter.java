package com.aboutlib;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LibraryInfoFilter
 */
@WebFilter(description = "生成保存图书馆信息的session", 
urlPatterns = { "/index.jsp" })
public class LibraryInfoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LibraryInfoFilter() {
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
		HttpServletRequest req=(HttpServletRequest) request;
		request.setCharacterEncoding("utf-8");
		HttpSession session = (HttpSession)req.getSession();
		LibraryBean library=(LibraryBean) session.getAttribute("library");
		if(library==null){
			AboutLibDao aboutLib =new AboutLibDao();
			library=aboutLib.getLibrary();
			session.setAttribute("library",library);
			session.setMaxInactiveInterval(60*60*3);
		}
			chain.doFilter(request, response);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
