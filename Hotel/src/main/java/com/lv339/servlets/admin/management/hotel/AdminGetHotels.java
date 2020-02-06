package com.lv339.servlets.admin.management.hotel;

import com.lv339.entity.Hotel;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.HotelService;
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

@WebServlet("/admin/hotels")
public class AdminGetHotels extends HttpServlet{
    private static Logger logger = Logger.getLogger(AdminGetHotels.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelService hotelService = new HotelService();
        List<Hotel> hotels = new ArrayList<>();
        hotels = hotelService.getAllHotels();
        MessageForOutput.setMessageToRequest(req);
        req.setAttribute("list", hotels);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/hotels.jsp");
        dispatcher.include(req, resp);
    }
}
