package com.lv339.servlets;

import com.lv339.dao.HotelDAO;
import com.lv339.entity.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findhotels")
public class FindHotels extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelDAO hotelDAO = new HotelDAO();
        List<Hotel> hotels = new ArrayList<Hotel>();
        if (Integer.parseInt(req.getParameter("type")) == 1) {
            int stars = Integer.parseInt(req.getParameter("field"));
            hotels = hotelDAO.getHotelsByStars(stars);
            req.setAttribute("list", hotels);
        } else if (Integer.parseInt(req.getParameter("type")) == 2) {
            String city = req.getParameter("field");
            hotels = hotelDAO.getHotelsByCity(city);
            req.setAttribute("list", hotels);
        } else if (Integer.parseInt(req.getParameter("type")) == 3) {
            ;
            hotels = hotelDAO.getAllHotels();
            req.setAttribute("list", hotels);
        }


        req.getRequestDispatcher("showhotels.jsp").forward(req, resp);
    }
}
