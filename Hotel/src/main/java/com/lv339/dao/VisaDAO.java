/*
 *
 * Author: Kostiantyn Pryzyhlei
 *
 * Date: 14.08.2018
 *
 */
package com.lv339.dao;

import com.lv339.entity.Visa;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisaDAO {
    private static Logger logger = Logger.getLogger(VisaDAO.class.getName());

    /**
     * @param customerEmail
     * @return visaList
     */
    public List<Visa> getVisasByCustomerEmail(String customerEmail) {
        List<Visa> visaList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstmVisas = null;
        ResultSet rsVisas = null;
        try {
            String sqlSelectVisas = "SELECT country, endDate, startDate, visa_number, customer_email FROM visa WHERE customer_email = ?";

            pstmVisas = connection.prepareStatement(sqlSelectVisas);
            pstmVisas.setString(1, customerEmail);

            rsVisas = pstmVisas.executeQuery();

            while (rsVisas.next()) {
                Visa visa = new Visa();

                visa.setStartDate(rsVisas.getDate("endDate").toLocalDate());
                visa.setEndDate(rsVisas.getDate("endDate").toLocalDate());
                visa.setCountry(rsVisas.getString("country"));
                visa.setVisaNumber(rsVisas.getString("visa_number"));
                visa.setCustomer_email(rsVisas.getString("customer_email"));

                visaList.add(visa);
            }

        } catch (SQLException e) {
            logger.error("Problem with getting visa list from database by customer's id");
            logger.error(e);
        } finally {
            try {
                if (pstmVisas != null) {
                    pstmVisas.close();
                }
                if (rsVisas != null) {
                    rsVisas.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement or resultSet " +
                        "resources in getting visa list method");
                logger.error(e);
            }
        }

        return visaList;
    }

    /**
     * @param visaNumber
     * @return
     */
    public Visa getVisa(String visaNumber) {
        Visa visa = null;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT country, endDate, startDate, visa_number, customer_email FROM visa WHERE visa_number = ?";

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, visaNumber);

            rs = pstm.executeQuery();

            while (rs.next()) {
                visa = new Visa();
                visa.setStartDate(rs.getDate("endDate").toLocalDate());
                visa.setEndDate(rs.getDate("endDate").toLocalDate());
                visa.setCountry(rs.getString("country"));
                visa.setVisaNumber(rs.getString("visaNumber"));
                visa.setCustomer_email(rs.getString("customer_email"));
            }

        } catch (SQLException e) {
            logger.error("Problem with getting visa list from database by customer's id");
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
                logger.error("Problem with closing preparedStatement or resultSet " +
                        "resources in getting visa method");
                logger.error(e);
            }
        }

        return visa;
    }


    /**
     * @param visa
     */
    public boolean insertVisa(Visa visa) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;

        try {
            String sql = "INSERT INTO visa(country, startDate, endDate, visa_number, customer_email ) VALUES (?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, visa.getCountry());
            pstm.setDate(2, Date.valueOf(visa.getStartDate()));
            pstm.setDate(3, Date.valueOf(visa.getEndDate()));
            pstm.setString(4, visa.getVisaNumber());
            pstm.setString(5, visa.getCustomer_email());

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with inserting visa in the database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in inserting visa method");
                logger.error(e);
            }
        }

        return isSuccess;
    }

    /**
     * @param visaNumber
     */
    public boolean deleteVisa(String visaNumber) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM visa WHERE visa_number = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, visaNumber);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting visa from database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in deleting visa by visa number method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param visa
     */
    public boolean updateVisa(Visa visa, String oldVisaNumber) {
        boolean isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE visa SET country = ?, startDate = ?, endDate = ?, visa_number = ?, customer_email = ? WHERE visa_number = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, visa.getCountry());
            pstm.setDate(2, Date.valueOf(visa.getStartDate()));
            pstm.setDate(3, Date.valueOf(visa.getEndDate()));
            pstm.setString(4, visa.getVisaNumber());
            pstm.setString(5, visa.getCustomer_email());
            pstm.setString(6, oldVisaNumber);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Something wrong with updating visa in db.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in updating visa method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

}
