/*
 *
 * Author: Kostiantyn Pryzyhlei
 *
 * Date: 14.08.2018
 *
 */
package com.lv339.dao;

import com.lv339.entity.Customer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static Logger logger = Logger.getLogger(CustomerDAO.class.getName());

    /**
     * Only users can add customer to a database
     *
     * @param customer
     * @return success
     */
    public boolean insertCustomer(Customer customer) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql =
                    "INSERT INTO customer(firstName, lastName, contactNumber, email, user_email, password) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, customer.getFirstName());
            pstm.setString(2, customer.getLastName());
            pstm.setString(3, customer.getContactNumber());
            pstm.setString(4, customer.getEmail());
            pstm.setString(5, customer.getUser_email());
            pstm.setString(6, customer.getPassword());


            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problems with inserting customer into database");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in inserting customer method");
                logger.error(e);
            }
        }

        return isSuccess;
    }

    /**
     * @return customerList
     */
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sqlSelectCustomer = "SELECT * FROM customer";

            pstm = connection.prepareStatement(sqlSelectCustomer);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setContactNumber(rs.getString("contactNumber"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setUser_email(rs.getString("user_email"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            logger.error("Problem with getting customer by id from database");
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
                        " resource in getting customer(id) method");
                logger.error(e);
            }
        }
        return customerList;
    }


    /**
     * @param email
     * @return customer
     */
    public Customer getCustomer(String email) {
        Customer customer = null;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM customer WHERE email = ?";

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            rs = pstm.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setContactNumber(rs.getString("contactNumber"));
                customer.setPassword(rs.getString("password"));
                customer.setUser_email(rs.getString("user_email"));

                customer.setEmail(email);
            }
        } catch (SQLException e) {
            logger.error("Problem with getting customer by email from database");
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
                        " resources in getting customer(email) method");
                logger.error(e);
            }
        }
        return customer;
    }

    /**
     * @param userEmail
     * @return customer list
     */
    public List<Customer> getCustomerListByUserEmail(String userEmail) {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sqlSelectCustomers =
                    "SELECT * FROM customer WHERE user_email = ?";

            pstm = connection.prepareStatement(sqlSelectCustomers);
            pstm.setString(1, userEmail);

            rs = pstm.executeQuery();

            VisaDAO visaDAO = new VisaDAO();
            while (rs.next()) {
                Customer customer = new Customer();

                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setPassword(rs.getString("password"));
                customer.setContactNumber(rs.getString("contactNumber"));
                customer.setEmail(rs.getString("email"));
                customer.setVisaList(visaDAO.getVisasByCustomerEmail(rs.getString("email")));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            logger.error("Problem with getting list of customers by user id");
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
                        " resources in getting customer list method");
                logger.error(e);
            }
        }

        return customerList;
    }

    /**
     * @param customer
     * @return success
     */
    public boolean updateCustomer(Customer customer, String oldEmail) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE customer SET firstName = ?, lastName = ?, contactNumber = ?, email = ?, password = ? WHERE email = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, customer.getFirstName());
            pstm.setString(2, customer.getLastName());
            pstm.setString(3, customer.getContactNumber());
            pstm.setString(4, customer.getEmail());
            pstm.setString(5, customer.getPassword());
            pstm.setString(6, oldEmail);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Something wrong with updating customer in db.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in updating customer method");
                logger.error(e);
            }
        }

        return isSuccess;
    }

    /**
     * @param email
     * @return success
     */
    public boolean deleteCustomer(String email) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM customer WHERE email = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, email);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting customer from database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement " +
                        "resource in deleting customer method");
                logger.error(e);
            }
        }

        return isSuccess;
    }

    /**
     * @param email
     * @return success
     */
    public boolean deleteCustomer(String email, String userEmail) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM customer WHERE email = ? and user_email=?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, email);
            pstm.setString(2, userEmail);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting customer from database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement " +
                        "resource in deleting customer (customerEmail, userEmail) method");
                logger.error(e);
            }
        }

        return isSuccess;
    }
}
