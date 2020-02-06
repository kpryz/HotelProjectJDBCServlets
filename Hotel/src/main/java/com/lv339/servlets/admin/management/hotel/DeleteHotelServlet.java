package com.lv339.servlets.admin.management.hotel;


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

@WebServlet("/admin/delete-hotel")
public class DeleteHotelServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(DeleteHotelServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelService hotelService = new HotelService();
        String name = req.getParameter("name");
        hotelService.deleteHotel(name);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/delete-hotel.jsp");
        rq.include(req, resp);
    }
}
