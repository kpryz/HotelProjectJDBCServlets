package com.lv339.servlets.admin.management.customer;

import com.lv339.service.MessageForOutput;
import com.lv339.service.management.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-customer")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        CustomerService customerService = new CustomerService();

        customerService.deleteCustomer(email);

        MessageForOutput.setMessageToRequest(req);
        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/delete-customer.jsp");
        rq.include(req, resp);
    }
}
