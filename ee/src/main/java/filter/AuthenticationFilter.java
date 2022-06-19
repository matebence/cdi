package filter;

import javax.servlet.http.HttpServletResponse;
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

@Named(value = "authenticationFilter")
@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            System.out.println("No session attribute");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
