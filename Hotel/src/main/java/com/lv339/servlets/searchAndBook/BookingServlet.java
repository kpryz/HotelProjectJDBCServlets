package com.lv339.servlets.searchAndBook;

import com.lv339.entity.Booking;
import com.lv339.entity.Customer;
import com.lv339.entity.User;
import com.lv339.service.management.BookingService;
import com.lv339.service.management.CustomerService;
import com.lv339.service.management.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/booking")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        String userEmail = user.getEmail();

        CustomerService customerService = new CustomerService();
        List<Customer> customers = customerService.getCustomers(userEmail);

        req.setAttribute("Customers", customers);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/booking-modal.jsp");
        rq.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        String userEmail = user.getEmail();
        String searchQuery = req.getParameter("searchQuery");
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
        byte numberOfPeople = Byte.parseByte(req.getParameter("numberOfPeople"));
        String customerEmail = req.getParameter("selectedCustomer");

        BookingService bookingService = new BookingService();
        CustomerService customerService = new CustomerService();
        RoomService roomService = new RoomService();

        Booking booking = new Booking(startDate, endDate, "", customerEmail, roomId);

        RequestDispatcher rq;
        if (bookingService.insertBooking(booking, roomId)) {
            req.setAttribute("BookingStatus","success");
        } else {
            req.setAttribute("BookingStatus","failed");
        }
        rq = getServletContext().getRequestDispatcher("/booking-success.jsp");
        rq.include(req, resp);
    }
}
