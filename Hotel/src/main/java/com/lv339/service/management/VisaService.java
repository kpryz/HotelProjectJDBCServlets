package com.lv339.service.management;

import com.lv339.dao.CustomerDAO;
import com.lv339.dao.VisaDAO;
import com.lv339.entity.Customer;
import com.lv339.entity.Visa;
import com.lv339.exceptions.ValidationException;
import com.lv339.service.MessageForOutput;
import com.lv339.service.validation.DateValidation;
import org.apache.log4j.Logger;

import java.util.List;

public class VisaService {
    private static Logger logger = Logger.getLogger(VisaService.class.getName());


    public void insertVisa(Visa visa, String ownerEmail) {
        VisaDAO visaDAO = new VisaDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        Customer customer = customerDAO.getCustomer(ownerEmail);
        try {
            if (!DateValidation.isOk(visa.getStartDate()) ||
                !DateValidation.isOk(visa.getEndDate()) ||
                !visa.getEndDate().isAfter(visa.getStartDate()) ||
                visa.getStartDate().equals(visa.getEndDate())) {
                MessageForOutput.setMsg("Dates are incorrect");
                throw new ValidationException("Dates are incorrect");
            }
            if (customer == null) {
                logger.info("There is no such customer in the db");

                MessageForOutput.setMsg("Customer with such email doesn't exist. Enter another customer");
                MessageForOutput.setMsgTypeError();
            } else if (visaDAO.getVisa(visa.getVisaNumber()) != null) {
                logger.info("There is already such visa in the database");

                MessageForOutput.setMsg("Such visa is already registered.");
                MessageForOutput.setMsgTypeError();
            } else {
                visa.setCustomer_email(customer.getEmail());
                boolean isSuccess = false;
                if (isSuccess = visaDAO.insertVisa(visa)) {
                    logger.info("Visa " + visa.getVisaNumber() + " is inserted successfully");

                    MessageForOutput.setMsg("Visa is added successfully.");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    logger.info("Visa is not inserted.");

                    MessageForOutput.setMsg("Visa is not inserted, please, check input data.");
                    MessageForOutput.setMsgTypeError();
                }
            }

        } catch (ValidationException e) {
            logger.error("Dates are incorrect");
            logger.error(e);
        } catch (RuntimeException e) {
            logger.error("Problem during inserting visa");
            logger.error(e);
        }

    }

    public void updateVisa(Visa visa, String oldNumber, String ownerEmail) {
        VisaDAO visaDAO = new VisaDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        Customer customer = customerDAO.getCustomer(ownerEmail);
        try {
            if (!DateValidation.isOk(visa.getStartDate()) ||
                !DateValidation.isOk(visa.getEndDate()) ||
                !visa.getEndDate().isAfter(visa.getStartDate()) ||
                visa.getStartDate().equals(visa.getEndDate())) {
                MessageForOutput.setMsg("Dates are incorrect");
                throw new ValidationException("Dates are incorrect");
            }
            if (customer != null) {
                visa.setCustomer_email(customer.getEmail());

                boolean isSuccess = false;
                if (isSuccess = visaDAO.updateVisa(visa, oldNumber)) {
                    logger.info("Visa " + oldNumber + " is updated successfully");

                    MessageForOutput.setMsg("Visa is updated successfully.");
                    MessageForOutput.setMsgTypeInfo();
                } else {
                    if (visaDAO.getVisa(visa.getVisaNumber()) == null) {
                        logger.info("There is no such visa in the database");
                        MessageForOutput.setMsg("Such visa is not registered yet.");
                    } else {
                        logger.info("Visa is not updated.");
                        MessageForOutput.setMsg("Visa is not updated, please, check input data.");
                    }
                    MessageForOutput.setMsgTypeError();
                }
            } else {
                logger.info("There is no such customer in the db");

                MessageForOutput.setMsg("Connected customer doesn't exist. Enter another customer.");
                MessageForOutput.setMsgTypeError();
            }

        } catch (ValidationException e) {
            logger.error("Dates are incorrect");
            logger.error(e);
        } catch (RuntimeException e) {
            logger.error("Problem during updating visa");
            logger.error(e);
        }
    }

    public void deleteVisa(String visaNumber) {
        VisaDAO visaDAO = new VisaDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        try {

            boolean isSuccess = false;
            if (isSuccess = visaDAO.deleteVisa(visaNumber)) {
                logger.info("Visa " + visaNumber + " is deleted successfully");

                MessageForOutput.setMsg("Visa is deleted successfully.");
                MessageForOutput.setMsgTypeInfo();
            } else {
                if (visaDAO.getVisa(visaNumber) == null) {
                    logger.info("There is no such visa in the database");
                    MessageForOutput.setMsg("Such visa is not registered yet. Nothing to delete.");
                } else {
                    logger.info("Visa is not deleted.");
                    MessageForOutput.setMsg("Visa is not deleted, please, check input data.");
                }
                MessageForOutput.setMsgTypeError();
            }
        } catch (RuntimeException e) {
            logger.error("Problem during deleting visa");
            logger.error(e);
        }
    }

    public List<Visa> getAllVisasByCustomerEmail(String customerEmail) {
        VisaDAO visaDAO = new VisaDAO();

        return visaDAO.getVisasByCustomerEmail(customerEmail);
    }
}
