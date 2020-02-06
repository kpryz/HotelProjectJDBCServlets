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

@WebServlet("/admin/update-user")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UserService userService = new UserService();

        String oldEmail = req.getParameter("email");
        String newEmail = req.getParameter("newEmail");
        user.setEmail(newEmail.equals("") ? oldEmail : newEmail);
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        user.setUserRole(UserRole.valueOf(req.getParameter("userRole")));

        userService.updateUser(user, oldEmail);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/update-user.jsp");
        rq.include(req, resp);
    }
}
