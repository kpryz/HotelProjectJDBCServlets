package com.lv339.servlets.logout;

import com.lv339.service.login_logout.LogoutService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class UserLogoutServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(UserLogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogoutService logoutService = new LogoutService();

        logoutService.logout(req.getCookies(), req.getSession());
        resp.sendRedirect("login.jsp");
    }

}
