package com.lv339.servlets.admin.management.booking;

import com.lv339.entity.Booking;
import com.lv339.entity.Hotel;
import com.lv339.service.management.BookingService;
import com.lv339.service.management.HotelService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/add-booking")
public class AddBookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        Booking booking = new Booking();
        booking.setCustomer_email(req.getParameter("email"));
        booking.setComment(req.getParameter("comment"));
        booking.setStartDate(LocalDate.parse(req.getParameter("startDate")));
        booking.setEndDate(LocalDate.parse(req.getParameter("endDate")));
        String hotel = req.getParameter("hotel");
        short roomNumber = Short.parseShort(req.getParameter("roomNumber"));

        bookingService.insertBooking(booking,hotel,roomNumber);
        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/add-booking.jsp");
        rq.include(req, resp);
    }

}
