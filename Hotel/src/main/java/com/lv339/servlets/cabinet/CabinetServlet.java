package com.lv339.servlets.cabinet;

import com.lv339.entity.Booking;
import com.lv339.entity.Customer;
import com.lv339.entity.User;
import com.lv339.service.management.BookingService;
import com.lv339.service.management.CustomerService;
import com.lv339.service.management.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cabinet")
public class CabinetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer;
        User user;
        BookingService bookingService = new BookingService();
        CustomerService customerService = new CustomerService();

        List<Booking> bookings = null;
        if ((customer = (Customer) session.getAttribute("Customer")) != null) {
            bookings = bookingService.getAllBookings(customer);
            UserService userService = new UserService();
            req.setAttribute("User", userService.getUser(customer.getUser_email()));
            bookings = bookingService.getAllBookings(customer);

        } else if ((user = (User) session.getAttribute("User")) != null) {
            List<Customer> customers = customerService.getCustomers(user.getEmail());
            bookings = bookingService.getAllBookings(user);
            req.setAttribute("CustomerList", customers);
        }

        req.setAttribute("BookingList", bookings);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/cabinet.jsp");
        rd.include(req, resp);
    }
}
