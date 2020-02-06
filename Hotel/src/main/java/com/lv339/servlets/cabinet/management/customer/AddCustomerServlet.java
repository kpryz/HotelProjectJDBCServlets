package com.lv339.servlets.cabinet.management.customer;

import com.lv339.entity.Customer;
import com.lv339.entity.User;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-customer")
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        CustomerService customerService = new CustomerService();

        customer.setEmail(req.getParameter("email"));
        customer.setFirstName(req.getParameter("firstName"));
        customer.setLastName(req.getParameter("lastName"));
        customer.setPassword(req.getParameter("password"));
        customer.setContactNumber(req.getParameter("phoneNumber"));

        User user = (User) req.getSession().getAttribute("User");
        String connectedUserEmail = user.getEmail();

        customerService.insertCustomer(customer, connectedUserEmail);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/add-customer.jsp");
        rq.include(req, resp);
    }
}
