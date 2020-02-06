package com.lv339.servlets.filters;


import com.lv339.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CabinetAuthenticationFilter implements Filter {
    private Logger logger = Logger.getLogger(CabinetAuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("CabinetAuthenticationFilter initialized");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        logger.info("Requested Resource::" + uri);

        HttpSession session = req.getSession(false);
        User user;

        if (session != null) {
            if (session.getAttribute("User") == null && session.getAttribute("Customer") == null) {
                logger.error("Unauthorized access request to cabinet page");
                res.sendRedirect("login.jsp");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
