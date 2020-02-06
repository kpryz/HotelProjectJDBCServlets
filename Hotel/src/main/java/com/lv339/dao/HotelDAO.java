package com.lv339.dao;

import com.lv339.entity.Hotel;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    private static Logger logger = Logger.getLogger(HotelDAO.class.getName());

    /**
     * @param hotel
     */
    public boolean insertHotel(Hotel hotel) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT into hotel(name, country, city, stars, street, image) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, hotel.getName());
            pstm.setString(2, hotel.getCountry());
            pstm.setString(3, hotel.getCity());
            pstm.setInt(4, hotel.getStars());
            pstm.setString(5, hotel.getStreet());
            pstm.setString(6, hotel.getImageUrl());

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with inserting hotel into database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in insert hotel method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param name
     * @return Hotel
     */
    public Hotel getHotel(String name) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "SELECT a.name, a.country, a.city, a.stars, a.street, a.image from hotel a where a.name = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setName(name);
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotel.setStars(rs.getByte("stars"));
                hotel.setStreet(rs.getString("street"));
                hotel.setImageUrl(rs.getString("image"));
                return hotel;
            }
        } catch (SQLException e) {
            logger.error("Problem with getting hotel from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in find hotel by Name method");
                logger.error(e);
            }
        }
        return null;
    }

    /**
     * @param hotel
     * @param oldName
     */
    public boolean updateHotel(Hotel hotel, String oldName) {
        boolean isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE hotel SET name =? , country= ?, city = ?, stars= ?, street= ?, image= ?  WHERE  name =?;";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, hotel.getName());
            pstm.setString(2, hotel.getCountry());
            pstm.setString(3, hotel.getCity());
            pstm.setInt(4, hotel.getStars());
            pstm.setString(5, hotel.getStreet());
            pstm.setString(6, hotel.getImageUrl());
            pstm.setString(7, oldName);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with updating hotel");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in update hotel method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param name
     */
    public boolean deleteHotelByName(String name) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM hotel WHERE name=?;";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, name);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting hotel from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in delete hotels by name method");
                logger.error(e);
            }
        }
        return isSuccess;
    }


    /**
     * @return List<Hotels>
     */
    public List<Hotel> getAllHotels() {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        List<Hotel> list = new ArrayList<>();
        try {
            String sql = "SELECT  a.name, a.country, a.city, a.stars, a.street, a.image from hotel a ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setName(rs.getString("name"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotel.setStars(rs.getByte("stars"));
                hotel.setStreet(rs.getString("street"));
                hotel.setImageUrl(rs.getString("image"));
                list.add(hotel);
            }

        } catch (SQLException e) {
            logger.error("Problem with getting all hotels  from database ");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in get all hotels method");
                logger.error(e);
            }
        }
        return list;
    }


//----------------------------------------------------------uder this point not tested methods


    /**
     * @param hotelStars
     * @return List<Hotel>
     */
    public List<Hotel> getHotelsByStars(int hotelStars) {
        String sql = "SELECT a.id, a.name, a.country, a.city, a.stars, a.street, a.image from hotel a where a.stars = ?";
        PreparedStatement pstm = null;
        List<Hotel> list = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, hotelStars);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Hotel hotel = new Hotel();
                //  hotel.setId(rs.getInt("id"));
                hotel.setName(rs.getString("name"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotel.setStars(rs.getByte("stars"));
                hotel.setStreet(rs.getString("street"));
                hotel.setStreet(rs.getString("image"));
                list.add(hotel);
            }

        } catch (SQLException e) {
            logger.error("Problem with getting hotel by stars from database.");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in get hotels by stars method");
                logger.error(e);
            }
        }
        return list;
    }

    /**
     * @param city
     * @return List<Hotel>
     */
    public List<Hotel> getHotelsByCity(String city) {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        List<Hotel> list = new ArrayList<>();
        try {
            String sql = "SELECT a.id, a.name, a.country, a.city, a.stars, a.street, a.image from hotel a where a.city = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, city);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Hotel hotel = new Hotel();
                //hotel.setId(rs.getInt("id"));
                hotel.setName(rs.getString("name"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotel.setStars(rs.getByte("stars"));
                hotel.setStreet(rs.getString("street"));
                hotel.setImageUrl(rs.getString("image"));
                list.add(hotel);
            }

        } catch (SQLException e) {
            logger.error("Problem with getting hotels by city from database ");
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in get hotels by city method");
                logger.error(e);
            }
        }
        return list;
    }


    //------------------------------------------------------------------------------------
    //Written by Kostiantyn

    /**
     * @return all countries
     */
    public List<String> getAllCountries() {
        List<String> countries = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "SELECT DISTINCT country FROM hotel;";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                countries.add(rs.getString("country"));
            }

        } catch (SQLException e) {
            logger.error("Problem with getting countries in hotelsDAO ");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getting countries method in hotelsDAO ");
                logger.error(e);
            }
        }

        return countries;
    }

    /**
     * @return all cities
     */
    public List<String> getAllCities() {
        List<String> cities = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "SELECT DISTINCT city FROM hotel;";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cities.add(rs.getString("city"));
            }

        } catch (SQLException e) {
            logger.error("Problem with getting cities in hotelsDAO ");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in getting cities method in hotelsDAO ");
                logger.error(e);
            }
        }

        return cities;
    }


    /**
     * @return all hotel names
     */
    public List<String> getAllHotelNames() {
        List<String> hotelNames = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "SELECT DISTINCT name FROM hotel;";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                hotelNames.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            logger.error("Problem with getting hotel names in hotelsDAO ");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in hotel names method in hotelsDAO ");
                logger.error(e);
            }
        }

        return hotelNames;
    }

}
