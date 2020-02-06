package com.lv339.service.login_logout;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class LogoutService {
    private static Logger logger = Logger.getLogger(LogoutService.class.getName());

    public void logout(Cookie[] cookies, HttpSession session) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    logger.info("JSESSIONID = " + cookie.getValue());
                    break;
                }
            }
        }

        try{
            if (session.getAttribute("User") != null) {
                logger.info("User=" + session.getAttribute("User"));
            } else if (session.getAttribute("Customer") != null) {
                logger.info("User=" + session.getAttribute("Customer"));
            }
            session.invalidate();
        }catch (NullPointerException e) {
            logger.info("Session is not established");
        }
    }
}
