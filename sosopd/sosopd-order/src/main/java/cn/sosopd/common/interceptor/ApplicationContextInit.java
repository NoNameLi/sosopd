package cn.sosopd.common.interceptor;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

/**
 * 初始化应用级别上下文
 */
public class ApplicationContextInit implements ServletContextAware {

    private ServletContext servletContext;

    private static final String CONTEXT_PATH_KEY = "contextPath";

    private static final String RESOURCE_PATH_KEY = "resources";

    private static final String RESOURCE_PATH_VALUE_PREFIX = "/resources-";

    /**
     * 静态资源映射根路径，spring-mvc.xml中需要用到这个变量，变量名不能随意变更，必须与spring-mvc.xml中同步修改
     */
    private String resourceRoot;

    public void init() throws IOException {
        // Web应用的上下文路径放到应用上下文中
        getServletContext().setAttribute(CONTEXT_PATH_KEY, getServletContext().getContextPath());

        // 所有视图中都可以通过【${resources}】取得静态资源映射路径
        // 每次服务器启动后映射为不同的路径，从而使得客户端浏览器的缓存失效
        resourceRoot = RESOURCE_PATH_VALUE_PREFIX + System.currentTimeMillis();
        getServletContext().setAttribute(RESOURCE_PATH_KEY, getServletContext().getContextPath() + resourceRoot);
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    /**
     * spring-mvc.xml中需要用到这个变量
     * 
     * @return
     */
    public String getResourceRoot() {
        return this.resourceRoot;
    }
}