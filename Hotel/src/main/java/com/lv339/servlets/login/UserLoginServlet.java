package com.lv339.servlets.login;

import com.lv339.entity.IUser;
import com.lv339.service.MessageForOutput;
import com.lv339.service.login_logout.LoginService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(UserLoginServlet.class.getName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        LoginService loginService = new LoginService();

        IUser visitor = loginService.login(req.getSession(), email, password);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rd = null;
        if (visitor == null) {
            rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.include(req, resp);

        } else {
            resp.sendRedirect("/cabinet");
        }
    }
}
