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

@WebServlet("/admin/update-hotel")
public class UpdateHotelServlet extends HttpServlet{
    private static Logger logger = Logger.getLogger(UpdateHotelServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelService hotelService= new HotelService();
        Hotel hotel = new Hotel();

        String oldName = req.getParameter("oldName");
        String newName = req.getParameter("newName");
        String country = req.getParameter("country");
        String city = req.getParameter("street");
        byte stars = Byte.parseByte(req.getParameter("stars"));
        String street = req.getParameter("street");
        String image = req.getParameter("imageUrl");

        hotel.setName(newName);
        hotel.setCountry(country);
        hotel.setCity(city);
        hotel.setStars(stars);
        hotel.setStreet(street);
        hotel.setImageUrl(image);
        hotelService.updateHotel(hotel,oldName);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/update-hotel.jsp");
        rq.include(req, resp);
    }
}
