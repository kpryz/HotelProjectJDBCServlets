package com.lv339.dao;

import com.lv339.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {
    UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAO();
    }

    @Test
    public void getUserWithEmptyParameter() {
    }

    @Test
    public void getUser1() {
    }
}