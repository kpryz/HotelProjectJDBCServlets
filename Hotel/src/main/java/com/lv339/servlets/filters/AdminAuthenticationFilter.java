package com.lv339.servlets.filters;

import com.lv339.entity.User;
import com.lv339.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminAuthenticationFilter implements Filter {
    private Logger logger = Logger.getLogger(AdminAuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("AdminAuthenticationFilter initialized");
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
            if ((user = (User) session.getAttribute("User")) != null) {
                if (user.getUserRole() == UserRole.ROLE_ADMIN) {

                    filterChain.doFilter(servletRequest, servletResponse);

                } else {
                    logger.error("Authorized user doesn't have correspondent access rights");
                    res.sendRedirect("../login.jsp");
                }
            } else {
                logger.error("Unauthorized access request to admin panel");
                res.sendRedirect("../login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
