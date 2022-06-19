package filter;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.inject.Named;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.DispatcherType;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.Filter;
import java.io.IOException;

/* initParams is used in servlet via getInitParameter("test") */

@Named(value = "simpleParameterLoggingFilter")
@WebFilter(
        description = "Filter whole application",
        filterName = "SimpleParameterLoggingFilter",
        initParams = @WebInitParam(name = "test", value = "filtering"),
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class SimpleParameterLoggingFilter implements Filter {

    public SimpleParameterLoggingFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) {
    }

    @Override
    public void destroy() {
    }
}
