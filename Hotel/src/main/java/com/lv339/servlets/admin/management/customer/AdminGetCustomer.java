package com.lv339.servlets.admin.management.customer;

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
import java.util.List;

@WebServlet("/admin/customers")
public class AdminGetCustomer extends HttpServlet {
    private static Logger logger = Logger.getLogger(AdminGetCustomer.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();

        List<Customer> customers = customerService.getAllCustomers();
        MessageForOutput.setMessageToRequest(req);

        req.setAttribute("Customers", customers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/customers.jsp");
        dispatcher.include(req, resp);
    }
}
