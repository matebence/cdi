package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.inject.Named;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.Filter;

@Named(value = "visitorCounterFilter")
@WebFilter(filterName = "VisitorCounterFilter")
public class VisitorCounterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
