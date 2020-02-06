package com.lv339.servlets.admin.management.user;

import com.lv339.dao.UserDAO;
import com.lv339.entity.User;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/users")
public class AdminGetUsers extends HttpServlet{
    private static Logger logger = Logger.getLogger(AdminGetUsers.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users;
        UserService userService = new UserService();

        users = userService.getAllUsers();
        MessageForOutput.setMessageToRequest(req);

        req.setAttribute("Users", users);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/users.jsp");
        dispatcher.include(req, resp);
    }
}
