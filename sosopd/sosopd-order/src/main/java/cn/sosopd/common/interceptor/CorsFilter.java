package cn.sosopd.common.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;

		hresponse.addHeader("Access-Control-Allow-Origin", "*");
		hresponse.addHeader("Access-Control-Allow-Headers",
				"origin, content-type, accept, authorization, x-requested-with");
		hresponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		hresponse.addHeader("Access-Control-Max-Age", "1209600");
		hresponse.addHeader("Access-Control-Allow-Credentials", "true");

		chain.doFilter(hrequest, hresponse);
	}

	@Override
	public void destroy() {
	}

}