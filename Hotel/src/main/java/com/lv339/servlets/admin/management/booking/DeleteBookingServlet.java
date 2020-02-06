package com.lv339.servlets.admin.management.booking;

import com.lv339.service.management.BookingService;
import com.lv339.service.management.HotelService;
import com.lv339.servlets.admin.management.hotel.DeleteHotelServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-booking")
public class DeleteBookingServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(DeleteHotelServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        int id = Integer.parseInt(req.getParameter("id"));
        bookingService.deleteBooking(id);
        req.getRequestDispatcher("/admin/delete-booking.jsp").include(req, resp);
    }
}
