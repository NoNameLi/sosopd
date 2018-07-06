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

    private static final String ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";
    private static final String ALLOW_ORIGIN_VALUE = "*";

    private static final String ALLOW_HEADERS_HEADER = "Access-Control-Allow-Headers";
    private static final String ALLOW_HEADERS_VALUE = "origin, content-type, accept, authorization, x-requested-with";

    private static final String ALLOW_METHODS_HEADER = "Access-Control-Allow-Methods";
    private static final String ALLOW_METHODS_VALUE = "GET, POST, PUT, DELETE, OPTIONS, HEAD";

    private static final String ALLOW_CREDENTIALS_HEADER = "Access-Control-Allow-Credentials";
    private static final String ALLOW_CREDENTIALS_VALUE = "true";

    private static final String MAX_AGE_HEADER = "Access-Control-Max-Age";
    private static final String MAX_AGE_VALUE = "1209600";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;

        hresponse.addHeader(ALLOW_ORIGIN_HEADER, ALLOW_ORIGIN_VALUE);
        hresponse.addHeader(ALLOW_HEADERS_HEADER, ALLOW_HEADERS_VALUE);
        hresponse.addHeader(ALLOW_METHODS_HEADER, ALLOW_METHODS_VALUE);
        hresponse.addHeader(MAX_AGE_HEADER, MAX_AGE_VALUE);
        hresponse.addHeader(ALLOW_CREDENTIALS_HEADER, ALLOW_CREDENTIALS_VALUE);

        chain.doFilter(hrequest, hresponse);
    }

    @Override
    public void destroy() {
    }

}