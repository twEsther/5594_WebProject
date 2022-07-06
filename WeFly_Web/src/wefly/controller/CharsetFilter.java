package wefly.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharsetFilter
 */
//@WebFilter ({ "*.jsp", "*.do" })
@WebFilter(urlPatterns={ "*.jsp", "*.do" }, dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.ERROR})
public class CharsetFilter implements Filter {


    public CharsetFilter() {
    }

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println(LocalDateTime.now());
		
		request.setCharacterEncoding("UTF-8");
		request.getParameterNames();//鎖定request的CharacterEncoding
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter();//鎖定response的CharacterEncoding
		
		chain.doFilter(request, response); //交棒給原來的jsp或servlet
		//System.out.println(LocalDateTime.now());
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
