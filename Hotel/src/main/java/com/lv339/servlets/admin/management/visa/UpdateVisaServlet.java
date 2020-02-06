package com.lv339.servlets.admin.management.visa;

import com.lv339.dao.CustomerDAO;
import com.lv339.dao.VisaDAO;
import com.lv339.entity.Customer;
import com.lv339.entity.Visa;
import com.lv339.service.MessageForOutput;
import com.lv339.service.management.VisaService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/update-visa")
public class UpdateVisaServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(UpdateVisaServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Visa visa = new Visa();
        VisaService visaService = new VisaService();

        String oldNumber = req.getParameter("visaNumber");
        String newNumber = req.getParameter("newVisaNumber");
        visa.setVisaNumber(newNumber.equals("") ? oldNumber : newNumber);
        visa.setCountry(req.getParameter("country"));
        visa.setStartDate(LocalDate.parse(req.getParameter("startDate")));
        visa.setEndDate(LocalDate.parse(req.getParameter("endDate")));
        String ownerEmail = req.getParameter("ownerEmail");

        visaService.updateVisa(visa, oldNumber, ownerEmail);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/update-visa.jsp");
        rq.include(req, resp);
    }
}
