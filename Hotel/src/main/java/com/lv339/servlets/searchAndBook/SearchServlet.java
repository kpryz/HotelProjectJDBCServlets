package com.lv339.servlets.searchAndBook;

import com.lv339.entity.Room;
import com.lv339.service.MessageForOutput;
import com.lv339.service.search.SearchParam;
import com.lv339.service.search.SearchService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@WebServlet("/hotel-search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchQuery = req.getParameter("searchQuery");
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
        byte numberOfPeople = Byte.parseByte(req.getParameter("numberOfPeople"));

        SearchParam searchParam = new SearchParam(searchQuery, startDate, endDate, numberOfPeople);

        SearchService searchService = new SearchService();


        List<Room> roomList = searchService.getRooms(searchParam);
        MessageForOutput.setMessageToRequest(req);

        if (roomList != null && !roomList.isEmpty()) {
            req.setAttribute("RoomList", roomList);
        }
        req.setAttribute("DaysNumber", DAYS.between(startDate, endDate));
        req.setAttribute("StartDate", startDate.toString());
        req.setAttribute("EndDate", endDate.toString());

        //get parameters from search
        req.setAttribute("SearchQuery", searchQuery);
        req.setAttribute("NumberOfPeople", numberOfPeople);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/hotels.jsp");
        rd.include(req, resp);
    }
}
