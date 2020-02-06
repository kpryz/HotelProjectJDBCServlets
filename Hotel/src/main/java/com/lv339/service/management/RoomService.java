package com.lv339.service.management;

import com.lv339.dao.BookingDAO;
import com.lv339.dao.HotelDAO;
import com.lv339.dao.RoomDAO;
import com.lv339.dao.UserDAO;
import com.lv339.entity.Booking;
import com.lv339.entity.Room;
import com.lv339.service.MessageForOutput;
import org.apache.log4j.Logger;

import java.time.LocalDate;

public class RoomService {
    private static Logger logger = Logger.getLogger(UserDAO.class.getName());

    /**
     * @param room
     */
    public void insertRoom(Room room) {
        RoomDAO roomDAO = new RoomDAO();
        try {
            Room room1 = roomDAO.getRoomByRoomNumberAndHotelName(room.getRoomNumber(), room.getHotel_name());
            if (room1!=null){
                logger.info("There is already such room in the database");

                MessageForOutput.setMsg("Such room is already registered.");
                MessageForOutput.setMsgTypeError();
            } else{
                boolean isSuccess = false;
                if (isSuccess =  roomDAO.insertRoom(room)) {
                    logger.info("Room " + room.getRoomNumber() + " is inserted successfully");

                    MessageForOutput.setMsg("Customer is added successfully");
                    MessageForOutput.setMsgTypeInfo();
                }else {
                    logger.info("Room is not inserted.");

                    MessageForOutput.setMsg("Room is not added, please, check input data.");
                    MessageForOutput.setMsgTypeError();
                }
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting user");
            logger.error(e);
        }
    }

    /**
     * @param room
     * @param oldRoomNumber
     */
    public void updateRoom(Room room, short oldRoomNumber) {
        RoomDAO roomDAO = new RoomDAO();
        HotelDAO hotelDAO = new HotelDAO();
        try{
            if (hotelDAO.getHotel(room.getHotel_name())!=null) {
                Room oldRoom = roomDAO.getRoomByRoomNumberAndHotelName(oldRoomNumber, room.getHotel_name());
                room.setId(oldRoom.getId());
                boolean isSuccess = false;
                if (isSuccess = roomDAO.updateRoom(room)) {
                    logger.info("Room  " + room.getRoomNumber() + " is updated successfully");

                    MessageForOutput.setMsg("Room is updated successfully.");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    if (roomDAO.getRoomByRoomNumberAndHotelName(room.getRoomNumber(), room.getHotel_name()) != null) {
                        logger.info("There is already such room");
                        MessageForOutput.setMsg("Customer with such email isn't registered yet.");
                    } else {
                        logger.info("Room is not updated, smth went wrong");
                        MessageForOutput.setMsg("Room is not updated, please, check input data.");
                    }

                    MessageForOutput.setMsgTypeError();
                }
            }else {
                logger.info("Problem with updating room. There is no such hotel. ");
                MessageForOutput.setMsg("There is no such hotel. Please try again");
                MessageForOutput.setMsgTypeError();
            }
        }catch (RuntimeException e) {
            logger.error("Problem during inserting room");
            logger.error(e);
        }

        roomDAO.updateRoom(room);
    }

    public void deleteRoom(short roomNumber, String hotelName) {
        RoomDAO roomDAO = new RoomDAO();
        HotelDAO hotelDAO = new HotelDAO();
        try {
            if (hotelDAO.getHotel(hotelName)!=null) {
                boolean isSuccess = false;
                Room room = roomDAO.getRoomByRoomNumberAndHotelName(roomNumber, hotelName);
                if (isSuccess = roomDAO.deleteRoomById(room.getId())) {
                    logger.info("Room " + room.getRoomNumber() + " is deleted successfully");

                    MessageForOutput.setMsg("Visa is deleted successfully.");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    if (roomDAO.getRoom(room.getId()) == null) {
                        logger.info("There is no such room in the database");
                        MessageForOutput.setMsg("Such room is not registered yet. Nothing to delete.");
                    } else {
                        logger.info("Room is not deleted.");
                        MessageForOutput.setMsg("Room is not deleted, please, check input data.");
                    }
                    MessageForOutput.setMsgTypeError();
                }
            } else {
                logger.info("Problem with deleting room. There is no such room");
                MessageForOutput.setMsg("There is no such hotel. Please try again");
                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during deleting room");
            logger.error(e);
        }
    }

    public boolean isFree(int roomId, LocalDate startDate, LocalDate endDate) {
        BookingDAO bookingDAO = new BookingDAO();
        Booking booking = new Booking();
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setRoom_id(roomId);

        return bookingDAO.BookingDateIsFree(booking);
    }

    public Room getRoom(int id) {
        RoomDAO roomDAO = new RoomDAO();
        return roomDAO.getRoom(id);
    }
}
