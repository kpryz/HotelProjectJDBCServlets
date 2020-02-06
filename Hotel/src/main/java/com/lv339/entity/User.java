package com.lv339.entity;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole userRole;
    private List<Customer> customerList = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, UserRole userRole,
                List<Customer> customerList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.customerList = customerList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean isAdmin() {
        return userRole == UserRole.ROLE_ADMIN;
    }

    public boolean isJustUser() {
        return userRole == UserRole.ROLE_USER;
    }
}