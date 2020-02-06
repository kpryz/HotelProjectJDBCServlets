package com.lv339.servlets.admin.management.visa;

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

@WebServlet("/admin/delete-visa")
public class DeleteVisaServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(DeleteVisaServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VisaService visaService = new VisaService();
        String visaNumber = req.getParameter("visaNumber");

        visaService.deleteVisa(visaNumber);
        MessageForOutput.setMessageToRequest(req);

        RequestDispatcher rq = getServletContext().getRequestDispatcher("/admin/delete-visa.jsp");
        rq.include(req, resp);
    }
}
