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

@WebServlet("/admin/add-hotel")
public class AddHotelServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddHotelServlet.class.getName());


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelService hotelService = new HotelService();
        Hotel hotel = new Hotel();
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        byte stars = Byte.parseByte(req.getParameter("stars"));
        String street = req.getParameter("street");
        String image = req.getParameter("imageUrl");

        hotel.setName(name);
        hotel.setCountry(country);
        hotel.setCity(city);
        hotel.setStars(stars);
        hotel.setStreet(street);
        if (image != null) {
            hotel.setImageUrl(image);
        }
        hotelService.insertHotel(hotel);
        MessageForOutput.setMessageToRequest(req);
        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/add-hotel.jsp");
        rq.include(req, resp);
    }

}
