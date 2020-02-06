package com.lv339.servlets.admin.management.room;

import com.lv339.entity.Room;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.RoomService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-room")
public class AddRoomServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddRoomServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        Room room = new Room();
        String hotelName = req.getParameter("hotelName");
        String roomType = req.getParameter("roomType");
        int numberOfPeople = Integer.parseInt(req.getParameter("numberOfPeople"));
        short roomNumber = Short.parseShort(req.getParameter("roomNumber"));
        int price = Integer.parseInt(req.getParameter("price"));

        room.setPriceInDollars(price);
        room.setRoomNumber(roomNumber);
        room.setNumberOfPeople(numberOfPeople);
        room.setRoomType(roomType);
        room.setHotel_name(hotelName);

        roomService.insertRoom(room);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/add-room.jsp");
        rq.include(req, resp);
    }
}
