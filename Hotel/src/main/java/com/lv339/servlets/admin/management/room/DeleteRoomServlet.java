package com.lv339.servlets.admin.management.room;

import com.lv339.dao.HotelDAO;
import com.lv339.dao.RoomDAO;
import com.lv339.entity.Hotel;
import com.lv339.entity.Room;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-room")
public class DeleteRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        String hotelName = req.getParameter("hotelName");
        short roomNumber = Short.parseShort(req.getParameter("roomNumber"));
        roomService.deleteRoom(roomNumber,hotelName);

        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/delete-room.jsp");
        rq.include(req, resp);
    }

}
