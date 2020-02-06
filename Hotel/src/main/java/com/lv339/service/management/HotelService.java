package com.lv339.service.management;

import com.lv339.dao.HotelDAO;
import com.lv339.entity.Hotel;
import com.lv339.service.MessageForOutput;
import org.apache.log4j.Logger;

import java.util.List;

public class HotelService {

    private static Logger logger = Logger.getLogger(CustomerService.class.getName());

    /**
     * @param hotel
     */
    public void insertHotel(Hotel hotel) {
        HotelDAO hotelDAO = new HotelDAO();
        try {
            Hotel hotel1 = hotelDAO.getHotel(hotel.getName());
            if (hotel1 != null) {
                logger.info("There is such hotel in database");
                MessageForOutput.setMsg("Hotel with such name is already exist. Please enter another name");
                MessageForOutput.setMsgTypeError();
            } else {
                boolean isSuccess = false;
                if (isSuccess = hotelDAO.insertHotel(hotel)) {
                    logger.info("Hotel" + hotel.getName() + " added successfully");
                    MessageForOutput.setMsg("Hotel is added successfully");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    logger.info("Hotel is not inserted.");

                    MessageForOutput.setMsg("hotel is not added, please, check input data.");
                    MessageForOutput.setMsgTypeError();
                }
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting user");
            logger.error(e);
        }
    }

    /**
     * @param hotel
     * @param oldHotelName
     */
    public void updateHotel(Hotel hotel, String oldHotelName) {
        HotelDAO hotelDAO = new HotelDAO();
        try {
            boolean isSuccess = false;
            if (isSuccess = hotelDAO.updateHotel(hotel, oldHotelName)) {
                logger.info("Hotel" + hotel.getName() + " added successfully");
                MessageForOutput.setMsg("Hotel is updated successfully");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (hotelDAO.getHotel(hotel.getName()) != null) {
                    logger.info("Hotel" + oldHotelName + " isnt exist");
                    MessageForOutput.setMsg("Hotel with such name doesnt exist");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    logger.info("Hotel is not updated, smth went wrong");
                    MessageForOutput.setMsg("Hotel is not updated, please, check input data.");
                }
                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during updating user");
            logger.error(e);
        }
    }

    /**
     * @param name
     */
    public void deleteHotel(String name) {
        HotelDAO hotelDAO = new HotelDAO();
        try {
            boolean isSuccess = false;
            if (isSuccess = hotelDAO.deleteHotelByName(name)) {
                logger.info("Hotel" + name + " is deleted");

                MessageForOutput.setMsg("Hotel is deleted successfully.");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (hotelDAO.getHotel(name) == null) {
                    MessageForOutput.setMsg("Hotel with such name is not registered yet.");
                } else {
                    MessageForOutput.setMsg("Hotel is not deleted, something went wrong.");
                }
                MessageForOutput.setMsgTypeError();
            }

        } catch (RuntimeException e) {
            logger.error("Problem during deleting hotel");
            logger.error(e);
        }
    }

    /**
     * @return List<Hotel>
     */
    public List<Hotel> getAllHotels() {
        HotelDAO hotelDAO = new HotelDAO();
        List<Hotel> hotels = hotelDAO.getAllHotels();
        if (hotels.isEmpty()) {
            MessageForOutput.setMsg("There is no htels");
            MessageForOutput.setMsgTypeError();

            logger.info("There is no hotels in db");
        }
        return hotels;
    }

}