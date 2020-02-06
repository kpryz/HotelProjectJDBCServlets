package com.lv339.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database management singelton
 */
public class DBConnection {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static DBConnection dbConnection;
    private Connection connection = null;

    private DBConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION + "?user=" + DB_USER + "&password=" + DB_PASSWORD +
                                                     "&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                                                     "&useLegacyDatetimeCode=false&" +
                                                     "serverTimezone=UTC&allowPublicKeyRetrieval=true");
            logger.info("DB is connected");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Problem with db connection");
            logger.error(e);
        }

    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
            return dbConnection;
        } else {
            return dbConnection;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
