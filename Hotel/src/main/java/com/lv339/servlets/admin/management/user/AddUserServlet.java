package com.lv339.servlets.admin.management.user;

import com.lv339.dao.UserDAO;
import com.lv339.entity.User;
import com.lv339.entity.UserRole;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-user")
public class AddUserServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddUserServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UserService userService = new UserService();

        user.setEmail(req.getParameter("email"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        user.setUserRole(UserRole.valueOf(req.getParameter("userRole")));

        userService.insertUser(user);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/add-user.jsp");
        rq.include(req, resp);
    }
}
