/*
 *
 * Author: Kostiantyn Pryzyhlei
 *
 * Date: 14.08.2018
 *
 */
package com.lv339.dao;

import com.lv339.entity.Customer;
import com.lv339.entity.User;
import com.lv339.entity.UserRole;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static Logger logger = Logger.getLogger(UserDAO.class.getName());

    /**
     * @return user list
     */
    public List<User> getUserList(String beginningOfEmail) {
        List<User> userList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM user WHERE email LIKE " + beginningOfEmail + "%";
            pstm = connection.prepareStatement(sql);

            rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserRole(UserRole.valueOf(rs.getString("userRole")));

                userList.add(user);
            }
        } catch (SQLException e) {
            logger.error("Problem with getting users from database");
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
                        " resources in getting users method");
                logger.error(e);
            }
        }

        return userList;
    }

    /**
     * @return user list
     */
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM user";
            pstm = connection.prepareStatement(sql);

            rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserRole(UserRole.valueOf(rs.getString("userRole")));

                userList.add(user);
            }
        } catch (SQLException e) {
            logger.error("Problem with getting all users from database");
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
                        " resources in getting all users method");
                logger.error(e);
            }
        }

        return userList;
    }

    /**
     * @param user
     * @return inserting success
     */
    public boolean insertUser(User user) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO user(firstName, lastName, email, password, userRole) VALUES (?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, user.getFirstName());
            pstm.setString(2, user.getLastName());
            pstm.setString(3, user.getEmail());
            pstm.setString(4, user.getPassword());
            pstm.setString(5, user.getUserRole().toString());

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with inserting user in the database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in inserting user method");
                logger.error(e);
            }
        }

        return isSuccess;
    }

    /**
     * @param email
     * @return user
     */
    public User getUser(String email) {
        User user = null;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT firstName, lastName, email, password, userRole FROM user WHERE user.email = ?";

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            rs = pstm.executeQuery();

            if (rs.next()) {
                user = new User();

                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserRole(UserRole.valueOf(rs.getString("userRole")));
            }
        } catch (SQLException e) {
            logger.error("Problem with getting user by email from database");
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
                        " resources in getting user (email) method");
                logger.error(e);
            }
        }
        return user;
    }

    /**
     * @param user
     * @param oldEmail
     * @return updating success
     */
    public boolean updateUser(User user, String oldEmail) {
        boolean isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE user SET email = ?, firstName = ?, lastName = ?, password = ?, userRole = ? WHERE email = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getFirstName());
            pstm.setString(3, user.getLastName());
            pstm.setString(4, user.getPassword());
            pstm.setString(5, user.getUserRole().toString());
            pstm.setString(6, oldEmail);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Something wrong with updating user in db.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in updating user method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param email
     * @return deleting success
     */
    public boolean deleteUser(String email) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM user WHERE email = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, email);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting user by email from database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in deleting user by email method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param email
     * @return true if such user is in db
     */
    public boolean isSuchUser(String email) {
        return getUser(email) != null;
    }
}
