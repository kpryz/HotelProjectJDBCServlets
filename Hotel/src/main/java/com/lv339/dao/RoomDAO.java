package com.lv339.dao;

import com.lv339.entity.Booking;
import com.lv339.entity.Room;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    private static Logger logger = Logger.getLogger(RoomDAO.class.getName());

    /**
     * @param id
     * @return Hotel
     */
    public Room getRoom(int id) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "SELECT * from room a where a.id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Room room = new Room();
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setHotel_name(rs.getString("hotel_name"));
                room.setPriceInDollars(rs.getInt("price"));
                room.setRoomType(rs.getString("roomType"));
                room.setNumberOfPeople(rs.getInt("numberOfPeople"));
                return room;
            }
        } catch (SQLException e) {
            logger.error("Problem with getting user from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getRom method");
                logger.error(e);
            }
        }
        return null;
    }

    /**
     * @param room
     */
    public boolean insertRoom(Room room) {
        boolean isSuccess=false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT into room(roomnumber, hotel_name, priceInDollars, roomType, numberOfPeople ) VALUES (?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setShort(1, room.getRoomNumber());
            pstm.setString(2, room.getHotel_name());
            pstm.setInt(3, room.getPriceInDollars());
            pstm.setString(4, room.getRoomType());
            pstm.setInt(5, room.getNumberOfPeople());

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with inserting room in the database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in insert room method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param room
     */
    public boolean updateRoom(Room room) {
        boolean isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE room SET roomnumber = ? , hotel_name= ?, priceInDollars = ?, roomType = ?, numberOfpeople = ? WHERE  id =?;";
            pstm = connection.prepareStatement(sql);

            pstm.setShort(1, room.getRoomNumber());
            pstm.setString(2, room.getHotel_name());
            pstm.setInt(3, room.getPriceInDollars());
            pstm.setString(4, room.getRoomType());
            pstm.setInt(5, room.getNumberOfPeople());
            pstm.setInt(6, room.getId());

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with updating room in database");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in update room method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param roomId
     * @return Hotel
     */
    public boolean deleteRoomById(int roomId) {
        boolean  isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM room WHERE id=?;";
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, roomId);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting room from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in delete room by id method");
                logger.error(e);
            }
        }
        return isSuccess;
    }


    /**
     * @param roomType
     * @return List<Room>
     */
    public List<Room> getRoomsByType(String roomType) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;

        List<Room> list = new ArrayList<>();
        try {
            String sql = "SELECT a.id, a.roomnumber, a.priceInDollars, a.roomType, a.numberOfPeople,a.hotel_name from room a where a.roomType = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, roomType);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setHotel_name(rs.getString("hotel_name"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));
                room.setRoomType(rs.getString("roomType"));
                room.setNumberOfPeople(rs.getInt("numberOfPeople"));
                list.add(room);

            }

        } catch (SQLException e) {
            logger.error("Problem with getting room by type from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in get Room by type method");
                logger.error(e);
            }
        }
        return list;
    }


    /**
     * @param roomNumber
     * @param hotelName
     * @return Room
     */
    public Room getRoomByRoomNumberAndHotelName(short roomNumber, String hotelName) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "SELECT a.id, a.roomnumber, a.priceInDollars, a.roomType, a.numberOfPeople,a.hotel_name from room a \n" +
                    "where a.roomnumber=? and a.hotel_name=?  ;";
            pstm = connection.prepareStatement(sql);
            pstm.setShort(1, roomNumber);
            pstm.setString(2, hotelName);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(roomNumber);
                room.setHotel_name(rs.getString("hotel_name"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));
                room.setRoomType(rs.getString("roomType"));
                room.setNumberOfPeople(rs.getInt("numberOfPeople"));
                return room;
            }
        } catch (SQLException e) {
            logger.error("Problem with getting user from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getRom method");
                logger.error(e);
            }
        }
        return null;
    }


    //-----------------------------------------------
    // Kostiantyn 23.08

    /**
     * @param city
     * @return List<Room>
     */
    public List<Room> getFreeRoomsByCity(String city, byte numberOfPeople, LocalDate startDate, LocalDate endDate) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        BookingDAO bookingDAO = new BookingDAO();

        List<Room> list = new ArrayList<>();
        try {
            String sql = "SELECT a.id, a.roomnumber, a.priceInDollars, a.roomType, a.numberOfPeople,a.hotel_name from room a " +
                    "JOIN hotel ON a.hotel_name = hotel.name WHERE hotel.city=? and numberOfpeople <= ? GROUP BY a.priceInDollars;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, city);
            pstm.setByte(2, numberOfPeople);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setHotel_name(rs.getString("hotel_name"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));
                room.setRoomType(rs.getString("roomType"));
                room.setNumberOfPeople(rs.getInt("numberOfPeople"));

                Booking booking = new Booking();
                booking.setStartDate(startDate);
                booking.setEndDate(endDate);
                booking.setRoom_id(room.getId());
                booking.setRoom(room);
                if (bookingDAO.BookingDateIsFree(booking)) {
                    list.add(room);
                }
            }

        } catch (SQLException e) {
            logger.error("Problem with getting room by city from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getRoomsByCity method");
                logger.error(e);
            }
        }
        return list;
    }

    /**
     * @param country
     * @return List<Room>
     */
    public List<Room> getFreeRoomsByCountry(String country, byte numberOfPeople, LocalDate startDate, LocalDate endDate) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        BookingDAO bookingDAO = new BookingDAO();
        List<Room> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM room r INNER JOIN hotel h ON r.hotel_name = h.`name` WHERE h.country = ? and numberOfpeople <= ?;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, country);
            pstm.setByte(2, numberOfPeople);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setHotel_name(rs.getString("hotel_name"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));
                room.setRoomType(rs.getString("roomType"));
                room.setNumberOfPeople(rs.getInt("numberOfPeople"));


                Booking booking = new Booking();
                booking.setStartDate(startDate);
                booking.setEndDate(endDate);
                booking.setRoom_id(room.getId());
                booking.setRoom(room);
                if (bookingDAO.BookingDateIsFree(booking)) {
                    list.add(room);
                }
            }

        } catch (SQLException e) {
            logger.error("Problem with getting room by country from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getting room by country method");
                logger.error(e);
            }
        }
        return list;
    }

    /**
     * @param hotel_name
     * @return List<Room>
     */
    public List<Room> getFreeRoomsByHotelName(String hotel_name, byte numberOfPeople, LocalDate startDate, LocalDate endDate) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        BookingDAO bookingDAO = new BookingDAO();

        List<Room> list = new ArrayList<>();
        try {
            String sql = "SELECT a.id, a.roomnumber, a.priceInDollars, a.roomType, a.numberOfPeople,a.hotel_name from room a " +
                    "JOIN hotel ON a.hotel_name = hotel.name WHERE hotel.name=? and numberOfpeople <= ? GROUP BY a.hotel_name;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, hotel_name);
            pstm.setByte(2, numberOfPeople);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setHotel_name(rs.getString("hotel_name"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));
                room.setRoomType(rs.getString("roomType"));
                room.setNumberOfPeople(rs.getInt("numberOfPeople"));

                Booking booking = new Booking();
                booking.setStartDate(startDate);
                booking.setEndDate(endDate);
                booking.setRoom_id(room.getId());
                booking.setRoom(room);
                if (bookingDAO.BookingDateIsFree(booking)) {
                    list.add(room);
                }

            }

        } catch (SQLException e) {
            logger.error("Problem with getting room by hotel name from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getting room by hotel name method");
                logger.error(e);
            }
        }
        return list;
    }
}
