package com.lv339.servlets.admin.management.customer;

import com.lv339.dao.CustomerDAO;
import com.lv339.entity.Customer;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.CustomerService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update-customers")
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        CustomerService customerService = new CustomerService();

        String oldEmail = req.getParameter("email");
        String newEmail = req.getParameter("newEmail");

        customer.setEmail(newEmail.equals("") ? oldEmail : newEmail);
        customer.setFirstName(req.getParameter("firstName"));
        customer.setLastName(req.getParameter("lastName"));
        customer.setPassword(req.getParameter("password"));
        customer.setContactNumber(req.getParameter("phoneNumber"));

        customerService.updateCustomer(customer, oldEmail);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/update-customer.jsp");
        rq.include(req, resp);
    }
}
