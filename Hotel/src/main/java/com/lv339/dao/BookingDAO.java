/*
 *
 * Author: Kostiantyn Pryzyhlei
 *
 * Date: 14.08.2018
 *
 */
package com.lv339.dao;

import com.lv339.entity.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookingDAO {
    private static Logger logger = Logger.getLogger(BookingDAO.class.getName());

    /**
     * @param booking
     */
    public boolean insertBooking(Booking booking) {
        boolean success = false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT into booking(endDate, startDate, comment, customer_email, room_id) VALUES (?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setDate(1, Date.valueOf(booking.getEndDate()));
            pstm.setDate(2, Date.valueOf(booking.getStartDate()));
            pstm.setString(3, booking.getComment());
            pstm.setString(4, booking.getCustomer_email());
            pstm.setInt(5, booking.getRoom_id());

            success = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with inserting booking into database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in insert booking method");
                logger.error(e);
            }
        }
        return success;
    }

    /**
     * @param booking
     * @return isFree
     */
    public boolean BookingDateIsFree(Booking booking) {
        boolean isFree = true;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM hotel_db.booking where room_id =? and ((startDate between ? and ? or endDate between ? and ?)" +
                    " or (startDate<=? and endDate>=?));";

            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, booking.getRoom_id());
            pstm.setDate(2, Date.valueOf(booking.getStartDate()));
            pstm.setDate(3, Date.valueOf(booking.getEndDate()));
            pstm.setDate(4, Date.valueOf(booking.getStartDate()));
            pstm.setDate(5, Date.valueOf(booking.getEndDate()));
            pstm.setDate(6, Date.valueOf(booking.getStartDate()));
            pstm.setDate(7, Date.valueOf(booking.getEndDate()));
            rs = pstm.executeQuery();
            if (rs.next()) {
                isFree = false;
            }

        } catch (SQLException e) {
            logger.error("Problem with checking booking dates in database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in BookingDateIsFree method");
                logger.error(e);
            }
        }
        return isFree;
    }

    /**
     * @param booking
     */
    public void updateBooking(Booking booking) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE booking SET endDate =? , startDate= ?, comment = ?, customer_email= ?, room_id= ? WHERE  id =?;";
            pstm = connection.prepareStatement(sql);

            pstm.setDate(1, Date.valueOf(booking.getEndDate()));
            pstm.setDate(2, Date.valueOf(booking.getStartDate()));
            pstm.setString(3, booking.getComment());
            pstm.setString(4, booking.getCustomer_email());
            pstm.setInt(5, booking.getRoom_id());
            pstm.setInt(6, booking.getId());

            pstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Problem with updating booking");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in update booking method");
                logger.error(e);
            }
        }
    }

    /**
     * @param id
     */
    public void deleteBookingById(int id) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM booking WHERE id=?;";
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Problem with deleting booking from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in delete booking by id method");
                logger.error(e);
            }
        }
    }

//=============================================================
    //Kostiantyn

    public List<Booking> getAllBookings(Customer customer) {
        String customerEmail = customer.getEmail();

        List<Booking> bookings = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT booking.id, endDate, startDate, hotel_name," +
                    "country, city, street, roomnumber, numberOfpeople, roomType, priceInDollars FROM booking \n" +
                    "join room on booking.room_id=room.id\n" +
                    "join hotel on room.hotel_name=hotel.name\n" +
                    "join customer on booking.customer_email=customer.email " +
                    "WHERE customer_email = ?;";

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, customerEmail);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                Room room = new Room();
                Hotel hotel = new Hotel();

                hotel.setName(rs.getString("hotel_name"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotel.setStreet(rs.getString("street"));

                room.setHotel(hotel);
                room.setHotel_name(rs.getString("hotel_name"));
                room.setNumberOfPeople(rs.getByte("numberOfPeople"));
                room.setRoomType(rs.getString("roomType"));
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));

                booking.setRoom(room);
                booking.setStartDate(rs.getDate("startDate").toLocalDate());
                booking.setEndDate(rs.getDate("endDate").toLocalDate());
                booking.setId(rs.getInt("id"));
                booking.setCustomer_email(customerEmail);

                bookings.add(booking);
            }
        } catch (SQLException | NullPointerException e) {
            logger.error("Problem with getting all bookings from database");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement or resultSet" +
                        " resource in getting all bookings method");
                logger.error(e);
            }
        }
        return bookings;
    }

    public List<Booking> getAllBookings(User user) {
        String userEmail = user.getEmail();
        List<Booking> bookings = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT booking.id, booking.endDate, booking.startDate, hotel_name, " +
                    "hotel.country, city, street, roomnumber, numberOfpeople, roomType, priceInDollars, customer_email FROM booking \n" +
                    "join room on booking.room_id=room.id\n" +
                    "join hotel on room.hotel_name=hotel.name\n" +
                    "join customer on booking.customer_email=customer.email " +
                    "join `user` on customer.user_email=user.email " +
                    "WHERE user.email = ?;";

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, userEmail);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                Room room = new Room();
                Hotel hotel = new Hotel();

                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotel.setStreet(rs.getString("street"));
                hotel.setName(rs.getString("hotel_name"));

                room.setHotel(hotel);
                room.setHotel_name(rs.getString("hotel_name"));
                room.setNumberOfPeople(rs.getByte("numberOfPeople"));
                room.setRoomType(rs.getString("roomType"));
                room.setRoomNumber(rs.getShort("roomnumber"));
                room.setPriceInDollars(rs.getInt("priceInDollars"));

                booking.setRoom(room);
                booking.setStartDate(rs.getDate("startDate").toLocalDate());
                booking.setEndDate(rs.getDate("endDate").toLocalDate());
                booking.setId(rs.getInt("id"));
                booking.setCustomer_email(rs.getString("customer_email"));

                bookings.add(booking);
            }
        } catch (SQLException | NullPointerException e) {
            logger.error("Problem with getting all bookings from database");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement or resultSet" +
                        " resource in getting all bookings method");
                logger.error(e);
            }
        }
        return bookings;
    }
}
