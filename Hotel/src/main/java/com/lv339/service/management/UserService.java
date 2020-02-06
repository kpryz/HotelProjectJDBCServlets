package com.lv339.service.management;

import com.lv339.dao.UserDAO;
import com.lv339.entity.User;
import com.lv339.service.MessageForOutput;
import org.apache.log4j.Logger;

import java.util.List;

public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class.getName());

    public void insertUser(User user) {
        UserDAO userDAO = new UserDAO();

        try {
            boolean isSuccess = false;

            if (userDAO.getUser(user.getEmail()) == null) {
                if (isSuccess = userDAO.insertUser(user)) {
                    logger.info("User " + user.getEmail() + " is inserted");

                    MessageForOutput.setMsg("User is added successfully.");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    logger.info("User is not inserted, something went wrong");

                    MessageForOutput.setMsg("User is not inserted, please, check input data.");
                    MessageForOutput.setMsgTypeError();
                }
            } else {
                logger.info("There is already such user");

                MessageForOutput.setMsg("User with such email is already registered.");
                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting user");
            logger.error(e);
        }
    }

    public void updateUser(User user, String oldEmail) {
        UserDAO userDAO = new UserDAO();

        try {
            boolean isSuccess = false;

            if (isSuccess = userDAO.updateUser(user, oldEmail)) {
                logger.info("User " + oldEmail + " is updated successfully");

                MessageForOutput.setMsg("User is updated successfully.");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (userDAO.getUser(user.getEmail()) != null) {
                    logger.info("There is already such user");
                    MessageForOutput.setMsg("User with such email isn't registered yet.");
                } else {
                    logger.info("User is not updated, smth went wrong");
                    MessageForOutput.setMsg("User is not updated, please, check input data.");
                }

                MessageForOutput.setMsgTypeError();
            }

        } catch (RuntimeException e) {
            logger.error("Problem during updating user");
            logger.error(e);
        }
    }

    public void deleteUser(String email) {
        UserDAO userDAO = new UserDAO();

        try {
            boolean isSuccess = false;
            if (isSuccess = userDAO.deleteUser(email)) {
                logger.info("User" + email + " is deleted");

                MessageForOutput.setMsg("User is deleted successfully.");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (userDAO.getUser(email) == null) {
                    MessageForOutput.setMsg("User with such email is not registered yet.");
                } else {
                    MessageForOutput.setMsg("User is not inserted, something went wrong.");
                }
                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting user");
            logger.error(e);
        }
    }

    public List<User> getAllUsers() {
        UserDAO userDAO = new UserDAO();

        List<User> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            MessageForOutput.setMsg("There is no users");
            MessageForOutput.setMsgTypeError();

            logger.info("There is no users in db");
        }

        return users;
    }

    public User getUser(String userEmail) {
        UserDAO userDAO = new UserDAO();

        return userDAO.getUser(userEmail);
    }
}
