package com.lv339.service.search;

import com.lv339.dao.HotelDAO;
import com.lv339.dao.RoomDAO;
import com.lv339.entity.Hotel;
import com.lv339.entity.Room;
import com.lv339.exceptions.ValidationException;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.RoomService;
import com.lv339.service.validation.DateValidation;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private static Logger logger = Logger.getLogger(SearchService.class.getName());

    // private SearchType searchType;

    public List<Room> getRooms(SearchParam searchParam) throws ValidationException {
        searchParam.setQuery(searchParam.getQuery().trim());
        List<Room> roomList = null;

        try {
            if (!DateValidation.isOk(searchParam.getStartDate()) ||
                    !DateValidation.isOk(searchParam.getEndDate()) ||
                    !searchParam.getEndDate().isAfter(searchParam.getStartDate()) ||
                    searchParam.getStartDate().equals(searchParam.getEndDate())) {
                MessageForOutput.setMsg("Dates are incorrect");
                throw new ValidationException("Dates are incorrect");
            }

            RoomDAO roomDAO = new RoomDAO();
            HotelDAO hotelDAO = new HotelDAO();
            RoomService roomService = new RoomService();

            if (hotelDAO.getAllCountries().contains(searchParam.getQuery())) {
                logger.info("Search by country");

                roomList = roomDAO.getFreeRoomsByCountry(searchParam.getQuery(), searchParam.getNumberOfPeople(),
                        searchParam.getStartDate(), searchParam.getEndDate());
            } else if (hotelDAO.getAllCities().contains(searchParam.getQuery())) {
                logger.info("Search by city");

                roomList = roomDAO.getFreeRoomsByCity(searchParam.getQuery(), searchParam.getNumberOfPeople(),
                        searchParam.getStartDate(), searchParam.getEndDate());
            } else if (hotelDAO.getAllHotelNames().contains(searchParam.getQuery())) {
                logger.info("Search by hotel name");

                roomList = roomDAO.getFreeRoomsByHotelName(searchParam.getQuery(), searchParam.getNumberOfPeople(),
                        searchParam.getStartDate(), searchParam.getEndDate());
            } else {
                logger.info("No search results");

                MessageForOutput.setMsg("No results");
                MessageForOutput.setMsgTypeError();

                return null;
            }

            for (Room room : roomList) {
                room.setHotel(hotelDAO.getHotel(room.getHotel_name()));
            }


        } catch (ValidationException e) {
            logger.error("Dates are incorrect");
            logger.error(e);
        }


        return roomList;
    }

    public List<Hotel> getHotels(SearchParam searchParam) {
        List<Room> rooms = getRooms(searchParam);
        List<Hotel> hotels = null;

        HotelDAO hotelDAO = new HotelDAO();
        if (!rooms.isEmpty()) {
            hotels = new ArrayList<>();
        }

        for (Room room : rooms) {
            Hotel hotel = hotelDAO.getHotel(room.getHotel_name());

            if (!hotels.contains(hotel)) {
                hotels.add(hotel);
            }
        }

        return hotels;
    }
}
