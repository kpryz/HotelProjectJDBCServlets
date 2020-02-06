package com.lv339.servlets.filters;

import com.lv339.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerManagementAuthenticationFilter implements Filter {
    static private Logger logger = Logger.getLogger(CustomerManagementAuthenticationFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("CustomerManagementAuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        logger.info("Requested Resource::" + uri);

        HttpSession session = req.getSession(false);
        User user;

        if (session != null) {
            if ((user = (User) session.getAttribute("User")) != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                logger.error("Unauthorized access request to customer management panels");
                res.sendRedirect("../login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
