package com.lv339.service.management;

import com.lv339.dao.CustomerDAO;
import com.lv339.dao.UserDAO;
import com.lv339.entity.Customer;
import com.lv339.entity.User;
import com.lv339.entity.Visa;
import com.lv339.service.MessageForOutput;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomerService {
    private static Logger logger = Logger.getLogger(CustomerService.class.getName());

    public void insertCustomer(Customer customer, String connectedUserEmail) {
        CustomerDAO customerDAO = new CustomerDAO();
        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.getUser(connectedUserEmail);

            if (user == null) {
                logger.info("There is no such user in the db");

                MessageForOutput.setMsg("User with such email doesn't exist. Enter another customer");
                MessageForOutput.setMsgTypeError();
            } else if (customerDAO.getCustomer(customer.getEmail()) != null) {

                logger.info("There is already such customer in the database");

                MessageForOutput.setMsg("Such customer is already registered.");
                MessageForOutput.setMsgTypeError();
            } else {
                customer.setUser_email(connectedUserEmail);

                boolean isSuccess = false;
                if (isSuccess = customerDAO.insertCustomer(customer)) {
                    logger.info("Customer " + customer.getEmail() + " is inserted successfully");

                    MessageForOutput.setMsg("Customer is added successfully");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    logger.info("Customer is not inserted.");

                    MessageForOutput.setMsg("Customer is not added, please, check input data.");
                    MessageForOutput.setMsgTypeError();
                }
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting user");
            logger.error(e);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers;

        CustomerDAO customerDAO = new CustomerDAO();
        VisaService visaService = new VisaService();

        customers = customerDAO.getAllCustomers();

        for (Customer customer : customers) {
            List<Visa> visas = visaService.getAllVisasByCustomerEmail(customer.getEmail());
            customer.setVisaList(visas);
        }

        if (customers.isEmpty()) {
            logger.info("Customer table is empty in the db");

            MessageForOutput.setMsg("There is no customers");
            MessageForOutput.setMsgTypeError();
        }

        return customers;
    }

    public void deleteCustomer(String email, String userEmail) {
        CustomerDAO customerDAO = new CustomerDAO();

        try {
            boolean isSuccess = false;
            if (isSuccess = customerDAO.deleteCustomer(email, userEmail)) {
                logger.info("Customer" + email + " is deleted");

                MessageForOutput.setMsg("Customer is deleted successfully");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (customerDAO.getCustomer(email) == null) {
                    logger.info("Customer with such email or user is not registered yet.");
                    MessageForOutput.setMsg("Customer with such email or user is not registered yet.");
                } else {
                    logger.info("Customer is not inserted, something went wrong.");
                    MessageForOutput.setMsg("Customer is not inserted, something went wrong.");
                }

                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting customer");
            logger.error(e);
        }
    }

    public void deleteCustomer(String email) {
        CustomerDAO customerDAO = new CustomerDAO();

        try {
            boolean isSuccess = false;
            if (isSuccess = customerDAO.deleteCustomer(email)) {
                logger.info("Customer" + email + " is deleted");

                MessageForOutput.setMsg("Customer is deleted successfully");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (customerDAO.getCustomer(email) == null) {
                    logger.info("Customer with such email is not registered yet.");
                    MessageForOutput.setMsg("Customer with such email is not registered yet.");
                } else {
                    logger.info("Customer is not inserted, something went wrong.");
                    MessageForOutput.setMsg("Customer is not inserted, something went wrong.");
                }

                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during inserting customer");
            logger.error(e);
        }
    }

    public void updateCustomer(Customer customer, String oldEmail) {
        CustomerDAO customerDAO = new CustomerDAO();

        try {
            boolean isSuccess = false;

            if (isSuccess = customerDAO.updateCustomer(customer, oldEmail)) {
                logger.info("Customer " + oldEmail + " is updated successfully");

                MessageForOutput.setMsg("User is updated successfully.");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (customerDAO.getCustomer(customer.getEmail()) == null) {
                    logger.info("Customer with such email isn't registered yet.");
                    MessageForOutput.setMsg("Customer with such email isn't registered yet.");
                } else {
                    logger.info("Customer is not updated, smth went wrong");
                    MessageForOutput.setMsg("Customer is not updated, please, check input data.");
                }

                MessageForOutput.setMsgTypeError();
            }

        } catch (RuntimeException e) {
            logger.error("Problem during updating customer");
            logger.error(e);
        }
    }

    public List<Customer> getCustomers(String userEmail) {
        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.getCustomerListByUserEmail(userEmail);
    }

    public Customer getCustomer(String customerEmail) {
        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.getCustomer(customerEmail);
    }
}
