package com.lv339.service.management;

import com.lv339.dao.BookingDAO;
import com.lv339.dao.RoomDAO;
import com.lv339.entity.Booking;
import com.lv339.entity.Customer;
import com.lv339.entity.Room;
import com.lv339.entity.User;
import com.lv339.exceptions.ValidationException;
import com.lv339.service.MessageForOutput;
import com.lv339.service.validation.DateValidation;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class BookingService {
    private static Logger logger = Logger.getLogger(VisaService.class.getName());


    public List<Booking> getAllBookings(Customer customer) {
        BookingDAO bookingDAO = new BookingDAO();
        List<Booking> bookings = bookingDAO.getAllBookings(customer);

        for (Booking booking : bookings) {
            booking.setTotalPriceInDollars(getTotalPrice(
                    booking.getRoom().getPriceInDollars(), booking.getStartDate(), booking.getEndDate()));
        }

        return bookings;
    }

    public List<Booking> getAllBookings(User user) {
        BookingDAO bookingDAO = new BookingDAO();
        List<Booking> bookings = bookingDAO.getAllBookings(user);

        for (Booking booking : bookings) {
            booking.setTotalPriceInDollars(getTotalPrice(
                    booking.getRoom().getPriceInDollars(), booking.getStartDate(), booking.getEndDate()));
        }

        return bookings;
    }

    /**
     * @param booking
     * @param hotelName
     * @param roomNumber
     */
    public void insertBooking(Booking booking, String hotelName, short roomNumber) {
        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = new RoomDAO();
        Room room;
        try {
            if (DateValidation.isOk(booking.getStartDate()) &&
                    !DateValidation.isOk(booking.getEndDate()) &&
                    !booking.getEndDate().isAfter(booking.getStartDate())) {
                MessageForOutput.setMsg("Dates are incorrect");
                throw new ValidationException("Dates are incorrect");
            }
            room = roomDAO.getRoomByRoomNumberAndHotelName(roomNumber, hotelName);
            booking.setRoom_id(room.getId());
            if (bookingDAO.BookingDateIsFree(booking)) {
                bookingDAO.insertBooking(booking);
            }
        } catch (ValidationException e) {
            logger.error("Dates are incorrect");
            logger.error(e);
        }
    }

    public boolean insertBooking(Booking booking, int roomId) {
        boolean success = false;
        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = new RoomDAO();
        try {
            if (!DateValidation.isOk(booking.getStartDate()) ||
                    !DateValidation.isOk(booking.getEndDate()) ||
                    !booking.getEndDate().isAfter(booking.getStartDate()) ||
                    booking.getStartDate().equals(booking.getEndDate())) {
                MessageForOutput.setMsg("Dates are incorrect");
                throw new ValidationException("Dates are incorrect");
            }
            booking.setRoom_id(roomId);
            if (bookingDAO.BookingDateIsFree(booking)) {
                success = bookingDAO.insertBooking(booking);
                logger.info("Booking is inserted");
            } else {
                logger.info("This room is not free for selected dates");
            }
        } catch (ValidationException e) {
            logger.error("Dates are incorrect");
            logger.error(e);
        }
        return success;
    }

    /**
     * @param booking
     * @param hotelName
     * @param roomNumber
     */
    public void updateBooking(Booking booking, String hotelName, short roomNumber) {
        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = new RoomDAO();
        try {
            if (!DateValidation.isOk(booking.getStartDate()) ||
                    !DateValidation.isOk(booking.getEndDate()) ||
                    !booking.getEndDate().isAfter(booking.getStartDate()) ||
                    booking.getStartDate().equals(booking.getEndDate())) {
                MessageForOutput.setMsg("Dates are incorrect");
                throw new ValidationException("Dates are incorrect");
            }
            Room room = new Room();
            room = roomDAO.getRoomByRoomNumberAndHotelName(roomNumber, hotelName);
            booking.setRoom_id(room.getId());
            if (bookingDAO.BookingDateIsFree(booking)) {
                bookingDAO.updateBooking(booking);
            }
        } catch (ValidationException e) {
            logger.error("Dates are incorrect");
            logger.error(e);
        }
    }

    public int getTotalPrice(int pricePerDay, LocalDate start, LocalDate end) {
        int diff = (int) DAYS.between(start,end );
        return pricePerDay * diff;
    }

    /**
     * @param id
     */
    public void deleteBooking(int id) {
        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.deleteBookingById(id);
    }
}
