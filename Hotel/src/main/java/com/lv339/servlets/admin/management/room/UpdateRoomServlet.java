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

@WebServlet("/admin/update-room")
public class UpdateRoomServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(UpdateRoomServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        Room room = new Room();

        short oldRoomNumber = Short.parseShort(req.getParameter("oldRoomNumber"));

        String hotelName = req.getParameter("hotelName");
        String roomType = req.getParameter("roomType");
        int numberOfPeople = Integer.parseInt(req.getParameter("numberOfPeople"));
        short newroomNumber = Short.parseShort(req.getParameter("newRoomNumber"));
        int price = Integer.parseInt(req.getParameter("price"));

        room.setPriceInDollars(price);
        room.setRoomNumber(newroomNumber);
        room.setNumberOfPeople(numberOfPeople);
        room.setRoomType(roomType);
        room.setHotel_name(hotelName);

        roomService.updateRoom(room, oldRoomNumber);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/update-room.jsp");
        rq.include(req, resp);
    }
}
